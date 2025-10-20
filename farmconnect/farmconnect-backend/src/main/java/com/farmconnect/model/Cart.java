Location: src/main/java/com/farmconnect/model/Cart.java
java
package com.farmconnect.model;
import jakarta.persistence. *;
import lombok. AllArgsConstructor ;
import lombok. Data ;
import lombok. NoArgsConstructor ;
import java.util. ArrayList ;
import java.util. List;
@Entity
@Table(name ="carts" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    
@Id
@GeneratedValue(strategy =GenerationType .IDENTITY)
private Long  id;
    
@OneToOne(fetch =FetchType .EAGER)
@JoinColumn(name ="user_id" , unique =true, nullable =false )
private User  user;
    
@OneToMany(mappedBy ="cart" , cascade =CascadeType .ALL, orphanRemoval =true, fetch =
private List<CartItem > items =new ArrayList <>();
    
public void addItem (CartItem  item) {
        items. add(item);
        item. setCart (this);
}
    
public void removeItem (CartItem  item) {
        items. remove (item);
        item. setCart (null);
}
    
public void clearItems () {
        items. clear ();
}
}
