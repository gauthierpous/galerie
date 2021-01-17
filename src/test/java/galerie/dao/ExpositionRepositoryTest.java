package galerie.dao;

import galerie.entity.Galerie;
import galerie.entity.Exposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import galerie.dao.GalerieRepository;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@DataJpaTest
public class ExpositionRepositoryTest {
    @Autowired
    private ExpositionRepository expositionDAO;
    @Autowired
    private GalerieRepository galerieDAO;

    @Test
    public void onSaitCompterLeNombreDexpositions(){
        log.info("On compte le nombre d'Exposition enregistrés dans la base de données");
        //Création de la galerie
        Galerie nouvelleGalerie = new Galerie(3000, "Louvre", "Musée du Louvre");

        //On crée 2 Expositions différentes
        Exposition expo1 = new Exposition(LocalDate.of(2020, 11, 13), "Premiere expo", 7, nouvelleGalerie);
        Exposition expo2 = new Exposition(LocalDate.of(2020, 12, 14), "Deuxième expo", 7, nouvelleGalerie);

        //Ajout des expositions à la liste des expositions de la galerie
        nouvelleGalerie.getExpositions().add(expo1);
        nouvelleGalerie.getExpositions().add(expo2);

        //On enregistre les expositions et la galerie dans la base de données
        galerieDAO.save(nouvelleGalerie);
        expositionDAO.save(expo1);
        expositionDAO.save(expo2);

        //On compte et on vérifie le nombre d'expositions présentes
        int nombre = 2;
        long resultat = expositionDAO.count();
        assertEquals(nombre, resultat, "On doit trouver 2 expositions enregistrées");
    }

    @Test
    public void onSaitAjouterUneExposition(){
        log.info("On ajoute une exposition puis on vérifie qu'elle a bien été ajoutée dans la base de données");
        //Création de la galerie
        Galerie nouvelleGalerie = new Galerie(3000, "Louvre", "Musée du Louvre");

        //On crée une exposition
        Exposition expo1 = new Exposition(LocalDate.now(), "Premiere expo", 7, nouvelleGalerie);

        //Ajout des expositions à la liste des expositions de la galerie
        nouvelleGalerie.getExpositions().add(expo1);

        //On enregistre l'exposition et la galerie la base de données
        galerieDAO.save(nouvelleGalerie);
        expositionDAO.save(expo1);

        //On récupère le contenu de la base de données et on le compare avec expo1
        List<Exposition> expositions = expositionDAO.findAll();
        Exposition expoRecuperee = expositions.get(0);
        assertEquals(expo1, expoRecuperee, "On doit trouver la même exposition");
    }

    @Test
    public void onSaitAjouterUneGalerieEtSesExpositions(){
        log.info("On ajoute une nouvelle galerie ainsi que des expositions");
        //Création de la galerie
        Galerie nouvelleGalerie = new Galerie(3000, "Louvre", "Musée du Louvre");

        //Création des expositions
        Exposition expo1 = new Exposition(LocalDate.of(2020, 11, 13), "Premiere Expo", 7, nouvelleGalerie);
        Exposition expo2 = new Exposition(LocalDate.of(2020, 12, 14), "Deuxième expo", 7, nouvelleGalerie);

        //Ajout des expositions à la liste des expositions de la galerie
        nouvelleGalerie.getExpositions().add(expo1);
        nouvelleGalerie.getExpositions().add(expo2);

        //Enregistrement de la galerie et des expositions dans la base de données
        galerieDAO.save(nouvelleGalerie);
        expositionDAO.save(expo1);
        expositionDAO.save(expo2);

        //Récupération des données
        List<Exposition> expositions = expositionDAO.findAll();
        Exposition expoRecuperee = expositions.get(0);

        List<Galerie> galerie = galerieDAO.findAll();
        Galerie galerieRecuperee = galerie.get(0);

        //Vérification de l'égalité pour l'id de la galerie dans la table galerie et exposition
        assertEquals(galerieRecuperee.getId(), expoRecuperee.getOrganisateur().getId(), "L'id doit être le même");
    }


}
