package umin.trapp;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component("pop")
public class PopMusic extends Music{

    List<String> compositions=new ArrayList<>();
    @PostConstruct
    private void init(){

    }
    @PreDestroy
    private void destroy(){

    }

    private PopMusic(){
        setName("POP");
        setCompositions();
    }
    private void setCompositions(){
        compositions.add("The Proclaimers - I'm on My Way");
        compositions.add("Hozier - Take Me To Church");
        compositions.add("Pitbull feat. Ke$ha -Timber");
    }
    @Override
    public List getCompositions(){
        return compositions;
    }
}
