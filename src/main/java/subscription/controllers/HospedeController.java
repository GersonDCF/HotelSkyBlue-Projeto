package subscription.controllers;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import subscription.dataVO.HospedeVO;
import subscription.services.HospedeService;
import io.swagger.v3.oas.annotations.Operation;
import subscription.utils.MediaType;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/hospede")
@Tag(name = "Hospede", description = "Endpoint for managing hospedes.")
public class HospedeController {

    @Autowired
    private HospedeService service;

    @GetMapping
    @Operation(
            summary = "Lista todos os hóspedes", description = "Retorna uma lista com todos os hóspedes cadastrados", tags = {"Hospede"},
            responses = {
                    @ApiResponse(description = "Sucess.", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = HospedeVO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    public List<HospedeVO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Busca um hóspede por ID", description = "Retorna um hóspede pelo seu ID", tags = {"Hospede"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            schema = @Schema(implementation = HospedeVO.class)
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public HospedeVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(
            summary = "Cria um novo hóspede", description = "Cria um novo hóspede no sistema", tags = {"Hospede"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = HospedeVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public HospedeVO save(@RequestBody HospedeVO hospedeVO) {
        return service.save(hospedeVO);
    }

    @PutMapping
    @Operation(
            summary = "Atualiza um hóspede", description = "Atualiza as informações de um hóspede já existente", tags = {"Hospede"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = HospedeVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public HospedeVO update(@RequestBody HospedeVO hospedeVO) {
        return service.update(hospedeVO);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deleta um hóspede", description = "Deleta um hóspede do sistema", tags = {"Hospede"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "Hóspede deleted";
    }
}