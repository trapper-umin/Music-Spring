package umin.trapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer musicPlayer=context.getBean("player",MusicPlayer.class);
        Scanner keyboard=new Scanner(System.in);
        Random random=new Random();
        String genre;

        System.out.print("Enter the genre of music: ");
        genre=keyboard.nextLine();

        if (genre.equals(EnumMusic.CLASSIC.name().toLowerCase())){
            musicPlayer.playMusic(random, "classic");
        }else if(genre.equals(EnumMusic.POP.name().toLowerCase())){
            musicPlayer.playMusic(random,"pop");
        }
    }
}
