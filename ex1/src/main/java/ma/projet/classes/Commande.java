package ma.projet.classes;
import jakarta.persistence.*; import java.time.LocalDate; import java.util.*;
@Entity @Table(name="commandes") public class Commande {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private LocalDate date;
 @OneToMany(mappedBy="commande",cascade=CascadeType.ALL,orphanRemoval=true) private List<LigneCommandeProduit> lignes=new ArrayList<>();
 public Commande(){} public Commande(LocalDate date){this.date=date;}
 public Long getId(){return id;} public LocalDate getDate(){return date;} public void setDate(LocalDate d){date=d;} public List<LigneCommandeProduit> getLignes(){return lignes;}
 public void ajouterLigne(Produit p,int q){lignes.add(new LigneCommandeProduit(this,p,q));}
}
