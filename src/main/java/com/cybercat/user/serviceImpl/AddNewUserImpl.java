package com.cybercat.user.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.cybercat.user.entity.AddNewUserTrigger;
import com.cybercat.user.repository.AddNewUserTriggerRepo;
import com.cybercat.user.repository.AgentRepo;
import com.cybercat.user.repository.BRVRepo;
import com.cybercat.user.repository.BrokerRepo;
import com.cybercat.user.repository.ClaimApprovalRepo;
import com.cybercat.user.repository.ClientRepo;
import com.cybercat.user.repository.HippaQuestionRepository;
import com.cybercat.user.repository.HippaResponseRepo;
import com.cybercat.user.repository.IndustryQuestionRepository;
import com.cybercat.user.repository.IndustryResponseRepo;
import com.cybercat.user.repository.TechnicalResponseRepo;
import com.cybercat.user.repository.StrategicQuestionRepository;
import com.cybercat.user.repository.StrategicResponseRepo;
import com.cybercat.user.repository.IntermediaryRepo;
import com.cybercat.user.repository.MultipleUsersListRepo;
import com.cybercat.user.repository.TechnicalQuestionRepo;
import com.cybercat.user.repository.TriggerRepo;
import com.cybercat.user.repository.UnderwriterRepo;
import com.cybercat.user.repository.UsersRepo;
import com.cybercat.user.service.AddNewUserService;
import com.cybercat.user.entity.AgentEntity;
import com.cybercat.user.entity.BRVEntity;
import com.cybercat.user.entity.BrokerEntity;
import com.cybercat.user.entity.ClaimApprovalEntity;
import com.cybercat.user.entity.ClientEntity;
import com.cybercat.user.entity.HippaQuestionEntity;
import com.cybercat.user.entity.HippaQuestionResponseEntity;
import com.cybercat.user.entity.HippaResponseEntity;
import com.cybercat.user.entity.IndustryQuestionEntity;
import com.cybercat.user.entity.IndustryQuestionResponseEntity;
import com.cybercat.user.entity.IndustryResponseEntity;
import com.cybercat.user.entity.TechnicalResponseEntity;
import com.cybercat.user.entity.StrategicQuestionEntity;
import com.cybercat.user.entity.StrategicQuestionResponseEntity;
import com.cybercat.user.entity.StrategicResponseEntity;
import com.cybercat.user.entity.IntermediaryEntity;
import com.cybercat.user.entity.MultipleUsersListEntity;
import com.cybercat.user.entity.TechnicalQuestionEntity;
import com.cybercat.user.entity.TechnicalQuestionResponseEntity;
import com.cybercat.user.entity.UnderwriterEntity;
import com.cybercat.user.entity.UsersEntity;

@Service
public class AddNewUserImpl implements AddNewUserService {

	@Autowired
	ClientRepo clientRepo;

	@Autowired
	UnderwriterRepo underwriterRepo;

	@Autowired
	IntermediaryRepo intermediaryRepo;

	@Autowired
	AgentRepo agentRepo;

	@Autowired
	BrokerRepo brokerRepo;

	@Autowired
	BRVRepo bRVRepo;

	@Autowired
	ClaimApprovalRepo claimApprovalRepo;

	@Autowired
	UsersRepo usersRepo;

	@Autowired
	MultipleUsersListRepo multipleRepo;

	@Autowired
	AddNewUserTriggerRepo addNewUserRepo;

	@Autowired
	TriggerRepo triggerRepo;

	@Autowired
	TechnicalResponseRepo technicalResponseRepo;

	@Autowired
	TechnicalQuestionRepo technicalQuestionRepo;

	@Autowired
	StrategicResponseRepo strategicResponseRepo;

	@Autowired
	StrategicQuestionRepository strategicQuestionRepository;

	@Autowired
	IndustryResponseRepo industryResponseRepo;

	@Autowired
	IndustryQuestionRepository industryQuestionRepository;

	@Autowired
	HippaResponseRepo hippaResponseRepo;

	@Autowired
	HippaQuestionRepository hippaQuestionRepository;

//	List<StrategicQuestionEntity> gen = strategicQuestionRepository.findAll();
//	StrategicResponseEntity gen2 = new StrategicResponseEntity();
//	gen2.setId(clientID);
//	gen2.setResponse(gen);
//	strategicResponseRepo.save(gen2);

