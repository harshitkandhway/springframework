package springframework.day1.disambiguation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GuestBookServices {

    private SpamChecker spamChecker;
    @Autowired
    private JpaRepository jpaRepository;
    @Autowired
    private RateLimiter rateLimiter;

    public GuestBookServices(JpaRepository jpaRepository, SpamChecker spamChecker, RateLimiter rateLimiter) {
        this.jpaRepository = jpaRepository;
        this.spamChecker = spamChecker;
        this.rateLimiter = rateLimiter;
    }

    public GuestBookServices() {
    }

    @Autowired
    public void getSpamChecker(SpamCheckerFactory spamCheckerFactory){
        this.spamChecker = spamCheckerFactory.getSpamChecker(Language.ENGLISH);
    }

    public void create(GuestBookEntry guestbookEntry, String ipAddress){
        if (spamChecker.isSpam(guestbookEntry.getContent())) {
            throw new RuntimeException("Spam words in content");
        }
        if (rateLimiter.isRateLimited(ipAddress)) {
            throw new RuntimeException("Ip Address is rate limited");
        }
        jpaRepository.save(guestbookEntry);
    }

    @Override
    public String toString() {
        return  "GuestBookService : toString method called \n-> jpaRepository=" + jpaRepository +
                "\n-> spamChecker=" + spamChecker +
                "\n-> rateLimiter=" + rateLimiter ;
    }
}
