package com.mbe.services.impl;


import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.mbe.mapper.DeviceManagementInfoMapper;
import com.mbe.mapper.DeviceTypeSettingInfoMapper;
import com.mbe.model.DeviceTypeSettingInfo;
import com.mbe.services.DeviceTypeSettingInfoService;
import com.mbe.vo.DeviceManagementInfoVo;
import com.mbe.vo.DeviceTypeSettingInfoVo;
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
public class DeviceTypeSettingInfoServiceImpl implements DeviceTypeSettingInfoService {

    private static Logger log = LoggerFactory.getLogger(DeviceTypeSettingInfoServiceImpl.class);

    @Autowired
    private DeviceTypeSettingInfoMapper deviceTypeSettingInfoMapper;
    @Override
    public void insert(DeviceTypeSettingInfoVo deviceTypeSettingInfoVo) throws LogicalException {
        DeviceTypeSettingInfo deviceManagementInfo =new DeviceTypeSettingInfo();
        try {
            BeanUtils.copyProperties(deviceTypeSettingInfoVo, deviceManagementInfo);
            deviceTypeSettingInfoMapper.insert(deviceManagementInfo);
        }catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException(e.getMessage());
        }
    }

    @Override
    public ApiResult findDeviceTypeAll() throws LogicalException {
        try{

            List<DeviceTypeSettingInfoVo> infoList = deviceTypeSettingInfoMapper.findDeviceTypeAll();
            ApiResult returnVo = new ApiResult();
            returnVo.setData(infoList);
            return ApiResult.success(returnVo);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("查询操作异常！");
        }
    }

    @Override
    public ApiResult queryByDeviceName(String deviceName) throws LogicalException {
        try{

            List<DeviceTypeSettingInfoVo> infoList = deviceTypeSettingInfoMapper.queryByDeviceName(deviceName);
            ApiResult returnVo = new ApiResult();
            returnVo.setData(infoList);
            return ApiResult.success(returnVo);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("查询操作异常！");
        }
    }

    @Override
    public void update(DeviceTypeSettingInfoVo deviceTypeSettingInfoVo) throws LogicalException {

    }

    @Override
    public void delete(DeviceTypeSettingInfoVo deviceTypeSettingInfoVo) throws LogicalException {

    }
}