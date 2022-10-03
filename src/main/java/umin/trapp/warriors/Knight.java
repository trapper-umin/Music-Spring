package umin.trapp.warriors;

import umin.trapp.Warrior;

public class Knight extends Warrior {
    private Knight(){}
    public static Warrior factory(){
        return new Knight();
    }

    private void init(){
        System.out.println("Knight ready to war!");
    }
    private void destroy(){
        System.out.println("Knight die!");
    }
}
