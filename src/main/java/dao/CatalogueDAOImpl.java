package dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

public class CatalogueDAOImpl implements ICatalogDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_Prod");
    EntityManager em = emf.createEntityManager();
	
	public void addProduit(Produit P) {
		// TODO Auto-generated method stub
		//Les transactions pour eviter les acces concurrents , pour ne pas avoir bcp de requete execute dans le m reecord en m temps
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
	        em.persist(P);
            t.commit();
		}catch(Exception e) {
			System.out.print(e.getMessage());
			t.rollback();
		}
	}

	public List<Produit> listProduits() {
		// TODO Auto-generated method stub
		//HQL
        Query q = em.createQuery("select P from Produit P");
		return q.getResultList();
	}

	public List<Produit> produitsParMC(String mc) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select P from Produit P where P.des like :x");
		q.setParameter("x", "%"+mc+"%");
		return q.getResultList();
	}
	public Produit getProduit(Long idProduit) {
		// TODO Auto-generated method stub
		Produit P = em.find(Produit.class, idProduit);
		return P;
	}

	public void updateProduit(Produit P) {
		// TODO Auto-generated method stub
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.merge(P);
			t.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			t.rollback();
		}
	}

	public void deleteProduit(Long idP) {
		// TODO Auto-generated method stub
EntityTransaction t = em.getTransaction();

		
		try {
			t.begin();
			Produit P= em.find(Produit.class, idP);
			em.remove(P);
			t.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			t.rollback();
		}
	}
   
}
