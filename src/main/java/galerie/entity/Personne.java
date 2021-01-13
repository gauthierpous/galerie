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
    private String nom;

    @Column(unique = true)
    @NonNull
    private String adresse;

    //Relation Personne -- Transaction
    @OneToMany(mappedBy = "client")
    private List<Transaction> achats;
    public List<Transaction> getTransactions() {
        return achats;
    }

}
