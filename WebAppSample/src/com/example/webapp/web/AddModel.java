package com.example.webapp.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.example.webapp.bean.Item;
import com.example.webapp.db.DBMapper;
import com.example.webapp.db.DBUtil;

public class AddModel extends ItemModel {
	private Map<String, Object> map;
	private String id;

	public void open() {
		map = Collections.emptyMap();
		setSuccess();
	}

	public void submit() {
		if (!validate()) {
			return;
		}

		try (SqlSession session = DBUtil.openSession()) {
			DBMapper db = session.getMapper(DBMapper.class);
			System.out.println("insert id: " + id);

			boolean exists = db.existsUser(getUser(), id);
			System.out.println("insert: exists=" + exists);
			if (exists) {
				return;
			}

			int r = db.insertUser(getUser(), id, map);
			System.out.println("insert: " + r);
			if (r > 0) {
				session.commit();
				setSuccess();
			}
		}
	}

	protected boolean validate() {
		boolean valid = true;
		map = new HashMap<>();
		for (Item i : getItems()) {
			map.put(i.getKey(), i.validate(getReq()));
			if (i.getValidation().isError()) {
				System.out.println("[VALIDATION][ERR] " + i.getKey());
				valid = false;
			}
		}
		System.out.println(map);
		return valid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}
