package com.example.swifty.entity.transaction_log;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
/*
* Entity for Items that has been ordered.
* Has a many-to-one relation with Transaction
*/
@Setter
@Getter
@Entity
public class TransactionItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String companyName;

    @NonNull
    private String productName;

    @NonNull
    private Float price;

    @NonNull
    private Float quantity;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    public TransactionItems(){}
}
