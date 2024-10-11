package com.cybercat.user.repository;

import com.cybercat.user.entity.ClientInfo;
import com.cybercat.user.payload.ClientInfoDto;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientInfoRepository extends MongoRepository<ClientInfo,String> {

	ClientInfoDto save(ClientInfoDto clientInfoDto);


}
