package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString

@Entity
public class Tableau{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(unique = true)
    @NonNull
    public String titre;

    @Column(unique = true)
    @NonNull
    public String support;

    @Column(unique = true)
    @NonNull
    public Integer largeur;

    @Column(unique = true)
    @NonNull
    public Integer hauteur;


    @ManyToOne
    private Artiste artiste;

    @OneToMany(mappedBy = "tableau")
    private List<Artiste> artistes;
    public List<Artiste> getArtistes() {
        return artistes;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    private Transaction transaction;
}