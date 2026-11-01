package ma.projet.classes;
import jakarta.persistence.*;
@Entity public class Produit {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String reference;
 private float prix;
 @ManyToOne(optional=false) private Categorie categorie;
 public Produit(){} public Produit(String reference,float prix,Categorie categorie){this.reference=reference;this.prix=prix;this.categorie=categorie;}
 public Long getId(){return id;} public String getReference(){return reference;} public void setReference(String v){reference=v;} public float getPrix(){return prix;} public void setPrix(float v){prix=v;} public Categorie getCategorie(){return categorie;} public void setCategorie(Categorie v){categorie=v;}
}
