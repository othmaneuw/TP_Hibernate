package dao;

import java.util.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CatalogueDAOImpl cdi = new CatalogueDAOImpl();
		cdi.addProduit(new Produit("USB TOSHIBA",123,10));
		cdi.addProduit(new Produit("Souris",125,10));
		cdi.addProduit(new Produit("Clavier",130,10));
		
		List<Produit> maListe = new ArrayList<Produit>();
		//affichage
		//maListe = cdi.listProduits();
		//Afficher par designation
		maListe = cdi.produitsParMC("TOSHIBA");
		for(Produit P: maListe) {
			System.out.println(P);
		}
		
		cdi.updateProduit(new Produit(2L,"USB SDD",30,20));
		//cdi.deleteProduit(2L);
		
		System.out.println(cdi.getProduit(2L));
		
		
	
	}

}
