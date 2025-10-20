Location: src/main/java/com/farmconnect/FarmConnectApplication.javaproperties
# Server Configuration
server.port =8080
server.servlet.context-path =/
# H2 Database Configuration
spring.datasource.url =jdbc:h2:mem:farmconnect
spring.datasource.driverClassName =org.h2.Driver
spring.datasource.username =sa
spring.datasource.password =
# JPA/Hibernate Configuration
spring.jpa.database-platform =org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto =create-drop
spring.jpa.show-sql =true
spring.jpa.properties.hibernate.format_sql =true
# H2 Console Configuration
spring.h2.console.enabled =true
spring.h2.console.path =/h2-console
spring.h2.console.settings.web-allow-others =true
# Logging
logging.level.org.springframework =INFO
logging.level.com.farmconnect =DEBUG
