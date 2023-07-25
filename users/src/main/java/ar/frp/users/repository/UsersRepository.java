package ar.frp.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.frp.users.entity.Users;

@RepositoryRestResource()
public interface UsersRepository extends JpaRepository<Users,Long>{  //Hereda a JpaRepository y toma el modelo "Users"  y el tipo de datos del id

}
