package hu.model;

import java.util.Objects;

public class Match {


  private Long id;

  private String dateOfMatch;

  private String nameOfTeam1;

  private String nameOfTeam2;

  private int pointsOfTeam1;

  private int pointsOfTeam2;

  private Game game;

  public Match() {

  }

  public Match(Long id,
               String dateOfMatch,
               String nameOfTeam1,
               String nameOfTeam2,
               int pointsOfTeam1,
               int pointsOfTeam2,
               Game game) {
    this.id = id;
    this.dateOfMatch = dateOfMatch;
    this.nameOfTeam1 = nameOfTeam1;
    this.nameOfTeam2 = nameOfTeam2;
    this.pointsOfTeam1 = pointsOfTeam1;
    this.pointsOfTeam2 = pointsOfTeam2;
    this.game = game;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDateOfMatch() {
    return dateOfMatch;
  }

  public void setDateOfMatch(String dateOfMatch) {
    this.dateOfMatch = dateOfMatch;
  }

  public String getNameOfTeam1() {
    return nameOfTeam1;
  }

  public void setNameOfTeam1(String nameOfTeam1) {
    this.nameOfTeam1 = nameOfTeam1;
  }

  public String getNameOfTeam2() {
    return nameOfTeam2;
  }

  public void setNameOfTeam2(String nameOfTeam2) {
    this.nameOfTeam2 = nameOfTeam2;
  }

  public int getPointsOfTeam1() {
    return pointsOfTeam1;
  }

  public void setPointsOfTeam1(int points) {
    this.pointsOfTeam1 = points;
  }

  public int getPointsOfTeam2() {
    return pointsOfTeam2;
  }

  public void setPointsOfTeam2(int pointsOfTeam2) {
    this.pointsOfTeam2 = pointsOfTeam2;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Match match = (Match) o;
    return pointsOfTeam1 == match.pointsOfTeam1
            &&
            pointsOfTeam2 == match.pointsOfTeam2
            &&
            Objects.equals(id, match.id)
            &&
            Objects.equals(dateOfMatch, match.dateOfMatch)
            &&
            Objects.equals(nameOfTeam1, match.nameOfTeam1)
            &&
            Objects.equals(nameOfTeam2, match.nameOfTeam2)
            &&
            game == match.game;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id,
            dateOfMatch,
            nameOfTeam1,
            nameOfTeam2,
            pointsOfTeam1,
            pointsOfTeam2, game);
  }

  @Override
  public String toString() {
    return "Match{"
            + "id=" + id
            +
            ", date_of_match='"
            + dateOfMatch + '\''
            +
            ", name_of_team_1='"
            + nameOfTeam1 + '\''
            +
            ", name_of_team_2='"
            + nameOfTeam2 + '\''
            +
            ", points_of_team_1="
            + pointsOfTeam1
            +
            ", points_of_team_2="
            + pointsOfTeam2
            +
            ", game="
            + game
            +
            '}';
  }
}
