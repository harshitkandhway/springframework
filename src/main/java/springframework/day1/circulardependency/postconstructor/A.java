package springframework.day1.circulardependency.postconstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class A {
    @Autowired
    private B b;

    @PostConstruct
    void init() {
        b.setA(this);
    }
}
