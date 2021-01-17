package galerie.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ExpositionTest {

    private Galerie Louvre = new Galerie("Louvre", "Musée du Louvre");
    private Exposition expo1 = new Exposition(LocalDate.of(2020, 11, 13), "Premiere Expo", 7, Louvre);

    private Personne Guillaume = new Personne();
    private Tableau tableau1 = new Tableau();
    private Tableau tableau2 = new Tableau();

    private Transaction achat1 = new Transaction(LocalDate.of(2020, 11, 13), (float)300, expo1, Guillaume, tableau1);
    private Transaction achat2 = new Transaction(LocalDate.of(2020, 11, 14), (float)400, expo1, Guillaume, tableau2);


    @Test
    public void testCAExposition(){
        expo1.getTransactions().add(achat1);
        expo1.getTransactions().add(achat2);

        int CAAttendu = 700;
        int CACalcule = (int) expo1.CA(expo1.getId());
        assertEquals(CAAttendu, CACalcule, "Le chiffre d'affaires attendu est de 700");
    }
}
