Location: src/main/java/com/farmconnect/service/CartService.javareturn  productRepository. save(product);
}
    
@Transactional
public Product updateProduct (Long  id,Product  productDetails) {
Product  product = getProductById (id);
        
if(productDetails. getName ()!=null) {
            product. setName (productDetails. getName ());
}
if(productDetails. getPrice ()!=null) {
            product. setPrice (productDetails. getPrice ());
}
if(productDetails. getUnit ()!=null) {
            product. setUnit (productDetails. getUnit ());
}
if(productDetails. getStock ()!=null) {
            product. setStock (productDetails. getStock ());
}
if(productDetails. getImage ()!=null) {
            product. setImage (productDetails. getImage ());
}
        
return  productRepository. save(product);
}
    
@Transactional
public void deleteProduct (Long  id) {
if(!productRepository. existsById (id)) {
throw new RuntimeException ("Product not found with id: " + id);
}
        productRepository. deleteById (id);
}
}
java
package com.farmconnect.service;
import com.farmconnect.model. *;
import com.farmconnect.repository. *;
import org.springframework.beans.factory.annotation. Autowired ;
import org.springframework.stereotype. Service ;
import org.springframework.transaction.annotation. Transactional ;
import java.util. Optional ;
@Service
public class CartService {
    
@Autowired
private CartRepository  cartRepository;
    
@Autowired
private ProductRepository  productRepository;
    
@Transactional
public Cart getOrCreateCart (User  user) {
return  cartRepository. findByUser (user)
.orElseGet (()->{
Cart cart =new Cart();
                cart. setUser (user);
return  cartRepository. save(cart);
});
}
    
@Transactional
public Cart addToCart (User  user, Long  productId, Integer  quantity) {
if(quantity <=0) {
throw new RuntimeException ("Quantity must be greater than 0" );
}
        
Cart cart = getOrCreateCart (user);
Product  product = productRepository. findById (productId)
.orElseThrow (()->new RuntimeException ("Product not found" ));
        
// Check if product already exists in cart
Optional <CartItem > existingItem = cart. getItems ().stream ()
.filter (item -> item. getProduct ().getId ().equals (productId))
.findFirst ();
if(existingItem. isPresent ()) {
CartItem  item = existingItem. get();
            item. setQuantity (item. getQuantity ()+ quantity);
}else{
CartItem  newItem CartItem ()
