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
                warrior.setHealthPoint(resultSet.getInt("healthPoint"));
                warrior.setWeapon(resultSet.getString("weapon"));

                warriors.add(warrior);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return warriors;
    }
    public Warrior readId(int id){
        Warrior warrior=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Warrior WHERE id=?");

            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            resultSet.next();

            warrior=new Warrior();
            warrior.setId(resultSet.getInt("id"));
            warrior.setName(resultSet.getString("name"));
            warrior.setHealthPoint(resultSet.getInt("healthPoint"));
            warrior.setWeapon(resultSet.getString("weapon"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return warrior;
    }
    public void create(Warrior warrior){
        warrior.setId(id++);
        try {

            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO Warrior VALUES (?,?,?,?)");

            preparedStatement.setInt(1,warrior.getId());
            preparedStatement.setString(2,warrior.getName());
            preparedStatement.setInt(3,warrior.getHealthPoint());
            preparedStatement.setString(4,warrior.getWeapon());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(Warrior warrior,int id){
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE Warrior SET name=?,healthPoint=?,weapon=? WHERE id=?");

            preparedStatement.setString(1,warrior.getName());
            preparedStatement.setInt(2,warrior.getHealthPoint());
            preparedStatement.setString(3,warrior.getWeapon());
            preparedStatement.setInt(4,id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void delete(int id){
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM Warrior WHERE id=?");

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}