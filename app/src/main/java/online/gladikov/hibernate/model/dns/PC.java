package online.gladikov.hibernate.model.dns;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pc")
@Setter
@Getter
@PrimaryKeyJoinColumn(name = "product_model")
public class PC extends Product{

	@Column(nullable=false)
	private float speed;
	@Column(nullable=false)
	private int ram;
	@Column(nullable=false)
	private int hd;
	@Column(nullable=false)
	private int price;
}
