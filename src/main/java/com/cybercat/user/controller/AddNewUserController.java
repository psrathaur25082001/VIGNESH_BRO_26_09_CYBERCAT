package com.cybercat.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cybercat.user.entity.AgentEntity;
import com.cybercat.user.entity.BRVEntity;
import com.cybercat.user.entity.BrokerEntity;
import com.cybercat.user.entity.ClaimApprovalEntity;
import com.cybercat.user.entity.ClientEntity;
import com.cybercat.user.entity.IntermediaryEntity;
import com.cybercat.user.entity.MultipleUsersListEntity;
import com.cybercat.user.entity.Response;
import com.cybercat.user.entity.UnderwriterEntity;
import com.cybercat.user.entity.UsersEntity;
import com.cybercat.user.repository.ClientRepo;
import com.cybercat.user.repository.UnderwriterRepo;
import com.cybercat.user.repository.UsersRepo;
import com.cybercat.user.service.AddNewUserService;

@RestController
@RequestMapping("/add/new")
@CrossOrigin
public class AddNewUserController {

	@Autowired
	AddNewUserService addNewUserService;

	@Autowired
	UsersRepo usersRepo;

	@Autowired
	UnderwriterRepo underwriterRepo;

	@Autowired
	ClientRepo clientRepo;
	
	// CREATE ALL USERS
//	@PostMapping("/createClient")
//	public ClientEntity createClient(@RequestBody ClientEntity client) {
//		ClientEntity result = addNewUserService.setClientDraft(client);
//		addNewUserService.generateClient(result.getId());
//		return addNewUserService.createClient(client);
//	}

	@PostMapping("/createClient")
	public Response setClientDraft(@RequestBody ClientEntity client) throws Exception {
		ClientEntity result = addNewUserService.createClient(client);
		addNewUserService.generateClient(result.getId());
		Response res = new Response();
		res.setMessage("Client Added Successfully!");
		res.setResponseCode(200);
		res.setResponsedata(result);
		res.setStatus(true);
		return res;		
	}
	
	@PostMapping("/createUnderwriter")
	public UnderwriterEntity createUnderwriter(@RequestBody UnderwriterEntity under) {
		return addNewUserService.createUnderwriter(under);
	}

	@PostMapping("/createIntermediary")
	public IntermediaryEntity createIntermediary(@RequestBody IntermediaryEntity inter) {
		return addNewUserService.createIntermediary(inter);
	}

	@PostMapping("/createAgent")
	public AgentEntity createAgent(@RequestBody AgentEntity agent) {
		return addNewUserService.createAgent(agent);
	}

	@PostMapping("/createBroker")
	public BrokerEntity createBroker(@RequestBody BrokerEntity broker) {
		return addNewUserService.createBroker(broker);
	}

	@PostMapping("/createBrv")
	public BRVEntity createBrv(@RequestBody BRVEntity brv) {
		return addNewUserService.createBrv(brv);
	}

	@PostMapping("/createClaimApproval")
	public ClaimApprovalEntity createClaimApproval(@RequestBody ClaimApprovalEntity claim) {
		return addNewUserService.createClaimApproval(claim);
	}

	// EDIT ALL USERS
	@PutMapping("/editClient")
	public ClientEntity editClient(@RequestBody ClientEntity editClient, @RequestParam int id) throws Exception {
		return addNewUserService.editClient(editClient, id);
	}

	@PutMapping("/editUnder")
	public UnderwriterEntity editUnder(@RequestBody UnderwriterEntity editUnder, @RequestParam int id)
			throws Exception {
		return addNewUserService.editUnder(editUnder, id);
	}

	@PutMapping("/editInter")
	public IntermediaryEntity editInter(@RequestBody IntermediaryEntity editInter, @RequestParam int id)
			throws Exception {
		return addNewUserService.editInter(editInter, id);
	}

