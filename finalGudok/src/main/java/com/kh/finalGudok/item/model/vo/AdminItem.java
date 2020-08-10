package com.kh.finalGudok.item.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class AdminItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1476512498108750682L;
	
	private int itemNo;
	private String itemName;
	private int itemPrice;
	private int itemRate;
	private String itemDpStatus;
	private int itemCmSales;
	private int itemChoice;
	private Date itemDate;
	private String itemRecommend;
	private String categoryNo;
	private String itemMemo;
	private String itemEventStatus;
	private String imageOriginalName;
	private String imageRename;
	private String imagePath;
	
	public AdminItem() {}

	public AdminItem(int itemNo, String itemName, int itemPrice, int itemRate, String itemDpStatus, int itemCmSales,
			int itemChoice, Date itemDate, String itemRecommend, String categoryNo, String itemMemo,
			String itemEventStatus, String imageOriginalName, String imageRename, String imagePath) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemRate = itemRate;
		this.itemDpStatus = itemDpStatus;
		this.itemCmSales = itemCmSales;
		this.itemChoice = itemChoice;
		this.itemDate = itemDate;
		this.itemRecommend = itemRecommend;
		this.categoryNo = categoryNo;
		this.itemMemo = itemMemo;
		this.itemEventStatus = itemEventStatus;
		this.imageOriginalName = imageOriginalName;
		this.imageRename = imageRename;
		this.imagePath = imagePath;
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

	public int getItemRate() {
		return itemRate;
	}

	public void setItemRate(int itemRate) {
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

	public String getItemMemo() {
		return itemMemo;
	}

	public void setItemMemo(String itemMemo) {
		this.itemMemo = itemMemo;
	}

	public String getItemEventStatus() {
		return itemEventStatus;
	}

	public void setItemEventStatus(String itemEventStatus) {
		this.itemEventStatus = itemEventStatus;
	}

	public String getImageOriginalName() {
		return imageOriginalName;
	}

	public void setImageOriginalName(String imageOriginalName) {
		this.imageOriginalName = imageOriginalName;
	}

	public String getImageRename() {
		return imageRename;
	}

	public void setImageRename(String imageRename) {
		this.imageRename = imageRename;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AdminItem [itemNo=" + itemNo + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemRate="
				+ itemRate + ", itemDpStatus=" + itemDpStatus + ", itemCmSales=" + itemCmSales + ", itemChoice="
				+ itemChoice + ", itemDate=" + itemDate + ", itemRecommend=" + itemRecommend + ", categoryNo="
				+ categoryNo + ", itemMemo=" + itemMemo + ", itemEventStatus=" + itemEventStatus
				+ ", imageOriginalName=" + imageOriginalName + ", imageRename=" + imageRename + ", imagePath="
				+ imagePath + "]";
	}
	
	

}