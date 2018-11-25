package com.example.dynamictable.model;

import java.util.List;

public class MenuDto {	
	
	private Integer id;

	private Integer switchBoard;
	private Integer itemNumber;
	private String menuLabel;

	List<SubMenuDto> subMenus;

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

	public List<SubMenuDto> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenuDto> subMenus) {
		this.subMenus = subMenus;
	}
	
	
}
