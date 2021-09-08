package com.jinxinkeji.comm.group.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jinxinkeji.comm.group.model.entity.CircleMessage;
import com.jinxinkeji.comm.group.model.entity.MessageComment;
import com.jinxinkeji.comm.group.model.entity.MessageTheme;
import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.vo.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author changyl
 * @create 2021-09-03 19:50
 */
public interface ICityCircleService {
    Result<IPage<MessageListVo>> messageList(long pageNum, String themeCode, String currentOpenId);

    Result<String> publishMessage(CircleMessageVo vo);

    Result<String> addFiles(BatchFileVo vo);

    Result<String> removeMessage(String messageId);

    Result<String> messageThumbUp(ThumbUpVo vo);

    Result<String> messageComment(MessageCommentVo vo);

    Result<String> removeMessageComment(String commentId);

    Result<List<MessageTheme>> allTheme();

    Result<IPage<MessageComment>> queryMessageComment(long pageNum, String messageId);

    Result<CircleMessage> messageDetail(String messageId);
}
