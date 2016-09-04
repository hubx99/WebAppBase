package com.example.webapp.web;

import java.util.Collections;

import org.apache.ibatis.session.SqlSession;

import com.example.webapp.db.DBMapper;
import com.example.webapp.db.DBUtil;

public class EditModel extends AddModel {
	public void open() {
		try (SqlSession session = DBUtil.openSession()) {
			DBMapper db = session.getMapper(DBMapper.class);
			setMap(db.selectUsersOne(getUser(), getId()));
			if (getMap() == null) {
				setItems(Collections.emptyList());
			}
			System.out.println(getMap());
			setSuccess();
		}
	}

	public void submit() {
		if (!validate()) {
			return;
		}

		try (SqlSession session = DBUtil.openSession()) {
			DBMapper db = session.getMapper(DBMapper.class);
			System.out.println("update id: " + getId());

			boolean exists = db.existsUser(getUser(), getId());
			System.out.println("update: exists=" + exists);
			if (!exists) {
				return;
			}

			int r = db.updateUser(getUser(), getId(), getMap());
			System.out.println("update: " + r);
			if (r > 0) {
				session.commit();
				setSuccess();
			}
		}
	}
}
