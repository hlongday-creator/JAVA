package com.example.demo1.Controller;

import com.example.demo1.Model.PhongBan;
import com.example.demo1.Service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/phongban")
public class PhongBanController {

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public List<PhongBan> getAllPhongBan() {
        return phongBanService.getAllPhongBan();
    }

    @PostMapping
    public PhongBan createPhongBan(@RequestBody PhongBan phongBan) {
        return phongBanService.savePhongBan(phongBan);
    }
}
