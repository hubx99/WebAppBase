package com.example.webapp.web.user;

import java.util.ArrayList;
import java.util.List;

import com.example.webapp.bean.Item;
import com.example.webapp.bean.Item.VarType;
import com.example.webapp.web.EditModel;

public class UserModel extends EditModel {

	@Override
	public void open() {
		List<Item> items = new ArrayList<>();

		Item item1 = new Item();
		item1.setVarType(VarType.VIEW);
		item1.setKey("id");
		item1.setLabel("id");
		items.add(item1);

		Item item2 = new Item();
		item2.setKey("name");
		item2.setLabel("name");
		items.add(item2);

		Item item3 = new Item();
		item3.setKey("role_id");
		item3.setLabel("role");
		items.add(item3);

		setItems(items);
		super.open();
	}

	@Override
	public void submit() {
		List<Item> items = new ArrayList<>();

		Item item1 = new Item();
		item1.setVarType(VarType.VIEW);
		item1.setKey("id");
		item1.setLabel("id");
		items.add(item1);

		Item item2 = new Item();
		item2.setKey("name");
		item2.setLabel("name");
		items.add(item2);

		Item item3 = new Item();
		item3.setKey("role_id");
		item3.setLabel("role");
		items.add(item3);

		setItems(items);
		super.submit();
	}
}
