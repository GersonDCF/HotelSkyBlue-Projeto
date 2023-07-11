package subscription.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import subscription.dataVO.PrestacaoVO;
import subscription.services.PrestacaoService;

import java.util.List;

@RestController
@RequestMapping("api/v1/prestacoes")
@Tag(name = "Prestacao", description = "Endpoint for managing prestacoes.")
public class PrestacaoController {

    @Autowired
    private PrestacaoService service;

    @GetMapping
    public List<PrestacaoVO> findAll() {
        List<PrestacaoVO> prestacoes = service.findAll();
        return prestacoes;
    }

    @GetMapping("/{id}")
    public PrestacaoVO findById(@PathVariable("id") Long id) throws Exception {
        PrestacaoVO prestacao = service.findById(id);
        return prestacao;
    }

    @PostMapping
    public PrestacaoVO create(@RequestBody PrestacaoVO prestacaoVO) throws Exception {
        PrestacaoVO createdPrestacao = service.save(prestacaoVO);
        return createdPrestacao;
    }

    @PutMapping("/{id}")
    public PrestacaoVO update(@PathVariable("id") Long id, @RequestBody PrestacaoVO prestacaoVO) throws Exception {
        prestacaoVO.setId(id);
        return service.update(prestacaoVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
