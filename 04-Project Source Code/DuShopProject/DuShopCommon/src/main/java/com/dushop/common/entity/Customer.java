package com.dushop.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.common.entity
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-15  16:47
 *@Description: TODO
 *@Version: 1.0
 */

@Entity
@Table(name = "customers")
public class Customer extends AbstractAddressWithCountry {


    /*self-finish*/
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    /*self-finish*/
    @Column(nullable = false, length = 64)
    private String password;

    /*self-finish*/
    @Column(name = "reset_password_token", length = 30)
    private String resetPasswordToken;

    /*self-finish*/
    @Column(name = "verification_code", length = 64)
    private String verificationCode;

    /*self-finish*/
    private boolean enabled;

    /*self-finish*/
    @Column(name = "created_time")
    private Date createdTime;

    /*self-finish*/
    @Enumerated(EnumType.STRING)
    @Column(name = "authentication_type", length = 10)
    private AuthenticationType authenticationType;

    /*Auto-generated by InteliJ Idea*/
    public AuthenticationType getAuthenticationType() {
        return authenticationType;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setAuthenticationType(AuthenticationType authenticationType) {
        this.authenticationType = authenticationType;
    }
    /*Auto-generated by InteliJ Idea*/
    public String getResetPasswordToken() {
        return resetPasswordToken;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }
    /*Auto-generated by InteliJ Idea*/
    public Customer() {
    }
    /*Auto-generated by InteliJ Idea*/
    public Customer(Integer id) {
        this.id = id;
    }

    /*Auto-generated by InteliJ Idea*/
    public String getEmail() {
        return email;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setEmail(String email) {
        this.email = email;
    }
    /*Auto-generated by InteliJ Idea*/
    public String getPassword() {
        return password;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setPassword(String password) {
        this.password = password;
    }

    /*Auto-generated by InteliJ Idea*/
    public String getVerificationCode() {
        return verificationCode;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
    /*Auto-generated by InteliJ Idea*/
    public boolean isEnabled() {
        return enabled;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    /*Auto-generated by InteliJ Idea*/
    public Date getCreatedTime() {
        return createdTime;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /*Auto-generated by InteliJ Idea*/
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
