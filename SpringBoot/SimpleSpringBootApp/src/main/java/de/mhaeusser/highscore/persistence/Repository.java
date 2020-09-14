package de.mhaeusser.highscore.persistence;

import de.mhaeusser.highscore.util.Log;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Repository {

  // playerId to score
  private Map<Long, Integer> map = new HashMap<>();

  private static Repository _instance;

  private Repository() {
  }

  public static Repository getInstance() {
    if (_instance == null) {
      _instance = new Repository();
    }
    return _instance;
  }

  public void storeScore(Long playerId, Integer score) {
    // Log.log(String.format("Storing config for player %s: %s", playerId, config));
  }

  /**
   * @param playerId
   * @return true if player was added, false is if was already used
   */
  public boolean createPlayer(long playerId) {
    if (map.containsKey(playerId)) {
      return false;
    }
    map.put(playerId, 0);
    return true;
  }

  public boolean hasPlayer(long playerId) {
    return map.containsKey(playerId);
  }

  /**
   * @param playerId
   * @return true if playerId was in the Map
   */
  public boolean deletePlayer(long playerId) {
    return null != map.remove(playerId);
  }
}
