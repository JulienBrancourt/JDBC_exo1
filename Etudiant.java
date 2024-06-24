package org.example;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private int numClasse;
    private LocalDate dateDiplome;

}

