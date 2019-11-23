package springframework.day1.ordering;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class VehicleFactoryConfig {

    @Bean("tire")
    @DependsOn("engine")
    void tire() {
        System.out.println("Inside tire (depends on engine) : Bean1 called");
    }
    @Bean("engine")
    void engine() {
        System.out.println("Inside engine : Bean2 called");
    }

    @Bean
    @DependsOn({"engine","tire"})
    void carBody(){
        System.out.println("Inside car body (depends on both) : Bean3 called");
    }
}
