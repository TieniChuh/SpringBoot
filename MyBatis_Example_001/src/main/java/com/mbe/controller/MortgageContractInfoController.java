package com.mbe.controller;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.BaseClass.util.RequestUtils;
import com.mbe.services.ApartmentInsInfoService;
import com.mbe.services.MortgageContractInfoService;
import com.mbe.vo.ApartmentInsInfoVo;
import com.mbe.vo.MortgageContractInfoVo;
import com.mbe.vo.PawnDetailVo;
import com.github.pagehelper.util.StringUtil;
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
 * Description: MortgageContractInfoController
 * Date:  2018/6/27
 */
@RestController
@RequestMapping("/mortgageContractInfo")
public class MortgageContractInfoController {

    @Autowired
    private MortgageContractInfoService mortgageContractInfoService;


    /**
     * 新增操作
     *
     * @param mortgageContractInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "insert", method = {RequestMethod.POST})
    public ApiResult insert(@RequestBody MortgageContractInfoVo mortgageContractInfoVo, HttpServletRequest request) {
        try {
            if (mortgageContractInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //insert 基本操作_Begin
            String mortgageContractInfoVoId=UUID.randomUUID().toString();
            mortgageContractInfoVo.setId(mortgageContractInfoVoId);
            mortgageContractInfoVo.setCreateby(RequestUtils.CurrentUserId(request));  // 创建人
            mortgageContractInfoVo.setCreateon(new Date());    // 创建时间
            mortgageContractInfoVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            mortgageContractInfoVo.setModifyon(new Date());// 更新时间
            mortgageContractInfoVo.setOwner(RequestUtils.CurrentUserId(request)); // 负责人
            mortgageContractInfoVo.setStatus("0");  // 状态
            //抵押物明细 信息增加
            List<PawnDetailVo> pawnDetailVoList =new ArrayList<>();
            for (PawnDetailVo pawnDetailTemp:mortgageContractInfoVo.getPawnDetailList()) {
                pawnDetailTemp.setPid(UUID.randomUUID().toString());
                pawnDetailTemp.setMorconinfoid(mortgageContractInfoVoId);
                pawnDetailTemp.setCreateby(RequestUtils.CurrentUserId(request));  // 创建人
                pawnDetailTemp.setCreateon(new Date());    // 创建时间
                pawnDetailTemp.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
                pawnDetailTemp.setModifyon(new Date());// 更新时间
                pawnDetailTemp.setOwner(RequestUtils.CurrentUserId(request)); // 负责人
                pawnDetailTemp.setStatus("0");  // 状态
                pawnDetailVoList.add(pawnDetailTemp);
            }
            mortgageContractInfoVo.setPawnDetailList(pawnDetailVoList);
            //insert 基本操作_End

            mortgageContractInfoService.insert(mortgageContractInfoVo);
            return ApiResult.success();
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     *
     * @param mortgageContractInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "queryMortgageFetchPawn", method = {RequestMethod.POST})
    public ApiResult queryMortgageFetchPawn(@RequestBody MortgageContractInfoVo mortgageContractInfoVo, HttpServletRequest request) {
        try {
            if (mortgageContractInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }

            ApiResult apiResult = mortgageContractInfoService.selectMortgageFetchPawn(mortgageContractInfoVo);
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
     * @param mortgageContractInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "updateMortgageContractInfo", method = {RequestMethod.POST})
    public ApiResult updateMortgageContractInfo(@RequestBody MortgageContractInfoVo mortgageContractInfoVo, HttpServletRequest request) {
        try {
            if (mortgageContractInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //update 基本操作_Begin
            mortgageContractInfoVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            mortgageContractInfoVo.setModifyon(new Date());// 更新时间

            List<PawnDetailVo> pawnDetailVoList =new ArrayList<>();
            for (PawnDetailVo pawnDetailVoTemp:mortgageContractInfoVo.getPawnDetailList() ) {
                //更新操作中，如果明细表有新增记录
                if(StringUtil.isEmpty(pawnDetailVoTemp.getPid())) {
                    pawnDetailVoTemp.setPid(UUID.randomUUID().toString());
                    pawnDetailVoTemp.setMorconinfoid(mortgageContractInfoVo.getId());
                    pawnDetailVoTemp.setCreateby(RequestUtils.CurrentUserId(request));  // 创建人
                    pawnDetailVoTemp.setCreateon(new Date());    // 创建时间
                    pawnDetailVoTemp.setOwner(RequestUtils.CurrentUserId(request)); // 负责人
                    pawnDetailVoTemp.setStatus("0");  // 状态
                }
                pawnDetailVoTemp.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
                pawnDetailVoTemp.setModifyon(new Date());// 更新时间
                pawnDetailVoList.add(pawnDetailVoTemp);
            }
            mortgageContractInfoVo.setPawnDetailList(pawnDetailVoList);
            //update 基本操作_End

            mortgageContractInfoService.update(mortgageContractInfoVo);
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
     * @param mortgageContractInfoVo
     * @param request
     * @return
     */
    @RequestMapping(value = "deleteMortgageContractInfo", method = {RequestMethod.POST})
    public ApiResult deleteMortgageContractInfo(@RequestBody MortgageContractInfoVo mortgageContractInfoVo, HttpServletRequest request) {
        try {
            if (mortgageContractInfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            //delete 基本操作_Begin
            mortgageContractInfoVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
            mortgageContractInfoVo.setModifyon(new Date());// 更新时间
            //delete 基本操作_End
            mortgageContractInfoService.delete(mortgageContractInfoVo);
            return ApiResult.success();
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }
}