	public boolean generateClient(int clientID) {
		ClientEntity cl = clientRepo.findById(clientID).get();
		int techCount = 0;
		int strCount = 0;
		int indCount = 0;
		int hippaCount = 0;

		List<TechnicalQuestionEntity> techQues = technicalQuestionRepo.findAll();
		TechnicalResponseEntity techRes = new TechnicalResponseEntity();
		techRes.setId(clientID);
		ArrayList<TechnicalQuestionResponseEntity> techQuesRes = new ArrayList<TechnicalQuestionResponseEntity>();
		for (TechnicalQuestionEntity q : techQues) {
			TechnicalQuestionResponseEntity r = new TechnicalQuestionResponseEntity();
			if (cl.getClientQuestionnaireType().equals("Cybercat-PRO")) {
				r.setIndex(techCount);
				r.setId(q.getId());
				r.setOptions(q.getOptions());
				r.setQuestion(q.getQuestion());
				r.setHead(q.getHead());
				r.setTechnical(q.getTechnical());
				r.setType(q.getType());
				r.setTeam(q.getTeam());
				r.setSection(q.getSection());
				r.setQuestionType(q.getQuestionType());
				r.setAddedNotes(q.isAddedNotes());
				r.setAnswer("");
				r.setScore(0);
				techQuesRes.add(r);
				techCount++;
			} else {
				System.out.println("CHECKING");
			}
		}
		techRes.setTechResponses(techQuesRes);
		technicalResponseRepo.save(techRes);

		List<StrategicQuestionEntity> strQues = strategicQuestionRepository.findAll();
		StrategicResponseEntity strRes = new StrategicResponseEntity();
		strRes.setId(clientID);
		ArrayList<StrategicQuestionResponseEntity> strQuesRes = new ArrayList<StrategicQuestionResponseEntity>();
		for (StrategicQuestionEntity q1 : strQues) {
			StrategicQuestionResponseEntity r1 = new StrategicQuestionResponseEntity();
			r1.setIndex(strCount);
			r1.setId(q1.getId());
			r1.setOptions(q1.getOptions());
			r1.setQuestion(q1.getQuestion());
			r1.setHead(q1.getHead());
			r1.setStrategic(q1.getStrategic());
			r1.setType(q1.getType());
			r1.setTeam(q1.getTeam());
			r1.setSection(q1.getSection());
			r1.setQuestionType(q1.getQuestionType());
			r1.setAddedNotes(q1.isAddedNotes());
			r1.setAnswer("");
			r1.setScore(0);
			strQuesRes.add(r1);
			strCount++;
		}
		strRes.setStrResponses(strQuesRes);
		strategicResponseRepo.save(strRes);

		List<IndustryQuestionEntity> indQues = industryQuestionRepository.findAll();
		IndustryResponseEntity indRes = new IndustryResponseEntity();
		indRes.setId(clientID);
		ArrayList<IndustryQuestionResponseEntity> indQuesRes = new ArrayList<IndustryQuestionResponseEntity>();

		for (IndustryQuestionEntity q2 : indQues) {
			IndustryQuestionResponseEntity r2 = new IndustryQuestionResponseEntity();
			//bfsi
			if ((cl.getSector().equals("PUBLIC SECTOR BANKS") && q2.getSection().equals("PUBLIC SECTOR BANKS")) ||
				    (cl.getSector().equals("PRIVATE BANKS") && q2.getSection().equals("PRIVATE BANKS")) ||
				    (cl.getSector().equals("HOUSING FINANCE") && q2.getSection().equals("HOUSING FINANCE")) ||
				    (cl.getSector().equals("SMALL FINANCE BANKS") && q2.getSection().equals("SMALL FINANCE BANKS")) ||
				    (cl.getSector().equals("MICRO FINANCE") && q2.getSection().equals("MICRO FINANCE")) ||
				    (cl.getSector().equals("INSURANCE COMPANIES") && q2.getSection().equals("INSURANCE COMPANIES")) ||
				      
				    //technology
				    (cl.getSector().equals("TECHNOLOGY") && q2.getSection().equals("TECHNOLOGY")) ||	
				    (cl.getSector().equals("GAMING & ENTERTAINEMNT ONLINE") && q2.getSection().equals("GAMING & ENTERTAINMENT ONLINE")) ||	
				    (cl.getSector().equals("TELECOM & COMMUNICATION") && q2.getSection().equals("TELECOM & COMMUNICATION")) ||	
				    (cl.getSector().equals("EDUCATION ONLINE SERVICE") && q2.getSection().equals("EDUCATION-ONLINE SERVICES")) ||
				    
				    //pharma
				    (cl.getSector().equals("PHARMA & HEALTH CARE") && q2.getSection().equals("PHARMA & HEALTH CARE")) ||
				    
				    //manufacturing
				    (cl.getSector().equals("MANUFACTURING") && q2.getSection().equals("MANUFACTURING")) ||
				    
				    //oil & gas				    
				    (cl.getSector().equals("OIL & GAS, REFINING") && q2.getSection().equals("OIL & GAS, REFINING")) ||
				    
				    //others
				    (cl.getSector().equals("OTHERS") && q2.getSection().equals("OTHERS")) ||
				    (cl.getSector().equals("TRANSPORT - AVIATION") && q2.getSection().equals("TRANSPORT-AVIATION"))) {
				    r2.setIndex(indCount);
				    r2.setId(q2.getId());
				    r2.setOptions(q2.getOptions());
				    r2.setQuestion(q2.getQuestion());
				    r2.setHead(q2.getHead());
				    r2.setType(q2.getType());
				    r2.setTeam(q2.getTeam());
				    r2.setSection(q2.getSection());
				    r2.setAddedNotes(q2.isAddedNotes());
				    r2.setAnswer("");
				    r2.setScore(0);
				    indQuesRes.add(r2);
				    indCount++;
				}
		}
		indRes.setIndResponses(indQuesRes);
		industryResponseRepo.save(indRes);

		List<HippaQuestionEntity> hippaQues = hippaQuestionRepository.findAll();
		HippaResponseEntity hippaRes = new HippaResponseEntity();
		hippaRes.setId(clientID);
		ArrayList<HippaQuestionResponseEntity> hippaQuesRes = new ArrayList<HippaQuestionResponseEntity>();
		for (HippaQuestionEntity q3 : hippaQues) {
		   if(cl.getSector().equals("PHARMA & HEALTH CARE") && cl.isHipaaAssessment()){
			HippaQuestionResponseEntity r3 = new HippaQuestionResponseEntity();
			r3.setIndex(hippaCount);
			r3.setId(q3.getId());
			r3.setQuestion(q3.getQuestion());
			r3.setHead(q3.getHead());
			r3.setType(q3.getType());
			r3.setAddedNotes(q3.isAddedNotes());
			r3.setAnswer("");
			r3.setScore(0);
			hippaQuesRes.add(r3);
			hippaCount++;
		   }
		}
		hippaRes.setHippaResponses(hippaQuesRes);
		hippaResponseRepo.save(hippaRes);

		return true;
	}

