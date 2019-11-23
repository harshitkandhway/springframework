package springframework.day1.disambiguation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SpamCheckerFactory {

    @Autowired
    @Qualifier("english")
    private SpamChecker englishSpamChecker;
    @Autowired
    @Qualifier("french")
    private SpamChecker frenchSpamChecker;

    public SpamChecker getSpamChecker(Language language){
        if(language==Language.FRENCH)
            return this.frenchSpamChecker;
        else
            return this.englishSpamChecker;
    }
}
