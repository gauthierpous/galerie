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
    @NonNull
    private Exposition lieuDeVente;

    //Relation Transaction -- Personne
    @ManyToOne
    @NonNull
    private Personne client;

    //Relation Transaction -- Tableau
    @OneToOne
    @NonNull
    private Tableau oeuvre;
}
