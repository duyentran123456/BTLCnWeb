package cnweb.service;

import java.util.List;

import cnweb.model.User;

public interface IUserService {
	public List<User> findAll();
	public User findById(int id);
	public User findByUsername(String username);
	
	public User login(String username, String password);	
	public int register(User user);
	public void updateUserInfo(User user);
	
	public void changePassword(int userId, String pw);
	public List<User> getUsers(int index, int offset);
}
