package umin.trapp;

import org.springframework.stereotype.Component;

@Component("classic")
public class ClassicMusic extends Music{

    public ClassicMusic(){
        setName("CLASSIC");
    }
}
