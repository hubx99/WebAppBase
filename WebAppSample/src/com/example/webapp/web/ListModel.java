package com.example.webapp.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.example.webapp.db.DBMapper;
import com.example.webapp.db.DBUtil;

public class ListModel extends ItemModel {
	private List<Map<String, Object>> list;

	private String order;
	private String sort;
	private String filter;

	public void open() {
		try (SqlSession session = DBUtil.openSession()) {
			DBMapper db = session.getMapper(DBMapper.class);
			list = db.selectUsers2(getUser());
			setSuccess();
		}
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list2) {
		this.list = list2;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
}
