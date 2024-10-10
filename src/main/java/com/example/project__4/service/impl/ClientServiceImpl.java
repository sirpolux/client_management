package com.example.project__4.service.impl;

import com.example.project__4.dto.request.ClientDataRequestDTO;
import com.example.project__4.dto.request.PaginationDTO;
import com.example.project__4.dto.response.ClientDataDTO;
import com.example.project__4.entity.ClientData;
import com.example.project__4.repository.ClientDataRepository;
import com.example.project__4.service.ClientService;
import com.example.project__4.service.DataPatchingService;
import com.example.project__4.utils.PaginatedResponse;
import com.example.project__4.utils.ResponseWrapper;
import com.example.project__4.utils.Utility;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ModelMapper modelMapper;
    private final Utility utils;
    private final ClientDataRepository clientDataRepository;
    @Override
    public ResponseWrapper<PaginatedResponse<ClientDataDTO>> allClients(PaginationDTO paginationDTO) {
        return null;
    }

    @Override
    public ResponseWrapper<ClientDataDTO> getClient(String clientUid) {
        ClientData clientData = (ClientData) utils.unwrapOptional(clientDataRepository.findByUid(clientUid), "clientData");
        return null;
    }

    @Override
    public ResponseWrapper<ClientDataDTO> saveClient(ClientDataRequestDTO clientDataRequestDTO) {
        return new ResponseWrapper<>(true,
                " Client Data saved",
                modelMapper.map(clientDataRepository.save(
                        modelMapper.map(
                                clientDataRequestDTO,
                                ClientData.class)),
                                ClientDataDTO.class));
    }

    @Override
    public ResponseWrapper<ClientDataDTO> updateClient(ClientDataRequestDTO clientDataRequestDTO, String clientUid) {
        ClientData clientData = (ClientData) utils.unwrapOptional(clientDataRepository.findByUid(clientUid), "clientData");
        DataPatchingService.setFieldIfProvided(clientData::setAccountNumber,clientDataRequestDTO.getAccountNumber());
        DataPatchingService.setFieldIfProvided(clientData::setName,clientDataRequestDTO.getName());
        DataPatchingService.setFieldIfProvided(clientData::setCustomerId,clientDataRequestDTO.getCustomerId());
        return new ResponseWrapper<>(true,
                "Client data successfully updated",
                modelMapper.map(clientDataRepository.save(clientData),ClientDataDTO.class));

    }
}
