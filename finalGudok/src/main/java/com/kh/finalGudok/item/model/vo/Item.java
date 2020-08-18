package com.kh.finalGudok.item.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6935207850394583077L;
	
	private int itemNo;
	private String itemName;
	private int itemPrice;
	private int itemCount;
	private Double itemRate;
	private String itemDpStatus;
	private int itemCmSales;
	private int itemChoice;
	private Date itemDate;
	private String itemRecommend;
	private String categoryNo;
	private int eventNo;
	private String itemMemo;

	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int itemNo, String itemName, int itemPrice, int itemCount, Double itemRate, String itemDpStatus,
			int itemCmSales, int itemChoice, Date itemDate, String itemRecommend, String categoryNo, int eventNo,
			String itemMemo) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemCount = itemCount;
		this.itemRate = itemRate;
		this.itemDpStatus = itemDpStatus;
		this.itemCmSales = itemCmSales;
		this.itemChoice = itemChoice;
		this.itemDate = itemDate;
		this.itemRecommend = itemRecommend;
		this.categoryNo = categoryNo;
		this.eventNo = eventNo;
		this.itemMemo = itemMemo;
	}



	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public Double getItemRate() {
		return itemRate;
	}

	public void setItemRate(Double itemRate) {
		this.itemRate = itemRate;
	}

	public String getItemDpStatus() {
		return itemDpStatus;
	}

	public void setItemDpStatus(String itemDpStatus) {
		this.itemDpStatus = itemDpStatus;
	}

	public int getItemCmSales() {
		return itemCmSales;
	}

	public void setItemCmSales(int itemCmSales) {
		this.itemCmSales = itemCmSales;
	}

	public int getItemChoice() {
		return itemChoice;
	}

	public void setItemChoice(int itemChoice) {
		this.itemChoice = itemChoice;
	}

	public Date getItemDate() {
		return itemDate;
	}

	public void setItemDate(Date itemDate) {
		this.itemDate = itemDate;
	}

	public String getItemRecommend() {
		return itemRecommend;
	}

	public void setItemRecommend(String itemRecommend) {
		this.itemRecommend = itemRecommend;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public String getItemMemo() {
		return itemMemo;
	}

	public void setItemMemo(String itemMemo) {
		this.itemMemo = itemMemo;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemCount="
				+ itemCount + ", itemRate=" + itemRate + ", itemDpStatus=" + itemDpStatus + ", itemCmSales="
				+ itemCmSales + ", itemChoice=" + itemChoice + ", itemDate=" + itemDate + ", itemRecommend="
				+ itemRecommend + ", categoryNo=" + categoryNo + ", eventNo=" + eventNo + ", itemMemo=" + itemMemo
				+ "]";
	}

	

	
	
}
