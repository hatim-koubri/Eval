package ma.projet.beans;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="mariage")
public class Mariage {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false)
    @JoinColumn(name="homme_id")
    private Homme homme;
    @ManyToOne(optional=false)
    @JoinColumn(name="femme_id")
    private Femme femme;
    private LocalDate dateDebut,dateFin;
    private int nbrEnfant; protected Mariage(){} public Mariage(Homme h,Femme f,LocalDate d,LocalDate fin,int e){homme=h;femme=f;dateDebut=d;dateFin=fin;nbrEnfant=e;} public Long getId(){return id;} public Homme getHomme(){return homme;} public Femme getFemme(){return femme;} public LocalDate getDateDebut(){return dateDebut;} public LocalDate getDateFin(){return dateFin;} public int getNbrEnfant(){return nbrEnfant;} }
