package com.mbe.controller;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.BaseClass.util.RequestUtils;
import com.mbe.services.MaintenanceStandardsService;
import com.mbe.vo.MaintenanceStandardsVo;
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
 * Description: Auto_Templeate 房源保险
 * Date:  2018/6/22.
 */
@RestController
@RequestMapping("/maintenanceStandards")
public class MaintenanceStandardsController {

    @Autowired
    private MaintenanceStandardsService maintenanceStandardsService;


    /**
     * 新增操作
     *
     * @param maintenanceStandardsVo
     * @param request
     * @return
     */
    @RequestMapping(value = "insert", method = {RequestMethod.POST})
    public ApiResult insert(@RequestBody MaintenanceStandardsVo maintenanceStandardsVo, HttpServletRequest request) {
        try {
            if (maintenanceStandardsVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //insert 基本操作_Begin
            maintenanceStandardsVo.setId(UUID.randomUUID().toString());
            maintenanceStandardsVo.setCreateby(RequestUtils.CurrentUserId(request));  // 创建人
            maintenanceStandardsVo.setCreateon(new Date());    // 创建时间
            maintenanceStandardsVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            maintenanceStandardsVo.setModifyon(new Date());// 更新时间
            maintenanceStandardsVo.setOwner(RequestUtils.CurrentUserId(request)); // 负责人
            maintenanceStandardsVo.setStatus("0");  // 状态
            //insert 基本操作_End

            maintenanceStandardsService.insert(maintenanceStandardsVo);
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
    @RequestMapping(value = "fuzzyQuery", method = {RequestMethod.POST})
    public ApiResult fuzzyQuery(@RequestBody MaintenanceStandardsVo maintenanceStandardsVo, HttpServletRequest request) {
        try {
            if (maintenanceStandardsVo == null) {
                return ApiResult.fail("参数对象无效！");
            }

            ApiResult apiResult = maintenanceStandardsService.fuzzyQuery(maintenanceStandardsVo);
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
     * @param maintenanceStandardsVo
     * @param request
     * @return
     */
    @RequestMapping(value = "updateMaintenanceStandards", method = {RequestMethod.POST})
    public ApiResult updateMaintenanceStandards(@RequestBody MaintenanceStandardsVo maintenanceStandardsVo, HttpServletRequest request) {
        try {
            if (maintenanceStandardsVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //update 基本操作_Begin
            maintenanceStandardsVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            maintenanceStandardsVo.setModifyon(new Date());// 更新时间
             //update 基本操作_End

            maintenanceStandardsService.update(maintenanceStandardsVo);
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
     * @param maintenanceStandardsVo
     * @param request
     * @return
     */
    @RequestMapping(value = "deleteMaintenanceStandards", method = {RequestMethod.POST})
    public ApiResult deleteMaintenanceStandards(@RequestBody MaintenanceStandardsVo maintenanceStandardsVo, HttpServletRequest request) {
        try {
            if (maintenanceStandardsVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //update 基本操作_Begin
            maintenanceStandardsVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            maintenanceStandardsVo.setModifyon(new Date());// 更新时间
             //update 基本操作_End
            maintenanceStandardsService.delete(maintenanceStandardsVo);
            return ApiResult.success();
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }
}
