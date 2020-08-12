package com.kh.finalGudok.item.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class ItemListView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6337821619057909757L;
	private int itemNo;
	private String categoryNo;
	private Date itemDate;
	private String itemName;
	private String itemMemo;
	private int itemPrice;
	private int itemDiscount;
	private Double itemRate;
	private int reviewCount;
	private int itemChoice;
	private int heartNo;

	public ItemListView() {
		// TODO Auto-generated constructor stub
	}

	public ItemListView(String categoryNo, Date itemDate, String itemName, String itemMemo, int itemPrice,
			int itemDiscount, Double itemRate, int reviewCount, int itemChoice, int itemNo, int heartNo) {
		super();
		this.categoryNo = categoryNo;
		this.itemDate = itemDate;
		this.itemName = itemName;
		this.itemMemo = itemMemo;
		this.itemPrice = itemPrice;
		this.itemDiscount = itemDiscount;
		this.itemRate = itemRate;
		this.reviewCount = reviewCount;
		this.itemChoice = itemChoice;
		this.itemNo = itemNo;
		this.heartNo = heartNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public Date getItemDate() {
		return itemDate;
	}

	public void setItemDate(Date itemDate) {
		this.itemDate = itemDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemMemo() {
		return itemMemo;
	}

	public void setItemMemo(String itemMemo) {
		this.itemMemo = itemMemo;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemDiscount() {
		return itemDiscount;
	}

	public void setItemDiscount(int itemDiscount) {
		this.itemDiscount = itemDiscount;
	}

	public Double getItemRate() {
		return itemRate;
	}

	public void setItemRate(Double itemRate) {
		this.itemRate = itemRate;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getItemChoice() {
		return itemChoice;
	}

	public void setItemChoice(int itemChoice) {
		this.itemChoice = itemChoice;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getHeartNo() {
		return heartNo;
	}

	public void setHeartNo(int heartNo) {
		this.heartNo = heartNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ItemListView [categoryNo=" + categoryNo + ", itemDate=" + itemDate + ", itemName=" + itemName
				+ ", itemMemo=" + itemMemo + ", itemPrice=" + itemPrice + ", itemDiscount=" + itemDiscount
				+ ", itemRate=" + itemRate + ", reviewCount=" + reviewCount + ", itemChoice=" + itemChoice + ", itemNo="
				+ itemNo + ", heartNo=" + heartNo + "]";
	}

	


}
