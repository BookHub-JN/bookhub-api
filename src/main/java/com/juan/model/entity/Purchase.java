package com.juan.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.juan.model.enums.PaymentStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float total;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "Fk_purchase_customer"))
    private User customer;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private List<PurchaseItem> items;
}
