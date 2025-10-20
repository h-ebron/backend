Location: src/main/java/com/farmconnect/config/CorsConfig.javajava
package com.farmconnect;
import org.springframework.boot. SpringApplication ;
import org.springframework.boot.autoconfigure. SpringBootApplication ;
@SpringBootApplication
public class FarmConnectApplication {
    
public static void main (String [] args) {
SpringApplication .run(FarmConnectApplication .class , args);
System .out.println ("\n==========================================="
System .out.println ("
 FarmConnect Backend Started Successfully!" );
System .out.println ("===========================================" );
System .out.println ("
 API Base URL: http://localhost:8080/api" );
System .out.println ("
  H2 Console: http://localhost:8080/h2-console" );
System .out.println ("   JDBC URL: jdbc:h2:mem:farmconnect" );
System .out.println ("   Username: sa" );
System .out.println ("   Password: (leave empty)" );
System .out.println ("===========================================\n"
}
}
