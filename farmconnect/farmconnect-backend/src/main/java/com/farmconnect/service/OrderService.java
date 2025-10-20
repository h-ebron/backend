Location: src/main/java/com/farmconnect/service/OrderService.javaCartItem  newItem =new CartItem ();
            newItem. setProduct (product);
            newItem. setQuantity (quantity);
            cart. addItem (newItem);
}
        
return  cartRepository. save(cart);
}
    
@Transactional
public Cart updateQuantity (User  user, Long  productId, Integer  quantity) {
if(quantity <=0) {
throw new RuntimeException ("Quantity must be greater than 0" );
}
        
Cart cart = getOrCreateCart (user);
        
        cart. getItems ().stream ()
.filter (item -> item. getProduct ().getId ().equals (productId))
.findFirst ()
.ifPresent (item -> item. setQuantity (quantity));
        
return  cartRepository. save(cart);
}
    
@Transactional
public Cart removeFromCart (User  user, Long  productId) {
Cart cart = getOrCreateCart (user);
        
        cart. getItems ().removeIf (item -> 
            item. getProduct ().getId ().equals (productId));
        
return  cartRepository. save(cart);
}
    
@Transactional
public void clearCart (User  user) {
Cart cart = getOrCreateCart (user);
        cart. clearItems ();
        cartRepository. save(cart);
}
}
java
package com.farmconnect.service;
import com.farmconnect.model. *;
import com.farmconnect.repository. OrderRepository ;
import org.springframework.beans.factory.annotation. Autowired ;
import org.springframework.stereotype. Service ;
import org.springframework.transaction.annotation. Transactional ;
import java.util. List;
@Service
public class OrderService {
    
@Autowired
private OrderRepository  orderRepository;
    
@Transactional
public Order createOrder (User  buyer, User  vendor, Double  totalAmount) {
if(totalAmount <=0) {
throw new RuntimeException ("Total amount must be greater than 0" );
}
        
Order  order =new Order ();
        order. setBuyer (buyer);
        order. setVendor (vendor);
        order. setTotalAmount (totalAmount);
        order. setPaymentUpi (vendor. getGpayUpi ());
        order. setStatus (Order .OrderStatus .PENDING);
        
return  orderRepository. save(order);
}
    
public List<Order >getBuyerOrders (User  buyer) {
return  orderRepository. findByBuyerOrderByCreatedAtDesc (buyer);
}
    
public List<Order >getVendorOrders (User  vendor) {
return  orderRepository. findByVendorOrderByCreatedAtDesc (vendor);
}
    
public Order getOrderById (Long  orderId) {
return  orderRepository. findById (orderId)
.orElseThrow (()->new RuntimeException ("Order not found with id: " + orderId));
}
    
@Transactional
public Order updateOrderStatus (Long  orderId, Order .OrderStatus  status) {
Order  order = getOrderById (orderId);
        order setStatus (status)
