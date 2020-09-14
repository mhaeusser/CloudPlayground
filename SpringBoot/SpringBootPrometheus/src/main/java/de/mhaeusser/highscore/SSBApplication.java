package de.mhaeusser.highscore;

import de.mhaeusser.highscore.util.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** This code kills fascists. */
@SpringBootApplication
public class SSBApplication {

  public static void main(String[] args) {
    SpringApplication.run(SSBApplication.class, args);
    Log.log("The application is running.");
  }
}
