package ma.projet.classes;
import jakarta.persistence.*; import java.time.LocalDate; import java.util.*;
@Entity public class Tache {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id; private String nom; private LocalDate dateDebut; private LocalDate dateFin; private double prix;
 @ManyToOne private Projet projet; @OneToMany(mappedBy="tache",cascade=CascadeType.ALL) private List<EmployeTache> affectations=new ArrayList<>();
 public Tache(){} public Tache(String nom,LocalDate debut,LocalDate fin,double prix){this.nom=nom;dateDebut=debut;dateFin=fin;this.prix=prix;}
 public int getId(){return id;} public void setId(int v){id=v;} public String getNom(){return nom;} public void setNom(String v){nom=v;} public LocalDate getDateDebut(){return dateDebut;} public void setDateDebut(LocalDate v){dateDebut=v;} public LocalDate getDateFin(){return dateFin;} public void setDateFin(LocalDate v){dateFin=v;} public double getPrix(){return prix;} public void setPrix(double v){prix=v;} public Projet getProjet(){return projet;} public void setProjet(Projet v){projet=v;} public List<EmployeTache> getAffectations(){return affectations;}
}
