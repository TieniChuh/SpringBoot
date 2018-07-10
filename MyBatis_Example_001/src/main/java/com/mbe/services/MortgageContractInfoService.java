package com.mbe.services;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
 import com.mbe.vo.MortgageContractInfoVo;

 /**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public interface MortgageContractInfoService {

    /**
     * @param mortgageContractInfoVo
     * @throws LogicalException
     */
    void insert(MortgageContractInfoVo mortgageContractInfoVo) throws LogicalException;

    /**
     * @param mortgageContractInfoVo
     * @return
     * @throws LogicalException
     */
    ApiResult selectMortgageFetchPawn(MortgageContractInfoVo mortgageContractInfoVo) throws LogicalException;

    /**
     *
     * @param mortgageContractInfoVo
     * @throws LogicalException
     */
    void update(MortgageContractInfoVo mortgageContractInfoVo) throws LogicalException;

    /**
     *
     * @param mortgageContractInfoVo
     * @throws LogicalException
     */
    void delete(MortgageContractInfoVo mortgageContractInfoVo) throws LogicalException;

}