	@PutMapping("/editAgent")
	public AgentEntity editAgent(@RequestBody AgentEntity editAgent, @RequestParam int id) throws Exception {
		return addNewUserService.editAgent(editAgent, id);
	}

	@PutMapping("/editBroker")
	public BrokerEntity editBroker(@RequestBody BrokerEntity editBroker, @RequestParam int id) throws Exception {
		return addNewUserService.editBroker(editBroker, id);
	}

	@PutMapping("/editBrv")
	public BRVEntity editBrv(@RequestBody BRVEntity editBrv, @RequestParam int id) throws Exception {
		return addNewUserService.editBrv(editBrv, id);
	}

	@PutMapping("/editClaimApproval")
	public ClaimApprovalEntity editClaimApproval(@RequestBody ClaimApprovalEntity editClaimApproval,
			@RequestParam int id) throws Exception {
		return addNewUserService.editClaimApproval(editClaimApproval, id);
	}

	// GET ALL USERS
	@GetMapping("/getClient")
	public List<ClientEntity> getClient() {
		return addNewUserService.getClient();
	}

	@GetMapping("/getUnderwriter")
	public List<UnderwriterEntity> getUnderwriter() {
		return addNewUserService.getUnderwriter();
	}

	@GetMapping("/getIntermediary")
	public List<IntermediaryEntity> getIntermediary() {
		return addNewUserService.getIntermediary();
	}

	@GetMapping("/getAgent")
	public List<AgentEntity> getAgent() {
		return addNewUserService.getAgent();
	}

	@GetMapping("/getBroker")
	public List<BrokerEntity> getBroker() {
		return addNewUserService.getBroker();
	}

	@GetMapping("/getBrv")
	public List<BRVEntity> getBrv() {
		return addNewUserService.getBrv();
	}

	@GetMapping("/getClaimApproval")
	public List<ClaimApprovalEntity> getClaimApproval() {
		return addNewUserService.getClaimApproval();
	}

	// ADMIN FILTER USERS
	@GetMapping("/adminFilter")
	public List<UsersEntity> AdminFilterUsers(@RequestParam int pageNo, @RequestParam int count,
			@RequestParam String type, @RequestParam String value) {
		return addNewUserService.AdminFilterUsers(pageNo, count, type, value);
	}

	// GET ALL USERS WITH MULTIPLE
	@GetMapping("/entities")
	public MultipleUsersListEntity getAllEntities() {
		return addNewUserService.getAllEntities();
	}

	@GetMapping("/getUsers")
	public MultipleUsersListEntity getUsers() {
		MultipleUsersListEntity dto = new MultipleUsersListEntity();
		dto.setClient(addNewUserService.getClient());
		dto.setUnder(addNewUserService.getUnderwriter());
		dto.setInter(addNewUserService.getIntermediary());
		dto.setAgent(addNewUserService.getAgent());
		dto.setBroker(addNewUserService.getBroker());
		dto.setBrv(addNewUserService.getBrv());
		dto.setClaim(addNewUserService.getClaimApproval());
		System.out.println(dto);
		return dto;
	}

	// CREATE USERS ONLY
	@PostMapping("/createUsers")
	public UsersEntity createUsers(@RequestBody UsersEntity users) {
		return addNewUserService.createUsers(users);
	}

	@PostMapping("/editUsers")
	public UsersEntity editUsers(@RequestBody UsersEntity editUsers, @RequestParam int id) throws Exception {
		return addNewUserService.editUsers(editUsers, id);
	}

	@DeleteMapping("deleteUsers/{id}")
	public UsersEntity deleteUsers(@PathVariable int id) {
		return addNewUserService.deleteUsers(id);
	}

	@PutMapping("/persons/{id}/activate")
	public ResponseEntity<String> activatePerson(@PathVariable("id") int id) {
		UsersEntity person = usersRepo.findById(id).orElse(null);
		if (person == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
		}
		person.setActive(true);
		usersRepo.save(person);
		return ResponseEntity.ok("Person activated successfully");
	}

