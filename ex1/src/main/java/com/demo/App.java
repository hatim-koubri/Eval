package com.demo;

import ma.projet.classes.*;
import ma.projet.service.*;
import ma.projet.util.HibernateUtil;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            CategorieService categories = new CategorieService();
            ProduitService produits = new ProduitService();
            CommandeService commandes = new CommandeService();

            // Réutilise les données existantes si le programme est relancé.
            Categorie categorie = categories.findAll().stream()
                    .filter(c -> "INFO".equals(c.getCode())).findFirst().orElse(null);
            if (categorie == null) {
                categorie = new Categorie("INFO", "Informatique");
                categories.create(categorie);
            }
            final Categorie cat = categorie;
            creerProduitSiAbsent(produits, "ES12", 120, cat);
            creerProduitSiAbsent(produits, "ZR85", 100, cat);
            creerProduitSiAbsent(produits, "EE85", 200, cat);

            List<Produit> liste = produits.findAll();
            Produit es12 = liste.stream().filter(p -> "ES12".equals(p.getReference())).findFirst().orElseThrow();
            Produit zr85 = liste.stream().filter(p -> "ZR85".equals(p.getReference())).findFirst().orElseThrow();
            Produit ee85 = liste.stream().filter(p -> "EE85".equals(p.getReference())).findFirst().orElseThrow();

            Commande commande = new Commande(LocalDate.of(2013, 3, 14));
            commande.ajouterLigne(es12, 7);
            commande.ajouterLigne(zr85, 14);
            commande.ajouterLigne(ee85, 5);
            commandes.create(commande);

            System.out.println("Commande : " + commande.getId() + "    Date : " + commande.getDate());
            System.out.println("Liste des produits :");
            System.out.printf("%-15s %-12s %s%n", "Référence", "Prix", "Quantité");
            for (Object[] ligne : produits.lignesParCommande(commande.getId())) {
                System.out.printf("%-15s %-12s %s%n", ligne[0], ligne[1] + " DH", ligne[2]);
            }

            System.out.println("\nProduits de la catégorie " + cat.getLibelle() + " :");
            produits.parCategorie(cat.getId()).forEach(p -> System.out.println(p.getReference() + " - " + p.getPrix() + " DH"));
            System.out.println("\nProduits commandés entre deux dates :");
            produits.commandesEntre(LocalDate.of(2013, 3, 1), LocalDate.of(2013, 3, 31))
                    .forEach(p -> System.out.println(p.getReference() + " - " + p.getPrix() + " DH"));
            System.out.println("\nProduits de plus de 100 DH :");
            produits.prixSuperieurA(100).forEach(p -> System.out.println(p.getReference() + " - " + p.getPrix() + " DH"));
        } catch (Exception e) {
            System.err.println("Erreur : vérifiez MySQL, XAMPP et les paramètres de hibernate.cfg.xml.");
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    private static void creerProduitSiAbsent(ProduitService service, String reference, float prix, Categorie categorie) {
        boolean existe = service.findAll().stream().anyMatch(p -> reference.equals(p.getReference()));
        if (!existe) service.create(new Produit(reference, prix, categorie));
    }
}
