package com.guojin.dpp.web.dao;

import com.guojin.dpp.web.model.ConfigPO;
import com.guojin.dpp.web.model.ConfigPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConfigPOMapper {
    long countByExample(ConfigPOExample example);

    int deleteByExample(ConfigPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ConfigPO record);

    int insertSelective(ConfigPO record);

    List<ConfigPO> selectByExample(ConfigPOExample example);

    ConfigPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ConfigPO record, @Param("example") ConfigPOExample example);

    int updateByExample(@Param("record") ConfigPO record, @Param("example") ConfigPOExample example);

    int updateByPrimaryKeySelective(ConfigPO record);

    int updateByPrimaryKey(ConfigPO record);
}