package com.mbe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.mbe.vo.RoomSplitInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.BaseClass.util.RequestUtils;
import com.mbe.model.Roominfo;
import com.mbe.paasvo.BasetreeinstanceVo;
import com.mbe.services.RoominfoService;
import com.mbe.vo.RoominfoVo;
import com.mysql.jdbc.StringUtils;

@RestController
@RequestMapping("/room")
public class RoominfoController {
	@Autowired
	private RoominfoService roominfoService;

	@RequestMapping(value = "/selectAll", method = { RequestMethod.POST })
	public ApiResult selectAll(@RequestBody RoominfoVo roominfovo, HttpServletRequest request) {
		try {
			if (roominfovo == null) {
				return ApiResult.fail("参数对象无效！");
			}
			roominfovo = RequestUtils.CurrentPageOwnerList(request, roominfovo);
			return ApiResult.success(roominfoService.selectAll(roominfovo));
		} catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}

	@RequestMapping(value = "/selectById", method = { RequestMethod.GET })
	public ApiResult selectById(String roomid, HttpServletRequest request) {
		try {
			if (roomid == null) {
				return ApiResult.fail("参数对象无效！");
			}
			return ApiResult.success(roominfoService.selectById(roomid));
		} catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}

	@RequestMapping(value = "/insert", method = { RequestMethod.POST })
	public ApiResult insert(@RequestBody RoominfoVo roominfovo, HttpServletRequest request) {
		try {
			if (roominfovo == null) {
				return ApiResult.fail("参数对象无效！");
			}
			roominfovo.setCreateby(RequestUtils.CurrentUserId(request));
			roominfovo.setModifyby(RequestUtils.CurrentUserId(request));
			roominfovo.setOwner(RequestUtils.CurrentUserId(request));
			roominfoService.insert(roominfovo, request);
			return ApiResult.success();
		} catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}

	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public ApiResult update(@RequestBody RoominfoVo roominfovo, HttpServletRequest request) {
		try {
			if (roominfovo == null) {
				return ApiResult.fail("参数对象无效！");
			}

			if (StringUtils.isNullOrEmpty(roominfovo.getRoomid())) {
				return ApiResult.fail("房间id为空！");
			}
			roominfovo.setModifyby(RequestUtils.CurrentUserId(request));
			roominfoService.update(roominfovo, request);
			return ApiResult.success();
		} catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.POST })
	public ApiResult delete(@RequestBody RoominfoVo roominfovo, HttpServletRequest request) {
		try {
			if (roominfovo == null) {
				return ApiResult.fail("参数对象无效！");
			}
			roominfovo.setModifyby(RequestUtils.CurrentUserId(request));
			roominfoService.delete(roominfovo, request);
			return ApiResult.success();
		} catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}

	/**
	 * 按照需求类型，统计房间面积
	 * 
	 * @param bVo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sumAreaByCondition", method = { RequestMethod.POST })
	public ApiResult sumAreaByCondition(@RequestBody BasetreeinstanceVo bVo, HttpServletRequest request) {

		try {
			if (bVo == null || bVo.getCodeList().size() == 0) {
				return ApiResult.fail("参数对象无效！");
			}
			bVo.setOwner(RequestUtils.CurrentUserId(request));
			//=====
			bVo = RequestUtils.CurrentPageOwnerList(request, bVo);
			//=====
			return ApiResult.success(roominfoService.sumAreaByCondition(bVo));
		} catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}

	/**
	 * 
	 * @param roominfoVoList  房间列表
	 */
	@RequestMapping(value = "/usableRoom", method = { RequestMethod.POST })
	public ApiResult usableUpdate(@RequestBody ArrayList<RoominfoVo> roominfoVoList, HttpServletRequest request) {

		try {
			if (roominfoVoList == null || roominfoVoList.size() == 0) {
				return ApiResult.fail("参数对象无效！");
			}
			
			// usable = "0" 可用
			String usable = "0";
			roominfoService.usableRoom(roominfoVoList, usable);
			return ApiResult.success();
		} catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
		
	}

	/**
	 * 
	 * @param roominfoVoList  房间列表
	 */
	@RequestMapping(value = "/disableRoom", method = { RequestMethod.POST })
	public ApiResult disableUpdate(@RequestBody ArrayList<RoominfoVo> roominfoVoList, HttpServletRequest request) {

		try {
			if (roominfoVoList == null || roominfoVoList.size() == 0) {
				return ApiResult.fail("参数对象无效！");
			}
			// usable = "1" 不可用
			String usable = "1";
			roominfoService.usableRoom(roominfoVoList, usable);
			return ApiResult.success();
		} catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}

	/**
	 * 
	 * 查询委托房源
	 */
	@RequestMapping(value = "/selectAllTrustRoom", method = { RequestMethod.POST })
	public ApiResult selectAllTrustRoom(@RequestBody RoominfoVo roominfovo, HttpServletRequest request) {
		try {
			if (roominfovo == null) {
				return ApiResult.fail("参数对象无效！");
			}
			roominfovo = RequestUtils.CurrentPageOwnerList(request, roominfovo);
			return ApiResult.success(roominfoService.selectAllTrustRoom(roominfovo));
		} catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
	// ==class=end
	/**
	 *
	 * 房源拆分
	 */
	@RequestMapping(value = "/roomSplit", method = { RequestMethod.POST })
	public ApiResult roomSplit(@RequestBody RoomSplitInfoVo roomsplitinfoVo, HttpServletRequest request) {
		try {
			if (roomsplitinfoVo == null) {
				return ApiResult.fail("参数对象无效！");
			}
			for (RoominfoVo oldroomtemp:roomsplitinfoVo.getOldroomlist() ) {
				//update 基本操作_Begin
				oldroomtemp.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
				oldroomtemp.setModifyon(new Date());// 更新时间
				oldroomtemp.setRoomstatus("2"); //0 启用 1 停用 2 失效
				//update 基本操作_End
			}
			for (RoominfoVo newroomtemp:roomsplitinfoVo.getNewroomlist() ) {
				//insert 基本操作_Begin
				newroomtemp.setRoomid(UUID.randomUUID().toString());
				newroomtemp.setCreateby(RequestUtils.CurrentUserId(request));  // 创建人
				newroomtemp.setCreateon(new Date());    // 创建时间
				newroomtemp.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
				newroomtemp.setModifyon(new Date());// 更新时间
				newroomtemp.setOwner(RequestUtils.CurrentUserId(request)); // 负责人
				newroomtemp.setStatus("0");  // 状态
				//insert 基本操作_End
			}
			//insert 基本操作_Begin 拆分几率
			roomsplitinfoVo.setId(UUID.randomUUID().toString());
			roomsplitinfoVo.setCreateby(RequestUtils.CurrentUserId(request));  // 创建人
			roomsplitinfoVo.setCreateon(new Date());    // 创建时间
			roomsplitinfoVo.setModifyby(RequestUtils.CurrentUserId(request));// 更新人
			roomsplitinfoVo.setModifyon(new Date());// 更新时间
			roomsplitinfoVo.setOwner(RequestUtils.CurrentUserId(request)); // 负责人
			roomsplitinfoVo.setStatus("0");  // 状态
			//insert 基本操作_End
			roominfoService.roomSplit(roomsplitinfoVo);

			return ApiResult.success();
		} catch (LogicalException e) {
			return ApiResult.fail(e.getMessage());
		} catch (Exception e) {
			return ApiResult.fail("操作失败！");
		}
	}
}
