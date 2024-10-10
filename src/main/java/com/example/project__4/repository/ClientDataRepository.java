package com.example.project__4.repository;

import com.example.project__4.entity.ClientData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientDataRepository extends JpaRepository<ClientData, Long> {
    Optional<ClientData> findByUid(String clientUid);
}
