package com.mbe.vo;

import com.BaseClass.model.BaseModel;
import com.BaseClass.util.StringUtils;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseSearchVo<T> extends BaseModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//当前页
	@Transient
	protected Integer currentPage = 1;

	//页码
	@Transient
	protected Integer pageSize = 10;

	//选择排序的字段
	@Transient
	protected String sortColumn;

	//升序/降序 - asc/desc
	@Transient
	protected String sortOrder;

	public Map<String, Object> toSearchMap() {
		Map<String, Object> maps = new HashMap<>();
		maps.put("start", (currentPage - 1) * pageSize);
		maps.put("pageSize", pageSize);
		if(StringUtils.isNotBlank(sortColumn)) {
			maps.put("sortColumn", sortColumn);
			if(StringUtils.isNotBlank(sortOrder)) {
				maps.put("sortOrder", sortOrder);
			}
		}
		return maps;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortOrder() { return sortOrder; }

	public void setSortOrder(String sortOrder) { this.sortOrder = sortOrder;}

	public String getSortColumn() { return sortColumn; }

	public void setSortColumn(String sortColumn) { this.sortColumn = sortColumn; }
}
