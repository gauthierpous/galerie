package galerie.entity;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
//Annotation indiquand la création d'une entité
@Entity
public class Transaction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NonNull
    private LocalDate venduLe;

    @Column(unique = true)
    @NonNull
    private Float prixVente;

    @ManyToOne
    private Exposition exposition;

    @ManyToOne
    private Personne personne;

    @OneToOne(mappedBy = "transaction")
    private Tableau tableau;

}
