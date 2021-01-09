package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NonNull
    private String nom;

    @Column(unique = true)
    @NonNull
    private String adresse;

    @OneToMany(mappedBy = "personne")
    private List<Transaction> transactions;
    public List<Transaction> getTransactions() {
        return transactions;
    }

}
