package ar.frp.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;



import ar.frp.users.entity.Users;
import ar.frp.users.repository.UsersRepository;


/*@Component: le permite a Spring detectar a
nuestros beans de manera automática. En otras
palabras, sin escribir código permite:
•
Escanear nuestra aplicación buscando clases
anotadas con @Component
•
Instanciarlas e inyectarles las dependencias
especificadas
•
Inyectarlas donde sea necesario*/


@Component
public class UsersService { 
	
	/*En esta clase llamamos a todos los métodos de la
interface DAO (en el repositorio) para manejar todas
las operaciones SQL.*/
	
	@Autowired
	private UsersRepository userRepository;
	
	public void UserRepository(UsersRepository userRepository)
	{
		this.userRepository=userRepository;
	}
	
	public List<Users> getUsers()
	{
		return userRepository.findAll();
	}

	public Users saveUser(Users user)
	{
		return userRepository.save(user);
	}
	
	
	
	public String putUsers(Long id, Users user)
	{
		if (userRepository.existsById(id)==true)
		{
			userRepository.deleteById(id);
			userRepository.save(user);
		}
		
		return "Modificado con exito!";
	}
	public Optional<Users> getById(Long id)
	{
		return userRepository.findById(id);
	}
	public String DeleteUser(Long id)
	{
		if (userRepository.existsById(id)==true)
		{
			userRepository.deleteById(id);
		}
		//userRepository.delete(users);
		return "Eliminado con exito!";
	}
}
