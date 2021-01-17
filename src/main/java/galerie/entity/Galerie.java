package galerie.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;


// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column
    @NonNull
    private float chiffreAffairesAnnuel;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;

    //Relation Galerie -- Expositions
    @OneToMany(mappedBy = "organisateur")
    private List<Exposition> evenements = new ArrayList<>() ;
    public List<Exposition> getExpositions(){ return evenements; }

    public float CAannuel(int annee){
        //Initialisation du chiffre d'affaires à 0;
        //Pour chaque evenements, si la date de l'évènement correspond à l''année en paramètre
        //Alors ajouter le CA de l'évènement au chiffre d'affaires annuel de la galerie.
        this.chiffreAffairesAnnuel = 0;
        evenements.forEach((e) -> {
           if(e.getDebut().getYear() == annee) {
               this.chiffreAffairesAnnuel += e.CA(this.id);
           }
        });
        return this.chiffreAffairesAnnuel;
    }

}
