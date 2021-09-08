package com.jinxinkeji.comm.group.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jinxinkeji.comm.group.model.entity.CircleMessage;
import com.jinxinkeji.comm.group.model.entity.MessageComment;
import com.jinxinkeji.comm.group.model.entity.MessageTheme;
import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.vo.*;
import com.jinxinkeji.comm.group.service.ICityCircleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 同城圈
 * @author changyl
 * @create 2021-09-02 14:05
 */
@RestController
@RequestMapping("/circlr")
@Api(value = "小程序同城圈", tags = "同城圈消息相关的接口", description = "同城圈消息相关的接口")
public class CityCircleController {

    @Autowired
    private ICityCircleService cityCircleService;

    @CrossOrigin
    @PostMapping("/messageList.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "分页查询的页数", required = true, dataType = "long"),
            @ApiImplicitParam(name = "themeCode", value = "话题编码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "currentOpenId", value = "当前小程序登录用户openId", required = true, dataType = "String"),
    })
    @ApiOperation(value = "同城圈消息列表分页查询", notes = "同城圈消息列表分页查询")
    public Result<IPage<MessageListVo>> list(@RequestParam("pageNum") long pageNum,
                                             @RequestParam("themeCode") String themeCode,
                                             @RequestParam("currentOpenId") String currentOpenId){
        try {
            return cityCircleService.messageList(pageNum, themeCode, currentOpenId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("查询异常");
        }
    }

    @CrossOrigin
    @PostMapping("/messageDetail.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageId", value = "同城圈消息ID", required = true, dataType = "String")
    })
    @ApiOperation(value = "同城圈动态详情", notes = "同城圈动态详情")
    public Result<CircleMessage> messageDetail(String messageId){
        try {
            return cityCircleService.messageDetail(messageId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("查询同城圈动态详情异常");
        }
    }


    @CrossOrigin
    @PostMapping("/publishMessage.json")
    @ApiImplicitParam(name = "CircleMessageVo", value = "发布消息的实体")
    @ApiOperation(value = "同城圈发布消息", notes = "同城圈发布消息")
    public Result<String> publish(@RequestBody CircleMessageVo circleMessageVo){
        try {
            return cityCircleService.publishMessage(circleMessageVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("发布异常");
        }
    }

    @CrossOrigin
    @PostMapping("/addFiles.json")
    @ApiImplicitParam(name = "BatchFileVo", value = "批量保存文件入参")
    @ApiOperation(value = "批量保存文件", notes = "批量保存文件")
    public Result<String> addFiles(@RequestBody BatchFileVo fileVo){
        try {
            return cityCircleService.addFiles(fileVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("批量保存文件异常");
        }
    }

    @CrossOrigin
    @PostMapping("/removeMessage.json")
    @ApiImplicitParam(name = "messageId", value = "要删除的消息的ID")
    @ApiOperation(value = "删除同城圈消息", notes = "删除同城圈消息")
    public Result<String> remove(String messageId){
        try {
            return cityCircleService.removeMessage(messageId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("删除消息异常异常");
        }
    }

    @CrossOrigin
    @PostMapping("/messageThumbUp.json")
    @ApiImplicitParam(name = "ThumbUpVo", value = "")
    @ApiOperation(value = "点赞/取消点赞", notes = "点赞/取消点赞")
    public Result<String> thumbUp(@RequestBody ThumbUpVo vo){
        try {
            return cityCircleService.messageThumbUp(vo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("点赞/取消赞异常");
        }
    }

    @CrossOrigin
    @PostMapping("/addMessageComment.json")
    @ApiImplicitParam(name = "MessageCommentVo", value = "评论实体")
    @ApiOperation(value = "评论", notes = "评论")
    public Result<String> addComment(@RequestBody MessageCommentVo vo){
        try {
            return cityCircleService.messageComment(vo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("添加评论异常");
        }
    }

    @CrossOrigin
    @PostMapping("/removeMessageComment.json")
    @ApiImplicitParam(name = "commentId", value = "评论ID")
    @ApiOperation(value = "查询评论", notes = "删除评论")
    public Result<String> removeComment(String commentId){
        try {
            return cityCircleService.removeMessageComment(commentId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("查询评论异常");
        }
    }

    @CrossOrigin
    @PostMapping("/queryMessageComment.json")
    @ApiOperation(value = "查询动态的评论-分页查询", notes = "查询动态的评论-分页查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum", value = "分页的当前页数", required = true, dataType = "long"),
            @ApiImplicitParam(name = "messageId", value = "用户标识", required = true, dataType = "String")
    })
    public Result<IPage<MessageComment>> queryMessageComment(@RequestParam("pageNum") long pageNum,
                                                             @RequestParam("messageId") String messageId){
        try {
            return cityCircleService.queryMessageComment(pageNum, messageId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("分页查询评论异常");
        }
    }

    //查询评论，查询动态详情

    @CrossOrigin
    @PostMapping("/allTheme.json")
    @ApiOperation(value = "所有话题", notes = "所有话题")
    public Result<List<MessageTheme>> allTheme(){
        try {
            return cityCircleService.allTheme();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("查询话题详情异常");
        }
    }

}
