package umin.trapp;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("music")
public class Music {

    @Setter
    @Getter
    private String name;
    List<String> compositions=new ArrayList<>();
    public List getCompositions(){
        return compositions;
    }
}
