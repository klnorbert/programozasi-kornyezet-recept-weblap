package hu.service;

import java.util.List;

import hu.model.Match;

public interface EsportService {

  List<Match> getAllMatches();

  Match getMatch(Long id);

  Match createMatch(Match match);

  Match updateMatch(Long id, Match matchUpdate);

  void deleteMatch(Long id);

}
