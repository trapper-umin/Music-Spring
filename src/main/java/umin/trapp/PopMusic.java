package umin.trapp;

import org.springframework.stereotype.Component;

@Component("pop")
public class PopMusic extends Music{

    private PopMusic(){
        setName("POP");
    }
}
