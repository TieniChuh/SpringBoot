package com.mbe.mapper;

import com.mbe.model.DeviceTypeSettingInfo;
import com.mbe.vo.DeviceManagementInfoVo;
import com.mbe.vo.DeviceTypeSettingInfoVo;

import java.util.List;
import java.util.Map;

/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public interface DeviceTypeSettingInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceTypeSettingInfo record);

    int insertSelective(DeviceTypeSettingInfo record);

    DeviceTypeSettingInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceTypeSettingInfo record);

    int updateByPrimaryKey(DeviceTypeSettingInfo record);

    List<DeviceTypeSettingInfoVo> findDeviceTypeAll();
    List<DeviceTypeSettingInfoVo> queryByDeviceName(String deviceName);
}