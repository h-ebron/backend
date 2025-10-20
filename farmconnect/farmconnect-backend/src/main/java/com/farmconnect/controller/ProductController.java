Location: src/main/java/com/farmconnect/controller/ProductController.java
java
package com.farmconnect.controller;
import com.farmconnect.model. Product ;
import com.farmconnect.model. User ;
import com.farmconnect.service. AuthService ;
import com.farmconnect.service. ProductService ;
import org.springframework.beans.factory.annotation. Autowired ;
import org.springframework.http. ResponseEntity ;
import org.springframework.web.bind.annotation. *;
import java.util. List;
@RestController
@RequestMapping( "/api/products" )
@CrossOrigin(origins ="http://localhost:3000" )
public class ProductController {
    
@Autowired
private ProductService  productService;
    
@Autowired
private AuthService  authService;
    
@GetMapping
public ResponseEntity <List<Product >>getAllProducts () {
return ResponseEntity .ok(productService. getAllProducts ());
}
    
@GetMapping( "/recent" )
public ResponseEntity <List<Product >>getRecentProducts () {
return ResponseEntity .ok(productService. getRecentProducts ());
}
    
@GetMapping( "/vendor/{vendorId}" )
public ResponseEntity <List<Product >>getVendorProducts (@PathVariable Long  vendorId) {
try{
User  vendor = authService. getUserById (vendorId);
return ResponseEntity .ok(productService. getVendorProducts (vendor));
}catch (Exception  e) {
return ResponseEntity .notFound ().build ();
}
}
@GetMapping( "/{id}" )
public ResponseEntity <Product >getProductById (@PathVariable Long  id) {
try{
return ResponseEntity .ok(productService. getProductById (id));
}catch (Exception ) {
Continue to next part for Cart and Order Controllers...}catch (Exception  e) {
return ResponseEntity .notFound ().build ();
}
}
    
@PostMapping
public ResponseEntity <Product >addProduct (@RequestBody Product  product) {
try{
Product  savedProduct = productService. addProduct (product);
return ResponseEntity .ok(savedProduct);
}catch (Exception  e) {
return ResponseEntity .badRequest ().build ();
}
}
    
@PutMapping( "/{id}" )
public ResponseEntity <Product >updateProduct (
@PathVariable Long  id, 
@RequestBody Product  product) {
try{
return ResponseEntity .ok(productService. updateProduct (id, product));
}catch (Exception  e) {
return ResponseEntity .badRequest ().build ();
}
}
    
@DeleteMapping( "/{id}" )
public ResponseEntity <Void>deleteProduct (@PathVariable Long  id) {
try{
            productService. deleteProduct (id);
return ResponseEntity .ok().build ();
}catch (Exception  e) {
return ResponseEntity .notFound ().build ();
}
}
}

FarmConnect Backend - Part 3 (Final Controllers &
Setup)
