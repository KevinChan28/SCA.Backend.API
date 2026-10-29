package com.SCA.Backend.Controller;

import com.SCA.Backend.DTO.CreateStatusDTO;
import com.SCA.Backend.Service.IStatusService;
import com.SCA.Backend.Service.Imp.ImpStatusService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
@Tag(name = "Status", description = "Gestión de los estados por los que pasa un documento")
public class StatusController {

    private final IStatusService _statusService;

    public StatusController(IStatusService statusService) {
        _statusService = statusService;
    }

    //Obtener todos los status
    @GetMapping("/all")
    public ResponseEntity<?> getStatus() {
        return ResponseEntity.ok(_statusService.getStatus());
    }

    @GetMapping("/{idStatus}")
    public ResponseEntity<?> getStatusById(@Valid @PathVariable long idStatus) {
        return ResponseEntity.ok(_statusService.getStatusById(idStatus));
    }

    @PostMapping()
    public ResponseEntity<?> createStatus(@Valid @RequestBody CreateStatusDTO createStatusDTO) {
        return ResponseEntity.ok(_statusService.createStatus(createStatusDTO));
    }
}
