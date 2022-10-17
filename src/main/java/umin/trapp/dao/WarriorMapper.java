package umin.trapp.dao;

import org.springframework.jdbc.core.RowMapper;
import umin.trapp.models.Warrior;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WarriorMapper implements RowMapper<Warrior> {

    @Override
    public Warrior mapRow(ResultSet resultSet, int i) throws SQLException {

        Warrior warrior=new Warrior();

        warrior.setId(resultSet.getInt("id"));
        warrior.setName(resultSet.getString("name"));
        warrior.setHealthPoint(resultSet.getInt("healthPoint"));
        warrior.setWeapon(resultSet.getString("weapon"));

        return warrior;
    }
}
