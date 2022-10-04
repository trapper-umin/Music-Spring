package umin.trapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("player")
public class MusicPlayer {

    private List<Music> musics=new ArrayList<>();

    @Autowired
    private void setMusic(@Qualifier("classic") Music classic,@Qualifier("pop")Music pop) {
        musics.add(classic);
        musics.add(pop);
    }

    public void playMusic(){
        for (Music music : musics){
            System.out.printf("Now play %s music\n",music.getName());
        }
    }
}
