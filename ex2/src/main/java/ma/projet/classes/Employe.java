package ma.projet.classes;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Employe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    private String nom;
    private String prenom;
    private String telephone;
    @OneToMany(mappedBy = "employe") private List<EmployeTache> affectations = new ArrayList<>();
    @OneToMany(mappedBy = "chefProjet") private List<Projet> projetsGeres = new ArrayList<>();
    public Employe() {}
    public Employe(String nom, String prenom, String telephone) { this.nom=nom; this.prenom=prenom; this.telephone=telephone; }
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getNom(){return nom;} public void setNom(String v){nom=v;}
    public String getPrenom(){return prenom;} public void setPrenom(String v){prenom=v;}
    public String getTelephone(){return telephone;} public void setTelephone(String v){telephone=v;}
    public List<EmployeTache> getAffectations(){return affectations;}
    public List<Projet> getProjetsGeres(){return projetsGeres;}
    @Override public String toString(){return prenom+" "+nom;}
}
