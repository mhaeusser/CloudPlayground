package de.mhaeusser.highscore.model;

import de.mhaeusser.highscore.util.Log;
import java.util.Objects;

public class Player {

  private long playerId;

  public Player(long playerId) {
    this.playerId = playerId;
  }

  public void storeScore(int score) {
    Log.log(String.format("Stored %s -> %s", playerId, score));
  }

  public Long getId() {
    return playerId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return playerId == player.playerId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerId);
  }
}
