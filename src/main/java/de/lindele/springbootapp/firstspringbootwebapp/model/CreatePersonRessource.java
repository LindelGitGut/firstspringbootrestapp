package de.lindele.springbootapp.firstspringbootwebapp.model;

//wird benötigt um z.B. den die benötigten paramter aus dem Request zu ziehen
// wird z.b. hier im PersonController als Paramter mit der @Requestbody Parameter genutzt um die entsprechenden Attribute zu erhalten

public record CreatePersonRessource( String name, int age, String job) {

}
