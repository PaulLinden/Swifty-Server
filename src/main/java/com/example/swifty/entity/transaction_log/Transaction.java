package com.example.swifty.entity.transaction_log;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private Long customerId;
    @NonNull
    private Long companyId;
    @NonNull
    private LocalDateTime dateTime;

    @NonNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<Product> products;

    public Transaction(){}
}
