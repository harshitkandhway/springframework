package springframework.day1.disambiguation;

import org.springframework.stereotype.Component;

@Component
public class RateLimiter {
    public boolean isRateLimited(String ipaddress){
        return false;
    }
}
