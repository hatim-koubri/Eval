package com.demo;

import ma.projet.classes.*;
import ma.projet.service.*;
import ma.projet.util.HibernateUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class App {
 private static final DateTimeFormatter F=DateTimeFormatter.ofPattern("dd/MM/yyyy");
 public static void main(String[] args) {
  try {
   EmployeService employes=new EmployeService(); ProjetService projets=new ProjetService();
   TacheService taches=new TacheService(); EmployeTacheService affectations=new EmployeTacheService();
   Employe e=new Employe("Alami","Sara","0600000000"); employes.create(e);
   Projet p=new Projet("Gestion de stock",LocalDate.of(2013,1,14),LocalDate.of(2013,12,31)); p.setChefProjet(e); projets.create(p);
   Tache a=new Tache("Analyse",LocalDate.of(2013,2,1),LocalDate.of(2013,2,28),1200); a.setProjet(p); taches.create(a);
   Tache c=new Tache("Conception",LocalDate.of(2013,3,1),LocalDate.of(2013,3,31),1500); c.setProjet(p); taches.create(c);
   Tache d=new Tache("Développement",LocalDate.of(2013,4,1),LocalDate.of(2013,4,30),2500); d.setProjet(p); taches.create(d);
   affectations.create(new EmployeTache(e,a,LocalDate.of(2013,2,10),LocalDate.of(2013,2,20)));
   affectations.create(new EmployeTache(e,c,LocalDate.of(2013,3,10),LocalDate.of(2013,3,15)));
   affectations.create(new EmployeTache(e,d,LocalDate.of(2013,4,10),LocalDate.of(2013,4,25)));

   List<EmployeTache> rows=projets.tachesReelles(p.getId());
   System.out.printf("Projet : %d    Nom : %s    Date début : %s%n",p.getId(),p.getNom(),p.getDateDebut().format(DateTimeFormatter.ofPattern("dd MMMM yyyy",java.util.Locale.FRENCH)));
   System.out.println("Liste des tâches :");
   System.out.printf("%-5s %-20s %-23s %s%n","Num","Nom","Date Début Réelle","Date Fin Réelle");
   for(EmployeTache row:rows) System.out.printf("%-5d %-20s %-23s %s%n",row.getTache().getId(),row.getTache().getNom(),row.getDateDebutReelle().format(F),row.getDateFinReelle().format(F));
  } finally { HibernateUtil.shutdown(); }
 }
}
