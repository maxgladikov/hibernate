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
@Setter
@Getter
@Table(name = "printers")
@PrimaryKeyJoinColumn(name = "product_model")
public class Printer extends Product{

	@Column(nullable = false)
	private boolean color;
	@Column(nullable = false, length = 20)
	private String type;
	@Column(nullable = false)
	private int price;
}
