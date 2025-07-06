package de.adam.votingapp.services;

import de.adam.votingapp.model.OptionVote;
import de.adam.votingapp.model.Poll;
import de.adam.votingapp.repositories.PollRepository;
import java.util.List;
import java.util.Optional;
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

  public void vote(Long pollId, int optionIndex) {
    Poll poll = pollRepository.findById(pollId)
        .orElseThrow(() -> new RuntimeException("Poll not found with id: " + pollId));
    List<OptionVote> options = poll.getOptions();

    if (optionIndex < 0 || optionIndex >= options.size()) {
      throw new IllegalArgumentException("Invalid option index: " + optionIndex);
    }

    OptionVote option = options.get(optionIndex);
    option.setVoteCount(option.getVoteCount() + 1);

    pollRepository.save(poll);
  }
}