	@PutMapping("/persons/{id}/deactivate")
	public ResponseEntity<String> deactivatePerson(@PathVariable("id") int id) {
		UsersEntity person = usersRepo.findById(id).orElse(null);
		if (person == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
		}
		person.setActive(false);
		usersRepo.save(person);
		return ResponseEntity.ok("Person deactivated successfully");
	}

	// CREATE ALL USERS AND TOO MAPPING FUNCTION
	@PostMapping("/createClientAndUser")
	public ClientEntity createClientAndUser(@RequestBody ClientEntity client) {
		return addNewUserService.createClientAndUser(client);
	}

	@PostMapping("/createUnderwriterAndUser")
	public UnderwriterEntity createUnderwriterAndUser(@RequestBody UnderwriterEntity under) {
		return addNewUserService.createUnderwriterAndUser(under);
	}

	@PostMapping("/createIntermediaryAndUser")
	public IntermediaryEntity createIntermediaryAndUser(@RequestBody IntermediaryEntity inter) {
		return addNewUserService.createIntermediaryAndUser(inter);
	}

	@PostMapping("/createAgentAndUser")
	public AgentEntity createAgentAndUser(@RequestBody AgentEntity agent) {
		return addNewUserService.createAgentAndUser(agent);
	}

	@PostMapping("/createBrokerAndUser")
	public BrokerEntity createBrokerAndUser(@RequestBody BrokerEntity broker) {
		return addNewUserService.createBrokerAndUser(broker);
	}

	@PostMapping("/createBRVAndUser")
	public BRVEntity createBRVAndUser(@RequestBody BRVEntity brv) {
		return addNewUserService.createBRVAndUser(brv);
	}

	@PostMapping("/createClaimAndUser")
	public ClaimApprovalEntity createClaimAndUser(@RequestBody ClaimApprovalEntity claim) {
		return addNewUserService.createClaimApprovalAndUser(claim);
	}

	// EDIT ALL USERS AND TOO MAPPING FUNCTION
	@PutMapping("/editClientAndUser")
	public ClientEntity editClientAndUser(@RequestBody ClientEntity editClient, @RequestParam String localTime)
			throws Exception {
		return addNewUserService.editClientAndUser(editClient, localTime);
	}

	@PutMapping("/editUnderwriterAndUser")
	public UnderwriterEntity editUnderwriterAndUser(@RequestBody UnderwriterEntity editUnder,
			@RequestParam String localTime) throws Exception {
		return addNewUserService.editUnderwriterAndUser(editUnder, localTime);
	}

	@PutMapping("/editIntermediaryAndUser")
	public IntermediaryEntity editIntermediaryAndUser(@RequestBody IntermediaryEntity editIntermediary,
			@RequestParam String localTime) throws Exception {
		return addNewUserService.editIntermediaryAndUser(editIntermediary, localTime);
	}

	@PutMapping("/editAgentAndUser")
	public AgentEntity editAgentAndUser(@RequestBody AgentEntity editAgent, @RequestParam String localTime)
			throws Exception {
		return addNewUserService.editAgentAndUser(editAgent, localTime);
	}

	@PutMapping("/editBrokerAndUser")
	public BrokerEntity editBrokerAndUser(@RequestBody BrokerEntity editBroker, @RequestParam String localTime)
			throws Exception {
		return addNewUserService.editBrokerAndUser(editBroker, localTime);
	}

	@PutMapping("/editBRVAndUser")
	public BRVEntity editBRVAndUser(@RequestBody BRVEntity editBrv, @RequestParam String localTime) throws Exception {
		return addNewUserService.editBRVAndUser(editBrv, localTime);
	}

	@PutMapping("/editClaimAndUser")
	public ClaimApprovalEntity editClaimAndUser(@RequestBody ClaimApprovalEntity editClaim,
			@RequestParam String localTime) throws Exception {
		return addNewUserService.editClaimAndUser(editClaim, localTime);
	}

}
