package com.cybercat.user.entity;

import lombok.Data;

@Data
public class CreateClaimAndUserRequest {

	ClientEntity client; 
	UnderwriterEntity under;
	IntermediaryEntity inter;
	AgentEntity agent;
	BrokerEntity broker;
	BRVEntity brv;
	ClaimApprovalEntity claim;
	UsersEntity users;
}
