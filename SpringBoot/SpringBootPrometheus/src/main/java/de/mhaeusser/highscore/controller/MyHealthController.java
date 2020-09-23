package de.mhaeusser.highscore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHealthController {

  @GetMapping("/myhealth")
  public String myhealth() {
    return "OK";
  }
}
