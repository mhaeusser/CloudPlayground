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

  private Repository() {}

  public static Repository getInstance() {
    if (_instance == null) {
      _instance = new Repository();
    }
    return _instance;
  }

  // -2: no player
  // -1: less than high score
  // 0: same as high score
  // 1: new high score
  public int saveScore(long playerId, int score) {
    if (!map.containsKey(playerId)) {
      return -2;
    }
    int oldScore = map.get(playerId);
    if (score < oldScore) {
      return -1;
    }
    if (score == oldScore) {
      return 0;
    }
    // score > oldScore
    map.put(playerId, score);
    return 1;
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

  /** Deletes all data. */
  public void deleteAll() {
    map.clear();
  }
}
