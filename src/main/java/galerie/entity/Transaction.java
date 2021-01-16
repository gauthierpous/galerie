package galerie.entity;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
//Annotation indiquant la création d'une entité
@Entity
public class Transaction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NonNull
    private LocalDate venduLe;

    @Column
    @NonNull
    private Float prixVente;

    //Relation Transaction -- Exposition
    @ManyToOne
    private Exposition lieuDeVente;

    //Relation Transaction -- Personne
    @ManyToOne
    private Personne client;

    //Relation Transaction -- Tableau
    @OneToOne
    private Tableau oeuvre;

    /*public LocalDate getVenduLe(){
        return this.venduLe;
    }
     */
}
