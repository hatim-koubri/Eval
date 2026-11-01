package com.demo;

import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/** Démonstration du format d'affichage demandé dans le TP. */
public class App {
    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Homme homme = new Homme("SAFI", "SAID", "0600000000", "Rabat", LocalDate.of(1965, 1, 1));
        List<Mariage> mariages = List.of(
            new Mariage(homme, new Femme("RAMI", "SALIMA", "", "", LocalDate.of(1970, 2, 4)), LocalDate.of(1990, 9, 3), null, 4),
            new Mariage(homme, new Femme("ALI", "AMAL", "", "", LocalDate.of(1972, 5, 10)), LocalDate.of(1995, 9, 3), null, 2),
            new Mariage(homme, new Femme("ALAOUI", "WAFA", "", "", LocalDate.of(1978, 6, 8)), LocalDate.of(2000, 11, 4), null, 3),
            new Mariage(homme, new Femme("ALAMI", "KARIMA", "", "", LocalDate.of(1971, 1, 2)), LocalDate.of(1989, 9, 3), LocalDate.of(1990, 9, 3), 0)
        );
        afficherMariages(homme, mariages);
    }

    public static void afficherMariages(Homme homme, List<Mariage> mariages) {
        System.out.println("Nom : " + homme.getNom() + " " + homme.getPrenom());
        System.out.println("\nMariages En Cours :\n");
        int i = 1;
        for (Mariage m : mariages) if (m.getDateFin() == null) {
            System.out.printf("%d. Femme : %-14s Date Début : %s    Nbr Enfants : %d%n",
                i++, m.getFemme().getNom() + " " + m.getFemme().getPrenom(), DATE.format(m.getDateDebut()), m.getNbrEnfant());
        }
        System.out.println("\nMariages échoués :\n");
        i = 1;
        for (Mariage m : mariages) if (m.getDateFin() != null) {
            System.out.printf("%d. Femme : %-14s Date Début : %s%n", i++, m.getFemme().getNom() + " " + m.getFemme().getPrenom(), DATE.format(m.getDateDebut()));
            System.out.printf("Date Fin : %s    Nbr Enfants : %d%n", DATE.format(m.getDateFin()), m.getNbrEnfant());
        }
    }
}
