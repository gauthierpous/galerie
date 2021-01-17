package galerie.dao;

import galerie.entity.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpositionRepository extends JpaRepository<Exposition, Integer>{
    /**
     * Calculer le chiffre d'affaires pour une exposition
     * @param id la clé primaire de l'exposition
     * @return le chiffre d'affaires de cette exposition
     */
    float chiffreAffairePour(Integer id);
    //Initialisation de la somme à 0;
    //Récupère toutes les transactions de l'exposition ayant pour id, l'id en paramètre
    //Somme tous les prix de ventes des transactions
    // "SELECT SUM(prix_vente) FROM Transaction, Exposition WHERE id = Exposition.id";
    //Exposition ();
}
