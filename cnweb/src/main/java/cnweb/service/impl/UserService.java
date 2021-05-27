package cnweb.service.impl;

import java.util.List;

import cnweb.dao.IUserDAO;
import cnweb.dao.impl.UserDAO;
import cnweb.model.User;
import cnweb.service.IUserService;

public class UserService implements IUserService{
	
	private IUserDAO dao = new UserDAO();

	@Override
	public List<User> findAll()   {
		return dao.findAll();
	}
	
	@Override
	public List<User> getUsers(int index, int offset) {
		return dao.getUsers(index, offset);
	}

	@Override
	public User findById(int id)   {
		return dao.findUserById(id);
	}

	@Override
	public User findByUsername(String username)   {
		return dao.findUserByUsername(username);
	}

	@Override
	public User login(String username, String password)   {
		User user = dao.findUserByUsername(username);
		if(user == null) return null;
		
		if(user.getHashedPw().equals(password)) return user;
		
		return null;
	}

	@Override
	public int register(User user)   {
		return dao.newUser(user);
	}

	@Override
	public void updateUserInfo(User user)   {
		dao.updateUser(user);
	}

	@Override
	public void changePassword(int userId, String pw)   {
		dao.changePassword(userId, pw);
	}

}
