package com.mbe.controller;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.BaseClass.util.RequestUtils;
import com.mbe.services.DeviceManagementInfoService;
import com.mbe.vo.DeviceManagementInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

/**
 * Author:Administrator
 * Description: Auto_Templeate 设备管理
 * Date:  2018/6/22.
 */
@RestController
@RequestMapping("/deviceManagementInfo")
public class DeviceManagementInfoController {

    @Autowired
    private DeviceManagementInfoService deviceManagementInfoService;


    /**
     * 新增操作
     *
     * @param deviceManagementInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "insert", method = {RequestMethod.POST})
    public ApiResult insert(@RequestBody DeviceManagementInfoVo deviceManagementInfoVo, HttpServletRequest request) {
        try {
            if (deviceManagementInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //insert 基本操作_Begin
            deviceManagementInfoVo.setId(UUID.randomUUID().toString());
            deviceManagementInfoVo.setCreateby(RequestUtils.CurrentUserId(request));  // 创建人
            deviceManagementInfoVo.setCreateon(new Date());    // 创建时间
            deviceManagementInfoVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            deviceManagementInfoVo.setModifyon(new Date());// 更新时间
            deviceManagementInfoVo.setOwner(RequestUtils.CurrentUserId(request)); // 负责人
            deviceManagementInfoVo.setStatus("0");  // 状态
            //insert 基本操作_End

            deviceManagementInfoService.insert(deviceManagementInfoVo);
            return ApiResult.success();
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 模糊查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "queryByDeviceNoOrName", method = {RequestMethod.POST})
    public ApiResult queryByDeviceNoOrName(@RequestBody DeviceManagementInfoVo deviceManagementInfoVo, HttpServletRequest request) {
        try {
            if (deviceManagementInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }

            ApiResult apiResult = deviceManagementInfoService.queryByDeviceNoOrName(deviceManagementInfoVo);
            return apiResult;
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 更新操作
     *
     * @param deviceManagementInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "updateDeviceManagementInfo", method = {RequestMethod.POST})
    public ApiResult updateDeviceManagementInfo(@RequestBody DeviceManagementInfoVo deviceManagementInfoVo, HttpServletRequest request) {
        try {
            if (deviceManagementInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //update 基本操作_Begin
            deviceManagementInfoVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            deviceManagementInfoVo.setModifyon(new Date());// 更新时间
             //update 基本操作_End

            deviceManagementInfoService.update(deviceManagementInfoVo);
            return ApiResult.success();
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 删除操作
     *
     * @param deviceManagementInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "deleteDeviceManagementInfo", method = {RequestMethod.POST})
    public ApiResult deleteDeviceManagementInfo(@RequestBody DeviceManagementInfoVo deviceManagementInfoVo, HttpServletRequest request) {
        try {
            if (deviceManagementInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //update 基本操作_Begin
            deviceManagementInfoVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            deviceManagementInfoVo.setModifyon(new Date());// 更新时间
             //update 基本操作_End
            deviceManagementInfoService.delete(deviceManagementInfoVo);
            return ApiResult.success();
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }
}
