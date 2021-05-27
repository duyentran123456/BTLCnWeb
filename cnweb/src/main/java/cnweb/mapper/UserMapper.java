package cnweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import cnweb.model.User;

public class UserMapper implements RowMapper<User>{
	
	@Override
	public User mapRow(ResultSet resultSet) {
		try {
			User user = new User();
			user.setId(resultSet.getInt("id"));
			user.setUsername(resultSet.getString("username"));
			user.setHashedPw(resultSet.getString("pw"));
			user.setRole(resultSet.getString("role"));
			user.setName(resultSet.getString("name"));
			user.setAbout(resultSet.getString("about"));
			user.setAvatar(resultSet.getString("avatar"));
			
			return user;
		} catch (SQLException e) {
			return null;
		}
	}
}
