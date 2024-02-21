package com.dushop.common.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.common.entity
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-27  16:44
 *@Description: Self-finished
 *@Version: 1.0
 */

public enum OrderStatus {

    NEW {
        @Override
        public String defaultDescription() {
            return "Order placed";
        }

    },

    CANCELLED {
        @Override
        public String defaultDescription() {
            return "Order rejected";
        }
    },

    PROCESSING {
        @Override
        public String defaultDescription() {
            return "Order is being processed";
        }
    },


    PICKED {
        @Override
        public String defaultDescription() {
            return "Shipper picked";
        }
    },

    SHIPPING {
        @Override
        public String defaultDescription() {
            return "Shipper delivering";
        }
    },

    DELIVERED {
        @Override
        public String defaultDescription() {
            return "Customer received";
        }
    },

    RETURNED {
        @Override
        public String defaultDescription() {
            return "Products were returned";
        }
    },

    PAID {
        @Override
        public String defaultDescription() {
            return "Customer has paid this order";
        }
    },

    REFUNDED {
        @Override
        public String defaultDescription() {
            return "Customer refunded";
        }
    };

    public abstract String defaultDescription();
}