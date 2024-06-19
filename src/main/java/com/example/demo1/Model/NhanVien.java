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
@Table(name = "NHANVIEN")
public class NhanVien {

    @Id
    @Column(name = "Ma_NV", length = 3)
    private String maNV;

    @Column(name = "Ten_NV", length = 100)
    private String tenNV;

    @Column(name = "Phai", length = 3)
    private String phai;

    @Column(name = "Noi_Sinh", length = 200)
    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private PhongBan phongBan;

    @Column(name = "Luong")
    private int luong;
}
