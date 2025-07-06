package de.adam.votingapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Vote {
  private Long pollId;
  private int optionIndex;
}
