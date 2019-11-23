package springframework.day2.scope;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class CheckinManager {
    private Set<String> checkedIn;
    CheckinManager(){
        this.checkedIn = new HashSet<>(Arrays.asList("harshit","ram","rohan"));
    }
    public boolean hasCheckedIn(String name){
        return checkedIn.contains(name);
    }
}
