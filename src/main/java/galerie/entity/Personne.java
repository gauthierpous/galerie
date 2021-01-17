package galerie.entity;
import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne{

    private float budgetAnnuel;

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
    private List<Transaction> achats = new ArrayList<>();
    public List<Transaction> getTransactions() {
        return achats;
    }

    public float budgetArt(int annee){
        //Initialisation du budget à 0;
        //Pour chaque achat, si la date de l'achat correspond à l'année en paramètre
        //Alors ajouter le prix d'achat au budget annuel du client.
        this.budgetAnnuel = 0;
        achats.forEach(a ->{
           if (a.getVenduLe().getYear() == annee){
               this.budgetAnnuel += a.getPrixVente();
           }
        });
        return this.budgetAnnuel;
    }
}
