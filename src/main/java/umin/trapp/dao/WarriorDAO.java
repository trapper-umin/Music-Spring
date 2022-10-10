package umin.trapp.dao;

import org.springframework.stereotype.Component;
import umin.trapp.models.Warrior;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("warriorDAO")
public class WarriorDAO {
    private static int id=2;

    private static final String URL="jdbc:postgresql://localhost:5432/data";
    private static final String USERNAME="postgres";
    private static final String PASSWORD="1111";

    private static Connection connection;
    List<Warrior> warriors=new ArrayList<>();

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Warrior> read(){
        List<Warrior> warriors=new ArrayList<>();

        try {
            Statement statement=connection.createStatement();

            String SQL="SELECT * FROM Warrior";
            ResultSet resultSet=statement.executeQuery(SQL);

            while (resultSet.next()){
                Warrior warrior=new Warrior();

                warrior.setId(resultSet.getInt("id"));
                warrior.setName(resultSet.getString("name"));
                warrior.setHealthPoint(resultSet.getInt("healthpoint"));
                warrior.setWeapon(resultSet.getString("weapon"));

                warriors.add(warrior);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return warriors;
    }
    public Warrior readId(int id){
        return warriors.stream().filter(warriors -> warriors.getId() ==id).findAny().orElse(null);
    }
    public void create(Warrior warrior){
        warrior.setId(id++);
        try {
            Statement statement=connection.createStatement();

            String SQL="INSERT INTO Warrior VALUES("+warrior.getId()+",'"+warrior.getName()+"',"+warrior.getHealthPoint()+",'"+warrior.getWeapon()+"')";

            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(Warrior warrior,int id){
        warriors.get(id).setName(warrior.getName());
        warriors.get(id).setWeapon(warrior.getWeapon());
        warriors.get(id).setHealthPoint(warrior.getHealthPoint());
    }
    public void delete(int id){
        warriors.removeIf(warrior -> warrior.getId()==id);
    }
}