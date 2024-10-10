package com.example.project__4.service;

import com.example.project__4.dto.response.ClientDataDTO;
import com.example.project__4.utils.ResponseWrapper;

import java.util.List;

public interface ClientService {
    ResponseWrapper<List<ClientDataDTO>> allClients();
    //ResponseWrapper<ClientDataDTO>
}
