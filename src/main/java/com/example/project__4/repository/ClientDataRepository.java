package com.example.project__4.repository;

import com.example.project__4.entity.ClientData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientDataRepository extends JpaRepository<ClientData, Long> {
    Optional<ClientData> findByUid(String clientUid);

    @Query("SELECT c FROM ClientData c WHERE " +
            "(:searchValue IS NULL OR :searchValue = '' OR " +
            "LOWER(c.name) LIKE LOWER(CONCAT('%', :searchValue, '%')) OR " +
            "LOWER(c.accountNumber) LIKE LOWER(CONCAT('%', :searchValue, '%')) OR " +
            "LOWER(c.description) LIKE LOWER(CONCAT('%', :searchValue, '%')))")
    List<ClientData> searchClientData(@Param("searchValue") String searchValue, Pageable pageable);

    @Query("SELECT COUNT(c) FROM ClientData c WHERE " +
            "(:searchValue IS NULL OR :searchValue = '' OR " +
            "LOWER(c.name) LIKE LOWER(CONCAT('%', :searchValue, '%')) OR " +
            "LOWER(c.accountNumber) LIKE LOWER(CONCAT('%', :searchValue, '%')) OR " +
            "LOWER(c.description) LIKE LOWER(CONCAT('%', :searchValue, '%')))")
    long countClientData(@Param("searchValue") String searchValue);



}
