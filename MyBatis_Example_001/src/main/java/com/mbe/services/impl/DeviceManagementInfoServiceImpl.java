package com.mbe.services.impl;


import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.mbe.mapper.ApartmentInsInfoMapper;
import com.mbe.mapper.DeviceManagementInfoMapper;
import com.mbe.model.ApartmentInsInfo;
import com.mbe.model.DeviceManagementInfo;
import com.mbe.services.DeviceManagementInfoService;
import com.mbe.vo.ApartmentInsInfoVo;
import com.mbe.vo.DeviceManagementInfoVo;
import com.mbe.vo.Page;
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
public class DeviceManagementInfoServiceImpl implements DeviceManagementInfoService {
    private static Logger log = LoggerFactory.getLogger(DeviceManagementInfoServiceImpl.class);

    @Autowired
    private DeviceManagementInfoMapper deviceManagementInfoMapper;

    @Override
    public void insert(DeviceManagementInfoVo deviceManagementInfoVo) throws LogicalException {
        DeviceManagementInfo deviceManagementInfo=new DeviceManagementInfo();
        try {
            BeanUtils.copyProperties(deviceManagementInfoVo, deviceManagementInfo);

            deviceManagementInfoMapper.insert(deviceManagementInfo);
        }catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException(e.getMessage());
        }
    }

    @Override
    public ApiResult queryByDeviceNoOrName(DeviceManagementInfoVo deviceManagementInfoVo) throws LogicalException {
        try{
            Map<String, Object> requestMap = deviceManagementInfoVo.toSearchMap();

            requestMap.put("deviceno", deviceManagementInfoVo.getDeviceno());
            //分页参数加入
            requestMap.putAll(deviceManagementInfoVo.toSearchMap());

            int count = deviceManagementInfoMapper.countByDeviceNoOrName(requestMap);
            List<DeviceManagementInfoVo> infoList = deviceManagementInfoMapper.queryByDeviceNoOrName(requestMap);

            Page<DeviceManagementInfoVo> page = new Page<>(deviceManagementInfoVo.getCurrentPage(), count, deviceManagementInfoVo.getPageSize());
            page.setList(infoList);
            ApiResult returnVo = new ApiResult();
            returnVo.setData(page);
            return ApiResult.success(returnVo);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("查询操作异常！");
        }

    }

    @Override
    public void update(DeviceManagementInfoVo deviceManagementInfoVo) throws LogicalException {
        DeviceManagementInfo deviceManagementInfo=new DeviceManagementInfo();
        try {
            BeanUtils.copyProperties(deviceManagementInfoVo, deviceManagementInfo);

            deviceManagementInfoMapper.updateByPrimaryKeySelective(deviceManagementInfo);
        }catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException(e.getMessage());
        }
    }

    @Override
    public void delete(DeviceManagementInfoVo deviceManagementInfoVo) throws LogicalException {
        //	Status	数据状态 （0：可用，1：逻辑删除）
        deviceManagementInfoVo.setStatus("1");
        update(deviceManagementInfoVo);
    }
}