package ma.projet.classes;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="employe_tache") public class EmployeTache {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
 @ManyToOne(optional=false) private Employe employe; @ManyToOne(optional=false) private Tache tache;
 private LocalDate dateDebutReelle; private LocalDate dateFinReelle;
 public EmployeTache(){} public EmployeTache(Employe e,Tache t,LocalDate debut,LocalDate fin){employe=e;tache=t;dateDebutReelle=debut;dateFinReelle=fin;}
 public int getId(){return id;} public Employe getEmploye(){return employe;} public void setEmploye(Employe v){employe=v;} public Tache getTache(){return tache;} public void setTache(Tache v){tache=v;} public LocalDate getDateDebutReelle(){return dateDebutReelle;} public void setDateDebutReelle(LocalDate v){dateDebutReelle=v;} public LocalDate getDateFinReelle(){return dateFinReelle;} public void setDateFinReelle(LocalDate v){dateFinReelle=v;}
}
