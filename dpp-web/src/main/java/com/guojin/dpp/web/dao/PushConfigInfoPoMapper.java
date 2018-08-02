package com.guojin.dpp.web.dao;

import com.guojin.dpp.web.model.PushConfigInfoPo;
import com.guojin.dpp.web.model.PushConfigInfoPoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PushConfigInfoPoMapper {
    long countByExample(PushConfigInfoPoExample example);

    int deleteByExample(PushConfigInfoPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PushConfigInfoPo record);

    int insertSelective(PushConfigInfoPo record);

    List<PushConfigInfoPo> selectByExample(PushConfigInfoPoExample example);

    PushConfigInfoPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PushConfigInfoPo record, @Param("example") PushConfigInfoPoExample example);

    int updateByExample(@Param("record") PushConfigInfoPo record, @Param("example") PushConfigInfoPoExample example);

    int updateByPrimaryKeySelective(PushConfigInfoPo record);

    int updateByPrimaryKey(PushConfigInfoPo record);
}