	// CREATE ALL USERS
	public ClientEntity createClient(ClientEntity client) {
		AddNewUserTrigger trigger = addNewUserRepo.findByName("client");
		client.setId(trigger.getCount() + 1);
		client.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		client.setCreatedTime(formattedTime);
		clientRepo.save(client);
		trigger.setCount(trigger.getCount() + 1);
		addNewUserRepo.save(trigger);
		return client;
	}

	public UnderwriterEntity createUnderwriter(UnderwriterEntity under) {
		AddNewUserTrigger trigger = addNewUserRepo.findByName("underwriter");
		under.setId(trigger.getCount() + 1);
		under.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		under.setCreatedTime(formattedTime);
		underwriterRepo.save(under);
		trigger.setCount(trigger.getCount() + 1);
		addNewUserRepo.save(trigger);
		return under;
	}

	public IntermediaryEntity createIntermediary(IntermediaryEntity inter) {
		AddNewUserTrigger trigger = addNewUserRepo.findByName("intermediary");
		inter.setId(trigger.getCount() + 1);
		inter.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		inter.setCreatedTime(formattedTime);
		intermediaryRepo.save(inter);
		trigger.setCount(trigger.getCount() + 1);
		addNewUserRepo.save(trigger);
		return inter;
	}

	public AgentEntity createAgent(AgentEntity agent) {
		AddNewUserTrigger trigger = addNewUserRepo.findByName("agent");
		agent.setId(trigger.getCount() + 1);
		agent.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		agent.setCreatedTime(formattedTime);
		agentRepo.save(agent);
		trigger.setCount(trigger.getCount() + 1);
		addNewUserRepo.save(trigger);
		return agent;
	}

	public BrokerEntity createBroker(BrokerEntity broker) {
		AddNewUserTrigger trigger = addNewUserRepo.findByName("broker");
		broker.setId(trigger.getCount() + 1);
		broker.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		broker.setCreatedTime(formattedTime);
		brokerRepo.save(broker);
		trigger.setCount(trigger.getCount() + 1);
		addNewUserRepo.save(trigger);
		return broker;
	}

	public BRVEntity createBrv(BRVEntity brv) {
		AddNewUserTrigger trigger = addNewUserRepo.findByName("brv");
		brv.setId(trigger.getCount() + 1);
		brv.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		brv.setCreatedTime(formattedTime);
		bRVRepo.save(brv);
		trigger.setCount(trigger.getCount() + 1);
		addNewUserRepo.save(trigger);
		return brv;
	}

	public ClaimApprovalEntity createClaimApproval(ClaimApprovalEntity claim) {
		AddNewUserTrigger trigger = addNewUserRepo.findByName("claimApproval");
		claim.setId(trigger.getCount() + 1);
		claim.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		claim.setCreatedTime(formattedTime);
		claimApprovalRepo.save(claim);
		trigger.setCount(trigger.getCount() + 1);
		addNewUserRepo.save(trigger);
		return claim;
	}

	// GET ALL USERS
	public List<ClientEntity> getClient() {
		return clientRepo.findAll();
	}

	public List<UnderwriterEntity> getUnderwriter() {
		return underwriterRepo.findAll();
	}

	public List<IntermediaryEntity> getIntermediary() {
		return intermediaryRepo.findAll();
	}

	public List<AgentEntity> getAgent() {
		return agentRepo.findAll();
	}

	public List<BrokerEntity> getBroker() {
		return brokerRepo.findAll();
	}

	public List<BRVEntity> getBrv() {
		return bRVRepo.findAll();
	}

	public List<ClaimApprovalEntity> getClaimApproval() {
		return claimApprovalRepo.findAll();
	}

	// ADMIN FILTER USERS
	public List<UsersEntity> AdminFilterUsers(int pageNo, int count, String type, String value) {
		Pageable pageable = PageRequest.of(pageNo, count);
		if (type.equals("userType")) {
			return usersRepo.findByUserTypeIsLikeIgnoreCase(value, pageable);
		} else {
			System.out.println("MultipleUsersListEntity");
		}
		return usersRepo.findByUserTypeIsLikeIgnoreCase(value, pageable);
	}

	// GET ALL USERS WITH MULTIPLE
	public MultipleUsersListEntity getAllEntities() {
		List<ClientEntity> clients = clientRepo.findAll();
		List<UnderwriterEntity> underwriters = underwriterRepo.findAll();
		List<IntermediaryEntity> inter = intermediaryRepo.findAll();
		List<AgentEntity> agent = agentRepo.findAll();
		List<BrokerEntity> broker = brokerRepo.findAll();
		List<BRVEntity> brv = bRVRepo.findAll();
		List<ClaimApprovalEntity> claim = claimApprovalRepo.findAll();

		MultipleUsersListEntity entity = new MultipleUsersListEntity();
		entity.setClient(clients);
		entity.setUnder(underwriters);
		entity.setInter(inter);
		entity.setAgent(agent);
		entity.setBroker(broker);
		entity.setBrv(brv);
		entity.setClaim(claim);
		return entity;
	}

