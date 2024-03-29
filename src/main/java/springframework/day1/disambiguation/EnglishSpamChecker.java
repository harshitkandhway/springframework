package springframework.day1.disambiguation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
@Qualifier("english")
public class EnglishSpamChecker implements SpamChecker{
    Set<String> spamWords;

    public EnglishSpamChecker() {
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
        return language==Language.ENGLISH;
    }

}
