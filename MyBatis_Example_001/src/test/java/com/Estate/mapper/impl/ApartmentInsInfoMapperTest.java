package com.Estate.mapper.impl;

import com.Estate.mapper.ApartmentInsInfoMapper;
import com.Estate.mapper.GenericMapperTest;
import com.Estate.model.ApartmentInsInfo;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/25.
 */
public class ApartmentInsInfoMapperTest extends GenericMapperTest {
    @Resource
    ApartmentInsInfoMapper apartmentInsInfoMapper;

    private ApartmentInsInfo apartmentInsInfo;
    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        apartmentInsInfo=new ApartmentInsInfo();

        apartmentInsInfo.setInsuranceno("setInsuranceno_001");
        apartmentInsInfo.setInsuredname("setInsuredname_001");
        apartmentInsInfo.setInsstartdate(new Date());
        apartmentInsInfo.setInsenddate(new Date());
        apartmentInsInfo.setInspropertyaddr("setInspropertyaddr_001");
        apartmentInsInfo.setInscompanyname("setInscompanyname_001");
        apartmentInsInfo.setInsamountsum(1000000d);
        apartmentInsInfo.setPremiumsum(20000d);
        apartmentInsInfo.setPaydeadline(new Date());
        apartmentInsInfo.setAttachedinfo("setAttachedinfo_001");


        apartmentInsInfo.setId(UUID.randomUUID().toString());
        apartmentInsInfo.setCreateby("4a24a3b7-1967-4c0a-8d53-da1650ee2edd");  // 创建人
        apartmentInsInfo.setCreateon(new Date());    // 创建时间
        apartmentInsInfo.setModifyby("4a24a3b7-1967-4c0a-8d53-da1650ee2edd");// 更新人
        apartmentInsInfo.setModifyon(new Date());// 更新时间
        apartmentInsInfo.setOwner("4a24a3b7-1967-4c0a-8d53-da1650ee2edd"); // 负责人
        apartmentInsInfo.setStatus("0");  // 状态
        apartmentInsInfoMapper.insert(apartmentInsInfo);
    }

    @Test
    public void testInsertSelective() throws Exception {

    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {

    }

    @Test
    public void testCountByInsNoOrAddress() throws Exception {

    }

    @Test
    public void testSelectByInsNoOrAddress() throws Exception {

    }
}