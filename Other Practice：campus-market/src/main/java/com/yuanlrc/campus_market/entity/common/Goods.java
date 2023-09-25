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
 * 物品实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="ylrc_goods")
@EntityListeners(AuditingEntityListener.class)
public class Goods extends BaseEntity{

	public static final int GOODS_STATUS_UP = 1;//上架
	public static final int GOODS_STATUS_DOWN = 2;//下架
	public static final int GOODS_STATUS_SOLD = 3;//已售出
	
	public static final int GOODS_FLAG_ON = 1;//擦亮
	public static final int GOODS_FLAG_OFF = 0;//不擦亮

	public static final int GOODS_RECOMMEND_OFF = 0;//不推荐
	public static final int GOODS_RECOMMEND_ON = 1;//推荐
	
	
	
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
	
	@ManyToOne
	@JoinColumn(name="goods_category_id")
	private GoodsCategory goodsCategory;//物品分类
	
	@ValidateEntity(required=true,errorRequiredMsg="Please fill in the purchase price.",requiredMinValue=true,errorMinValueMsg="Purchase price should be more than 0.")
	@Column(name="buy_price",nullable=false,length=8)
	private Float buyPrice;//购买价格
	
	@ValidateEntity(required=true,errorRequiredMsg="Please fill in the selling price.",requiredMinValue=true,errorMinValueMsg="Selling price should be more than 0.")
	@Column(name="sell_price",nullable=false,length=8)
	private Float sellPrice;//出售价格
	
	@ValidateEntity(required=true,errorRequiredMsg="Please upload a picture")
	@Column(name="photo",nullable=false,length=128)
	private String photo;//物品图片
	
	@Column(name="status",nullable=false,length=1)
	private int status = GOODS_STATUS_UP;//物品状态，默认上架
	
	@Column(name="flag",nullable=false,length=1)
	private int flag = GOODS_FLAG_OFF;//是否擦亮
	
	@Column(name="recommend",nullable=false,length=1)
	private int recommend = GOODS_RECOMMEND_OFF;//是否推荐
	
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

	public GoodsCategory getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(GoodsCategory goodsCategory) {
		this.goodsCategory = goodsCategory;
	}

	public Float getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Float buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Float getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Float sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
	public int getViewNumber() {
		return viewNumber;
	}

	public void setViewNumber(int viewNumber) {
		this.viewNumber = viewNumber;
	}

	@Override
	public String toString() {
		return "Goods [student=" + student + ", name=" + name
				+ ", goodsCategory=" + goodsCategory + ", buyPrice=" + buyPrice
				+ ", sellPrice=" + sellPrice + ", photo=" + photo + ", status="
				+ status + ", flag=" + flag + ", recommend=" + recommend
				+ ", content=" + content + ", viewNumber=" + viewNumber + "]";
	}

	
	


	
}
