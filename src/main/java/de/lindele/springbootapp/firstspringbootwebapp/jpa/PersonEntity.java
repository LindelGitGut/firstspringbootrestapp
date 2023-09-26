package de.lindele.springbootapp.firstspringbootwebapp.jpa;


import jakarta.persistence.*;
import lombok.*;


// wird benötigt um eine Enität in der Datenbank zu erstellen

@Entity // Gibt an das es sich hierbei um eine Entität handelt
@Table(name = "person") // Optional Gibt an in welcher Tabelle die
// Entität gespeichert werden soll, wenn keine Angabe erfolgt,
// wird der Klassenname verwendet
@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

public class PersonEntity {


@Id //gibt an das es sich um eine ID Handelt (PK/FK?)
@GeneratedValue(strategy = GenerationType.IDENTITY) // Increment auf ID bei anlage
// und Automatische vergabe
private Long id;
private String name;
private int age;
private String job;


}
