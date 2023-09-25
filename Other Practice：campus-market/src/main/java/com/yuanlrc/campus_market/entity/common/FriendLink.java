package com.yuanlrc.campus_market.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yuanlrc.campus_market.annotion.ValidateEntity;

/**
 * 友情链接实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="ylrc_friend_link")
@EntityListeners(AuditingEntityListener.class)
public class FriendLink extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=64,errorRequiredMsg="The name of friend link cannot be empty.",errorMinLengthMsg="Length of friend link should be longer than 1.",errorMaxLengthMsg="Length of friend link should be no longer than 64.")
	@Column(name="name",nullable=false,length=64)
	private String name;//友情链接名称
	
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=256,errorRequiredMsg="The URL of friend link cannot be empty.",errorMinLengthMsg="Length of friend link URL should be longer than 1.",errorMaxLengthMsg="Length of friend link should be no longer than 256.")
	@Column(name="url",nullable=false,length=256)
	private String url;//友情链接地址
	
	@Column(name="sort",nullable=false,length=4)
	private Integer sort = 0;//显示顺序，默认升序排列,默认是0

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "FriendLink [name=" + name + ", url=" + url + ", sort=" + sort
				+ "]";
	}
	
	

	
	
	
	
}
