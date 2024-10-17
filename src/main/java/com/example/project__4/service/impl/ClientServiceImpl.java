package com.example.project__4.service.impl;

import com.example.project__4.dto.request.ClientDataRequestDTO;
import com.example.project__4.dto.request.PaginationDTO;
import com.example.project__4.dto.response.ClientDataResponse;
import com.example.project__4.entity.ClientData;
import com.example.project__4.entity.User;
import com.example.project__4.repository.ClientDataRepository;
import com.example.project__4.security.auth.AuthenticationContract;
import com.example.project__4.service.ClientService;
import com.example.project__4.service.DataPatchingService;
import com.example.project__4.utils.PaginatedResponse;
import com.example.project__4.utils.ResponseWrapper;
import com.example.project__4.utils.Utility;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ModelMapper modelMapper;
    private final Utility utils;
    private final ClientDataRepository clientDataRepository;
    private final AuthenticationContract auth;
    @Override
    public PaginatedResponse<ClientDataResponse> allClients(PaginationDTO paginationDTO) {
        List<ClientData> clientList = clientDataRepository.searchClientData(paginationDTO.getSearchFilter(), paginationDTO.getPaginationCriteria(null));
        int totalSize =(int) clientDataRepository.countClientData(paginationDTO.getSearchFilter());
        int pages = (int)(totalSize/ paginationDTO.getSize());
        return new PaginatedResponse<>(paginationDTO.getPage(),
                        totalSize,
                        pages,
                        clientList.stream().map(this::toclientDataDTO).toList()
        );

    }

    @Override
    public ClientDataResponse getClient(String clientUid) {
        ClientData clientData = (ClientData) utils.unwrapOptional(clientDataRepository.findByUid(clientUid), "clientData");
        return modelMapper.map(clientData, ClientDataResponse.class);
    }

    @Override
    public ClientDataResponse saveClient(ClientDataRequestDTO clientDataRequestDTO) {
        User user = auth.getAuthenticatedUser();
        ClientData clientData = modelMapper.map(clientDataRequestDTO, ClientData.class);
        clientData.setUser(user);
        return modelMapper.map(clientDataRepository.save(clientData), ClientDataResponse.class);
    }

    @Override
    public ClientDataResponse updateClient(ClientDataRequestDTO clientDataRequestDTO, String clientUid) {
        ClientData clientData = (ClientData) utils.unwrapOptional(clientDataRepository.findByUid(clientUid), "clientData");
        DataPatchingService.setFieldIfProvided(clientData::setAccountNumber,clientDataRequestDTO.getAccountNumber());
        DataPatchingService.setFieldIfProvided(clientData::setName,clientDataRequestDTO.getName());
        DataPatchingService.setFieldIfProvided(clientData::setCustomerId,clientDataRequestDTO.getCustomerId());
        return modelMapper.map(clientDataRepository.save(clientData), ClientDataResponse.class);

    }
    private ClientDataResponse toclientDataDTO(ClientData clientData){
        return modelMapper.map(clientData, ClientDataResponse.class);
    }
}
