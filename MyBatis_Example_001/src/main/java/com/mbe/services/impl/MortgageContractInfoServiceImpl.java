package com.mbe.services.impl;


import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.mbe.mapper.ApartmentInsInfoMapper;
import com.mbe.mapper.MortgageContractInfoMapper;
import com.mbe.mapper.PawnDetailMapper;
import com.mbe.mapper.WarrantinfoMapper;
import com.mbe.model.ApartmentInsInfo;
import com.mbe.model.MortgageContractInfo;
import com.mbe.model.PawnDetail;
import com.mbe.services.MortgageContractInfoService;
import com.mbe.vo.ApartmentInsInfoVo;
import com.mbe.vo.MortgageContractInfoVo;
import com.mbe.vo.Page;
import com.mbe.vo.PawnDetailVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MortgageContractInfoServiceImpl implements MortgageContractInfoService {

    private static Logger log = LoggerFactory.getLogger(MortgageContractInfoServiceImpl.class);

    @Autowired
    private MortgageContractInfoMapper mortgageContractInfoMapper;

    @Autowired
    private PawnDetailMapper pawnDetailMapper;

    @Autowired
    private WarrantinfoMapper warrantinfoMapper;

    @Override
    public void insert(MortgageContractInfoVo mortgageContractInfoVo) throws LogicalException {
        insertOrUpdateSelect(mortgageContractInfoVo,"I");
    }
    private void insertOrUpdateSelect(MortgageContractInfoVo mortgageContractInfoVo,String operatorFlag)throws LogicalException {
        MortgageContractInfo mortgageContractInfo=new MortgageContractInfo();
        PawnDetail pawnDetail=new PawnDetail();
        try {
            BeanUtils.copyProperties(mortgageContractInfoVo, mortgageContractInfo);
            StringBuffer warrantIdsStr=new StringBuffer();
            List<String> warrantIds=new ArrayList<>();
            for (PawnDetailVo tempVo:mortgageContractInfoVo.getPawnDetailList()) {
                BeanUtils.copyProperties(tempVo, pawnDetail);
                warrantIdsStr.append("'").append(tempVo.getPawnaddressid()).append("',");
                warrantIds.add(tempVo.getPawnaddressid());
                pawnDetailMapper.insert(pawnDetail);
            }
            //更新权证信息为 1 warrantIdsStr
            if(StringUtils.isNotBlank(warrantIdsStr.toString())){
                warrantIdsStr.append("''");
                warrantinfoMapper.updatewarranttstatusByIds(warrantIds,"1","0");
            }
            if(StringUtils.equals("I",operatorFlag)){
                mortgageContractInfoMapper.insert(mortgageContractInfo);
            }else{
                mortgageContractInfoMapper.updateByPrimaryKeySelective(mortgageContractInfo);
            }

        }catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException(e.getMessage());
        }
    }
    @Override
    public ApiResult selectMortgageFetchPawn(MortgageContractInfoVo mortgageContractInfoVo) throws LogicalException {
        Map<String, Object> requestMap = mortgageContractInfoVo.toSearchMap();
         //分页参数加入
        requestMap.putAll(mortgageContractInfoVo.toSearchMap());

        int count = mortgageContractInfoMapper.countMortgageFetchPawn(requestMap);
        List<MortgageContractInfoVo> infoList =  mortgageContractInfoMapper.selectMortgageFetchPawn(requestMap);

        Page<MortgageContractInfoVo> page = new Page<>(mortgageContractInfoVo.getCurrentPage(), count, mortgageContractInfoVo.getPageSize());
        page.setList(infoList);
        ApiResult returnVo = new ApiResult();
        returnVo.setData(page);
        return ApiResult.success(returnVo);
     }

    @Override
    public void update(MortgageContractInfoVo mortgageContractInfoVo) throws LogicalException {

        try {
            //权证信息处理
            warrantInfoOperation(mortgageContractInfoVo);

            //先删除明细表数据，再新增
            pawnDetailMapper.deleteByMorconInfoId(mortgageContractInfoVo.getId());

            insertOrUpdateSelect(mortgageContractInfoVo,"U");

         }catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException(e.getMessage());
        }
    }
    private void warrantInfoOperation(MortgageContractInfoVo mortgageContractInfoVo){
        //更新权证表状态 如果相关权证被其他合同抵押，不更新状态。
        List<String> updateWarrentIdList = new ArrayList<>();
        List<String> warrantIds=new ArrayList<>();
        List<String> pawnIds=new ArrayList<>();

        for (PawnDetailVo tempPawnVo:mortgageContractInfoVo.getOldPawnDetailList()) {
            updateWarrentIdList.add(tempPawnVo.getPawnaddressid());

            warrantIds.add(tempPawnVo.getPawnaddressid());
            pawnIds.add(tempPawnVo.getPid());
        }
        //查询不需要修改的warrentIds
        List unUpdateWarrentIds=warrantinfoMapper.selectUnUpdateWarrantId(warrantIds,pawnIds);

        //差集处理
        updateWarrentIdList.removeAll(unUpdateWarrentIds);
        //更新权证 信息为 0 updateWarrentIdsStr

        warrantinfoMapper.updatewarranttstatusByIds(updateWarrentIdList,"0","1");
    }
    @Override
    public void delete(MortgageContractInfoVo mortgageContractInfoVo) throws LogicalException {

        //权证信息处理
        warrantInfoOperation(mortgageContractInfoVo);

        //	Status	数据状态 （0：可用，1：逻辑删除）  抵押物不需要处理
        mortgageContractInfoVo.setStatus("1");

        MortgageContractInfo mortgageContractInfo=new MortgageContractInfo();
        BeanUtils.copyProperties(mortgageContractInfoVo, mortgageContractInfo);
        mortgageContractInfoMapper.updateByPrimaryKeySelective(mortgageContractInfo);

    }
}