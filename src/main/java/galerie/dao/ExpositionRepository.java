package galerie.dao;

import galerie.entity.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ExpositionRepository extends JpaRepository<Exposition, Integer>{
    /*
    @Autowired
    ExpositionRepository expositionDAO = null;

    //Création de la galerie
    Galerie Louvre = new Galerie("Musée du Louvre", "Musée du Louvre");

    //Création de l'exposition
    Exposition nouvelleExposition = new Exposition(LocalDate.of(2020, 3, 12), "La peinture moderne", 3, Louvre);

    //Création de tableaux
    Transaction tableau1 = new Transaction(LocalDate.of(2020, 3, 14), new Float(300));
    Transaction tableau2 = new Transaction(LocalDate.of(2020, 3, 5), new Float(500));

    //Ajout des tableaux à l'exposition
    nouvelleExposition.getTransactions().add(tableau1);
    nouvelleExposition.getTransactions().add(tableau2);

    //Ajout de l'exposition à la galerie
    Louvre.getExpositions().add(nouvelleExposition);

    //Enregistrement de la galerie
    expositionDAO.save(Louvre);

     */
}
