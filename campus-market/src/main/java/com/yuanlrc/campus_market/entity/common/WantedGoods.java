package com.yuanlrc.campus_market.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yuanlrc.campus_market.annotion.ValidateEntity;
import com.yuanlrc.campus_market.entity.common.BaseEntity;

/**
 * 求购物品实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="ylrc_wanted_goods")
@EntityListeners(AuditingEntityListener.class)
public class WantedGoods extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;//所属学生
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=30,errorRequiredMsg="The item name cannot be empty.",errorMinLengthMsg="Length of item name should be longer than 1.",errorMaxLengthMsg="Length of item name should be no longer than 30.")
	@Column(name="name",nullable=false,length=32)
	private String name;//物品名称
	
	@ValidateEntity(required=true,errorRequiredMsg="Please fill in the expected price",requiredMinValue=true,errorMinValueMsg="Expected price cannot be less than 0.")
	@Column(name="sell_price",nullable=false,length=8)
	private Float sellPrice;//期望价格
	
	@ValidateEntity(required=true,minLength=1,maxLength=128,errorRequiredMsg="The transaction location cannot be empty.",errorMinLengthMsg="Length of transaction location should be longer than 1.",errorMaxLengthMsg="Length of transaction location should be no longer than 100.")
	@Column(name="trade_place",nullable=false,length=128)
	private String tradePlace;//期望交易地点
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=1000,errorRequiredMsg="The item description cannot be empty.",errorMinLengthMsg="Length of item description should be longer than 1.",errorMaxLengthMsg="Length of item description should be no longer than 1000.")
	@Column(name="content",nullable=false,length=1024)
	private String content;//物品详情描述
	
	@Column(name="view_number",nullable=false,length=8)
	private int viewNumber = 0;//物品浏览量

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Float getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Float sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getTradePlace() {
		return tradePlace;
	}

	public void setTradePlace(String tradePlace) {
		this.tradePlace = tradePlace;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewNumber() {
		return viewNumber;
	}

	public void setViewNumber(int viewNumber) {
		this.viewNumber = viewNumber;
	}

	@Override
	public String toString() {
		return "WantedGoods [student=" + student + ", name=" + name
				+ ", sellPrice=" + sellPrice + ", tradePlace=" + tradePlace
				+ ", content=" + content + ", viewNumber=" + viewNumber + "]";
	}

	
	


	
}
