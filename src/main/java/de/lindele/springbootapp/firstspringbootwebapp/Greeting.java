package de.lindele.springbootapp.firstspringbootwebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// Ein Record ist eine Klasse welche die Parameter als attribut setzt und automatisch getter und setter
// dafür setzt
public record Greeting(int id, String name) {



}
