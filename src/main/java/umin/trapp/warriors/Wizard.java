package umin.trapp.warriors;

import umin.trapp.Warrior;

public class Wizard extends Warrior {
    private Wizard(){}
    public static Warrior factory(){
        return new Wizard();
    }

    private void init(){
        System.out.println("Wizard ready to war!");
    }
    private void destroy(){
        System.out.println("Wizard die!");
    }

}