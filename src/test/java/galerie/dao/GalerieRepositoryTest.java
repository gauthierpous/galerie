package galerie.dao;

import galerie.entity.Galerie;
import galerie.entity.Exposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import galerie.dao.GalerieRepository;

import java.time.LocalDate;
import java.util.List;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class GalerieRepositoryTest {

    @Autowired
    private GalerieRepository galerieDAO;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Galerie'");
        int combienDansLeJeuDeTest = 1; 
        long nombre = galerieDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 galerie" );
    }

    @Test
    public void onSaitAjouterUneGalerie(){
        log.info("On ajoute des données dans la table Galerie");
        //Création de la galerie
        Galerie nouvelleGalerie = new Galerie(3000, "Louvre", "Musée du Louvre");

        //Enregistrements de la Galerie dans la base de données
        galerieDAO.save(nouvelleGalerie);

        //Récuperation de tous les champs de la base de donnée
        List< Galerie> galeries = galerieDAO.findAll();
        Galerie galerieRecuperee = galeries.get(0);

        //Comparaison
        assertEquals(nouvelleGalerie, galerieRecuperee, "On doit avoir la même galerie");
    }
    //TODO : Les Galeries sont toutes différentes
    @Test
    public void galeriesToutesDifferentes() {
        log.info("On vérifie que toutes les galeries de la base sont différentes");
        //Création de deux galerie différentes
        Galerie nouvelleGalerie = new Galerie(30000, "Louvre", "Musée du Louvre");
        Galerie deuxiemeGalerie = new Galerie(5000, "Louvre", "2 rue Émile ZOLA");

        //Enregistrement des deux galeries dans la base de données
        galerieDAO.save(nouvelleGalerie);

        //Vérificaton
        assertThrows(DataIntegrityViolationException.class, () -> {
            galerieDAO.save(deuxiemeGalerie);
        }, "On doit avoir une violation de contrainte d'inrégrité (unicité)");
    }

    //TODO : Ajouter Galerie + Exposition
    @Test
    public void onSaitAjouterUneGalerieEtSesExpositions(){
        log.info("On ajoute une nouvelle galerie ainsi que des expositions");
        //Création de la galerie
        Galerie nouvelleGalerie = new Galerie(3000, "Louvre", "Musée du Louvre");

        //Création des expositions
        Exposition expo1 = new Exposition(LocalDate.of(2020, 11, 13), "Premiere Expo", 7);
        Exposition expo2 = new Exposition(LocalDate.of(2020, 12, 14), "Deuxième expo", 7);

        //Ajout des expositions à la liste des expositions de la galerie
        nouvelleGalerie.getExpositions().add(expo1);
        nouvelleGalerie.getExpositions().add(expo2);

        //Enregistrement de la galerie dans la base de données
        galerieDAO.save(nouvelleGalerie);
    }







}