	// EDIT ALL USERS
	public ClientEntity editClient(ClientEntity editClient, int id) throws Exception {
		ClientEntity client1 = clientRepo.findById(id).get();
		client1.setUserType(editClient.getUserType());
		client1.setFirstName(editClient.getFirstName());
		client1.setLastName(editClient.getLastName());
		client1.setEmailID(editClient.getEmailID());
		client1.setMobileNo(editClient.getMobileNo());
		client1.setClientComp(editClient.getClientComp());
		client1.setDesignation(editClient.getDesignation());
		client1.setInsComp(editClient.getInsComp());
		client1.setLinkExpiryDate(editClient.getLinkExpiryDate());
		client1.setClientQuestionnaireType(editClient.getClientQuestionnaireType());
//		client1.setPremiumCyberAssessment(editClient.isPremiumCyberAssessment());
//		client1.setAdvancedCyberAssessment(editClient.isAdvancedCyberAssessment());
//		client1.setBasicCyberTechnical(editClient.isBasicCyberTechnical());
//		client1.setAddedAdvanceTechnicalAssessment(editClient.isAddedAdvanceTechnicalAssessment());
		client1.setIndustry(editClient.getIndustry());
		client1.setSector(editClient.getSector());
		client1.setSubIndustry(editClient.getSubIndustry());
		client1.setDivision(editClient.getDivision());
		client1.setGroup(editClient.getGroup());
		client1.setOptionText(editClient.getOptionText());
		client1.setRiskLevel(editClient.getRiskLevel());
//		client1.setSendIndustryAssessment(editClient.isSendIndustryAssessment());
		client1.setHipaaAssessment(editClient.isHipaaAssessment());
		client1.setCreatedDate(editClient.getCreatedDate());
		client1.setCreatedTime(editClient.getCreatedTime());
		client1.setModifiedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		client1.setModifiedTime(formattedTime);
		return clientRepo.save(client1);
	}

	public UnderwriterEntity editUnder(UnderwriterEntity editUnder, int id) {
		UnderwriterEntity under1 = underwriterRepo.findById(id).get();
		under1.setUserType(editUnder.getUserType());
		under1.setFirstName(editUnder.getFirstName());
		under1.setLastName(editUnder.getLastName());
		under1.setEmailID(editUnder.getEmailID());
		under1.setMobileNo(editUnder.getMobileNo());
		under1.setInsComp(editUnder.getInsComp());
		under1.setUnderwriterAccess(editUnder.getUnderwriterAccess());
		under1.setCreatedDate(editUnder.getCreatedDate());
		under1.setCreatedTime(editUnder.getCreatedTime());
		under1.setModifiedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		under1.setModifiedTime(formattedTime);
		return underwriterRepo.save(under1);
	}

	public IntermediaryEntity editInter(IntermediaryEntity editInter, int id) {
		IntermediaryEntity inter1 = intermediaryRepo.findById(id).get();
		inter1.setUserType(editInter.getUserType());
		inter1.setFirstName(editInter.getFirstName());
		inter1.setLastName(editInter.getLastName());
		inter1.setEmailID(editInter.getEmailID());
		inter1.setMobileNo(editInter.getMobileNo());
		inter1.setInsComp(editInter.getInsComp());
		inter1.setLevel(editInter.getLevel());
		inter1.setCreatedDate(editInter.getCreatedDate());
		inter1.setCreatedTime(editInter.getCreatedTime());
		inter1.setModifiedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		inter1.setModifiedTime(formattedTime);
		return intermediaryRepo.save(inter1);
	}

	public AgentEntity editAgent(AgentEntity editAgent, int id) {
		AgentEntity agent1 = agentRepo.findById(id).get();
		agent1.setUserType(editAgent.getUserType());
		agent1.setFirstName(editAgent.getFirstName());
		agent1.setLastName(editAgent.getLastName());
		agent1.setEmailID(editAgent.getEmailID());
		agent1.setMobileNo(editAgent.getMobileNo());
		agent1.setInsComp(editAgent.getInsComp());
		agent1.setAgentAccess(editAgent.getAgentAccess());
		agent1.setCreatedDate(editAgent.getCreatedDate());
		agent1.setCreatedTime(editAgent.getCreatedTime());
		agent1.setModifiedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		agent1.setModifiedTime(formattedTime);
		return agentRepo.save(agent1);
	}

	public BrokerEntity editBroker(BrokerEntity editBroker, int id) {
		BrokerEntity broker1 = brokerRepo.findById(id).get();
		broker1.setUserType(editBroker.getUserType());
		broker1.setFirstName(editBroker.getFirstName());
		broker1.setLastName(editBroker.getLastName());
		broker1.setEmailID(editBroker.getEmailID());
		broker1.setMobileNo(editBroker.getMobileNo());
		broker1.setInsComp(editBroker.getInsComp());
		broker1.setBrokerAccess(editBroker.getBrokerAccess());
		broker1.setCreatedDate(editBroker.getCreatedDate());
		broker1.setCreatedTime(editBroker.getCreatedTime());
		broker1.setModifiedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		broker1.setModifiedTime(formattedTime);
		return brokerRepo.save(broker1);

	}

	public BRVEntity editBrv(BRVEntity editBrv, int id) {
		BRVEntity brv1 = bRVRepo.findById(id).get();
		brv1.setUserType(editBrv.getUserType());
		brv1.setFirstName(editBrv.getFirstName());
		brv1.setLastName(editBrv.getLastName());
		brv1.setEmailID(editBrv.getEmailID());
		brv1.setMobileNo(editBrv.getMobileNo());
		brv1.setInsComp(editBrv.getInsComp());
		brv1.setBrvAccess(editBrv.getBrvAccess());
		brv1.setCreatedDate(editBrv.getCreatedDate());
		brv1.setCreatedTime(editBrv.getCreatedTime());
		brv1.setModifiedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		brv1.setModifiedTime(formattedTime);
		return bRVRepo.save(brv1);
	}

	public ClaimApprovalEntity editClaimApproval(ClaimApprovalEntity editClaimApproval, int id) {
		ClaimApprovalEntity claim1 = claimApprovalRepo.findById(id).get();
		claim1.setUserType(editClaimApproval.getUserType());
		claim1.setFirstName(editClaimApproval.getFirstName());
		claim1.setLastName(editClaimApproval.getLastName());
		claim1.setEmailID(editClaimApproval.getEmailID());
		claim1.setMobileNo(editClaimApproval.getMobileNo());
		claim1.setCreatedDate(editClaimApproval.getCreatedDate());
		claim1.setCreatedTime(editClaimApproval.getCreatedTime());
		claim1.setModifiedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		claim1.setModifiedTime(formattedTime);
		return claimApprovalRepo.save(claim1);
	}

