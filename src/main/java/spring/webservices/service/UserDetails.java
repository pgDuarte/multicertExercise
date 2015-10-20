package spring.webservices.service;


import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public interface UserDetails {
	

	public  String getname(@WebParam(name="nif") String nif);
	
	public  String geDetails(@WebParam(name="nif") String nif);
	
	public String addUser(@WebParam(name="nif") String nif,
			@WebParam(name="name") String name,
			@WebParam(name="address") String address, 
			@WebParam(name="phone") String phone);
	
	public String deleteUser(@WebParam(name="nif") String nif);

	public String getDetailsUsers(@WebParam(name="name") String name);
	
	public String getUsers();
}
