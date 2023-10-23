package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class Skier implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long numSkier;
	String firstName;
	String lastName;
	LocalDate dateOfBirth;
	String city;

	public Skier(String firstName, String lastName, LocalDate dateOfBirth, String city,  Set<Piste> pistes, Set<Registration> registrations) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.city = city;

		this.pistes = pistes;
		this.registrations = registrations;
	}

	public Skier(Long numSkier, String firstName, String lastName, LocalDate dateOfBirth, String city, Set<Piste> pistes, Set<Registration> registrations) {
		this.numSkier = numSkier;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.pistes = pistes;
		this.registrations = registrations;
	}

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	Subscription subscription;



	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "excursion",
			joinColumns = @JoinColumn(name = "numSkier"),
			inverseJoinColumns = @JoinColumn(name = "numPiste"))
	private Set<Piste> pistes;


	@OneToMany(mappedBy = "skier")
	Set<Registration> registrations;



}
