Location: src/main/java/com/farmconnect/controller/AuthController.java        order. setStatus (status);
return  orderRepository. save(order);
}
}
java
package com.farmconnect.controller;
import com.farmconnect.model. User ;
import com.farmconnect.service. AuthService ;
import org.springframework.beans.factory.annotation. Autowired ;
import org.springframework.http. ResponseEntity ;
import org.springframework.web.bind.annotation. *;
import java.util. Map;
@RestController
@RequestMapping( "/api/auth" )
@CrossOrigin(origins ="http://localhost:3000" )
public class AuthController {
    
@Autowired
private AuthService  authService;
    
@PostMapping( "/login" )
public ResponseEntity <User >login (@RequestBody Map<String ,String > request) {
try{
String  username = request. get("username" );
String  userTypeStr = request. get("userType" );
            
if(username ==null|| username. trim().isEmpty ()) {
return ResponseEntity .badRequest ().build ();
}
            
User.UserType  userType =User.UserType .valueOf (userTypeStr);
User  user = authService. login (username, userType);
            
return ResponseEntity .ok(user);
}catch (Exception  e) {
return ResponseEntity .badRequest ().build ();
}
}
}
