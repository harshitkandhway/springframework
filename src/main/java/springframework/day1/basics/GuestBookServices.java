package springframework.day1.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuestBookServices {

    @Autowired(required = false)
    private JpaRepository jpaRepository;
    @Autowired
    private SpamChecker spamChecker;
    @Autowired
    private RateLimiter rateLimiter;

    public GuestBookServices(JpaRepository jpaRepository, SpamChecker spamChecker, RateLimiter rateLimiter) {
        this.jpaRepository = jpaRepository;
        this.spamChecker = spamChecker;
        this.rateLimiter = rateLimiter;
    }

    public GuestBookServices() {
    }
    /*public GuestBookServices(SpamChecker spamChecker, RateLimiter rateLimiter) {
        this.spamChecker = spamChecker;
        this.rateLimiter = rateLimiter;
    }*/

    public void create(GuestBookEntry guestbookEntry, String ipAddress){
        if (spamChecker.isSpam(guestbookEntry.getContent())) {
            throw new RuntimeException("Spam words in content");
        }
        if (rateLimiter.isRateLimited(ipAddress)) {
            throw new RuntimeException("Ip Address is rate limited");
        }
        //jpaRepository.save(guestbookEntry);
    }

    //Getters

    public JpaRepository getJpaRepository() {
        return jpaRepository;
    }

    public SpamChecker getSpamChecker() {
        return spamChecker;
    }

    public RateLimiter getRateLimiter() {
        return rateLimiter;
    }
}
