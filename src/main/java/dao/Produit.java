package dao;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Produits")
public class Produit implements Serializable {
	
	@Id
	@Column(name="id_produit")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ref;
	
	@Column(length = 50)
	private String des;
	
	private double prix_u;
	
	private int qte;
	
	public Produit(String des, double prix_u, int qte) {
		super();
		this.setDes(des);
		this.prix_u = prix_u;
		this.qte = qte;
	}

	public Produit(Long ref, String des, double prix_u, int qte) {
		super();
		this.ref = ref;
		this.des = des;
		this.prix_u = prix_u;
		this.qte = qte;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getPrix_u() {
		return prix_u;
	}

	public void setPrix_u(double prix_u) {
		this.prix_u = prix_u;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Long getRef() {
		return ref;
	}

	public void setRef(Long ref) {
		this.ref = ref;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	
}
