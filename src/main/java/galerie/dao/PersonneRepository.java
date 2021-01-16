package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer>{
    //Déclarer un budget nul
    //Selectionner et sommer les prixVente des transactions réalisées par le client pour une année donnée --> Utiliser le paramètre
    //Retourner la valeur obtenue
}
