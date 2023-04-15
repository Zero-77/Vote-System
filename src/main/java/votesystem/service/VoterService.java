package votesystem.service;

import org.springframework.data.domain.Page;
import votesystem.model.Voter;

import java.util.List;

public interface VoterService {
	List<Voter> getAllVoter();
	void saveVoter(Voter user);
	Voter getVoterById(int id);
	void deleteVoterById(int id);
	Page<Voter> findPaginatedVoter(int pageNo, int pageSize, String sortField, String sortDirection);
}
