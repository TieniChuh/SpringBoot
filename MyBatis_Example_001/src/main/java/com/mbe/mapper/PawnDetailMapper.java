package com.mbe.mapper;

import com.mbe.model.PawnDetail;
/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public interface PawnDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(PawnDetail record);

    int insertSelective(PawnDetail record);

    PawnDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PawnDetail record);

    int updateByPrimaryKey(PawnDetail record);

    int deleteByMorconInfoId(String morconInfoId);

}