	// CREATE USERS ONLY
	public UsersEntity createUsers(UsersEntity users) {
		AddNewUserTrigger trigger = addNewUserRepo.findByName("users");
		users.setId(trigger.getCount() + 1);
		users.setCreatedDate(LocalDate.now().toString());
		usersRepo.save(users);
		trigger.setCount(trigger.getCount() + 1);
		addNewUserRepo.save(trigger);
		return users;
	}

	public UsersEntity editUsers(UsersEntity users, int id) throws Exception {
		UsersEntity users1 = usersRepo.findById(id).get();
		users1.setUserType(users.getUserType());
		users1.setFirstName(users.getFirstName());
		users1.setLastName(users.getLastName());
		users1.setEmailID(users.getEmailID());
		users1.setMobileNo(users.getMobileNo());
		users1.setModifiedDate(LocalDate.now().toString());
		return usersRepo.save(users1);
	}

	public UsersEntity deleteUsers(int id) {
		UsersEntity deletedUsers = usersRepo.findById(id).orElse(null);
		if (deletedUsers != null) {
			AddNewUserTrigger trigger = addNewUserRepo.findByName("users");
			if (trigger != null) {
				trigger.setCount(trigger.getCount() - 1);
				addNewUserRepo.save(trigger);
			}
			usersRepo.deleteById(id);
		}
		return deletedUsers;
	}

	// ADDING TWO TYPES OF USERS
	public ClientEntity createClientAndUser(ClientEntity client) {
		// Handle ClaimApprovalEntity
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("client");
		client.setId(claimTrigger.getCount() + 1);
		client.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		client.setCreatedTime(formattedTime);
		clientRepo.save(client);
		claimTrigger.setCount(claimTrigger.getCount() + 1);
		addNewUserRepo.save(claimTrigger);

		// Handle UsersEntity
		AddNewUserTrigger userTrigger = addNewUserRepo.findByName("users");
		UsersEntity users = new UsersEntity();
		users.setId(userTrigger.getCount() + 1);
		users.setUserType(client.getUserType());
		users.setFirstName(client.getFirstName());
		users.setLastName(client.getLastName());
		users.setEmailID(client.getEmailID());
		users.setMobileNo(client.getMobileNo());
		users.setClientComp(client.getClientComp());
		users.setDesignation(client.getDesignation());
		users.setInsComp(client.getInsComp());
		users.setLinkExpiryDate(client.getLinkExpiryDate());
		users.setClientQuestionnaireType(client.getClientQuestionnaireType());
//		users.setPremiumCyberAssessment(client.isPremiumCyberAssessment());
//		users.setAdvancedCyberAssessment(client.isAdvancedCyberAssessment());
//		users.setBasicCyberTechnical(client.isBasicCyberTechnical());
//		users.setAddedAdvanceTechnicalAssessment(client.isAddedAdvanceTechnicalAssessment());
		users.setIndustry(client.getIndustry());
		users.setSector(client.getSector());
		users.setSubIndustry(client.getSubIndustry());
		users.setDivision(client.getDivision());
		users.setGroup(client.getGroup());
		users.setOptionText(client.getOptionText());
		users.setRiskLevel(client.getRiskLevel());
//		users.setSendIndustryAssessment(client.isSendIndustryAssessment());
		users.setHipaaAssessment(client.isHipaaAssessment());
		users.setCreatedDate(client.getCreatedDate());
		users.setCreatedTime(client.getCreatedTime());
		usersRepo.save(users);
		userTrigger.setCount(userTrigger.getCount() + 1);
		addNewUserRepo.save(userTrigger);
		return client;
	}

	public ClientEntity editClientAndUser(ClientEntity client, String localTime) throws Exception {
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("client");
		client.setId(claimTrigger.getCount());
		ClientEntity client1 = clientRepo.findByCreatedTime(localTime);
		UsersEntity users = usersRepo.findByCreatedTime(localTime);
		client1.setId(client.getId());
		client1.setUserType(client.getUserType());
		client1.setFirstName(client.getFirstName());
		client1.setLastName(client.getLastName());
		client1.setEmailID(client.getEmailID());
		client1.setMobileNo(client.getMobileNo());
		client1.setClientComp(client.getClientComp());
		client1.setDesignation(client.getDesignation());
		client1.setInsComp(client.getInsComp());
		client1.setLinkExpiryDate(client.getLinkExpiryDate());
		client1.setClientQuestionnaireType(client.getClientQuestionnaireType());
//		client1.setPremiumCyberAssessment(client.isPremiumCyberAssessment());
//		client1.setAdvancedCyberAssessment(client.isAdvancedCyberAssessment());
//		client1.setBasicCyberTechnical(client.isBasicCyberTechnical());
//		client1.setAddedAdvanceTechnicalAssessment(client.isAddedAdvanceTechnicalAssessment());
		client1.setIndustry(client.getIndustry());
		client1.setSector(client.getSector());
		client1.setSubIndustry(client.getSubIndustry());
		client1.setDivision(client.getDivision());
		client1.setGroup(client.getGroup());
		client1.setOptionText(client.getOptionText());
		client1.setRiskLevel(client.getRiskLevel());
//		client1.setSendIndustryAssessment(client.isSendIndustryAssessment());
		client1.setHipaaAssessment(client.isHipaaAssessment());
		client1.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		client1.setCreatedTime(formattedTime);
		clientRepo.save(client1);

		users.setUserType(client1.getUserType());
		users.setFirstName(client1.getFirstName());
		users.setLastName(client1.getLastName());
		users.setEmailID(client1.getEmailID());
		users.setMobileNo(client1.getMobileNo());
		users.setClientComp(client1.getClientComp());
		users.setDesignation(client1.getDesignation());
		users.setInsComp(client1.getInsComp());
		users.setLinkExpiryDate(client1.getLinkExpiryDate());
		users.setClientQuestionnaireType(client1.getClientQuestionnaireType());
//		users.setPremiumCyberAssessment(client1.isPremiumCyberAssessment());
//		users.setAdvancedCyberAssessment(client1.isAdvancedCyberAssessment());
//		users.setBasicCyberTechnical(client1.isBasicCyberTechnical());
//		users.setAddedAdvanceTechnicalAssessment(client1.isAddedAdvanceTechnicalAssessment());
		users.setIndustry(client1.getIndustry());
		users.setSector(client1.getSector());
		users.setSubIndustry(client1.getSubIndustry());
		users.setDivision(client1.getDivision());
		users.setGroup(client1.getGroup());
		users.setOptionText(client1.getOptionText());
		users.setRiskLevel(client1.getRiskLevel());
//		users.setSendIndustryAssessment(client1.isSendIndustryAssessment());
		users.setHipaaAssessment(client1.isHipaaAssessment());
		users.setCreatedDate(client1.getCreatedDate());
		users.setCreatedTime(client1.getCreatedTime());
		usersRepo.save(users);
		return client;
	}

