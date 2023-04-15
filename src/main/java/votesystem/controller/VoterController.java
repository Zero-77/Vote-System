package votesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import votesystem.model.Voter;
import votesystem.service.VoterService;

import java.util.List;

@Controller
public class VoterController {


	@Autowired
	private VoterService voterService;


	//Get 投票者 voter
	@CrossOrigin(origins = "*")
	@GetMapping("voter/getVoter")
	public ResponseEntity<List<Voter>> getVoterData() {


		List<Voter> result = this.voterService.getAllVoter();
		System.out.println(result.size());

		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(result);
	}


}
