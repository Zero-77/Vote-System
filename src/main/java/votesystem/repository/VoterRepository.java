package votesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import votesystem.model.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer>{

}
