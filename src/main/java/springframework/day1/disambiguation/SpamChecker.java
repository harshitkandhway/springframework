package springframework.day1.disambiguation;

import org.springframework.stereotype.Component;

@Component
public interface SpamChecker {
    public boolean isSpam(String content);
}
