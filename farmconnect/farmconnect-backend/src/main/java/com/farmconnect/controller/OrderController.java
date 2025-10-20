Location: src/main/java/com/farmconnect/controller/OrderController.java}
}
    
@PutMapping( "/{userId}/update" )
public ResponseEntity <Cart>updateQuantity (
@PathVariable Long  userId,
@RequestBody Map<String ,Object > request) {
try{
User  user = authService. getUserById (userId);
Long  productId =Long .valueOf (request. get("productId" ).toString ());
Integer  quantity =Integer .valueOf (request. get("quantity" ).toString ());
Cart cart = cartService. updateQuantity (user, productId, quantity);
return ResponseEntity .ok(cart);
}catch (Exception  e) {
return ResponseEntity .badRequest ().build ();
}
}
    
@DeleteMapping( "/{userId}/remove/{productId}" )
public ResponseEntity <Cart>removeFromCart (
@PathVariable Long  userId,
@PathVariable Long  productId) {
try{
User  user = authService. getUserById (userId);
Cart cart = cartService. removeFromCart (user, productId);
return ResponseEntity .ok(cart);
}catch (Exception  e) {
return ResponseEntity .badRequest ().build ();
}
}
    
@DeleteMapping( "/{userId}/clear" )
public ResponseEntity <Void>clearCart (@PathVariable Long  userId) {
try{
User  user = authService. getUserById (userId);
            cartService. clearCart (user);
return ResponseEntity .ok().build ();
}catch (Exception  e) {
return ResponseEntity .badRequest ().build ();
}
}
}
java
package com.farmconnect.controller;
import com.farmconnect.model. Order ;
import com.farmconnect.model. User ;
import com.farmconnect.service. AuthService ;
import com.farmconnect.service. OrderService ;
import org.springframework.beans.factory.annotation. Autowired ;
import org.springframework.http. ResponseEntity ;
import org.springframework.web.bind.annotation. *;
import java.util. List;
import java.util. Map;
@RestController
@RequestMapping( "/api/orders" )
@CrossOrigin(origins ="http://localhost:3000" )
public class OrderController {
    
@Autowired
private OrderService  orderService;
    
@Autowired
private AuthService  authService;
    
@PostMapping
public ResponseEntity <Order >createOrder (@RequestBody Map<String ,Object > request) {
try{
Long  buyerId =Long .valueOf (request. get("buyerId" ).toString ());
Long  vendorId =Long .valueOf (request. get("vendorId" ).toString ());
Double  totalAmount =Double .valueOf (request. get("totalAmount" ).toString ());
            
User  buyer = authService. getUserById (buyerId);
User  vendor = authService. getUserById (vendorId);
            
Order  order = orderService. createOrder (buyer, vendor, totalAmount);
return ResponseEntity .ok(order);
}catch (Exception  e) {
return ResponseEntity .badRequest ().build ();
}
}
    
@GetMapping( "/buyer/{buyerId}" )
public ResponseEntity <List<Order >>getBuyerOrders (@PathVariable Long  buyerId) {
try{
User  buyer = authService. getUserById (buyerId);
List<Order > orders = orderService. getBuyerOrders (buyer);
return ResponseEntity .ok(orders);
}catch (Exception ) {
 Complete Setup Instructions
Step 1: Create Project Structure}catch (Exception  e) {
return ResponseEntity .badRequest ().build ();
}
}
    
@GetMapping( "/vendor/{vendorId}" )
public ResponseEntity <List<Order >>getVendorOrders (@PathVariable Long  vendorId) {
try{
User  vendor = authService. getUserById (vendorId);
List<Order > orders = orderService. getVendorOrders (vendor);
return ResponseEntity .ok(orders);
}catch (Exception  e) {
return ResponseEntity .badRequest ().build ();
}
}
    
@GetMapping( "/{orderId}" )
public ResponseEntity <Order >getOrderById (@PathVariable Long  orderId) {
try{
Order  order = orderService. getOrderById (orderId);
return ResponseEntity .ok(order);
}catch (Exception  e) {
return ResponseEntity .notFound ().build ();
}
}
    
@PutMapping( "/{orderId}/status" )
public ResponseEntity <Order >updateOrderStatus (
@PathVariable Long  orderId,
@RequestBody Map<String ,String > request) {
try{
Order .OrderStatus  status =Order .OrderStatus .valueOf (request. get("status" ));
Order  order = orderService. updateOrderStatus (orderId, status);
return ResponseEntity .ok(order);
}catch (Exception  e) {
return ResponseEntity .badRequest ().build ();
}
}
}
Step 2: Copy All Files
Copy each ﬁle from the 3 artifacts into the correct location:
Root Level:
• pom.xml
src/main/resources/:
• application.properties
src/main/java/com/farmconnect/:
• FarmConnectApplication.java
src/main/java/com/farmconnect/conﬁg/:
• CorsConfig.java
src/main/java/com/farmconnect/model/:
• User.java
• Product.java
• Cart.java
• CartItem.java
• Order.java
src/main/java/com/farmconnect/repository/:bash
mkdir  farmconnect-backend
cd farmconnect-backend
# Create all directories
mkdir  -p src/main/java/com/farmconnect/config
mkdir  -p src/main/java/com/farmconnect/controller
mkdir  -p src/main/java/com/farmconnect/model
mkdir  -p src/main/java/com/farmconnect/repository
mkdir  -p src/main/java/com/farmconnect/service
mkdir  -p src/main/resources
• UserRepository.java
• ProductRepository.java
• CartRepository.java
• OrderRepository.java
src/main/java/com/farmconnect/service/:
• AuthService.java
• ProductService.java
• CartService.java
• OrderService.java
src/main/java/com/farmconnect/controller/:
• AuthController.java
• ProductController.java
• CartController.java
• OrderController.java
Step 3: Build and Run
Step 4: Verify Backend is Running
You should see:bash
# Clean and install dependencies
mvn clean install
# Run the application
mvn spring-boot:run
===========================================
 FarmConnect Backend Started Successfully!
