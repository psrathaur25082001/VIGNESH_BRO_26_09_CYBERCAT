package com.cybercat.user.service;

import com.cybercat.user.entity.StrategicResponseEntity;
import com.cybercat.user.payload.ClientInfoDto;

public interface ClientInfoService {

 //   ClientInfoDto calculateAndSaveClientInfo(ClientInfoDto clientInfoDto);
    ClientInfoDto getClientInfoById(String clientId);
//	String getStrategicResponseById(int id, int index);
	ClientInfoDto getStrategicResponseAndSaveClientInfo(int id, int index, ClientInfoDto clientInfoDto);



}
