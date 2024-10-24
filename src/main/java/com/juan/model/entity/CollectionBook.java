package com.juan.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "collection_books")
@IdClass(CollectionBookPK.class)
public class CollectionBook {
    @Id
    private Integer book;

    @Id
    private Integer collection;

    @Column(name = "added_date", nullable = false)
    private LocalDateTime addedDate;
}
