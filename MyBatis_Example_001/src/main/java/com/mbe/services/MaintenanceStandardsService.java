package com.mbe.services;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.mbe.vo.MaintenanceStandardsVo;
import com.mbe.vo.MortgageContractInfoVo;

import java.util.Date;
import java.util.Map;

/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public interface MaintenanceStandardsService {

    /**
     * @param maintenanceStandardsVo
     * @throws LogicalException
     */
    void insert(MaintenanceStandardsVo maintenanceStandardsVo) throws LogicalException;

    /**
     * @param maintenanceStandardsVo
     * @return
     * @throws LogicalException
     */
    ApiResult fuzzyQuery(MaintenanceStandardsVo maintenanceStandardsVo) throws LogicalException;

    /**
     *
     * @param maintenanceStandardsVo
     * @throws LogicalException
     */
    void update(MaintenanceStandardsVo maintenanceStandardsVo) throws LogicalException;

    /**
     *
     * @param maintenanceStandardsVo
     * @throws LogicalException
     */
    void delete(MaintenanceStandardsVo maintenanceStandardsVo) throws LogicalException;
}