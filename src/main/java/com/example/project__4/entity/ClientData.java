package com.example.project__4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client_date")
public class ClientData extends BaseEntity{
    @Column(name = "uid", nullable = false, unique = true)
    private String uid = UUID.randomUUID().toString();
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "name")
    private String name;
    @Column(name="account_number")
    private String accountNumber;
}
