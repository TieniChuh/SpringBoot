package com.mbe.services;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.mbe.vo.DeviceTypeSettingInfoVo;

 /**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public interface DeviceTypeSettingInfoService {

    /**
     * @param deviceTypeSettingInfoVo
     * @throws LogicalException
     */
    void insert(DeviceTypeSettingInfoVo deviceTypeSettingInfoVo) throws LogicalException;


    /**
      * @return
     * @throws LogicalException
     */
    ApiResult findDeviceTypeAll() throws LogicalException;

     /**
      * @return
      * @throws LogicalException
      */
     ApiResult queryByDeviceName(String deviceName) throws LogicalException;

    /**
     *
     * @param deviceTypeSettingInfoVo
     * @throws LogicalException
     */
    void update(DeviceTypeSettingInfoVo deviceTypeSettingInfoVo) throws LogicalException;

    /**
     *
     * @param deviceTypeSettingInfoVo
     * @throws LogicalException
     */
    void delete(DeviceTypeSettingInfoVo deviceTypeSettingInfoVo) throws LogicalException;
}