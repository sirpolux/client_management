package com.example.project__4.service;

import com.example.project__4.dto.request.ClientDataRequestDTO;
import com.example.project__4.dto.request.PaginationDTO;
import com.example.project__4.dto.response.ClientDataResponse;
import com.example.project__4.utils.PaginatedResponse;
import com.example.project__4.utils.ResponseWrapper;

public interface ClientService {
    PaginatedResponse<ClientDataResponse> allClients(PaginationDTO paginationDTO);
    ClientDataResponse getClient(String clientId);
    ClientDataResponse saveClient(ClientDataRequestDTO clientDataRequestDTO);
    ClientDataResponse updateClient(ClientDataRequestDTO clientDataRequestDTO, String clientId);
}
