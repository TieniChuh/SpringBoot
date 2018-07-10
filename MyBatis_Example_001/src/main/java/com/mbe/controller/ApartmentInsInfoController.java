package com.mbe.controller;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.BaseClass.util.RequestUtils;
import com.mbe.services.AddchargeService;
import com.mbe.services.ApartmentInsInfoService;
import com.mbe.vo.AddchargeVo;
import com.mbe.vo.ApartmentInsInfoVo;
import com.mysql.jdbc.StringUtils;
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
@RequestMapping("/apartInsInfo")
public class ApartmentInsInfoController {

    @Autowired
    private ApartmentInsInfoService apartmentInsInfoService;


    /**
     * 新增操作
     *
     * @param apartmentInsInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "insert", method = {RequestMethod.POST})
    public ApiResult insert(@RequestBody ApartmentInsInfoVo apartmentInsInfoVo, HttpServletRequest request) {
        try {
            if (apartmentInsInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //insert 基本操作_Begin
            apartmentInsInfoVo.setId(UUID.randomUUID().toString());
            apartmentInsInfoVo.setCreateby(RequestUtils.CurrentUserId(request));  // 创建人
            apartmentInsInfoVo.setCreateon(new Date());    // 创建时间
            apartmentInsInfoVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            apartmentInsInfoVo.setModifyon(new Date());// 更新时间
            apartmentInsInfoVo.setOwner(RequestUtils.CurrentUserId(request)); // 负责人
            apartmentInsInfoVo.setStatus("0");  // 状态
            //insert 基本操作_End

            apartmentInsInfoService.insert(apartmentInsInfoVo);
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
    @RequestMapping(value = "queryByInsNoOrAddress", method = {RequestMethod.POST})
    public ApiResult queryByInsNoOrAddress(@RequestBody ApartmentInsInfoVo apartmentInsInfoVo, HttpServletRequest request) {
        try {
            if (apartmentInsInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }

            ApiResult apiResult = apartmentInsInfoService.queryByInsNoOrAddress(apartmentInsInfoVo);
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
     * @param apartmentInsInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "updateApartmentInsInfo", method = {RequestMethod.POST})
    public ApiResult updateApartmentInsInfo(@RequestBody ApartmentInsInfoVo apartmentInsInfoVo, HttpServletRequest request) {
        try {
            if (apartmentInsInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //update 基本操作_Begin
            apartmentInsInfoVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            apartmentInsInfoVo.setModifyon(new Date());// 更新时间
             //update 基本操作_End

            apartmentInsInfoService.update(apartmentInsInfoVo);
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
     * @param apartmentInsInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "deleteApartmentInsInfo", method = {RequestMethod.POST})
    public ApiResult deleteApartmentInsInfo(@RequestBody ApartmentInsInfoVo apartmentInsInfoVo, HttpServletRequest request) {
        try {
            if (apartmentInsInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //update 基本操作_Begin
            apartmentInsInfoVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            apartmentInsInfoVo.setModifyon(new Date());// 更新时间
             //update 基本操作_End
            apartmentInsInfoService.delete(apartmentInsInfoVo);
            return ApiResult.success();
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }
}
