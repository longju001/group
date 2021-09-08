package com.jinxinkeji.comm.group.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinxinkeji.comm.group.model.entity.*;
import com.jinxinkeji.comm.group.model.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author changyl
 * @create 2021-09-03 20:16
 */
@Mapper
public interface MessageMapper {

    IPage<MessageListVo> selectPageVo(Page<?> page, String themeCode);

    List<MessageFile> getFilesByMessageIds(List<String> messageIdList);

    List<MessageComment> getCommentsByMessageIds(List<String> messageIdList);

    List<MessageThumbUp> getThumbUpsByMessageIds(List<String> messageIdList);

    int publishMessage(CircleMessageVo vo);

    int batchAddFiles(BatchFileVo vo);

    void removeFilesByMessageId(String messageId);

    void removeCommentsByMessageId(String messageId);

    void removeThumbUpsByMessageId(String messageId);

    void addThumbUp(ThumbUpVo vo);

    void removeThumbUp(ThumbUpVo vo);

    int addComment(MessageCommentVo vo);

    void removeMessageComment(String commentId);

    void removeMessageByMessageId(String messageId);

    List<MessageTheme> allTheme();

    List<Map<String, Object>> heatFlowOfTheme();

    IPage<MessageComment> selectPageComment(Page<MessageComment> p, String messageId);

    List<CircleMessage> messageDetail(String messageId);

}
