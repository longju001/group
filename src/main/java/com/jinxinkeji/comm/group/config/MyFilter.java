package com.jinxinkeji.comm.group.config;

import com.alibaba.fastjson.JSON;
import com.jinxinkeji.comm.group.mapper.WeChatUserMapper;
import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.entity.WechatUser;
import com.jinxinkeji.comm.group.util.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author changyl
 * @create 2021-09-10 15:05
 */
@WebFilter(urlPatterns = {"*.json"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        // 这里填写你允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
        rep.setHeader("Access-Control-Allow-Origin", "*");
        // 允许的访问方法
        rep.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
        // Access-Control-Max-Age 用于 CORS 相关配置的缓存
        rep.setHeader("Access-Control-Max-Age", "3600");
        rep.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept");


        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String token = req.getHeader("token");
        Result resultInfo;
        boolean isFilter = false;

        String method = ((HttpServletRequest) request).getMethod();
        if ("OPTIONS".equals(method)) {
            rep.setStatus(HttpServletResponse.SC_OK);
        }else{


            if (null == token || token.isEmpty()) {
                resultInfo = Result.failed("用户授权认证没有通过!客户端请求参数中无token信息");
            } else {
                if (volidateToken(token)) {
                    resultInfo = Result.failed("用户授权认证通过");
                    isFilter = true;
                } else {
                    resultInfo = Result.failed("用户授权认证没有通过!请登录");
                }
            }
            // 验证失败
            if (Result.STATUS_FAILED.equals(resultInfo.getSuccess())) {
                PrintWriter writer = null;
                OutputStreamWriter osw = null;
                try {
                    osw = new OutputStreamWriter(response.getOutputStream(),
                            "UTF-8");
                    writer = new PrintWriter(osw, true);
                    String jsonStr = JSON.toJSONString(resultInfo);
                    writer.write(jsonStr);
                    writer.flush();
                    writer.close();
                    osw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != writer) {
                        writer.close();
                    }
                    if (null != osw) {
                        osw.close();
                    }
                }
                return;
            }

            if (isFilter) {
                chain.doFilter(request, response);
            }
        }
    }

    @Autowired
    private WeChatUserMapper weChatUserMapper;
    @Value("${token.salt}")
    private String salt;

    private boolean volidateToken(String token) {
        WechatUser user = new WechatUser();
        try {
            user = JSON.parseObject(AESUtil.Decrypt(token, salt), WechatUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(null == user) {
            return false;
        }
        UserThreadLocal.setUser(user);
        return true;
    }

    @Override
    public void destroy() {

    }
}
