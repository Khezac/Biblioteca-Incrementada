package br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "usuario")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "user_id",
        scope = Usuario.class
)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer user_id; 
	
	@Column(name = "user_nome")
	@NotBlank
	private String user_nome;
	
	@Column(name = "user_email")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String user_email;
	
	@Column(name = "user_password")
	@NotBlank
	@Size(min = 4, max = 12)
	private String user_password;
	
	@ManyToOne
	@JoinColumn(name="perfil_id", referencedColumnName="perfil_id")
	@NotNull
	private Perfil perfil;

	public Usuario() {

	}

	public Usuario(String user_nome, String user_email, String user_password,Perfil perfil) {
		this.user_nome = user_nome;
		this.user_email = user_email;
		this.user_password = user_password;
		this.perfil = perfil;
		
	}
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_nome() {
		return user_nome;
	}

	public void setUser_nome(String user_nome) {
		this.user_nome = user_nome;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Perfil getPerfil() {
    return perfil;
    }
}
