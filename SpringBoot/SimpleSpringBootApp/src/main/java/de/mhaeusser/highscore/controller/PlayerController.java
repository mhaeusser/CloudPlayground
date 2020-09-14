package de.mhaeusser.highscore.controller;

import de.mhaeusser.highscore.persistence.Repository;
import de.mhaeusser.highscore.util.Log;
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

  @PutMapping("/score")
  @ResponseStatus(HttpStatus.OK)
  public String saveScore(
      @RequestParam(value = "id") long playerId, @RequestParam(value = "score") int score) {
    int result = Repository.getInstance().saveScore(playerId, score);
    String msg = "";
    switch (result) {
      case -2:
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No player with id " + playerId + ".");
      case -1:
        msg = String.format("%s is less than the high score.", score);
        break;
      case 0:
        msg = String.format("%s is equal to the high score.", score);
        break;
      case 1:
        msg = String.format("%s is the new high score!", score);
        break;
    }
    Log.log(msg);
    return msg;
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

  @DeleteMapping("/deleteAll")
  @ResponseStatus(HttpStatus.OK)
  public String deleteAll() {
    Repository.getInstance().deleteAll();
    return "Deleted all data.";
  }
}
