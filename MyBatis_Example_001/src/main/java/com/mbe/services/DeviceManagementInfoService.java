package com.mbe.services;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.mbe.vo.DeviceManagementInfoVo;

 /**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public interface DeviceManagementInfoService {


    /**
     * @param deviceManagementInfoVo
     * @throws LogicalException
     */
    void insert(DeviceManagementInfoVo deviceManagementInfoVo) throws LogicalException;


    /**
     * @param deviceManagementInfoVo
     * @return
     * @throws LogicalException
     */
    ApiResult queryByDeviceNoOrName(DeviceManagementInfoVo deviceManagementInfoVo) throws LogicalException;

    /**
     * 
     * @param deviceManagementInfoVo
     * @throws LogicalException
     */
    void update(DeviceManagementInfoVo deviceManagementInfoVo) throws LogicalException;

    /**
     * 
     * @param deviceManagementInfoVo
     * @throws LogicalException
     */
    void delete(DeviceManagementInfoVo deviceManagementInfoVo) throws LogicalException;

}