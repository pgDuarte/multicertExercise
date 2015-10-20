package spring.webservices.service.dao;




import java.util.List;

import spring.webservices.service.model.User;

public interface UserDAO {

	  void persistUser(User user);
	  
	  User findUserById(String nif);
	  
	  void updateUser(User user);
	  
	  void deleteUser(String id);

	  List getDetailsUsers(String name);

	  List getUsers();
	  
	/*  List getDetailsUsers(String name);*/
	  
	  
}
