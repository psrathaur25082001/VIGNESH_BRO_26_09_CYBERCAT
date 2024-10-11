package com.cybercat.user.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "ALLUSERS")
public class MultipleUsersListEntity {

	@Id
	String id;
	List<ClientEntity> client;
	List<UnderwriterEntity> under;
	List<IntermediaryEntity> inter;
	List<AgentEntity> agent;
	List<BrokerEntity> broker;
	List<BRVEntity> brv;
	List<ClaimApprovalEntity> claim;
}
