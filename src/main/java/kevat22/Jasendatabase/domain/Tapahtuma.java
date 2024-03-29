package kevat22.Jasendatabase.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Tapahtuma {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=50, nullable = false, unique = true)
	private String name;
	
	@ManyToMany(mappedBy="tapahtumat")
	
	private Set<Jasen> jasentapahtumat;
	
	public Tapahtuma(){}
	
	public Tapahtuma(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Tapahtuma( String name) {
		super();
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "" + name + "";
	}

	
	

}
