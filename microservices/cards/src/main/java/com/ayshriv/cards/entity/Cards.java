package com.ayshriv.cards.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "cards")
@Data
@NoArgsConstructor
public class Cards extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @Column(unique = true, nullable = false,name="mobile_number")
    private String mobileNumber;

    @Column(unique = true, nullable = false,name="card_number")
    private String cardNumber;

    @Column(nullable = false,name="card_type")
    private String cardType;

    @Column(nullable = false,name="total_limit")
    private int totalLimit;

    @Column(nullable = false,name="amount_used")
    private int amountUsed;

    @Column(nullable = false,name="available_amount")
    private int availableAmount;
}
