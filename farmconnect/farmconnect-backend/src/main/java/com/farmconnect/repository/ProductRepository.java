Location: src/main/java/com/farmconnect/repository/ProductRepository.javajava
package com.farmconnect.repository;
import com.farmconnect.model. User ;
import org.springframework.data.jpa.repository. JpaRepository ;
import org.springframework.stereotype. Repository ;
import java.util. Optional ;
@Repository
public interface UserRepository extends JpaRepository <User,Long > {
Optional <User >findByUsername (String  username);
boolean existsByUsername (String  username);
}
java
package com.farmconnect.repository;
import com.farmconnect.model. Product ;
import com.farmconnect.model. User ;
import org.springframework.data.jpa.repository. JpaRepository ;
import org.springframework.stereotype. Repository ;
import java.time. LocalDateTime ;
import java.util. List;
@Repository
public interface ProductRepository extends JpaRepository <Product ,Long > {
List<Product >findByVendor (User  vendor);
List<Product >findTop5ByOrderByCreatedAtDesc ();
List<Product >findByCreatedAtAfter (LocalDateTime  date);
List<Product >findAllByOrderByCreatedAtDesc ();
}
