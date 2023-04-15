package votesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import votesystem.model.VoteRecord;
import votesystem.repository.VoteRecordRepository;

import java.util.List;
@Service
public class VoteRecordServiceImpl implements VoteRecordService{
    @Autowired
    private VoteRecordRepository voteRecordRepository;

    @Override
    public List<VoteRecord> getAllVoteRecord() {
        return voteRecordRepository.findAll();
    }

    @Override
    public void saveRecord(VoteRecord voteRecord) {
        this.voteRecordRepository.save(voteRecord);
    }
}
