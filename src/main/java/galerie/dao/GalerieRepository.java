package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Galerie;

// This will be AUTO IMPLEMENTED by Spring 

public interface GalerieRepository extends JpaRepository<Galerie, Integer> {
    //TODO : Implémenter la méthode pour calculer le chiffre d'affaires
    /*public float CAannuel(int annee){
        float chiffreAffaires = 0;

        return chiffreAffaires;
    }
    */
}
