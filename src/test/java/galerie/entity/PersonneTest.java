package galerie.entity;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonneTest {
    private Galerie Louvre = new Galerie("Louvre", "Musée du Louvre");
    private Exposition expo1 = new Exposition(LocalDate.of(2020, 11, 13), "Premiere Expo", 7, Louvre);
    private Exposition expo2 = new Exposition(LocalDate.of(2020, 12, 14), "Deuxième expo", 7, Louvre);

    private Personne Guillaume = new Personne();
    private Tableau tableau1 = new Tableau();
    private Tableau tableau2 = new Tableau();
    private Tableau tableau3 = new Tableau();
    private Tableau tableau4 = new Tableau();

    private Transaction achat1 = new Transaction(LocalDate.of(2020, 11, 13), (float)300, expo1, Guillaume, tableau1);
    private Transaction achat2 = new Transaction(LocalDate.of(2020, 11, 14), (float)400, expo1, Guillaume, tableau2);
    private Transaction achat3 = new Transaction(LocalDate.of(2020, 12, 15), (float)700, expo2, Guillaume, tableau3);
    private Transaction achat4 = new Transaction(LocalDate.of(2020, 12, 17), (float)1000, expo2, Guillaume, tableau4);

    @Test
    public void testCalculBudgetAnnuelClient(){
        Guillaume.getTransactions().add(achat1);
        Guillaume.getTransactions().add(achat2);
        Guillaume.getTransactions().add(achat3);
        Guillaume.getTransactions().add(achat4);

        int budgetPrevu = 2400;
        float budgetCalcule = Guillaume.budgetArt(2020);
        assertEquals(budgetPrevu, budgetCalcule, "Le budget prévu pour Guillaume est de 2400");
    }
}
