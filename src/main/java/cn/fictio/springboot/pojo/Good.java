package cn.fictio.springboot.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="good")
public class Good {
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String goodName;
	@Column
	private float goodPrice;
	@Column
	private float costPrice;
	@Column
	private Timestamp upDate;
	@Column
	private int storeNums;
	@Column
	private int isDel;
	@Column
	private String context;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public void setGoodPrice(int goodPrice) {
		this.goodPrice = goodPrice;
	}
	public float getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(float goodPrice) {
		this.goodPrice = goodPrice;
	}
	public float getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}
	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}
	public Timestamp getUpDate() {
		return upDate;
	}
	public void setUpDate(Timestamp upDate) {
		this.upDate = upDate;
	}
	public int getStoreNums() {
		return storeNums;
	}
	public void setStoreNums(int storeNums) {
		this.storeNums = storeNums;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
}
