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
import subscription.dataVO.ReservaVO;
import subscription.services.ReservaService;
import subscription.utils.MediaType;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/reserva")
@Tag(name = "Reserva", description = "Endpoint for managing reservas.")
public class ReservaController {

    @Autowired
    private ReservaService service;

    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/reserva
    @GetMapping
    @Operation(
            summary = "Find all reeservas.", description = "Find all reservas.", tags = {"Reserva"},
            responses = {
                    @ApiResponse(description = "Sucess.", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = ReservaVO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    public List<ReservaVO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Find a reserva by ID.", description = "Find a reserva by ID.", tags = {"Reserva"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            schema = @Schema(implementation = ReservaVO.class)
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    ) public ReservaVO findById(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    // CREATE - HTTP POST
    // Endpoint: http://localhost:8080/api/v1/group
    @PostMapping
    @Operation(
            summary = "Create a Reserva.", description = "Create a reserva.", tags = {"Reserva"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = ReservaVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public ReservaVO save(@RequestBody ReservaVO reservaVO) throws Exception {
        return service.save(reservaVO);
    }

    // INSERT USERS - HTTP POST
    // Endpoint: http://localhost:8080/api/v1/group/insert-users
//    @PostMapping("insert-users")
//    @Operation(
//            summary = "Insert a user in group.", description = "Insert a user in group.", tags = {"Group"},
//            responses = {
//                    @ApiResponse(description = "Success", responseCode = "200",
//                            content = @Content(
//                                    schema = @Schema(implementation = ReservaVO.class)
//                            )
//                    ),
//                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
//                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
//                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
//                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
//            }
//    )
//    public ReservaVO insertReservas(@RequestBody ReservaVO reservaVO) throws Exception {
//        return service.insertReservas(reservaVO);
//    }

    // UPDATE - HTTP PUT
    // Endpoint: http://localhost:8080/api/v1/group
    @PutMapping
    @Operation(
            summary = "Update a reserva.", description = "Update a reserva.", tags = {"Reserva"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = ReservaVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public ReservaVO update(@RequestBody ReservaVO reservaVO) throws Exception {
        return service.update(reservaVO);
    }

    // DELETE - HTTP DELETE
    // Endpoint: http://localhost:8080/api/v1/group/ID
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletes a Reserva by ID.", description = "Deletes a Reserva by ID.", tags = {"Reserva"},
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