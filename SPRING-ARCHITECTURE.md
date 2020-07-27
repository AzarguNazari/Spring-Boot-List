# Spring Arhcitecture
![](https://spring.io/images/diagram-microservices-88e01c7d34c688cb49556435c130d352.svg)

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
