package dao;

import java.util.*;

public interface ICatalogDAO {
     public void addProduit(Produit P);
     public List<Produit> listProduits();
     public List<Produit> produitsParMC(String mc);
     public Produit getProduit(Long idProduit);
     public void updateProduit(Produit P);
     public void deleteProduit(Long idP);
}
