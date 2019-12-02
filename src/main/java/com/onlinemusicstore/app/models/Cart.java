package com.onlinemusicstore.app.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Le on 1/11/2016.
 */

@Entity
public class Cart implements Serializable {

    public Cart(int cartId) {
		super();
		this.cartId = cartId;
	}

    public Cart() {
    	
    }
	private static final long serialVersionUID = 3940548625296145582L;

    @Id
    @GeneratedValue
    private int cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	@OneToOne
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    private double grandTotal;

    public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

//	public void addCartItem(CartItem cartItem) {
//		String productId = cartItem.getProduct().getProductId();
//		int productIdd = Integer.parseInt(productId);
//		if(cartItems.containsKey(productId)) {
//			CartItem existingItem = cartItems.get(productIdd);
//			existingItem.setQuantity(existingItem.getQuantity());
//			cartItems.put(productId, existingItem);
//			
//		}
//		else {
//			cartItems.put(productId, cartItem);
//		}
//		updateGrantTotal();
//		
//	}
//	public void  removeCartItem(CartItem item) {
//		String productId = item.getProduct().getProductId();
//		cartItems.remove(productId);
//		updateGrantTotal();
//	}

//	private void updateGrantTotal() {
//		grandTotal = 0;
//		for(CartItem items : cartItems.get() {
//			grandTotal = grandTotal + items.getTotalPrice();
//			
//		}
//		
//	}

}
