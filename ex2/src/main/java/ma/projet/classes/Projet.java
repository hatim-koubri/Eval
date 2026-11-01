package ma.projet.classes;
import jakarta.persistence.*; import java.time.LocalDate; import java.util.*;
@Entity public class Projet {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id; private String nom; private LocalDate dateDebut; private LocalDate dateFin;
 @ManyToOne private Employe chefProjet;
 @OneToMany(mappedBy="projet",cascade=CascadeType.ALL) private List<Tache> taches=new ArrayList<>();
 public Projet(){} public Projet(String nom,LocalDate debut,LocalDate fin){this.nom=nom;dateDebut=debut;dateFin=fin;}
 public int getId(){return id;} public void setId(int v){id=v;} public String getNom(){return nom;} public void setNom(String v){nom=v;}
 public LocalDate getDateDebut(){return dateDebut;} public void setDateDebut(LocalDate v){dateDebut=v;} public LocalDate getDateFin(){return dateFin;} public void setDateFin(LocalDate v){dateFin=v;}
 public Employe getChefProjet(){return chefProjet;} public void setChefProjet(Employe v){chefProjet=v;} public List<Tache> getTaches(){return taches;}
}
