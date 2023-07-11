package subscription.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import subscription.dataVO.HotelVO;
import subscription.services.HotelService;
import subscription.utils.MediaType;

import java.util.List;

@RestController
@RequestMapping("api/v1/hotels")
@Tag(name = "Hotel", description = "Endpoint for managing hotel.")
public class HotelController {

    @Autowired
    private HotelService service;

    @GetMapping
    @Operation(
            summary = "Find all Hotel.", description = "Find all Hotel.", tags = {"Hotel"},
            responses = {
                    @ApiResponse(description = "Sucess.", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = HotelVO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    public List<HotelVO> findAll() {

        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Find a hotel by ID.", description = "Find a hotel by ID.", tags = {"Hotel"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            schema = @Schema(implementation = HotelVO.class)
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public HotelVO findById(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    @Operation(
            summary = "Create a hotel.", description = "Create a hotel.", tags = {"Hotel"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = HotelVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public HotelVO save(@RequestBody HotelVO hotelVO) throws Exception {
        return service.save(hotelVO);
    }

    @PutMapping
    @Operation(
            summary = "Update a Hotel.", description = "Update a Hotel.", tags = {"Hotel"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = HotelVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public HotelVO update(@RequestBody HotelVO hotelVO) throws Exception {

        return service.update(hotelVO);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletes a Hotel by ID.", description = "Deletes a Hotel by ID.", tags = {"Hotel"},
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


