package com.cybercat.user.service;

import java.util.List;

import com.cybercat.user.entity.AgentEntity;
import com.cybercat.user.entity.BRVEntity;
import com.cybercat.user.entity.BrokerEntity;
import com.cybercat.user.entity.ClaimApprovalEntity;
import com.cybercat.user.entity.ClientEntity;
import com.cybercat.user.entity.IntermediaryEntity;
import com.cybercat.user.entity.MultipleUsersListEntity;
import com.cybercat.user.entity.UnderwriterEntity;
import com.cybercat.user.entity.UsersEntity;

public interface AddNewUserService {

	//CREATE ALL USERS
	ClientEntity createClient(ClientEntity client);

	UnderwriterEntity createUnderwriter(UnderwriterEntity under);

	IntermediaryEntity createIntermediary(IntermediaryEntity inter);

	AgentEntity createAgent(AgentEntity agent);

	BrokerEntity createBroker(BrokerEntity broker);

	BRVEntity createBrv(BRVEntity brv);

	ClaimApprovalEntity createClaimApproval(ClaimApprovalEntity claim);

	//GET ALL USERS
	List<ClientEntity> getClient();

	List<UnderwriterEntity> getUnderwriter();

	List<IntermediaryEntity> getIntermediary();

	List<AgentEntity> getAgent();

	List<BrokerEntity> getBroker();

	List<BRVEntity> getBrv();

	List<ClaimApprovalEntity> getClaimApproval();
	
	// GET ALL USERS WITH MULTIPLE
	MultipleUsersListEntity getAllEntities();
	
	//ADMIN FILTER USERS
	List<UsersEntity> AdminFilterUsers(int pageNo, int count, String type, String value);
	
//	List<UsersEntity> AdminFilterUsers(int pageNo, int count, String type, String value);
	
	//CREATE USERS ONLY
	UsersEntity createUsers(UsersEntity users);

	UsersEntity editUsers(UsersEntity editUsers, int id) throws Exception;

	UsersEntity deleteUsers(int id);

	//CREATE ALL USERS AND TOO MAPPING FUNCTION
	ClientEntity createClientAndUser(ClientEntity client);

	UnderwriterEntity createUnderwriterAndUser(UnderwriterEntity under);

	IntermediaryEntity createIntermediaryAndUser(IntermediaryEntity inter);

	AgentEntity createAgentAndUser(AgentEntity agent);

	BrokerEntity createBrokerAndUser(BrokerEntity broker);

	BRVEntity createBRVAndUser(BRVEntity brv);

	ClaimApprovalEntity createClaimApprovalAndUser(ClaimApprovalEntity claim);

	// EDIT ALL USERS AND TOO MAPPING FUNCTION
	ClientEntity editClientAndUser(ClientEntity editClient, String localTime) throws Exception;

	UnderwriterEntity editUnderwriterAndUser(UnderwriterEntity editUnder, String localTime) throws Exception;

	IntermediaryEntity editIntermediaryAndUser(IntermediaryEntity editIntermediary, String localTime) throws Exception;

	AgentEntity editAgentAndUser(AgentEntity editAgent, String localTime) throws Exception;

	BrokerEntity editBrokerAndUser(BrokerEntity editBroker, String localTime) throws Exception;

	BRVEntity editBRVAndUser(BRVEntity editBrv, String localTime) throws Exception;

	ClaimApprovalEntity editClaimAndUser(ClaimApprovalEntity editClaim, String localTime) throws Exception;

	// EDIT ALL USERS
	ClientEntity editClient(ClientEntity editClient, int id) throws Exception;

	UnderwriterEntity editUnder(UnderwriterEntity editUnder, int id);

	IntermediaryEntity editInter(IntermediaryEntity editInter, int id);

	AgentEntity editAgent(AgentEntity editAgent, int id);

	BrokerEntity editBroker(BrokerEntity editBroker, int id);

	BRVEntity editBrv(BRVEntity editBrv, int id);

	ClaimApprovalEntity editClaimApproval(ClaimApprovalEntity editClaimApproval, int id);

	boolean generateClient(int id);

}
