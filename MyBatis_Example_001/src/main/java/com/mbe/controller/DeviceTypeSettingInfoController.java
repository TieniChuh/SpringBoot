package com.mbe.controller;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.BaseClass.util.RequestUtils;
import com.BaseClass.util.StringUtils;
import com.mbe.services.DeviceTypeSettingInfoService;
import com.mbe.vo.DeviceTypeSettingInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Author:Administrator
 * Description: Auto_Templeate 设备管理
 * Date:  2018/6/22.
 */
@RestController
@RequestMapping("/deviceTypeSettingInfo")
public class DeviceTypeSettingInfoController {

    @Autowired
    private DeviceTypeSettingInfoService deviceTypeSettingInfoService;


    /**
     * 新增操作
     *
     * @param deviceTypeSettingInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "insert", method = {RequestMethod.POST})
    public ApiResult insert(@RequestBody DeviceTypeSettingInfoVo deviceTypeSettingInfoVo, HttpServletRequest request) {
        try {
            if (deviceTypeSettingInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //注意保存时，VO空缺，以list内数据为保存数据。前端组装数据注意。
            List<DeviceTypeSettingInfoVo> voList=new ArrayList<>();
            for (DeviceTypeSettingInfoVo voTemp: deviceTypeSettingInfoVo.getChildList()) {
                voTemp.setId(UUID.randomUUID().toString());
                //根节点 F_id为0
                voTemp.setFatherid("0");
                voList= getDeviceTypeList(voTemp.getChildList(),voTemp.getId());
                voList.add(voTemp);
            }
            for (DeviceTypeSettingInfoVo voTempChild:voList) {
                //insert 基本操作_Begin
                voTempChild.setCreateby(RequestUtils.CurrentUserId(request));  // 创建人
                voTempChild.setCreateon(new Date());    // 创建时间
                voTempChild.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
                voTempChild.setModifyon(new Date());// 更新时间
                voTempChild.setOwner(RequestUtils.CurrentUserId(request)); // 负责人
                voTempChild.setStatus("0");  // 状态
                //insert 基本操作_End
                deviceTypeSettingInfoService.insert(voTempChild);
            }
            return ApiResult.success();
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }
    public List<DeviceTypeSettingInfoVo> getDeviceTypeList( List<DeviceTypeSettingInfoVo> voList, String fatherId) {
        List<DeviceTypeSettingInfoVo> childList = new ArrayList();
        for (DeviceTypeSettingInfoVo voTemp : voList) {
            voTemp.setId(UUID.randomUUID().toString());
            voTemp.setFatherid(fatherId);
            List<DeviceTypeSettingInfoVo> childListNode=getDeviceTypeList(voTemp.getChildList(), voTemp.getId());
            childList.addAll(childListNode);
            childList.add(voTemp);
        }
        return childList;
    }
    /**
     * 整设备树 查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "findDeviceTypeAll", method = {RequestMethod.POST})
    public ApiResult findDeviceTypeAll(HttpServletRequest request) {
        try {

            ApiResult apiResult = deviceTypeSettingInfoService.findDeviceTypeAll();
            return apiResult;
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
    @RequestMapping(value = "queryByDeviceName", method = {RequestMethod.POST})
    public ApiResult queryByDeviceName(@RequestBody DeviceTypeSettingInfoVo deviceTypeSettingInfoVo,HttpServletRequest request) {
        try {

            ApiResult apiResult = deviceTypeSettingInfoService.queryByDeviceName(deviceTypeSettingInfoVo.getDivicename());
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
     * @param deviceTypeSettingInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "updateDeviceTypeSettingInfo", method = {RequestMethod.POST})
    public ApiResult updateDeviceTypeSettingInfo(@RequestBody DeviceTypeSettingInfoVo deviceTypeSettingInfoVo, HttpServletRequest request) {
        try {
            if (deviceTypeSettingInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //update 基本操作_Begin
            deviceTypeSettingInfoVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            deviceTypeSettingInfoVo.setModifyon(new Date());// 更新时间
             //update 基本操作_End

            deviceTypeSettingInfoService.update(deviceTypeSettingInfoVo);
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
     * @param deviceTypeSettingInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "deleteDeviceTypeSettingInfo", method = {RequestMethod.POST})
    public ApiResult deleteDeviceTypeSettingInfo(@RequestBody DeviceTypeSettingInfoVo deviceTypeSettingInfoVo, HttpServletRequest request) {
        try {
            if (deviceTypeSettingInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //update 基本操作_Begin
            deviceTypeSettingInfoVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            deviceTypeSettingInfoVo.setModifyon(new Date());// 更新时间
             //update 基本操作_End
            deviceTypeSettingInfoService.delete(deviceTypeSettingInfoVo);
            return ApiResult.success();
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }
}
