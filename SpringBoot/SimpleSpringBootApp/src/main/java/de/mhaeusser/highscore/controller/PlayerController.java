package de.mhaeusser.highscore.controller;

import de.mhaeusser.highscore.persistence.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PlayerController {

  @PutMapping("/create")
  @ResponseStatus(HttpStatus.OK)
  public String createPlayer(@RequestParam(value = "id") long playerId) {
    boolean wasCreated = Repository.getInstance().createPlayer(playerId);
    if (wasCreated) {
      return "Created Player with id " + playerId + ".";
    }
    throw new ResponseStatusException(
        HttpStatus.CONFLICT, "Player with id " + playerId + " exists already.");
  }

  @DeleteMapping("/delete")
  @ResponseStatus(HttpStatus.OK)
  public String deletePlayer(@RequestParam(value = "id") long playerId) {
    boolean hasExisted = Repository.getInstance().deletePlayer(playerId);
    if (!hasExisted) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No player with id " + playerId);
    }
    return "Deleted player with id " + playerId + ".";
  }
}
