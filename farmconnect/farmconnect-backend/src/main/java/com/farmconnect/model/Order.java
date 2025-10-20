Location: src/main/java/com/farmconnect/model/Order.javajava
package com.farmconnect.model;
import jakarta.persistence. *;
import lombok. AllArgsConstructor ;
import lombok. Data ;
import lombok. NoArgsConstructor ;
import com.fasterxml.jackson.annotation. JsonIgnore ;
@Entity
@Table(name ="cart_items" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    
@Id
@GeneratedValue(strategy =GenerationType .IDENTITY)
private Long  id;
    
@ManyToOne(fetch =FetchType .LAZY)
@JoinColumn(name ="cart_id" , nullable =false )
@JsonIgnore
private Cart cart;
    
@ManyToOne(fetch =FetchType .EAGER)
@JoinColumn(name ="product_id" , nullable =false )
private Product  product;
    
@Column(nullable =false )
private Integer  quantity;
}
java
package com.farmconnect.model;
import jakarta.persistence. *;
import lombok. AllArgsConstructor ;
import lombok. Data ;
import lombok. NoArgsConstructor ;
import java.time. LocalDateTime ;
@Entity
@Table(name ="orders" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    
@Id
@GeneratedValue(strategy =GenerationType .IDENTITY)
private Long  id;
    
@ManyToOne(fetch =FetchType .EAGER)
@JoinColumn(name ="buyer_id" , nullable =false )
private User  buyer;
    
@ManyToOne(fetch =FetchType .EAGER)
@JoinColumn(name ="vendor_id" , nullable =false )
private User  vendor;
@Column(name ="total_amount" , nullable =false )
private Double  totalAmount;
    
@Column(name ="payment_upi" )
private String  paymentUpi;
    
@Enumerated( EnumType .STRING)
@Column(nullable =false )
private OrderStatus  status;
    
@Column(name ="created_at" , nullable =false , updatable =false )
private LocalDateTime  createdAt;
    
@PrePersist
protected void onCreate () {
        createdAt =LocalDateTime .now();
if(status ==null) {
            status =OrderStatus .PENDING;
}
}
Continue to next part for Repositories, Services, and Controllers...    
public enum OrderStatus {
        PENDING, PAID, COMPLETED, CANCELLED
}
}

FarmConnect Backend - Part 2 (Repositories,
Services, Controllers)
