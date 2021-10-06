package com.jinxinkeji.comm.group.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.jinxinkeji.comm.group.config.UserThreadLocal;
import com.jinxinkeji.comm.group.mapper.MessageMapper;
import com.jinxinkeji.comm.group.model.entity.*;
import com.jinxinkeji.comm.group.model.vo.*;
import com.jinxinkeji.comm.group.service.ICityCircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author changyl
 * @create 2021-09-03 19:50
 */
@Service
public class CityCircleServiceImpl implements ICityCircleService {

    @Autowired
    private MessageMapper messageMapper;

    private static final long messagePageSize = 10;
    private static final long commentPageSize = 20;

    @Override
    @Transactional
    public Result<IPage<MessageListVo>> messageList(long pageNum, String themeCode, String currentOpenId) {
        if("00".equals(themeCode)){
            themeCode = "";
        }
        Page<MessageListVo> p = new Page<>(pageNum, messagePageSize);
        IPage<MessageListVo> iPage = messageMapper.selectPageVo(p, themeCode);
        getFiles(iPage, currentOpenId);
        return Result.success("查询成功", iPage);
    }

    private void getFiles(IPage<MessageListVo> iPage, String currentOpenId) {
        List<MessageListVo> messageList = iPage.getRecords();
        List<Long> messageIdList = messageList.stream().map(MessageListVo::getMessageId).collect(Collectors.toList());
        if(messageIdList.isEmpty()){
            return;
        }
        List<MessageFile> fileList = messageMapper.getFilesByMessageIds(messageIdList);
        List<Map<String, Object>> commentCounts = messageMapper.getCommentCounts(messageIdList);
        List<Map<String, Object>> thumbUpCounts = messageMapper.getThumbUpCounts(messageIdList, null);
        List<Map<String, Object>> myThumbUpCounts = messageMapper.getThumbUpCounts(messageIdList, currentOpenId);
        for (MessageListVo circleMessage : messageList) {
            //处理文件
            List<MessageFile> files = new ArrayList<>();
            for (MessageFile messageFile : fileList) {
                if(circleMessage.getMessageId() == messageFile.getMessageId()){
                    files.add(messageFile);
                }
            }
            circleMessage.setFileList(files);

            //处理点赞数
            for (Map<String, Object> thumbUpCount : thumbUpCounts) {
                if(String.valueOf(circleMessage.getMessageId()).equals(String.valueOf(thumbUpCount.get("messageId")))){
                    circleMessage.setThumbUpCount(((Long) thumbUpCount.get("thumbupCount")).intValue());
                    break;
                }
            }

            //处理评论数
            for (Map<String, Object> commentCount : commentCounts) {
                if(String.valueOf(circleMessage.getMessageId()).equals(String.valueOf(commentCount.get("messageId")))){
                    circleMessage.setCommentCount(((Long) commentCount.get("commentCount")).intValue());
                    break;
                }
            }

            //处理当前登录人是不是点过赞
            boolean flag = false;
            for (Map<String, Object> myThumbUpCount : myThumbUpCounts) {
                if(String.valueOf(circleMessage.getMessageId()).equals(String.valueOf(myThumbUpCount.get("messageId")))){
                    flag = true;
                    break;
                }
            }
            if(flag){
                circleMessage.setIsMyThumbUp(1);
            }

        }
        iPage.setRecords(messageList);
    }

    @Override
    @Transactional
    public Result<String> publishMessage(CircleMessageVo vo) {
        messageMapper.publishMessage(vo);
        vo.setMessageId(vo.getMessageId());
        if(null!=vo.getFileIds() && vo.getFileIds().size()>0){
            BatchFileVo fileVos = new BatchFileVo();
            fileVos.setFileIds(vo.getFileIds());
            fileVos.setMessageId(vo.getMessageId());
            messageMapper.batchAddFiles(fileVos);
        }
        return Result.success("发布成功", null);
    }

