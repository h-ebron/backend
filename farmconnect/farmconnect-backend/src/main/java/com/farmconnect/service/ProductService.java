Location: src/main/java/com/farmconnect/service/ProductService.javajava
package com.farmconnect.service;
import com.farmconnect.model. User ;
import com.farmconnect.repository. UserRepository ;
import org.springframework.beans.factory.annotation. Autowired ;
import org.springframework.stereotype. Service ;
import org.springframework.transaction.annotation. Transactional ;
@Service
public class AuthService {
@Autowired
private UserRepository  userRepository;
    
@Transactional
public User login (String  username, User.UserType  userType) {
return  userRepository. findByUsername (username)
.orElseGet (()-> createNewUser (username, userType));
}
    
private User createNewUser (String  username, User.UserType  userType) {
User  newUser =new User ();
        newUser. setUsername (username);
        newUser. setUserType (userType);
        newUser. setGpayUpi (username. toLowerCase ().replaceAll ("\\s+" ,"")+"@paytm" );
return  userRepository. save(newUser);
}
    
public User getUserById (Long  userId) {
return  userRepository. findById (userId)
.orElseThrow (()->new RuntimeException ("User not found with id: " + userId));
}
}
java
package com.farmconnect.service;
import com.farmconnect.model. Product ;
import com.farmconnect.model. User ;
import com.farmconnect.repository. ProductRepository ;
import org.springframework.beans.factory.annotation. Autowired ;
import org.springframework.stereotype. Service ;
import org.springframework.transaction.annotation. Transactional ;
import java.util. List;
@Service
public class ProductService {
    
@Autowired
private ProductRepository  productRepository;
    
public List<Product >getAllProducts () {
return  productRepository. findAllByOrderByCreatedAtDesc ();
}
    
public List<Product >getRecentProducts () {
return  productRepository. findTop5ByOrderByCreatedAtDesc ();
}
    
public List<Product >getVendorProducts (User  vendor) {
return  productRepository. findByVendor (vendor);
}
    
public Product getProductById (Long  productId) {
return  productRepository. findById (productId)
.orElseThrow (()->new RuntimeException ("Product not found with id: " + productId));
}
    
@Transactional
public Product addProduct (Product  product) {
if(product. getName ()==null|| product. getName ().trim().isEmpty ()) {
throw new RuntimeException ("Product name is required" );
}
if(product. getPrice ()==null|| product. getPrice ()<=0) {
throw new RuntimeException ("Valid product price is required" );
}
if(product. getStock ()==null|| product. getStock ()<0) {
throw new RuntimeException ("Valid stock quantity is required" );
}
if(product. getVendor ()==null) {
throw new RuntimeException ("Vendor information is required" );
}
return  productRepository (product)
