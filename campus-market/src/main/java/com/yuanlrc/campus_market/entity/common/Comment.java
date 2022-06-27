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
 * 评论物品实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="ylrc_comment")
@EntityListeners(AuditingEntityListener.class)
public class Comment extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;//所属学生
	
	@ManyToOne
	@JoinColumn(name="goods_id")
	private Goods goods;//评论的物品
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=1000,errorRequiredMsg="The comment cannot be empty.",errorMinLengthMsg="Length of comment should be longer than 1.",errorMaxLengthMsg="Length of comment should be no longer than 1000.")
	@Column(name="content",nullable=false,length=1024)
	private String content;//评论内容
	
	
	@Column(name="reply_to",length=64)
	private String replyTo;//回复者

	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	@Override
	public String toString() {
		return "Comment [student=" + student + ", goods=" + goods
				+ ", content=" + content + ", replyTo=" + replyTo + "]";
	}

	
	
}
