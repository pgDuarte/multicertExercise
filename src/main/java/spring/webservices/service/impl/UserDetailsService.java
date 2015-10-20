package spring.webservices.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.hibernate.Criteria;


import spring.webservices.service.UserDetails;
import spring.webservices.service.dao.UserDAO;
import spring.webservices.service.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@WebService(endpointInterface = "spring.webservices.service.UserDetails")
public class UserDetailsService implements UserDetails {

	@Autowired
	private UserDAO UserDAO;

	@Override
	@Transactional
	public String getname(String nif) {

		System.out.println("ola");
		try {
			User usr = UserDAO.findUserById(nif);
			return "<name>" + usr.getName() + "<name>";
		} catch (Exception e) {
			return "Erro ao obter o utilizador - erro:" + e;
		}

	}

	@Override
	@Transactional
	public String geDetails(@WebParam(name = "nif") String nif) {
		if(nif != null)
		{
			try {
				User usr = UserDAO.findUserById(nif);
				return "<name>" + usr.getName() + "</name> <phone>" + usr.getPhoneNumber() + "</phone>";
			} catch (Exception e) {
				return "Erro ao obter o utilizador - erro:" + e;
			}
			
		}else return "Error, nif is null";
		

	}

	@Override
	@Transactional
	public String addUser(@WebParam(name = "nif") String nif, @WebParam(name = "name") String name,
			@WebParam(name = "address") String address, @WebParam(name = "phone") String phone) {

	if(nif!=null && name !=null && address !=null && phone!=null)
	{
		try {
			User user = new User();
			user.setAddress(address);
			user.setName(name);
			user.setNif(nif);
			user.setPhoneNumber(phone);
			UserDAO.persistUser(user);
			return "Success";
		} catch (Exception e) {
			return "Erro ao adicionar o utilizador - erro:" + e;
		}
	}
	else return "Erro ao adicionar o utilizador - parametro em falta";



	}

	@Override
	@Transactional
	public String deleteUser(@WebParam(name = "nif") String nif) {
		
		if(nif!=null)
		{
			try {
				UserDAO.deleteUser(nif);
				return "Success";
			} catch (Exception e) {
				return "Erro ao eliminar o utilizador - erro:" + e;
			}
			
		}
		else return "DeleteUser: niff = null";
		
	}

	@Override
	@Transactional

	public String getDetailsUsers(@WebParam(name = "name") String name) {
		
		if(name!=null)
		{
			try {
				List l = UserDAO.getDetailsUsers(name);
				System.out.println(l.size());
				String nam;
				String address;
				String nif;
				String phone;
				String b = "<user>";
				String e = "</user>";
				;
				String finals = "";

				Iterator iter = l.iterator();

				while (iter.hasNext()) {
					Map map = (Map) iter.next();
					User usr = (User) map.get(Criteria.ROOT_ALIAS);

					nam = "<name>" + usr.getName() + "</name>";
					nif = "<nif>" + usr.getNif() + "</nif>";
					address = "<address>" + usr.getAddress() + "</address>";
					phone = "<phone>" + usr.getPhoneNumber() + "</nif>";

					finals = finals + b + nam + nif + address + phone + e;
				}

				return finals;
			} catch (Exception e) {
				return "Error " + e;
			}
		}else return "Error name is null";
		

	}

	@Override
	@Transactional
	public String getUsers() {

		try {
			List l = UserDAO.getUsers();
			System.out.println(l.size());
			String nam;
			String address;
			String nif;
			String phone;
			String b = "<user>";
			String e = "</user>";
			
			String finals = "";

			Iterator iter = l.iterator();

			while (iter.hasNext()) {
				Map map = (Map) iter.next();
				User usr = (User) map.get(Criteria.ROOT_ALIAS);

				nam = "<name>" + usr.getName() + "</name>";
				nif = "<nif>" + usr.getNif() + "</nif>";
				address = "<address>" + usr.getAddress() + "</address>";
				phone = "<phone>" + usr.getPhoneNumber() + "</nif>";

				finals = finals + b + nam + nif + address + phone + e;
			}

			return finals;
		} catch (Exception e) {
			return "Error " + e;
		}

	}

}