	public UnderwriterEntity createUnderwriterAndUser(UnderwriterEntity under) {
		// Handle ClaimApprovalEntity
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("underwriter");
		under.setId(claimTrigger.getCount() + 1);
		under.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		under.setCreatedTime(formattedTime);
		underwriterRepo.save(under);
		claimTrigger.setCount(claimTrigger.getCount() + 1);
		addNewUserRepo.save(claimTrigger);

		// Handle UsersEntity
		AddNewUserTrigger userTrigger = addNewUserRepo.findByName("users");
		UsersEntity underUser = new UsersEntity();
		underUser.setId(userTrigger.getCount() + 1);
		underUser.setUserType(under.getUserType());
		underUser.setFirstName(under.getFirstName());
		underUser.setLastName(under.getLastName());
		underUser.setEmailID(under.getEmailID());
		underUser.setMobileNo(under.getMobileNo());
		underUser.setUnderwriterAccess(under.getUnderwriterAccess());
		underUser.setCreatedDate(under.getCreatedDate());
		underUser.setCreatedTime(under.getCreatedTime());
		usersRepo.save(underUser);
		userTrigger.setCount(userTrigger.getCount() + 1);
		addNewUserRepo.save(userTrigger);
		return under;
	}

	public UnderwriterEntity editUnderwriterAndUser(UnderwriterEntity editUnder, String localTime) throws Exception {
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("underwriter");
		editUnder.setId(claimTrigger.getCount());
		UnderwriterEntity under1 = underwriterRepo.findByCreatedTime(localTime);
		UsersEntity users = usersRepo.findByCreatedTime(localTime);
		under1.setId(editUnder.getId());
		under1.setUserType(editUnder.getUserType());
		under1.setFirstName(editUnder.getFirstName());
		under1.setLastName(editUnder.getLastName());
		under1.setEmailID(editUnder.getEmailID());
		under1.setMobileNo(editUnder.getMobileNo());
		under1.setInsComp(editUnder.getInsComp());
		under1.setUnderwriterAccess(editUnder.getUnderwriterAccess());
		under1.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		under1.setCreatedTime(formattedTime);
		underwriterRepo.save(under1);

		users.setUserType(under1.getUserType());
		users.setFirstName(under1.getFirstName());
		users.setLastName(under1.getLastName());
		users.setEmailID(under1.getEmailID());
		users.setMobileNo(under1.getMobileNo());
		users.setInsComp(under1.getInsComp());
		users.setUnderwriterAccess(under1.getUnderwriterAccess());
		users.setCreatedDate(under1.getCreatedDate());
		users.setCreatedTime(under1.getCreatedTime());
		usersRepo.save(users);
		return editUnder;
	}

	public IntermediaryEntity createIntermediaryAndUser(IntermediaryEntity inter) {
		// Handle ClaimApprovalEntity
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("intermediary");
		inter.setId(claimTrigger.getCount() + 1);
		inter.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		inter.setCreatedTime(formattedTime);
		intermediaryRepo.save(inter);
		claimTrigger.setCount(claimTrigger.getCount() + 1);
		addNewUserRepo.save(claimTrigger);

		// Handle UsersEntity
		AddNewUserTrigger userTrigger = addNewUserRepo.findByName("users");
		UsersEntity interUser = new UsersEntity();
		interUser.setId(userTrigger.getCount() + 1);
		interUser.setUserType(inter.getUserType());
		interUser.setFirstName(inter.getFirstName());
		interUser.setLastName(inter.getLastName());
		interUser.setEmailID(inter.getEmailID());
		interUser.setMobileNo(inter.getMobileNo());
		interUser.setInsComp(inter.getInsComp());
		interUser.setLevel(inter.getLevel());
		interUser.setCreatedDate(inter.getCreatedDate());
		interUser.setCreatedTime(inter.getCreatedTime());
		usersRepo.save(interUser);
		userTrigger.setCount(userTrigger.getCount() + 1);
		addNewUserRepo.save(userTrigger);
		return inter;
	}

