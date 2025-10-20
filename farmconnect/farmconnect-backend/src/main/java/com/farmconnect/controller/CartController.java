Location: src/main/java/com/farmconnect/controller/CartController.java
java
package com.farmconnect.controller;
import com.farmconnect.model. Cart;
import com.farmconnect.model. User ;
import com.farmconnect.service. AuthService ;
import com.farmconnect.service. CartService ;
import org.springframework.beans.factory.annotation. Autowired ;
import org.springframework.http. ResponseEntity ;
import org.springframework.web.bind.annotation. *;
import java.util. Map;
@RestController
@RequestMapping( "/api/cart" )
@CrossOrigin(origins ="http://localhost:3000" )
public class CartController {
    
@Autowired
private CartService  cartService;
    
@Autowired
private AuthService  authService;
    
@GetMapping( "/{userId}" )
public ResponseEntity <Cart>getCart (@PathVariable Long  userId) {
try{
User  user = authService. getUserById (userId);
Cart cart = cartService. getOrCreateCart (user);
return ResponseEntity .ok(cart);
}catch (Exception  e) {
return ResponseEntity .badRequest ().build ();
}
}
    
@PostMapping( "/{userId}/add" )
public ResponseEntity <Cart>addToCart (
@PathVariable Long  userId,
@RequestBody Map<String ,Object > request) {
try{
User  user = authService. getUserById (userId);
Long  productId =Long .valueOf (request. get("productId" ).toString ());
Integer  quantity =Integer .valueOf (request. get("quantity" ).toString ());
Cart cart = cartService. addToCart (user, productId, quantity);
return ResponseEntity .ok(cart);
}catch (Exception  e) {
return ResponseEntity .badRequest ().build ();
}
