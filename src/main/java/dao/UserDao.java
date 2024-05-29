package dao;

import entity.User;

public interface UserDao {
	
	public boolean userRegister(User user) ;
	
	public User loginUser(String email, String password);
	
	public boolean checkOldPassword(int userId, String oldPassword);
	
	public boolean changePassword(int userId, String newPassword);
	
	public int countTotalUser();

}
