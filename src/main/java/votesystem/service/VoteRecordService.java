package votesystem.service;

import votesystem.model.VoteRecord;

import java.util.List;

//投票紀錄vote_record介面
public interface VoteRecordService {


    List<VoteRecord> getAllVoteRecord();

    void saveRecord(VoteRecord voteRecord);


}
