package votesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import votesystem.model.VoteRecord;
import votesystem.service.VoteRecordService;

import java.util.List;
@Controller
public class VoteRecordController {
    @Autowired
    private VoteRecordService voteRecordService;


    //取得Item
    @CrossOrigin(origins = "*")
    @GetMapping("voting/getVoteRecord")
    public ResponseEntity<List<VoteRecord>> getVoteRecordData() {


        List<VoteRecord> result = this.voteRecordService.getAllVoteRecord();
        System.out.println(result.size());

        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(result);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/saveRecord")
    public String saveRecord(@ModelAttribute("voteRecord") VoteRecord voteRecord) {
        // save Record to database
        voteRecordService.saveRecord(voteRecord);
        return "redirect:/";
    }
//    @CrossOrigin(origins = "*")
//    @PostMapping("voting/insertOrderProduct")
//    public ResponseEntity<ResponseFormat<VoteRecord>> insertOrderProductData(@Valid @RequestBody VoteRecord data){
//
//        ResponseFormat <VoteRecord> results = new ResponseFormat<VoteRecord>();
//        System.out.println("VoteRecord....Data:"+data);
//        this.doInsertOrderIntoDB(data);
//
//        results.setReturn_message("success");
//        results.setReturn_data(data);
//
//        return ResponseEntity.ok().body(results);
//
//    }


}
