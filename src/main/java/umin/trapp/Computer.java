package umin.trapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Computer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer musicPlayer=context.getBean("player",MusicPlayer.class);
        musicPlayer.playMusic();
    }
}
