package com.example.project__4.service;

import com.example.project__4.dto.request.ClientDataRequestDTO;
import com.example.project__4.dto.request.PaginationDTO;
import com.example.project__4.dto.response.ClientDataDTO;
import com.example.project__4.utils.PaginatedResponse;
import com.example.project__4.utils.ResponseWrapper;

import java.util.List;

public interface ClientService {
    ResponseWrapper<PaginatedResponse<ClientDataDTO>> allClients(PaginationDTO paginationDTO);
    ResponseWrapper<ClientDataDTO> getClient(String clientId);
    ResponseWrapper<ClientDataDTO> saveClient(ClientDataRequestDTO clientDataRequestDTO);
    ResponseWrapper<ClientDataDTO> updateClient(ClientDataRequestDTO clientDataRequestDTO, String clientId);
}