	public IntermediaryEntity editIntermediaryAndUser(IntermediaryEntity editIntermediary, String localTime)
			throws Exception {
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("intermediary");
		editIntermediary.setId(claimTrigger.getCount());
		IntermediaryEntity under1 = intermediaryRepo.findByCreatedTime(localTime);
		UsersEntity users = usersRepo.findByCreatedTime(localTime);
		under1.setId(editIntermediary.getId());
		under1.setUserType(editIntermediary.getUserType());
		under1.setFirstName(editIntermediary.getFirstName());
		under1.setLastName(editIntermediary.getLastName());
		under1.setEmailID(editIntermediary.getEmailID());
		under1.setMobileNo(editIntermediary.getMobileNo());
		under1.setInsComp(editIntermediary.getInsComp());
		under1.setLevel(editIntermediary.getLevel());
		under1.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		under1.setCreatedTime(formattedTime);
		intermediaryRepo.save(under1);

		users.setUserType(under1.getUserType());
		users.setFirstName(under1.getFirstName());
		users.setLastName(under1.getLastName());
		users.setEmailID(under1.getEmailID());
		users.setMobileNo(under1.getMobileNo());
		users.setInsComp(under1.getInsComp());
		users.setLevel(under1.getLevel());
		users.setCreatedDate(under1.getCreatedDate());
		users.setCreatedTime(under1.getCreatedTime());
		usersRepo.save(users);
		return editIntermediary;
	}

	public AgentEntity createAgentAndUser(AgentEntity agent) {
		// Handle ClaimApprovalEntity
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("agent");
		agent.setId(claimTrigger.getCount() + 1);
		agent.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		agent.setCreatedTime(formattedTime);
		agentRepo.save(agent);
		claimTrigger.setCount(claimTrigger.getCount() + 1);
		addNewUserRepo.save(claimTrigger);

		// Handle UsersEntity
		AddNewUserTrigger userTrigger = addNewUserRepo.findByName("users");
		UsersEntity agentUser = new UsersEntity();
		agentUser.setId(userTrigger.getCount() + 1);
		agentUser.setUserType(agent.getUserType());
		agentUser.setFirstName(agent.getFirstName());
		agentUser.setLastName(agent.getLastName());
		agentUser.setEmailID(agent.getEmailID());
		agentUser.setMobileNo(agent.getMobileNo());
		agentUser.setInsComp(agent.getInsComp());
		agentUser.setAgentAccess(agent.getAgentAccess());
		agentUser.setCreatedDate(agent.getCreatedDate());
		agentUser.setCreatedTime(agent.getCreatedTime());
		usersRepo.save(agentUser);
		userTrigger.setCount(userTrigger.getCount() + 1);
		addNewUserRepo.save(userTrigger);
		return agent;
	}

	public AgentEntity editAgentAndUser(AgentEntity editAgent, String localTime) throws Exception {
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("agent");
		editAgent.setId(claimTrigger.getCount());
		AgentEntity inter1 = agentRepo.findByCreatedTime(localTime);
		UsersEntity users = usersRepo.findByCreatedTime(localTime);
		inter1.setId(editAgent.getId());
		inter1.setUserType(editAgent.getUserType());
		inter1.setFirstName(editAgent.getFirstName());
		inter1.setLastName(editAgent.getLastName());
		inter1.setEmailID(editAgent.getEmailID());
		inter1.setMobileNo(editAgent.getMobileNo());
		inter1.setInsComp(editAgent.getInsComp());
		inter1.setAgentAccess(editAgent.getAgentAccess());
		inter1.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		inter1.setCreatedTime(formattedTime);
		agentRepo.save(inter1);

		users.setUserType(inter1.getUserType());
		users.setFirstName(inter1.getFirstName());
		users.setLastName(inter1.getLastName());
		users.setEmailID(inter1.getEmailID());
		users.setMobileNo(inter1.getMobileNo());
		users.setInsComp(inter1.getInsComp());
		users.setAgentAccess(inter1.getAgentAccess());
		users.setCreatedDate(inter1.getCreatedDate());
		users.setCreatedTime(inter1.getCreatedTime());
		usersRepo.save(users);
		return editAgent;
	}

	public BrokerEntity createBrokerAndUser(BrokerEntity broker) {
		// Handle ClaimApprovalEntity
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("broker");
		broker.setId(claimTrigger.getCount() + 1);
		broker.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		broker.setCreatedTime(formattedTime);
		brokerRepo.save(broker);
		claimTrigger.setCount(claimTrigger.getCount() + 1);
		addNewUserRepo.save(claimTrigger);

		// Handle UsersEntity
		AddNewUserTrigger userTrigger = addNewUserRepo.findByName("users");
		UsersEntity brokerUser = new UsersEntity();
		brokerUser.setId(userTrigger.getCount() + 1);
		brokerUser.setUserType(broker.getUserType());
		brokerUser.setFirstName(broker.getFirstName());
		brokerUser.setLastName(broker.getLastName());
		brokerUser.setEmailID(broker.getEmailID());
		brokerUser.setMobileNo(broker.getMobileNo());
		brokerUser.setInsComp(broker.getInsComp());
		brokerUser.setBrokerAccess(broker.getBrokerAccess());
		brokerUser.setCreatedDate(broker.getCreatedDate());
		brokerUser.setCreatedTime(broker.getCreatedTime());
		usersRepo.save(brokerUser);
		userTrigger.setCount(userTrigger.getCount() + 1);
		addNewUserRepo.save(userTrigger);
		return broker;
	}

	public BrokerEntity editBrokerAndUser(BrokerEntity editBroker, String localTime) throws Exception {
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("broker");
		editBroker.setId(claimTrigger.getCount());
		BrokerEntity broker1 = brokerRepo.findByCreatedTime(localTime);
		UsersEntity users = usersRepo.findByCreatedTime(localTime);
		broker1.setId(editBroker.getId());
		broker1.setUserType(editBroker.getUserType());
		broker1.setFirstName(editBroker.getFirstName());
		broker1.setLastName(editBroker.getLastName());
		broker1.setEmailID(editBroker.getEmailID());
		broker1.setMobileNo(editBroker.getMobileNo());
		broker1.setInsComp(editBroker.getInsComp());
		broker1.setBrokerAccess(editBroker.getBrokerAccess());
		broker1.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		broker1.setCreatedTime(formattedTime);
		brokerRepo.save(broker1);

		users.setUserType(broker1.getUserType());
		users.setFirstName(broker1.getFirstName());
		users.setLastName(broker1.getLastName());
		users.setEmailID(broker1.getEmailID());
		users.setMobileNo(broker1.getMobileNo());
		users.setInsComp(broker1.getInsComp());
		users.setBrokerAccess(broker1.getBrokerAccess());
		users.setCreatedDate(broker1.getCreatedDate());
		users.setCreatedTime(broker1.getCreatedTime());
		usersRepo.save(users);
		return editBroker;
	}

