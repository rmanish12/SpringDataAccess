# Spring Data Access

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

#### Branches

  - master: Spring JDBC with java based configuration
  - spring-hibernate: master + spring-hibernate-configuration
  - spring-jpa: spring-hibernate + spring-jpa-configuration
  - spring transaction: spring jpa + spring transaction
  
##### Dependencies for Spring JDBC configuration using PostGreS
```
  	<dependency>
	    <groupId>org.postgresql</groupId>
	    <artifactId>postgresql</artifactId>
	    <version>42.2.11</version>
	</dependency>
   	
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-context</artifactId>
	    <version>5.2.5.RELEASE</version>
	</dependency>

	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-jdbc</artifactId>
	    <version>5.2.5.RELEASE</version>
	</dependency>
```
The configuration for Spring JDBC is defined in com.jdbc.config.SpringJdbcConfig file.

##### Additional dependencies for Spring Hibernate configuration using PostGres
```
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-orm</artifactId>
	    <version>5.2.5.RELEASE</version>
	</dependency>
	
	<dependency>
	    <groupId>org.hibernate</groupId>
	    <artifactId>hibernate-core</artifactId>
	    <version>5.4.13.Final</version>
	</dependency>
```

##### No additional dependency is required for Spring JPA implementation using Hibernate

##### Dependencies for Spring Data JPA with Hibernate and PostGres
```
  	<dependency>
	    <groupId>org.postgresql</groupId>
	    <artifactId>postgresql</artifactId>
	    <version>42.2.11</version>
	</dependency>
	
		<dependency>
	    <groupId>org.hibernate</groupId>
	    <artifactId>hibernate-core</artifactId>
	    <version>5.4.13.Final</version>
	</dependency>
	
	<dependency>
	    <groupId>org.springframework.data</groupId>
	    <artifactId>spring-data-jpa</artifactId>
	    <version>2.2.6.RELEASE</version>
	</dependency>
```
