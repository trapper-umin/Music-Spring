package umin.trapp.warriors;

import umin.trapp.Warrior;

public class Knight extends Warrior {

    private void init(){
        System.out.println("Knight ready to war!");
    }
    private void destroy(){
        System.out.println("Knight die!");
    }

    public Knight(int healthPoint,int damage, String type){
        super(healthPoint,damage,type);
    }
    public Knight(){}
}
