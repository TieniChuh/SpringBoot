package com.mbe.mapper;

import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;
import org.apache.ibatis.annotations.Param;

import com.BaseClass.util.MyMapper;
import com.mbe.model.Warrantinfo;
import com.mbe.vo.BuildinginfoVo;
import com.mbe.vo.WarrantInfoVo;
import com.mbe.vo.WarrantborrowVo;
import com.mbe.vo.WarrantremindVo;

public interface WarrantinfoMapper extends MyMapper<Warrantinfo> {
	List<Warrantinfo> selectWarrantInfo(WarrantInfoVo warrantinfovo);
	
	List<WarrantInfoVo> selectWarrantDetailedInfo(WarrantInfoVo warrantinfovo);
	
	public void updatewarranttstatus(@Param("warrantid")String warrantid);

	void updatewarranttstatusByIds(@Param("warrantids")List warrantids,@Param("warrantstatus")String warrantstatus,@Param("oldwarrantstatus")String oldwarrantstatus);

	List<String> selectUnUpdateWarrantId(@Param("warrantids")List warrantids, @Param("pawndetailids")List pawndetailids);

	List<WarrantInfoVo> selectBorrowInWarrantInfo(WarrantInfoVo warrantinfovo);
	
	List<WarrantInfoVo> selectAllInfo(WarrantInfoVo warrantinfovo);
	
	List<WarrantInfoVo> selectPropertynumberInfo(@Param("warrantpropertynumber")String warrantpropertynumber);
	
	Integer countWarrantsafekeeping(WarrantInfoVo warrantinfovo);
	
	Integer countUnWarrantsafekeeping(WarrantInfoVo warrantinfovo);
	
	Integer countWarrantpropertynumber(WarrantInfoVo warrantinfovo);
	
	Integer countWarrantmortgage(WarrantInfoVo warrantinfovo);
	
	Double sumWarrantusearea(WarrantInfoVo warrantinfovo);
}