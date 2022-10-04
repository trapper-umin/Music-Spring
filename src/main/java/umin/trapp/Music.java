package umin.trapp;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component("music")
public class Music {

    @Setter
    @Getter
    private String name;
}
