package springframework.day1.disambiguation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
@Qualifier("french")
public class FrenchSpamChecker implements SpamChecker {
    Set<String> spamWords;

    public FrenchSpamChecker() {
        this.spamWords = new HashSet<>();
        this.spamWords.addAll(Arrays.asList("spam","add"));
    }

    public boolean isSpam(String content){
        Set<String> words = new HashSet<>();
        words.addAll(Arrays.asList(content.split(" ")));
        if(!Collections.disjoint(words,spamWords)){
            return true;
        }
        return false;
    }

    @Override
    public boolean supports(Language language) {
        return language==Language.FRENCH;
    }
}
