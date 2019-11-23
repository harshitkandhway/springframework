package springframework.day1.circulardependency.lazyloading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class B {
    private A a;

    public B(A a) {
        System.out.println("B's constructor");
        this.a = a;
    }
}
