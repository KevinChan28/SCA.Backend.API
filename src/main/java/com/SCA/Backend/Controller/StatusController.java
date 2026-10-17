package com.SCA.Backend.Controller;

import com.SCA.Backend.Service.IStatusService;
import com.SCA.Backend.Service.Imp.ImpStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    IStatusService _statusService;

    @GetMapping("/all")
    public ResponseEntity<?> getStatus() {
        return ResponseEntity.ok(_statusService.getStatus());
    }
}
