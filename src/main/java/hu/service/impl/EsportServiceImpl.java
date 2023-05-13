package hu.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.model.Game;
import hu.model.Match;
import hu.model.exception.NotFoundException;
import hu.service.EsportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EsportServiceImpl implements EsportService {

  private static final List<Match> DATA_BASE = new ArrayList<>();

  @Autowired
  public EsportServiceImpl() {
    DATA_BASE.add(new Match(1L, "2022:05:15", "AZE", "SGB", 0, 1, Game.LeagueOfLegends));
    DATA_BASE.add(new Match(2L, "2022:05:15", "DFM", "T1", 0, 1, Game.LeagueOfLegends));
  }

  public EsportServiceImpl(final List<Match> matches) {
    DATA_BASE.addAll(matches);
  }

  @Override
  public List<Match> getAllMatches() {
    return Collections.unmodifiableList(DATA_BASE);
  }

  @Override
  public Match getMatch(final Long id) {
    return DATA_BASE.stream().filter(match -> match.getId()
                    .equals(id))
            .findFirst()
            .orElseThrow(NotFoundException::new);
  }

  @Override
  public Match createMatch(final Match match) {

    match.setId(getNextId());
    DATA_BASE.add(match);
    return match;

  }

  @Override
  public Match updateMatch(final Long id, final Match matchUpdate) {

    final Match match = getMatch(id);
    match.setDateOfMatch(matchUpdate.getDateOfMatch());
    match.setNameOfTeam1(matchUpdate.getNameOfTeam1());
    match.setNameOfTeam2(matchUpdate.getNameOfTeam2());
    match.setPointsOfTeam1(matchUpdate.getPointsOfTeam1());
    match.setPointsOfTeam2(matchUpdate.getPointsOfTeam2());
    match.setGame(matchUpdate.getGame());
    return match;

  }

  @Override
  public void deleteMatch(final Long id) {

    final Match match = getMatch(id);
    DATA_BASE.remove(match);

  }

  private long getNextId() {

    return getLastId() + 1L;

  }

  private long getLastId() {

    return DATA_BASE.stream()
            .mapToLong(Match::getId)
            .max()
            .orElse(0);

  }

}
