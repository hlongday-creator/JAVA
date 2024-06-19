package com.example.demo1.Service;

import com.example.demo1.Model.NhanVien;
import com.example.demo1.Repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public NhanVien saveNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVien getNhanVienById(String id) {
        Optional<NhanVien> optionalNhanVien = nhanVienRepository.findById(id);
        return optionalNhanVien.orElseThrow(() -> new RuntimeException("NhanVien not found for id :: " + id));
    }

    public void deleteNhanVienById(String id) {
        nhanVienRepository.deleteById(id);
    }
}
