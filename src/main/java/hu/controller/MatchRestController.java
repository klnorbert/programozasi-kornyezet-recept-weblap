package hu.controller;

import java.util.List;

import hu.model.Match;
import hu.service.EsportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/e-sport")
public class MatchRestController {

  private EsportService esportService;

  public MatchRestController(EsportService esportService) {
    this.esportService = esportService;
  }

  @GetMapping
  public List<Match> getAllMatches() {
    return esportService.getAllMatches();
  }

  @GetMapping("/{id}")
  Match getMatch(final @PathVariable("id") Long id) {

    return esportService.getMatch(id);

  }

  @PostMapping
  Match createMatch(final @RequestBody Match match) {

    return esportService.createMatch(match);

  }

  @PutMapping("/{id}")
  Match updateMatch(final @PathVariable Long id, final @RequestBody Match matchUpdate) {

    return esportService.updateMatch(id, matchUpdate);

  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteMatch(final @PathVariable Long id) {
    esportService.deleteMatch(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
