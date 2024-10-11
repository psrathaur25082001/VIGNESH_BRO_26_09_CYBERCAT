package com.cybercat.user.controller;

//import com.ransomware.ransomware.payload.ClientInfoDto;
//import com.ransomware.ransomware.service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cybercat.user.entity.StrategicResponseEntity;
import com.cybercat.user.payload.ClientInfoDto;
import com.cybercat.user.service.ClientInfoService;

@RestController
@RequestMapping("/api/ransomware")
public class ClientInfoController {


    @Autowired
    private ClientInfoService clientInfoService;

   
    @PostMapping("/strategic-response/{clientId}")
    public ClientInfoDto getStrategicResponseAndSaveClientInfo(
            @PathVariable String clientId,
            @RequestParam int id,
            @RequestParam int index,
            @RequestBody ClientInfoDto clientInfoDto) {
        return clientInfoService.getStrategicResponseAndSaveClientInfo(id, index, clientInfoDto);
    }
    
//    @GetMapping("/strategic-response")
//    public String getStrategicResponseById(@RequestParam  int id, @RequestParam  int index) {
//        return clientInfoService.getStrategicResponseById(id, index);
//    }
//    
//    @PostMapping("/saveRansomware/{clientId}")
//    public ClientInfoDto createClientInfo(@PathVariable String clientId, @RequestBody ClientInfoDto clientInfoDto) {
//        clientInfoDto.setClientId(clientId);
//        return clientInfoService.calculateAndSaveClientInfo(clientInfoDto);
//    }

    @GetMapping("/{clientId}")
    public ClientInfoDto getClientInfoById(@PathVariable String clientId) {
        return clientInfoService.getClientInfoById(clientId);
    }

}
