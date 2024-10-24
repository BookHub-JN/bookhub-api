package com.juan.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "purchase_items")
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float price;

    @Column(name = "downs_ava")
    private Integer downloadsAvailable;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "Fk_purchase_item_book"))
    private Book book;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "purchase_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "Fk_purchase_item_purchase"))
    public Purchase purchase;
}
