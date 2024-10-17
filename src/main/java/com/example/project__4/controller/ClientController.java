package com.example.project__4.controller;


import com.example.project__4.dto.request.ClientDataDto;
import com.example.project__4.dto.response.ClientDataResponse;
import com.example.project__4.utils.ResponseWrapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    public ResponseWrapper<ClientDataResponse> allClients(){
        return null;
    }


    @PostMapping
    public String saveClient(@RequestBody @Valid ClientDataDto clientDataDto){
        return "Requires token";
    }
}
