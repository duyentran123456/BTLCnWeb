package cnweb.dao;

import java.util.List;

import cnweb.model.User;

public interface IUserDAO extends GenericDAO<User>{
	
	public int newUser(User user) ;
	public void updateUser(User user) ;
	public void changePassword(int userId, String pw) ;
	
	public List<User> findAll() ;
	
	public User findUserById(int userId) ;
	
	public User findUserByUsername(String username) ;
	public List<User> getUsers(int index, int offset);
}
