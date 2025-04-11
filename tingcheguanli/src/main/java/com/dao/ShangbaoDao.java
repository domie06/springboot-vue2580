package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ShangbaoEntity;
import com.entity.view.ShangbaoView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 上报 Dao 接口
 *
 * @author 
 */
public interface ShangbaoDao extends BaseMapper<ShangbaoEntity> {

   List<ShangbaoView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
