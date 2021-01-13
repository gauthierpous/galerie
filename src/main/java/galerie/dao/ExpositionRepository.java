package galerie.dao;

import galerie.entity.Exposition;
import galerie.entity.Transaction;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ExpositionRepository extends JpaRepository<Exposition, Integer>{
    //TODO : Implémenter la méthode CA() : Float
   /* /**
     * Calculer le chiffre d'affaires pour une exposition
     * @param id la clé primaire de l'exposition
     * @return le chiffre d'affaires de cette exposition
     */
    /*float chiffreAffairePour(Integer id){
    //Déclarer un chiffre d'affaires nul
    //Selectionner et sommer les prixVente des transactions qui ont eu lieues lors de cette Exposition --> Utiliser l'ID
    //Retourner la valeur obtenue

        float chiffreAffaires = 0;
        return chiffreAffaires;

    }

     */

}
