package com.example.demo1.Controller;

import com.example.demo1.Model.NhanVien;
import com.example.demo1.Service.NhanVienService;
import com.example.demo1.Service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String listNhanVien(Model model) {
        model.addAttribute("nhanViens", nhanVienService.getAllNhanVien());
        return "nhanvien-list";
    }

    @GetMapping("/create")
    public String createNhanVienForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBans", phongBanService.getAllPhongBan());
        return "nhanvien-form";
    }

    @PostMapping("/create")
    public String createNhanVien(@ModelAttribute NhanVien nhanVien) {
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/update/{id}")
    public String updateNhanVienForm(@PathVariable String id, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(id);
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("phongBans", phongBanService.getAllPhongBan());
        return "nhanvien-form";
    }

    @PostMapping("/update")
    public String updateNhanVien(@ModelAttribute NhanVien nhanVien) {
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable String id) {
        nhanVienService.deleteNhanVienById(id);
        return "redirect:/nhanvien";
    }

}
