package com.mbe.services.impl;


import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.mbe.mapper.MaintenanceStandardsMapper;
import com.mbe.mapper.MortgageContractInfoMapper;
import com.mbe.model.MaintenanceStandards;
import com.mbe.model.MortgageContractInfo;
import com.mbe.model.PawnDetail;
import com.mbe.services.MaintenanceStandardsService;
import com.mbe.vo.MaintenanceStandardsVo;
import com.mbe.vo.MortgageContractInfoVo;
import com.mbe.vo.Page;
import com.mbe.vo.PawnDetailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MaintenanceStandardsServiceImpl implements MaintenanceStandardsService {
    private static Logger log = LoggerFactory.getLogger(MaintenanceStandardsServiceImpl.class);

    @Autowired
    private MaintenanceStandardsMapper maintenanceStandardsMapper;
    @Override
    public void insert(MaintenanceStandardsVo maintenanceStandardsVo) throws LogicalException {
        MaintenanceStandards maintenanceStandards=new MaintenanceStandards();
         try {
            BeanUtils.copyProperties(maintenanceStandardsVo, maintenanceStandards);
             maintenanceStandardsMapper.insert(maintenanceStandards);
        }catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException(e.getMessage());
        }
    }



    @Override
    public ApiResult fuzzyQuery(MaintenanceStandardsVo maintenanceStandardsVo) throws LogicalException {
        Map<String, Object> requestMap = maintenanceStandardsVo.toSearchMap();
        //分页参数加入
        requestMap.putAll(maintenanceStandardsVo.toSearchMap());
        //模糊查询 参数 前端保存在VO的ID中
        requestMap.put("fuzzyQueryStr",maintenanceStandardsVo.getId());
        int count = maintenanceStandardsMapper.countFuzzyQuery(requestMap);
        List<MaintenanceStandardsVo> infoList =  maintenanceStandardsMapper.fuzzyQuery(requestMap);

        Page<MaintenanceStandardsVo> page = new Page<>(maintenanceStandardsVo.getCurrentPage(), count, maintenanceStandardsVo.getPageSize());
        page.setList(infoList);
        ApiResult returnVo = new ApiResult();
        returnVo.setData(page);
        return ApiResult.success(returnVo);
    }

    @Override
    public void update(MaintenanceStandardsVo maintenanceStandardsVo) throws LogicalException {

    }

    @Override
    public void delete(MaintenanceStandardsVo maintenanceStandardsVo) throws LogicalException {

    }
}