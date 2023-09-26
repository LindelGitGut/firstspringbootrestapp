package de.lindele.springbootapp.firstspringbootwebapp.controller;

import de.lindele.springbootapp.firstspringbootwebapp.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ist eine Kobination aus @Controller und @ResponeseBody
public class GreetingController {

    private static String template = "Hello, %s!";
    private static AtomicLong counter = new AtomicLong();

    // Es wäre hier auch @RequestMapping(method=GET)) möglich, hier kann man auch PUT,POST ETC als Parameter hinterlegen
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Anonymous") String name){

        return new Greeting((int) counter.incrementAndGet(),String.format(template, name));
    }



}
