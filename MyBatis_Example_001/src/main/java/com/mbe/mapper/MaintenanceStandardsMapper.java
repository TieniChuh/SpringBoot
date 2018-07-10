package com.mbe.mapper;

import com.mbe.model.MaintenanceStandards;
import com.mbe.vo.MaintenanceStandardsVo;

import java.util.List;
import java.util.Map;

public interface MaintenanceStandardsMapper {
    int deleteByPrimaryKey(String id);

    int insert(MaintenanceStandards record);

    int insertSelective(MaintenanceStandards record);

    MaintenanceStandards  selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MaintenanceStandards record);

    List<MaintenanceStandardsVo> fuzzyQuery(Map<String, Object> requestMap);

    int countFuzzyQuery(Map<String, Object> requestMap);

    int updateByPrimaryKey(MaintenanceStandards record);
}