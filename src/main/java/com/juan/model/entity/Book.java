package com.juan.model.entity;

import java.time.LocalDateTime;

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
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Float Price;

    @Column(name = "cover_path")
    private String coverPath;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_books_categories"))
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_books_authors"))
    private Author author;
}
