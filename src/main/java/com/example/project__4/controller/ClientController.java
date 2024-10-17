package com.example.project__4.controller;


import com.example.project__4.dto.request.ClientDataRequestDTO;
import com.example.project__4.dto.request.PaginationDTO;
import com.example.project__4.dto.response.ClientDataResponse;
import com.example.project__4.service.ClientService;
import com.example.project__4.utils.PaginatedResponse;
import com.example.project__4.utils.ResponseWrapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;



    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<PaginatedResponse<ClientDataResponse>> allClients(@RequestParam PaginationDTO paginationDTO){
        return  new ResponseWrapper<>(
                true,
                "Client data retrieved",
                clientService.allClients(paginationDTO)
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<ClientDataResponse> saveClient(@RequestBody @Valid ClientDataRequestDTO clientDataDto){
        return new ResponseWrapper<>(true,
                "Client Data Successfully added",
                clientService.saveClient(clientDataDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<ClientDataResponse> getClient(String clientUid){
       return new ResponseWrapper<>(
               true,
               "Client data retrieved",
               clientService.getClient(clientUid)
       );
    }

    @PutMapping("/update/{uid}")
    @ResponseStatus(HttpStatus.OK)
    public  ResponseWrapper<ClientDataResponse> updateClient(ClientDataRequestDTO dto, String uid){
        return  new ResponseWrapper<>(
                true,
                "Client data updated",
                clientService.updateClient(dto, uid)
        );
    }

}
