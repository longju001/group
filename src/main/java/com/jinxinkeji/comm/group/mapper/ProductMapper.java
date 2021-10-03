package com.jinxinkeji.comm.group.mapper;

import com.jinxinkeji.comm.group.model.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author changyl
 * @create 2021-10-03 9:50
 */
@Mapper
public interface ProductMapper {
    List<Category> getCategoryList();
}
