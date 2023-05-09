# etag and ehcache example

## spring-mvc-showcase
java 17, spring mvc 5.0.4.RELEASE, jsp, etag, ehcache

backend : /spring-mvc-showcase/src/main/java/org/springframework/samples/mvc/cache/*.java

frontend : /spring-mvc-showcase/src/main/webapp/WEB-INF/views/views/html.jsp <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; /spring-mvc-showcase/src/main/webapp/WEB-INF/views/cache.jsp
                      
1. add this project to tomcat
2. tomcat config > module path : / 
3. run tomcat > access http://localhost:yourport > click cache tag


## spring-boot-etag-ehcache
java 17, spring boot 2.7.11, thymeleaf, h2 DB, etag, ehcache

1. run the embedded server
2. access http://localhost:8080

