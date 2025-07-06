package de.adam.votingapp.services;

import de.adam.votingapp.model.Poll;
import de.adam.votingapp.repositories.PollRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PollService {

  private final PollRepository pollRepository;

  public PollService(PollRepository pollRepository) {
      this.pollRepository = pollRepository;
  }

  public Poll createPoll(Poll poll) {
    return pollRepository.save(poll);
  }

  public List<Poll> getAllPolls() {
    return pollRepository.findAll();
  }

  public Optional<Poll> getPollById(Long id) {
    return pollRepository.findById(id);
  }
}
