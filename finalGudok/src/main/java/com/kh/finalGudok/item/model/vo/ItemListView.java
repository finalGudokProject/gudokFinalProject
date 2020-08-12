package com.kh.finalGudok.item.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class ItemListView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6337821619057909757L;
	private int itemNo;
	private String itemName;
	private String itemMemo;
	private int itemPrice;
	private int itemDiscount;
	private int itemRate;
	private int reviewCount;
	private int itemChoice;

	public ItemListView() {
		// TODO Auto-generated constructor stub
	}

	public ItemListView(int itemNo, String itemName, String itemMemo, int itemPrice, int itemDiscount, int itemRate,
			int reviewCount, int itemChoice) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemMemo = itemMemo;
		this.itemPrice = itemPrice;
		this.itemDiscount = itemDiscount;
		this.itemRate = itemRate;
		this.reviewCount = reviewCount;
		this.itemChoice = itemChoice;
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

	public int getItemRate() {
		return itemRate;
	}

	public void setItemRate(int itemRate) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ItemListView [itemNo=" + itemNo + ", itemName=" + itemName + ", itemMemo=" + itemMemo + ", itemPrice="
				+ itemPrice + ", itemDiscount=" + itemDiscount + ", itemRate=" + itemRate + ", reviewCount="
				+ reviewCount + ", itemChoice=" + itemChoice + "]";
	}

}
