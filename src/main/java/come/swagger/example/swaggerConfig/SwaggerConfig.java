package come.swagger.example.swaggerConfig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@OpenAPIDefinition
@Component
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi(){
        return new OpenAPI().info(new Info().title("Student API").version("1.1.1").termsOfService("www.example.com/tersmofservice").license(new License().name("Licence")));
    }

    @Bean
    public GroupedOpenApi studentGroup(){
        return GroupedOpenApi.builder().setGroup("Student Group").pathsToMatch("/api/students/**").build();
    }

    @Bean
    public GroupedOpenApi universityGroup(){
        return GroupedOpenApi.builder().setGroup("University Group").pathsToMatch("/api/university/**").build();
    }


    /*
    title: Sample Pet Store App
    description: This is a sample server for a pet store.
    termsOfService: http://example.com/terms/
    contact:
      name: API Support
      url: http://www.example.com/support
      email: support@example.com
    license:
      name: Apache 2.0
      url: https://www.apache.org/licenses/LICENSE-2.0.html
    version: 1.0.1
    * */






}
