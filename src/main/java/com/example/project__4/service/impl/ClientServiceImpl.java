package com.example.project__4.service.impl;

import com.example.project__4.dto.request.ClientDataRequestDTO;
import com.example.project__4.dto.request.PaginationDTO;
import com.example.project__4.dto.response.ClientDataDTO;
import com.example.project__4.service.ClientService;
import com.example.project__4.utils.PaginatedResponse;
import com.example.project__4.utils.ResponseWrapper;

public class ClientServiceImpl implements ClientService {
    @Override
    public ResponseWrapper<PaginatedResponse<ClientDataDTO>> allClients(PaginationDTO paginationDTO) {
        return null;
    }

    @Override
    public ResponseWrapper<ClientDataDTO> getClient(String clientId) {
        return null;
    }

    @Override
    public ResponseWrapper<ClientDataDTO> saveClient(ClientDataRequestDTO clientDataRequestDTO) {
        return null;
    }

    @Override
    public ResponseWrapper<ClientDataDTO> updateClient(ClientDataRequestDTO clientDataRequestDTO, String clientId) {
        return null;
    }
}
