package com.example.AsignmentJava4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "DongSP")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DongSanPham implements Serializable {

    @Id
    @GeneratedValue(generator = "autoGen")//tu dong gen ma
    @GenericGenerator(name = "autoGen", strategy = "guid")//gen theo strategy:GUID
    @Column(name = "Id")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @JsonIgnore
    @OneToMany(mappedBy = "dongSanPham", fetch = FetchType.LAZY)
    private Set<ChiTietSanPham> setChiTietSanPham;
}