===========================================
 API Base URL: http://localhost:8080/api
  H2 Console: http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:mem:farmconnect
   Username: sa
   Password: (leave empty)
===========================================
 Test the APIs
Test with curl or Postman:
1. Login (POST)
2. Get All Products (GET)
3. Add Product (POST)
4. Get Cart (GET)
5. Add to Cart (POST)bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username": "TestUser", "userType": "BUYER"}'
bash
curl http://localhost:8080/api/products
bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Fresh Tomatoes",
    "price": 45.0,
    "unit": "kg",
    "stock": 100,
    "image": "
 ",
    "vendor": {"id": 1}
  }'
bash
curl http://localhost:8080/api/cart/1
bash
curl -X POST http://localhost:8080/api/cart/1/add \
  -H "Content-Type: application/json" \
  -d '{"productId": 1, "quantity": 2}'
 Complete File List (21 Files Total)
Conﬁguration (3 ﬁles)
 pom.xml
 application.properties
 CorsConﬁg.java
Main Application (1 ﬁle)
 FarmConnectApplication.java
Models (5 ﬁles)
 User.java
 Product.java
 Cart.java
 CartItem.java
 Order.java
Repositories (4 ﬁles)
 UserRepository.java
 ProductRepository.java
 CartRepository.java
 OrderRepository.java
Services (4 ﬁles)
 AuthService.java
 ProductService.java
 CartService.java
 OrderService.java
Controllers (4 ﬁles)
 AuthController.java
 ProductController.java
 CartController.java
 OrderController.java
 Database Access
1. Start the backend
2. Open browser to: http://localhost:8080/h2-console
3. Use these credentials:
• JDBC URL: jdbc:h2:mem:farmconnect
• Username: sa
• Password: (leave empty)
4. Click "Connect"
You can now see and query all tables!
 Quick Veriﬁcation Checklist All 21 ﬁles copied to correct locationsmvn clean install  runs without errors Backend starts on port 8080 Can access H2 console Frontend can connect to backend APIs Login works (creates user in database) Can add products as vendor Can add items to cart as buyer Can view cart contents
 Common Issues & Solutions
Issue: Port 8080 already in use
Issue: Lombok not working
Issue: Maven dependencies not downloadingproperties
# Change in application.properties
server.port =8081
bash
# Make sure your IDE has Lombok plugin installed
# For IntelliJ: File > Settings > Plugins > Search "Lombok"
# For Eclipse: Download lombok.jar and run it
Issue: CORS errors
• Check CorsConﬁg.java has your frontend URL
• Make sure frontend is running on http://localhost:3000
 You're Done!
Your complete FarmConnect backend is ready! All 21 ﬁles are organized and ready to
run.
Next Steps:
1. Start backend: mvn spring-boot:run
2. Start frontend: npm start  (in frontend folder)
3. Open http://localhost:3000
4. Test the full application!
Happy farming! 
bash
mvn clean install  -U
