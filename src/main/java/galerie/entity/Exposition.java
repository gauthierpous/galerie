package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString

//Du coup je peux supprimer le NoArgsConstructor ?
//OK
@Entity
public class Exposition{

    private float sommeDesVentes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NonNull
    private LocalDate debut;

    @Column
    @NonNull
    private String intitule;

    @Column
    @NonNull
    private int duree;

    /*
    @Column
    @NonNull
    private Galerie galerie;
    */

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

    /**
     * Calculer le chiffre d'affaires pour une exposition
     * @param id la clé primaire de l'exposition
     * @return le chiffre d'affaires de cette exposition
     */
    public float CA(Integer id){
        //Initialisation de la somme à 0;
        //Pour chaque ventes, si l'id du lieu de vente correspond à l'id en paramètre
        //Alors ajouter le prix de vente à la la somme.
        this.sommeDesVentes = 0;
        ventes.forEach((v) -> {
            if(v.getLieuDeVente().id == id)
            this.sommeDesVentes += v.getPrixVente();
        });
        return this.sommeDesVentes;
    }
}