package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString

@Entity
public class Exposition{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NonNull
    private Date debut;

    @Column(unique = true)
    @NonNull
    private String intitule;

    @Column(unique = true)
    @NonNull
    private Integer duree;


    @ManyToOne
    private Galerie galerie;

    @ManyToOne
    private Tableau tableau;

    @OneToMany(mappedBy = "exposition")
    private List<Transaction> transactions;
    public List<Transaction> getTransactions() {
        return transactions;
    }
}