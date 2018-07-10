package com.mbe.mapper;

import com.mbe.model.MortgageContractInfo;
import com.mbe.vo.ApartmentInsInfoVo;
import com.mbe.vo.MortgageContractInfoVo;

import java.util.List;
import java.util.Map;

/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public interface MortgageContractInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(MortgageContractInfo record);

    int insertSelective(MortgageContractInfo record);

    MortgageContractInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MortgageContractInfo record);

    int updateByPrimaryKey(MortgageContractInfo record);

    List<MortgageContractInfoVo> selectMortgageFetchPawn(Map<String, Object> requestMap);
   int countMortgageFetchPawn(Map<String, Object> requestMap);



}