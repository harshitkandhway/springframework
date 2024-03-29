package springframework.day1.basics;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class SpamChecker {
    Set<String> spamWords;

    public SpamChecker() {
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
}
