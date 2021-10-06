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

    List<MessageFile> getFilesByMessageIds(List<Long> messageIdList);

    List<Map<String, Object>> getCommentCounts(List<Long> messageIdList);

    List<Map<String, Object>> getThumbUpCounts(List<Long> messageIdList, String currentOpenId);

    List<MessageComment> getCommentsByMessageIds(List<Long> messageIdList);

    List<MessageThumbUp> getThumbUpsByMessageIds(List<Long> messageIdList);

    long publishMessage(CircleMessageVo vo);

    int batchAddFiles(BatchFileVo vo);

    void removeFilesByMessageId(Long messageId);

    void removeCommentsByMessageId(Long messageId);

    void removeThumbUpsByMessageId(Long messageId);

    void addThumbUp(ThumbUpVo vo);

    void removeThumbUp(ThumbUpVo vo);

    int addComment(MessageCommentVo vo);

    void removeMessageComment(Long commentId);

    void removeMessageByMessageId(Long messageId);

    List<MessageTheme> allTheme();

    List<Map<String, Object>> heatFlowOfTheme();

    IPage<MessageComment> selectPageComment(Page<MessageComment> p, Long messageId);

    List<CircleMessage> messageDetail(Long messageId);

    int getThumbCount(ThumbUpVo vo);
}
