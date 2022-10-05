package umin.trapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component("player")
@Scope("prototype")
public class MusicPlayer {
    @Value("${MusicPlayer.name}")
    private String name;
    @Value("${MusicPlayer.volume}")
    private int volume;
    private List<Music> musics=new ArrayList<>();

    @Autowired
    private void setMusic(@Qualifier("classic") Music classic,@Qualifier("pop")Music pop) {
        musics.add(classic);
        musics.add(pop);
    }

    public void playMusic(Random random, String genre){
        int rand;
        System.out.printf("%s volume: %d\n",name,volume);
        if(genre.equals("classic")){
            List<String> compositions=musics.get(0).getCompositions();
            rand=random.nextInt(3);
            System.out.printf("Playing: %s\n",compositions.get(rand));
        }else if (genre.equals("pop")) {
            List<String> compositions = musics.get(1).getCompositions();
            rand = random.nextInt(3);
            System.out.printf("Playing: %s\n", compositions.get(rand));
        }
    }
}
