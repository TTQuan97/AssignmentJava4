package com.example.AsignmentJava4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Entity
@Table(name = "SanPham")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SanPham implements Serializable {
    @Id
    @GeneratedValue(generator = "autoGen")
    @GenericGenerator(name = "autoGen", strategy = "guid")
    @Column(name = "Id")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;
}
