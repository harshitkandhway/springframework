package springframework.day1.circulardependency.lazyloading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class A {
    private B b;

    public A(@Lazy B b) {
        System.out.println("A's constructor");
        this.b = b;
    }
}
