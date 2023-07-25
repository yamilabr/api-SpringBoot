package ar.frp.users.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.frp.users.entity.Users;
import ar.frp.users.service.UsersService;

@RestController
@RequestMapping("/api")
public class UsersController {
	
	          /*Esta clase se diseña para manejar las peticiones
              request ) entrantes, es decir, todos los endpoints ”
             CRUD de tipo REST . Se usa la anotación*/

	@Autowired
	private UsersService userService;
	
	@GetMapping("/users")  //GetMapping devuelve informacion
	public List<Users> listaUsers()
	{
		//List<Users> resource=userService.getUsers();
		//return    ResponseEntity.ok(resource);
	   return this.userService.getUsers();
	}
	
	@PostMapping //PostMapping guardara un nuevo usuario
	public Users saveUser(@RequestBody Users user)
	{	
		//Users resource=userService.saveUser(user);
		
		return this.userService.saveUser(user);
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<String> modificarUser(@PathVariable Long id,@RequestBody Users user)
	{
		String resource=userService.putUsers(id, user);
		return ResponseEntity.ok(resource);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<Users>> getUserById(@PathVariable Long id)
	{
		Optional<Users> u=userService.getById(id);
		return ResponseEntity.ok(u);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id)
	{
	   String resource=userService.DeleteUser(id);
	  return ResponseEntity.ok(resource);
	}
	
}
