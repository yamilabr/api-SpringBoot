package ar.frp.users.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="users")
public class Users {    //Entity es nuestro modelo para la BASE DE DATOS.
	
	@Id  //Marca el atributo id como la clave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY)   //especifica que los valores de la clave primaria van a ser generados automáticamente en la base de	datos.
	//@Column  //se usa para mapear los atributos entre la entidad y las columnas de la BD
	private Long id;

	@Column(name="nombre")
	@NonNull
	private String nombre;
	
	@Column(name="apellido")
	@NonNull	
	private String apellido;
	
	@Column(name="email")
	@NonNull
	private String email;
	
	
	
}
