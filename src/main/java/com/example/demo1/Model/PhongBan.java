package com.example.demo1.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PHONGBAN")
public class PhongBan {

    @Id
    @Column(name = "Ma_Phong", length = 2)
    private String maPhong;

    @Column(name = "Ten_Phong", length = 30)
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;
}
