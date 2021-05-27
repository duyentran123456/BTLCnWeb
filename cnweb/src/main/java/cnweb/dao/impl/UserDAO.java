package cnweb.dao.impl;

import java.util.List;

import cnweb.mapper.UserMapper;
import cnweb.dao.IUserDAO;
import cnweb.model.User;

public class UserDAO extends AbstractDAO<User> implements IUserDAO{

	@Override
	public List<User> findAll()  {
		StringBuilder sql = new StringBuilder("SELECT * FROM member");
		List<User> users = query(sql.toString(), new UserMapper());
		
		return users;
	}
	
	@Override
	public List<User> getUsers(int index, int offset) {
		String sql = "SELECT * FROM member ORDER BY id DESC LIMIT ?,?";
		List<User> users = this.query(sql, new UserMapper(), index, offset);
		
		return users;
	}

	@Override
	public User findUserById(int userId)  {
		StringBuilder sql = new StringBuilder("SELECT * FROM member WHERE id = ?");
		List<User> users = query(sql.toString(), new UserMapper(), userId);
		
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public User findUserByUsername(String username)  {
		StringBuilder sql = new StringBuilder("SELECT * FROM member WHERE username = ?");
		List<User> users = query(sql.toString(), new UserMapper(), username);
	
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public int newUser(User user)  {
		String sql = "INSERT INTO member(username, pw, role) VALUES(?,?,?)";
		Integer userId = insert(sql, user.getUsername(), user.getHashedPw(), user.getRole());
		if(userId == null) return -1;
		else return userId;
	}

	@Override
	public void updateUser(User user)  {
		String sql = "UPDATE member SET full_name=? about=? WHERE id = ?";
		update(sql, user.getName(), user.getId());
		sql = "UPDATE member SET full_name=? about=? WHERE id = ?";
		update(sql, user.getAbout(), user.getId());
	}

	@Override
	public void changePassword(int userId, String pw)  {
		String sql = "UPDATE memer SET pw = ? WHERE id = ?";
		update(sql, pw, userId);
	}

}
