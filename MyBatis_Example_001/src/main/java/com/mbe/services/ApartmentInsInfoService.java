package com.mbe.services;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
 import com.mbe.vo.ApartmentInsInfoVo;


/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public interface ApartmentInsInfoService {

    /**
     * @param apartmentInsInfoVo
     * @throws LogicalException
     */
      void insert(ApartmentInsInfoVo apartmentInsInfoVo) throws LogicalException;

    /**
     * @param apartmentInsInfoVo
     * @return
     * @throws LogicalException
     */
      ApiResult queryByInsNoOrAddress(ApartmentInsInfoVo apartmentInsInfoVo) throws LogicalException;

    /**
     *
     * @param apartmentInsInfoVo
     * @throws LogicalException
     */
    void update(ApartmentInsInfoVo apartmentInsInfoVo) throws LogicalException;

    /**
     *
     * @param apartmentInsInfoVo
     * @throws LogicalException
     */
    void delete(ApartmentInsInfoVo apartmentInsInfoVo) throws LogicalException;

}