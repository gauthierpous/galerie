package galerie.dao;

import galerie.entity.Galerie;
import galerie.entity.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;


@Log4j2
@DataJpaTest
public class PersonneRepositoryTest {
    @Autowired
    private PersonneRepository personneDAO;

    @Test
    @Sql("test-data.sql")
    public void onSaitCompterLeNombreDePersonne(){
        log.info("On compte le nombre d'enregistrement de Personne");
        int combienDansLeTest = 2;
        long nombreCompte = personneDAO.count();
        assertEquals(combienDansLeTest, nombreCompte, "Il doit y avoir 2 enregistrements de Personne");
    }

    @Test
    public void onSaitAjouterDesDonneesDansLaBase(){
        log.info("On ajoute des données dans la  table Personne");
        //Création de la Personne
        Personne nouvellePersonne = new Personne("44 boulevard de Lyon");

        //Enregistrements de la Galerie dans la base de données
        personneDAO.save(nouvellePersonne);

        //Récuperation de tous les champs de la base de donnée
        List< Personne> personnes = personneDAO.findAll();
        Personne personneRecuperee = personnes.get(0);

        //Comparaison
        assertEquals(nouvellePersonne, personneRecuperee, "On doit avoir la même personne");
    }
}
