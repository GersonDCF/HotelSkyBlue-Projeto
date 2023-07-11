package subscription.services;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import subscription.controllers.PrestacaoController;
import subscription.exceptions.RequiredObjectIsNullException;
import subscription.exceptions.ResourceNotFoundException;
import subscription.mapper.DozerMapper;
import subscription.dataVO.PrestacaoVO;
import subscription.models.Prestacao;
import subscription.repositories.PrestacaoRepository;
import subscription.utils.MediaType;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Service
public class PrestacaoService {

    @Autowired
    private PrestacaoRepository prestacaoRepository;


    public List<PrestacaoVO> findAll() {
        var prestacaoDbList = prestacaoRepository.findAll();
        var prestacoes = DozerMapper.parseListObject(prestacaoDbList, PrestacaoVO.class);
        prestacoes.stream().forEach(prestacao -> {
            try {
                prestacao.add(linkTo(methodOn(PrestacaoController.class).findById(prestacao.getId()))
                        .withSelfRel()
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        return prestacoes;
    }

    public PrestacaoVO findById(Long id) throws Exception {
        var prestacaoDb = prestacaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID."));
        var prestacao = DozerMapper.parseObject(prestacaoDb, PrestacaoVO.class);
        prestacao.add(linkTo(methodOn(PrestacaoController.class).findById(id)).withSelfRel());
        //user.add(linkTo(methodOn(UserController.class).update(user)).withSelfRel());
        //user.add(linkTo(methodOn(UserController.class).delete(id)).withSelfRel());
        return prestacao;
    }

    public PrestacaoVO save(PrestacaoVO prestacaoVO) throws Exception{
        if(prestacaoVO == null) throw new RequiredObjectIsNullException();

        Prestacao prestacao = DozerMapper.parseObject(prestacaoVO, Prestacao.class);
        var prestacaoDb = prestacaoRepository.save(prestacao);
        prestacaoVO = DozerMapper.parseObject(prestacaoDb, PrestacaoVO.class);
        prestacaoVO.add(linkTo(methodOn(PrestacaoController.class).findById(prestacaoVO.getId())).withSelfRel());
        return prestacaoVO;
    }

    public PrestacaoVO update(PrestacaoVO prestacaoVO) throws Exception {
        if(prestacaoVO == null) throw new RequiredObjectIsNullException();

        var dbPrestacao = prestacaoRepository.findById(prestacaoVO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        Prestacao prestacao = DozerMapper.parseObject(prestacaoVO, Prestacao.class);
        prestacao = prestacaoRepository.save(prestacao);
        prestacaoVO = DozerMapper.parseObject(prestacao, PrestacaoVO.class);
        prestacaoVO.add(linkTo(methodOn(PrestacaoController.class).findById(prestacaoVO.getId())).withSelfRel());
        return prestacaoVO;
    }

    public String delete(Long id) {
        var dbPrestacao = prestacaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        prestacaoRepository.deleteById(id);
        return "Prestação with id " + id + " has been deleted!";
    }
}