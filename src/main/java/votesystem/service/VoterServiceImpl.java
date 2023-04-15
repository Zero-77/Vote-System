package votesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import votesystem.model.Voter;
import votesystem.repository.VoterRepository;

import java.util.List;
import java.util.Optional;

//實踐投票者voter
@Service
public class VoterServiceImpl implements VoterService {

	@Autowired
	private VoterRepository voterRepository;

	@Override
	public List<Voter> getAllVoter() {
		return voterRepository.findAll();
	}


}
