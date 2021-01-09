package galerie.dao;

import galerie.entity.Exposition;
//import galerie.entity.Transaction;
//import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ExpositionRepository extends JpaRepository<Exposition, Integer>{
    //TODO : Implémenter la méthode CA() : Float
    /*public float CA(){
        float chiffreAffaires = 0;
        LocalDate finExposition = this.debut.plusDays(this.duree);
        Transaction transaction = new Transaction;
        //if (this.)
        return chiffreAffaires;
    }
    */
}
