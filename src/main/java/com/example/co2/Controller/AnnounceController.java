package com.example.co2.Controller;
import com.example.co2.Entite.Announce;
import com.example.co2.Service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RequestMapping("/api/message")
@RestController
public class AnnounceController {


    @Autowired
    AnnounceService announceService;


    @GetMapping("/list-announce")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Announce> ListUserByRoles() {
        return announceService.gettAllMessage();
    }

    @PostMapping("/add-announce")
    public Announce addMessage(@RequestBody @Valid Announce m) {
        return announceService.addMessage(m);
    }

}
