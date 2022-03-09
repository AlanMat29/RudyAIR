package rudyAir.model.compte;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.model.Views;

@Entity
@Table(name = "compte")
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_compte", initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "compte", discriminatorType = DiscriminatorType.STRING, length = 15)
public class Compte implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompte")
	@JsonView(Views.Common.class)
	private Long id;

	@Column(length = 100, nullable = false)
	@NotEmpty
	@Length(min = 1, max = 100)
	@JsonView(Views.Common.class)
	private String nom;
	@NotEmpty
	@Column(length = 100, nullable = false)
	@Length(min = 1, max = 100)
	@JsonView(Views.Common.class)
	private String prenom;
	@JsonView(Views.Common.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateNaissance;
	@Column(length = 100, nullable = false, unique = true)
	@NotEmpty
	@Email
	@Length(min = 5, max = 100)
	@JsonView(Views.Common.class)
	private String email;
	@NotEmpty
	@Column(name = "password", length = 150, nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "users_roles")
	private Set<Role> roles;

	@Version
	private int version;

	public Compte() {

	}

	public Compte(Long id, String nom, String prenom, LocalDate dateNaissance, String email, String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
	}

	public Compte(String nom, String prenom, LocalDate dateNaissance, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
	}

	// Getters-Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return getRoles().stream().map(r -> new SimpleGrantedAuthority(r.toString())).collect(Collectors.toList());
		
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
		
	
	
}