    /*@Override
    @Transactional
    public Result<String> addFiles(BatchFileVo vo) {
        if(vo.getFileIds().isEmpty()){
            return Result.failed("无可上传的文件");
        }
        int count = messageMapper.batchAddFiles(vo);
        return Result.success("成功插入：" + count + "个文件", null);
    }*/

    @Override
    public Result<String> removeMessage(long messageId) {
        //删除同城消息 (删除文件，评论，赞)
        messageMapper.removeFilesByMessageId(messageId);
        messageMapper.removeCommentsByMessageId(messageId);
        messageMapper.removeThumbUpsByMessageId(messageId);
        messageMapper.removeMessageByMessageId(messageId);
        return Result.success("删除成功", null);
    }

    @Override
    @Transactional
    public Result<String> messageThumbUp(ThumbUpVo vo) {
        WechatUser user = UserThreadLocal.getUser();
        vo.setOpenId(user.getOpenId());
        if(messageMapper.getThumbCount(vo)<=0 &&vo.getIsThumbUp()==1){
            System.out.println("==========================================" + vo.getIsThumbUp());
            messageMapper.addThumbUp(vo);
            return Result.success("点赞成功", null);
        }
        if(vo.getIsThumbUp() == 0){
            System.out.println("==========================================" + vo.getIsThumbUp());
            messageMapper.removeThumbUp(vo);
            return Result.success("取消赞成功", null);
        }
        return Result.success("成功", null);
    }

    @Override
    @Transactional
    public Result<String> messageComment(MessageCommentVo vo) {
        int count = messageMapper.addComment(vo);
        return count > 0 ? Result.success("评论成功", null) : Result.failed("出现异常，稍后重试！");
    }

    @Override
    @Transactional
    public Result<String> removeMessageComment(long commentId) {
        messageMapper.removeMessageComment(commentId);
        return Result.success("删除评论成功", null);
    }

    @Override
    public Result<List<MessageTheme>> allTheme() {
        List<MessageTheme> list = messageMapper.allTheme();
        List<Map<String, Object>> counts = messageMapper.heatFlowOfTheme();
        if(counts.isEmpty()){
            return Result.success("查询话题列表成功", list);
        }
        for (MessageTheme messageTheme : list) {
            for (Map<String, Object> count : counts) {
                if(messageTheme.getThemeCode().equals(String.valueOf(count.get("themeCode")))){
                    messageTheme.setHeatFlow((Long) count.get("heatFlow"));
                }
            }
        }
        return Result.success("查询话题列表成功", list);
    }

    @Override
    public Result<IPage<MessageComment>> queryMessageComment(long pageNum, long messageId) {
        Page<MessageComment> p = new Page<>(pageNum, commentPageSize);
        IPage<MessageComment> iPage = messageMapper.selectPageComment(p, messageId);
        return Result.success("查询评论成功", iPage);
    }

    @Override
    public Result<CircleMessage> messageDetail(long messageId) {
        List<CircleMessage> list = messageMapper.messageDetail(messageId);
        if(list.isEmpty()){
            return Result.success("该消息已经不存在", null);
        }
        CircleMessage reMessage = list.get(0);
        List<Long> ids = Lists.newArrayList(messageId);
        List<MessageFile> files = messageMapper.getFilesByMessageIds(ids);
        List<MessageComment> comments = messageMapper.getCommentsByMessageIds(ids);
        List<MessageThumbUp> thumbUps = messageMapper.getThumbUpsByMessageIds(ids);
        reMessage.setFileList(files);
        reMessage.setCommentList(comments);
        reMessage.setThumbUpList(thumbUps);
        //处理当前登录人是不是点过赞
        boolean flag = false;
        for (MessageThumbUp thumbUp : thumbUps) {
            if(reMessage.getMessageId().equals(String.valueOf(thumbUp.getMessageId()))){
                flag = true;
                break;
            }
        }
        if(flag){
            reMessage.setIsMyThumbUp(1);
        }
        return Result.success("查询消息详情成功", reMessage);
    }
}
