package votesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import votesystem.model.Voter;
import votesystem.repository.VoterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VoterServiceImpl implements VoterService {

	@Autowired
	private VoterRepository voterRepository;

	@Override
	public List<Voter> getAllVoter() {
		return voterRepository.findAll();
	}

	@Override
	public void saveVoter(Voter voter) {
		this.voterRepository.save(voter);
	}

	@Override
	public Voter getVoterById(int id) {
		Optional<Voter> optional = voterRepository.findById(id);
		Voter voter = null;
		if (optional.isPresent()) {
			voter = optional.get();
		} else {
			throw new RuntimeException(" Voter not found id : " + id);
		}
		return voter;
	}

	@Override
	public void deleteVoterById(int id) {
		this.voterRepository.deleteById(id);
	}

	@Override
	public Page<Voter> findPaginatedVoter(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.voterRepository.findAll(pageable);
	}

}
