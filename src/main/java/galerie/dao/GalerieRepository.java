package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Galerie;


// This will be AUTO IMPLEMENTED by Spring
public interface GalerieRepository extends JpaRepository<Galerie, Integer> {

    /*
    @Autowired
    GalerieRepository galerieDAO = null;

    //Création de la galerie
    Galerie nouvelleGalerie = new Galerie("Ma Nouvelle Galerie", "2 rue de la Rue");

    //Création des expositions
    Exposition expo1 = new Exposition(LocalDate.of(2020, 11, 13), "Premiere Expo", 7, nouvelleGalerie);
    Exposition expo2 = new Exposition(LocalDate.of(2020, 12, 14), "Deuxième expo", 7, nouvelleGalerie);

    //Ajout des expositions à la liste des expositions de la galerie
    nouvelleGalerie.getExpositions().add(expo1);
    nouvelleGalerie.getExpositions().add(expo2);

    //Enregistrements de la Galerie
    galerieDAO.save(nouvelleGalerie)
     */
}
