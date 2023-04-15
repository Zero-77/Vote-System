package votesystem.service;

import votesystem.model.VoteRecord;

import java.util.List;

public interface VoteRecordService {


    List<VoteRecord> getAllVoteRecord();

    void saveRecord(VoteRecord voteRecord);


}
