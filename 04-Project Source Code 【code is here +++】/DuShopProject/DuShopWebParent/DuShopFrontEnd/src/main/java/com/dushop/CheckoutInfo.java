package com.dushop;

import java.util.Calendar;
import java.util.Date;
import java.text.DecimalFormat;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.checkout
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-28  14:43
 *@Description: TODO
 *@Version: 1.0
 */

public class CheckoutInfo {
    private float productCost;
    private float productTotal;
    private float shippingCostTotal;
    private float paymentTotal;
    private int deliverDays;
    private boolean codSupported;
    /*Auto-generated by InteliJ Idea*/
    public float getProductCost() {
        return productCost;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setProductCost(float productCost) {
        this.productCost = productCost;
    }
    /*Auto-generated by InteliJ Idea*/
    public float getProductTotal() {
        return productTotal;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setProductTotal(float productTotal) {
        this.productTotal = productTotal;
    }
    /*Auto-generated by InteliJ Idea*/
    public float getShippingCostTotal() {
        return shippingCostTotal;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setShippingCostTotal(float shippingCostTotal) {
        this.shippingCostTotal = shippingCostTotal;
    }
    /*Auto-generated by InteliJ Idea*/
    public float getPaymentTotal() {
        return paymentTotal;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setPaymentTotal(float paymentTotal) {
        this.paymentTotal = paymentTotal;
    }
    /*Auto-generated by InteliJ Idea*/
    public int getDeliverDays() {
        return deliverDays;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setDeliverDays(int deliverDays) {
        this.deliverDays = deliverDays;
    }

    /*self code*/
    public Date getDeliverDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, deliverDays);

        return calendar.getTime();
    }
    /*self code*/
    public boolean isCodSupported() {
        return codSupported;
    }
    /*self code*/
    public void setCodSupported(boolean codSupported) {
        this.codSupported = codSupported;
    }
    /*self code*/
    public String getPaymentTotal4PayPal() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return formatter.format(paymentTotal);
    }

}
