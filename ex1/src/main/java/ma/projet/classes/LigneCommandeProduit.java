package ma.projet.classes;
import jakarta.persistence.*;
@Entity @Table(name="ligne_commande_produit") public class LigneCommandeProduit {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private int quantite;
 @ManyToOne(optional=false) private Produit produit;
 @ManyToOne(optional=false) private Commande commande;
 public LigneCommandeProduit(){} public LigneCommandeProduit(Commande c,Produit p,int q){commande=c;produit=p;quantite=q;}
 public Long getId(){return id;} public int getQuantite(){return quantite;} public void setQuantite(int q){quantite=q;} public Produit getProduit(){return produit;} public Commande getCommande(){return commande;}
}
