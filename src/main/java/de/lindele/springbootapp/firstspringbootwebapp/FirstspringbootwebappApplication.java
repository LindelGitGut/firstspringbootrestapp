package de.lindele.springbootapp.firstspringbootwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/*@SpringBootApplication ist eine Bequemlichkeitsannotation, die Folgendes hinzufügt:

@Configuration: Markiert die Klasse als Quelle von Bean-Definitionen für den Anwendungskontext.

@EnableAutoConfiguration: Informiert Spring Boot, damit es beginnt, Beans basierend auf den Einstellungen des Klassenpfads, anderen Beans und verschiedenen Eigenschaftseinstellungen hinzuzufügen. Wenn beispielsweise spring-webmvc im Klassenpfad vorhanden ist, kennzeichnet diese Annotation die Anwendung als Webanwendung und aktiviert wichtige Verhaltensweisen wie die Einrichtung eines DispatcherServlet.

@ComponentScan: Teilt Spring mit, nach anderen Komponenten, Konfigurationen und Services im com/example-Paket zu suchen, wodurch es die Controller findet.*/

@SpringBootApplication // Hier wird mitgeteilt das es sich bei der Klasse um eine Springboot App handelt
@RestController // der einfachkeit halber wird nun der selben Klasse die RestController Property zugewiesen
// Später soll der Rest Controller natürlich in einer sepraten Klasse stehen
public class FirstspringbootwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstspringbootwebappApplication.class, args);
	}

//@Get Mapping ist dafür da das eben urls für bestimmte aufrufe reserviert/hintelegt werden können, hier am beispiel hello
	@GetMapping("/hello")
	// den get-request können wir nun innerhalb der hello funktion noch parameter übergeben, hier beispielsweise mit name und age
	// somit können die parameter im browserabruf übergeben werden
	//z.b.: localhost:8080/name=alex&age=29
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name,
						@RequestParam(value =  "age", defaultValue = "i dont know how many") String age) {
		return String.format("Hello %s!\n You Are %s years old", name, age);
}



}
