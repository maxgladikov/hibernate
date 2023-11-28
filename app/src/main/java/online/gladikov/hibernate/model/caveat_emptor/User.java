package online.gladikov.hibernate.model.caveat_emptor;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="users")
@NoArgsConstructor
public class User {
	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	protected long id;
	
	protected String name;
	
	@OneToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.PERSIST)
	@JoinColumn(unique = true)
	protected Address shippingAddress;
	
	@Override
	public String toString() {
		return name;
	}

}
