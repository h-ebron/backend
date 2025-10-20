Location: src/main/java/com/farmconnect/model/Product.javajava
package com.farmconnect.model;
import jakarta.persistence. *;
import lombok. AllArgsConstructor ;
import lombok. Data ;
import lombok. NoArgsConstructor ;
@Entity
@Table(name ="users" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
@Id
@GeneratedValue(strategy =GenerationType .IDENTITY)
private Long  id;
    
@Column(nullable =false , unique =true)
private String  username;
    
@Enumerated( EnumType .STRING)
@Column(nullable =false )
private UserType  userType;
    
@Column(name ="gpay_upi" )
private String  gpayUpi;
    
public enum UserType {
        BUYER, VENDOR
}
}
java
package com.farmconnect.model;
import jakarta.persistence. *;
import lombok. AllArgsConstructor ;
import lombok. Data ;
import lombok. NoArgsConstructor ;
import java.time. LocalDateTime ;
@Entity
@Table(name ="products" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
@Id
@GeneratedValue(strategy =GenerationType .IDENTITY)
private Long  id;
    
@Column(nullable =false )
private String  name;
    
@Column(nullable =false )
private Double  price;
    
@Column(nullable =false )
private String  unit;
    
@Column(nullable =false )
private Integer  stock;
    
@Column(nullable =false )
private String  image;
    
@ManyToOne(fetch =FetchType .EAGER)
@JoinColumn(name ="vendor_id" , nullable =false )
private User  vendor;
    
@Column(name ="created_at" , nullable =false , updatable =false )
private LocalDateTime  createdAt;
    
@PrePersist
protected void onCreate () {
        createdAt =LocalDateTime .now();
}
}
