package com.example.dynamictable.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Views")
public class ViewConfigEntity {

	@Id
	@Column(name="ID")
	private Integer id;

	@Column(name = "SWITCH_BOARD")
	private Integer switchBoard;

	@Column(name = "ITEM_NUMBER")
	private Integer itemNumber;

	@Column(name = "MENU_LABEL")
	private String menuLabel;

	@Column(name = "VIEW_ID")
	private String viewId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSwitchBoard() {
		return switchBoard;
	}

	public void setSwitchBoard(Integer switchBoard) {
		this.switchBoard = switchBoard;
	}

	public Integer getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getMenuLabel() {
		return menuLabel;
	}

	public void setMenuLabel(String menuLabel) {
		this.menuLabel = menuLabel;
	}

	public String getViewId() {
		return viewId;
	}

	public void setViewId(String viewId) {
		this.viewId = viewId;
	}

	
}
