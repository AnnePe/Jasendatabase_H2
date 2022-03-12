package kevat22.Jasendatabase.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;



@Entity
public class Jasen {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Size(min=2, max=50, message="Etunimi pitää olla {min} - {max} merkkiä pitkä.")
	private String etunimi;
	
	@Size(min=2, max=50, message="Sukunimi pitää olla {min} - {max} merkkiä pitkä.")
	private String sukunimi;
	
	@Size(min=0, max=100 , message="Osoite voi olla korkeintaan {max} merkkiä pitkä.")
	private String osoite;
	
	@Size (min=0, max=5, message="Postinumeron maksimi pituus on {max} merkkiä.") 
	private String postinumero;
	
	
	@Size(min=0, max=30, message="Puhelinumero voi olla korkeintaan {max} merkkiä.")
	private String puhelin;
	
	@Email(message="Email pitaa olla muotoa: ***@***")
	@Size(min=1, max=100)
	private String email;
	
	@ManyToOne
	@JoinColumn(name="yhdistysid")
	private Yhdistys yhdistys;
	
	@ManyToOne
	@JoinColumn(name="jasenyysid")
	private Jasenyys jasenyys;
	
	
	@ManyToMany
	@JoinTable(
			name="jasen_tapahtuma",
			joinColumns = @JoinColumn(name="jasen_id"),
			inverseJoinColumns = @JoinColumn(name="tapahtuma_id")
			)
	
	private Set<Tapahtuma> tapahtumat =new HashSet<>();//pitää määritellä set elementti että voi määriettlä get
	
	public Jasen() {}
	
	public Jasen(String etunimi, String sukunimi, String osoite, String postinumero, String puhelin, String email, Yhdistys yhdistys, Jasenyys jasenyys) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.osoite = osoite;
		this.postinumero = postinumero;
		this.puhelin = puhelin;
		this.email = email;
		this.yhdistys=yhdistys;
		this.jasenyys=jasenyys;
		
		
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public String getOsoite() {
		return osoite;
	}
	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}
	public String getPostinumero() {
		return postinumero;
	}
	public void setPostinumero(String postinumero) {
		this.postinumero = postinumero;
	}
	public String getPuhelin() {
		return puhelin;
	}
	public void setPuhelin(String puhelin) {
		this.puhelin = puhelin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Yhdistys getYhdistys() {
		return yhdistys;
	}

	public void setYhdistys(Yhdistys yhdistys) {
		this.yhdistys = yhdistys;
	}

	public Jasenyys getJasenyys() {
		return jasenyys;
	}

	public void setJasenyys(Jasenyys jasenyys) {
		this.jasenyys = jasenyys;
	}
	
	public Set<Tapahtuma> getTapahtumat() {
		return tapahtumat;
	}

	public void setTapahtumat(Set<Tapahtuma> tapahtumat) {
		this.tapahtumat = tapahtumat;
	}
	
	public void addTapahtuma(Tapahtuma tapahtuma) {
		this.tapahtumat.add(tapahtuma);
	}
	

	@Override
	public String toString() {
		return "[ tapahtumat ]";
	}

//	@Override
//	public String toString() {
//		return "Jasen [ etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", osoite=" + osoite
//				+ ", postinumero=" + postinumero + ", puhelin=" + puhelin + ", email=" + email + "]";
//	}

	
	

	
}
