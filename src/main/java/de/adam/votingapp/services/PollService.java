package de.adam.votingapp.services;

import de.adam.votingapp.model.Poll;
import de.adam.votingapp.repositories.PollRepository;
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
}
