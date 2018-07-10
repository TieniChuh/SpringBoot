package com.mbe.mapper;

import com.mbe.model.DeviceManagementInfo;
import com.mbe.vo.ApartmentInsInfoVo;
import com.mbe.vo.DeviceManagementInfoVo;

import java.util.List;
import java.util.Map;

/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public interface DeviceManagementInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeviceManagementInfo record);

    int insertSelective(DeviceManagementInfo record);

    DeviceManagementInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeviceManagementInfo record);

    int updateByPrimaryKey(DeviceManagementInfo record);

    /**
     *
     * @param map
     * @return
     */
    int countByDeviceNoOrName(Map<String, Object> map);

    /**
     *
     * @param map
     * @return
     */
    List<DeviceManagementInfoVo> queryByDeviceNoOrName(Map<String, Object> map);
}