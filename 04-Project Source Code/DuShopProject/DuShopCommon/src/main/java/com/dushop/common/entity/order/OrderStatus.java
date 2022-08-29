package com.dushop.common.entity.order;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.common.entity
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-27  16:44
 *@Description: TODO
 *@Version: 1.0
 */

public enum OrderStatus {
    NEW {
        @Override
        public String defaultDescription() {
            return "Order was placed by the customer";
        }

    },

    CANCELLED {
        @Override
        public String defaultDescription() {
            return "Order was rejected";
        }
    },

    PROCESSING {
        @Override
        public String defaultDescription() {
            return "Order is being processed";
        }
    },

    PACKAGED {
        @Override
        public String defaultDescription() {
            return "Products were packaged";
        }
    },

    PICKED {
        @Override
        public String defaultDescription() {
            return "Shipper picked the package";
        }
    },

    SHIPPING {
        @Override
        public String defaultDescription() {
            return "Shipper is delivering the package";
        }
    },

    DELIVERED {
        @Override
        public String defaultDescription() {
            return "Customer received products";
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
            return "Customer has been refund	ed";
        }
    };

    public abstract String defaultDescription();
}