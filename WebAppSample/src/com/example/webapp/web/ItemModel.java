package com.example.webapp.web;

import java.util.List;

import com.example.webapp.bean.Item;

public class ItemModel extends BaseModel {
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
