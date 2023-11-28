package online.gladikov.hibernate.model.caveat_emptor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="addresses")
public class Address {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	/*
	@org.hibernate.annotations.GenericGenerator(
			name = "ID_GENERATOR",
			strategy = "enhanced-sequence",
			parameters = {
				@org.hibernate.annotations.Parameter(
				name = "sequence_name",
				value = "JPWH_SEQUENCE"
			),
			@org.hibernate.annotations.Parameter(
				name = "initial_value",
				value = "1000"
			)
		})
	*/
	@Getter
	protected long id;

//	@OneToOne(optional = false)
//	protected User user;

	@NotNull
	private String street;
	@NotNull
	private String zipcode;
	@NotNull
	private String city;
	
	public Address(String street, String zipcode, String city) {
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", zipcode=" + zipcode + ", city=" + city + "]";
	}
	
	
}
