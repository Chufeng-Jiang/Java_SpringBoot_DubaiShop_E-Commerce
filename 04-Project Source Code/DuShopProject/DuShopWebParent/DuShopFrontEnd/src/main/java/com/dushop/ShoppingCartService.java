package com.dushop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.transaction.Transactional;
import com.dushop.common.entity.CartItem;
import com.dushop.common.entity.Customer;
import com.dushop.common.entity.Product;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.shoppingcart
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-24  23:22
 *@Description: TODO
 *@Version: 1.0
 */

@Service
@Transactional
public class ShoppingCartService {

    @Autowired private CartItemRepository cartRepo;
    @Autowired private ProductRepository productRepo;

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    public Integer addProduct(Integer productId, Integer quantity, Customer customer) throws ShoppingCartException {
        Integer updatedQuantity = quantity;
        Product product = new Product(productId);

        CartItem cartItem = cartRepo.findByCustomerAndProduct(customer, product);

        if (cartItem != null) {
            updatedQuantity = cartItem.getQuantity() + quantity;

            if (updatedQuantity > 5) {
                throw new ShoppingCartException("Could not add more " + quantity + " item(s)"
                        + " because there's already " + cartItem.getQuantity() + " item(s) "
                        + "in your shopping cart. Maximum allowed quantity is 5.");
            }
        } else {
            cartItem = new CartItem();
            cartItem.setCustomer(customer);
            cartItem.setProduct(product);
        }

        cartItem.setQuantity(updatedQuantity);

        cartRepo.save(cartItem);

        return updatedQuantity;
    }

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    public List<CartItem> listCartItems(Customer customer) {
        return cartRepo.findByCustomer(customer);
    }

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    public float updateQuantity(Integer productId, Integer quantity, Customer customer) {
        cartRepo.updateQuantity(quantity, customer.getId(), productId);
        Product product = productRepo.findById(productId).get();
        float subtotal = product.getDiscountPrice() * quantity;
        return subtotal;
    }

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    public void removeProduct(Integer productId, Customer customer) {
        cartRepo.deleteByCustomerAndProduct(customer.getId(), productId);
    }
/*self code*/
    public void deleteByCustomer(Customer customer) {
        cartRepo.deleteByCustomer(customer.getId());
    }
}