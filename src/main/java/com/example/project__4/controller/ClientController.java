package com.example.project__4.controller;


import com.example.project__4.dto.response.ClientDataDTO;
import com.example.project__4.utils.ResponseWrapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    public ResponseWrapper<ClientDataDTO> allClients(){
        return null;
    }


    @PostMapping
    public String saveClient(){
        return "Requires token";
    }
}
