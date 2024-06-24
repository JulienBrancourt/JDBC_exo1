package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BDDGestion {
    public static void Add(Etudiant etudiant) {
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=exojdbc1";
        String user = "postgres";
        String password = "test";

        Connection connection;

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("La connexion est ok");
            } else {
                System.out.println("Connexion echoué");

            }

            String request = "INSERT INTO etudiant (nom, prenom, numdeClasse) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setInt(3, etudiant.getNumClasse());
            int nbrRows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());


        }
    }

    public static void listeEtudiants() {

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=exojdbc1";
        String user = "postgres";
        String password = "test";

        Connection connection;

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("La connexion est ok");
            } else {
                System.out.println("Connexion echoué");

            }

            Statement statement = connection.createStatement();
            String requestList = "select * from etudiant";
            ResultSet resultSet = statement.executeQuery(requestList);
            List<Etudiant> etudiants = new ArrayList<>();
            while (resultSet.next()) {
                etudiants.add(Etudiant.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .prenom(resultSet.getString("prenom"))
                        .numClasse(resultSet.getInt("numdeclasse"))
                        .build());
            }
            System.out.println(etudiants);

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public static void listeEtudiantsClasse(int choixClasse) {

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=exojdbc1";
        String user = "postgres";
        String password = "test";

        Connection connection;

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("La connexion est ok");
            } else {
                System.out.println("Connexion echoué");

            }

            Statement statement = connection.createStatement();
            String requestClasse = "select * from etudiant where numdeclasse=" + choixClasse;
            ResultSet rs = statement.executeQuery(requestClasse);
            while (rs.next()) {
                System.out.println(rs.getString("nom") + " / " + rs.getString("prenom") + " / " + rs.getInt("numdeclasse"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public static void deleteEtudiant(int choixId) {

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=exojdbc1";
        String user = "postgres";
        String password = "test";

        Connection connection;

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("La connexion est ok");
            } else {
                System.out.println("Connexion echoué");

            }

            Statement statement = connection.createStatement();
            String requestClasse = "delete from etudiant where id=" + choixId;
            ResultSet rs = statement.executeQuery(requestClasse);


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

}
