package com.dushop;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dushop.common.entity.CartItem;
import com.dushop.common.entity.ShippingRate;
import com.dushop.common.entity.Product;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.checkout
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-28  14:45
 *@Description: TODO
 *@Version: 1.0
 */

@Service
public class CheckoutService {
    private static final int DIM_DIVISOR = 139;
    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    public CheckoutInfo prepareCheckout(List<CartItem> cartItems, ShippingRate shippingRate) {
        CheckoutInfo checkoutInfo = new CheckoutInfo();

        float productCost = calculateProductCost(cartItems);
        float productTotal = calculateProductTotal(cartItems);
        float shippingCostTotal = calculateShippingCost(cartItems, shippingRate);
        float paymentTotal = productTotal + shippingCostTotal;

        checkoutInfo.setProductCost(productCost);
        checkoutInfo.setProductTotal(productTotal);
        checkoutInfo.setShippingCostTotal(shippingCostTotal);
        checkoutInfo.setPaymentTotal(paymentTotal);

        checkoutInfo.setDeliverDays(shippingRate.getDays());
        checkoutInfo.setCodSupported(shippingRate.isCodSupported());

        return checkoutInfo;
    }

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    private float calculateShippingCost(List<CartItem> cartItems, ShippingRate shippingRate) {
        float shippingCostTotal = 0.0f;

        for (CartItem item : cartItems) {
            Product product = item.getProduct();
            float dimWeight = (product.getLength() * product.getWidth() * product.getHeight()) / DIM_DIVISOR;
            float finalWeight = product.getWeight() > dimWeight ? product.getWeight() : dimWeight;
            float shippingCost = finalWeight * item.getQuantity() * shippingRate.getRate();

            item.setShippingCost(shippingCost);

            shippingCostTotal += shippingCost;
        }

        return shippingCostTotal;
    }

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    private float calculateProductTotal(List<CartItem> cartItems) {
        float total = 0.0f;

        for (CartItem item : cartItems) {
            total += item.getSubtotal();
        }

        return total;
    }

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    private float calculateProductCost(List<CartItem> cartItems) {
        float cost = 0.0f;

        for (CartItem item : cartItems) {
            cost += item.getQuantity() * item.getProduct().getCost();
        }

        return cost;
    }
}