package org.example;

import java.util.Scanner;

public class IHM {
    public static void start() {

        System.out.println("===Menu===");
        System.out.println("Choisissez une option :");
        System.out.println("1. Ajouter un étudiant");
        System.out.println("2. Afficher les étudiants");
        System.out.println("3. Afficher les étudiants d'une classe");
        System.out.println("4. Supprimer un étudiant");
        System.out.println("5. Quitter");

        Scanner sc = new Scanner(System.in);

        int choix = sc.nextInt();
        sc.nextLine();

        switch (choix) {

            case 1 -> addEtudiant();

            case 2 -> BDDGestion.listeEtudiants();

            case 3 -> {
                //Scanner sc = new Scanner(System.in);
                System.out.println("Quelle classe ?");
                int choixClasse = sc.nextInt();
                sc.nextLine();

                BDDGestion.listeEtudiantsClasse(choixClasse);
            }
            case 4 -> {
                System.out.println("Quel id ?");
                int choixId = sc.nextInt();
                sc.nextLine();

                BDDGestion.deleteEtudiant(choixId);
            }
            case 5 -> sc.close();
        }



    }

    public static void addEtudiant () {
        Etudiant etudiant = new Etudiant();


        Scanner sc = new Scanner(System.in);

        System.out.println("Saisissez votre nom : ");
        String nom = sc.nextLine();
        etudiant.setNom(nom);
        System.out.println(nom);


        System.out.println("Saisissez votre prénom : ");
        String prenom = sc.nextLine();
        etudiant.setPrenom(prenom);

        System.out.println("Saisissez votre n° de classe : ");
        int numClasse = sc.nextInt();
        sc.nextLine();
        etudiant.setNumClasse(numClasse);

//        System.out.println("Saisissez votre date de diplôme : ");
//        String dateDiplome = sc.nextLine();
//        etudiant.setDateDiplome() = dateDiplome;

        BDDGestion.Add(etudiant);

    }


}
