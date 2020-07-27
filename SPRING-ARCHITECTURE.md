# Spring Arhcitecture

### Internal architecture of Spring
![](https://docs.spring.io/spring/docs/4.2.0.RELEASE/spring-framework-reference/html/images/spring-overview.png)

### Micro-services architecture in Spring Boot
![](https://spring.io/images/diagram-microservices-88e01c7d34c688cb49556435c130d352.svg)

### Messaging Arhcitecture in Spring
![](https://docs.spring.io/spring/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/images/message-flow-simple-broker.png)
![](https://docs.spring.io/spring-integration/reference/html/images/handler-endpoint.jpg)

### Reactive Spring Architecture
![](https://res.infoq.com/articles/Servlet-and-Reactive-Stacks-Spring-Framework-5/en/resources/1non-blocking-read-1521513540917.png)

### Spring Data Architecture
![](https://res.infoq.com/articles/spring-data-intro/en/resources/spring_data_overview_small.jpg)
![](https://www.jcombat.com/wp-content/uploads/2017/03/spring-data-tech-stack.png)

### Spring Security Architecture
![](https://bezkoder.com/wp-content/uploads/2020/05/spring-boot-jwt-mysql-spring-security-architecture.png)
![](https://docs.spring.io/spring-security/site/docs/current/reference/html5/images/servlet/architecture/multi-securityfilterchain.png)

### Spring Cloud Data Flow
![](https://raw.githubusercontent.com/spring-cloud/spring-cloud-dataflow/v1.0.1.RELEASE/spring-cloud-dataflow-docs/src/main/asciidoc/images/dataflow-server-arch.png)

### Spring Session Architecture
![](https://docs.spring.io/spring-boot-data-geode-build/1.1.x/reference/html5/images/Spring-Session-Framework-Architecture.png)

### Spring Vault Architecture
![](https://andifalk.github.io/jax-2018-spring-vault/presentation/images/springcloudconfig_vault.png)

### Spring LDAP Architecture
![](https://www.javacodegeeks.com/wp-content/uploads/2018/04/ldap-active-directory_authentication-spring-security-example.png)
![](https://d25ds5di20s2np.cloudfront.net/wp-content/uploads/2018/06/giuseppe-urso-cas-sso-spring-01.png)

### Spring Batch Architecture
![](https://grokonez.com/wp-content/uploads/2016/09/batchcsvsql-architect.jpg)


FailureAnalyzer -> for more information if application fails if FailureAnalyzer doesnt not exist, enable debug logging for 
org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener= true

Lazy Initialization
When lazy initialization is enabled,
beans are created as they are needed rather than during application startup. As a result, enabling
lazy initialization can reduce the time that it takes your application to start.  In a web application,
enabling lazy initialization will result in many web-related beans not being initialized until an
HTTP request is received. 
spring.main.lazy-initialization=true

Banner
```
${application.version}
${application.formatted-version}
${spring-boot.version}
${spring-boot.formatted-version}
${Ansi.NAME} ${AnsiColor.NAME}${AnsiBackground.NAME}, ${AnsiStyle.NAME})
${application.title}
```

Customization SpringApplication
```
public static void main(String[] args) {
  
  // First way
  SpringApplication app = new SpringApplication(MySpringConfiguration.class);
  app.setBannerMode(Banner.Mode.OFF);
  app.run(args);
  
  // Second way
  new SpringApplicationBuilder()
  .sources(Parent.class)
  .child(Application.class)
  .bannerMode(Banner.Mode.OFF)
  .run(args);
}
```

After ApplicationContext is statarted, 
`CommandLineRunner` and `ApplicationRunner` get ran.

Application components can retrieve the current availability state at any time, by injecting the
ApplicationAvailability interface and calling methods on it. More often, applications will want to
listen to state updates or update the state of the application

```
@Component
public class ReadinessStateExporter {
  @EventListener
  public void onStateChange(AvailabilityChangeEvent<ReadinessState> event) {
  switch (event.getState()) {
  case ACCEPTING_TRAFFIC:
  // create file /tmp/healthy
  break;
  case REFUSING_TRAFFIC:
  // remove file /tmp/healthy
  break;
  }
  }
}
```
We can also update the state of the application, when the application breaks and cannot recover:
```
@Component
public class LocalCacheVerifier {
  private final ApplicationEventPublisher eventPublisher;
  public LocalCacheVerifier(ApplicationEventPublisher eventPublisher) {
  this.eventPublisher = eventPublisher;
  }
  public void checkLocalCache() {
  try {
  //...
  }
  catch (CacheCompletelyBrokenException ex) {
  AvailabilityChangeEvent.publish(this.eventPublisher, ex,
LivenessState.BROKEN);
  }
  }
}
```
