package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString

@Entity
public class Exposition{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NonNull
    private LocalDate debut;

    @Column(unique = true)
    @NonNull
    private String intitule;

    @Column(unique = true)
    @NonNull
    private Integer duree;

    //Relation Exposition -- Galerie
    @ManyToOne
    private Galerie organisateur;

    //Relation Exposition -- Tableau
    @ManyToMany
    List<Tableau> oeuvres = new LinkedList<>();

    //Relation Exposition -- Transaction
    @OneToMany(mappedBy = "lieuDeVente")
    private List<Transaction> ventes;
    public List<Transaction> getTransactions() {
        return ventes;
    }
}