	public BRVEntity createBRVAndUser(BRVEntity brv) {
		// Handle ClaimApprovalEntity
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("brv");
		brv.setId(claimTrigger.getCount() + 1);
		brv.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		brv.setCreatedTime(formattedTime);
		bRVRepo.save(brv);
		claimTrigger.setCount(claimTrigger.getCount() + 1);
		addNewUserRepo.save(claimTrigger);

		// Handle UsersEntity
		AddNewUserTrigger userTrigger = addNewUserRepo.findByName("users");
		UsersEntity brvUser = new UsersEntity();
		brvUser.setId(userTrigger.getCount() + 1);
		brvUser.setUserType(brv.getUserType());
		brvUser.setFirstName(brv.getFirstName());
		brvUser.setLastName(brv.getLastName());
		brvUser.setEmailID(brv.getEmailID());
		brvUser.setMobileNo(brv.getMobileNo());
		brvUser.setInsComp(brv.getInsComp());
		brvUser.setBrvAccess(brv.getBrvAccess());
		brvUser.setCreatedDate(brv.getCreatedDate());
		brvUser.setCreatedTime(brv.getCreatedTime());
		usersRepo.save(brvUser);
		userTrigger.setCount(userTrigger.getCount() + 1);
		addNewUserRepo.save(userTrigger);
		return brv;
	}

	public BRVEntity editBRVAndUser(BRVEntity editBrv, String localTime) throws Exception {
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("brv");
		editBrv.setId(claimTrigger.getCount());
		BRVEntity brv1 = bRVRepo.findByCreatedTime(localTime);
		UsersEntity users = usersRepo.findByCreatedTime(localTime);
		brv1.setId(editBrv.getId());
		brv1.setUserType(editBrv.getUserType());
		brv1.setFirstName(editBrv.getFirstName());
		brv1.setLastName(editBrv.getLastName());
		brv1.setEmailID(editBrv.getEmailID());
		brv1.setMobileNo(editBrv.getMobileNo());
		brv1.setInsComp(editBrv.getInsComp());
		brv1.setBrvAccess(editBrv.getBrvAccess());
		brv1.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		brv1.setCreatedTime(formattedTime);
		bRVRepo.save(brv1);

		users.setUserType(brv1.getUserType());
		users.setFirstName(brv1.getFirstName());
		users.setLastName(brv1.getLastName());
		users.setEmailID(brv1.getEmailID());
		users.setMobileNo(brv1.getMobileNo());
		users.setInsComp(brv1.getInsComp());
		users.setBrvAccess(brv1.getBrvAccess());
		users.setCreatedDate(brv1.getCreatedDate());
		users.setCreatedTime(brv1.getCreatedTime());
		usersRepo.save(users);
		return editBrv;
	}

	public ClaimApprovalEntity createClaimApprovalAndUser(ClaimApprovalEntity claim) {
		// Handle ClaimApprovalEntity
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("claimApproval");
		claim.setId(claimTrigger.getCount() + 1);
		claim.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		claim.setCreatedTime(formattedTime);
		claimApprovalRepo.save(claim);
		claimTrigger.setCount(claimTrigger.getCount() + 1);
		addNewUserRepo.save(claimTrigger);

		// Handle UsersEntity
		AddNewUserTrigger usersTrigger = addNewUserRepo.findByName("users");
		UsersEntity claimUser = new UsersEntity();
		claimUser.setId(usersTrigger.getCount() + 1);
		claimUser.setUserType(claim.getUserType());
		claimUser.setFirstName(claim.getFirstName());
		claimUser.setLastName(claim.getLastName());
		claimUser.setEmailID(claim.getEmailID());
		claimUser.setMobileNo(claim.getMobileNo());
		claimUser.setCreatedDate(claim.getCreatedDate());
		claimUser.setCreatedTime(claim.getCreatedTime());
		usersRepo.save(claimUser);
		usersTrigger.setCount(usersTrigger.getCount() + 1);
		addNewUserRepo.save(usersTrigger);
		return claim;
	}

	public ClaimApprovalEntity editClaimAndUser(ClaimApprovalEntity editClaim, String localTime) throws Exception {
		AddNewUserTrigger claimTrigger = addNewUserRepo.findByName("claimApproval");
		editClaim.setId(claimTrigger.getCount());
		ClaimApprovalEntity claim1 = claimApprovalRepo.findByCreatedTime(localTime);
		UsersEntity users = usersRepo.findByCreatedTime(localTime);
		claim1.setId(editClaim.getId());
		claim1.setUserType(editClaim.getUserType());
		claim1.setFirstName(editClaim.getFirstName());
		claim1.setLastName(editClaim.getLastName());
		claim1.setEmailID(editClaim.getEmailID());
		claim1.setMobileNo(editClaim.getMobileNo());
		claim1.setCreatedDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = now.format(timeFormatter);
		claim1.setCreatedTime(formattedTime);
		claimApprovalRepo.save(claim1);

		users.setUserType(claim1.getUserType());
		users.setFirstName(claim1.getFirstName());
		users.setLastName(claim1.getLastName());
		users.setEmailID(claim1.getEmailID());
		users.setMobileNo(claim1.getMobileNo());
		users.setCreatedDate(claim1.getCreatedDate());
		users.setCreatedTime(claim1.getCreatedTime());
		usersRepo.save(users);
		return editClaim;
	}

}
