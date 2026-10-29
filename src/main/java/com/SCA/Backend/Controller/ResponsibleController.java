package com.SCA.Backend.Controller;

import com.SCA.Backend.DTO.CreateResponsibleDTO;
import com.SCA.Backend.Models.Responsible;
import com.SCA.Backend.Service.IResponsibleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsibles")
@Tag(name = "Responsables", description = "Gestión de responsables de responder los acuerdos")
public class ResponsibleController {

    private final IResponsibleService _responsibleService;

    public ResponsibleController(IResponsibleService responsibleService) {
        _responsibleService = responsibleService;
    }

    @Operation(summary = "Obtener todos los responsables")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de responsables")
    })
    @GetMapping
    public ResponseEntity<List<Responsible>> getResponsibles(){
        return ResponseEntity.ok(_responsibleService.getAllResponsibles());
    }


    @Operation(summary = "Crear un responsable", description = "Devuelve el id del responsable creado")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Responsable creado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos",
                    content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    })
    @PostMapping
    public ResponseEntity<Long> createResponsible(@Valid @RequestBody CreateResponsibleDTO createResponsibleDTO){
        Long id = _responsibleService.createResponsible(createResponsibleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}
