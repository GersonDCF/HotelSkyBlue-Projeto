package subscription.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import subscription.dataVO.VagaGaragemVO;
import subscription.services.VagaGaragemService;
import subscription.utils.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/vaga-garagem")
@Tag(name = "VagaGaragem", description = "Endpoint for managing garagens.")
public class VagaGaragemController {

    @Autowired
    VagaGaragemService service;

    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/vagaGaragem
    @GetMapping
    @Operation(
            summary = "Find all vagas.", description = "Find all vagas.", tags = {"VagaGaragem"},
            responses = {
                    @ApiResponse(description = "Sucess.", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = VagaGaragemVO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    public List<VagaGaragemVO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Find a vagas by ID.", description = "Find a vagas by ID.", tags = {"VagaGaragem"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            schema = @Schema(implementation = VagaGaragemVO.class)
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public VagaGaragemVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(
            summary = "Create a vaga.", description = "Create a vaga.", tags = {"VagaGaragem"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = VagaGaragemVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public VagaGaragemVO save(@RequestBody VagaGaragemVO vagaGaragemVO) {
        return service.save(vagaGaragemVO);
    }
    @PostMapping("insert-vagas")
    @Operation(
            summary = "Insert a user in vagas.", description = "Insert a user in vagas.", tags = {"VagaGaragem"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = VagaGaragemVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public VagaGaragemVO insertUsers(@RequestBody VagaGaragemVO VagaGaragemVO) {
        return service.save(VagaGaragemVO);
    }

    // DELETE - HTTP DELETE
    // Endpoint: http://localhost:8080/api/v1/group/ID
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletes a Vagas by ID.", description = "Deletes a Vagas by ID.", tags = {"VagaGaragem"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public String delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}