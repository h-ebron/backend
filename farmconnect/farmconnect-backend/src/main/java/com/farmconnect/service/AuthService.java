Location: src/main/java/com/farmconnect/service/AuthService.javajava
package com.farmconnect.repository;
import com.farmconnect.model. Cart;
import com.farmconnect.model. User ;
import org.springframework.data.jpa.repository. JpaRepository ;
import org.springframework.stereotype. Repository ;
import java.util. Optional ;
@Repository
public interface CartRepository extends JpaRepository <Cart,Long > {
Optional <Cart>findByUser (User  user);
void deleteByUser (User  user);
}
java
package com.farmconnect.repository;
import com.farmconnect.model. Order ;
import com.farmconnect.model. User ;
import org.springframework.data.jpa.repository. JpaRepository ;
import org.springframework.stereotype. Repository ;
import java.util. List;
@Repository
public interface OrderRepository extends JpaRepository <Order ,Long > {
List<Order >findByBuyer (User  buyer);
List<Order >findByVendor (User  vendor);
List<Order >findByBuyerOrderByCreatedAtDesc (User  buyer);
List<Order >findByVendorOrderByCreatedAtDesc (User  vendor);
}
