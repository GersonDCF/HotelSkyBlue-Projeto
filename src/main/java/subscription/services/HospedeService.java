package subscription.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import subscription.controllers.HospedeController;
import subscription.dataVO.HospedeVO;
import subscription.mapper.DozerMapper;
import subscription.models.Hospede;
import subscription.repositories.HospedeRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
@Service
public class HospedeService {

    @Autowired
    private HospedeRepository repository;

    public List<HospedeVO> findAll() {
        var hospedes = DozerMapper.parseListObject(repository.findAll(), HospedeVO.class);
        hospedes.stream().forEach(hospede -> {
            hospede.add(linkTo(methodOn(HospedeController.class).findById(hospede.getId()))
                    .withSelfRel()
            );
        });
        return hospedes;
    }

    public HospedeVO findById(Long id) {
        return DozerMapper.parseObject(repository.findById(id).get(), HospedeVO.class);
    }

    public HospedeVO save(HospedeVO hospedeVO) {
        if (verifyHospede(hospedeVO)) {
            var hospede = repository.save(DozerMapper.parseObject(hospedeVO, Hospede.class));
            return DozerMapper.parseObject(hospede, HospedeVO.class);
        }
        return null;
    }

    public HospedeVO update(HospedeVO hospedeVO) {
        var dbHospede = repository.findById(Long.valueOf(hospedeVO.getId()));
        if (dbHospede.isPresent() && verifyHospede(hospedeVO)) {
            var hospede = repository.save(DozerMapper.parseObject(hospedeVO, Hospede.class));
            return DozerMapper.parseObject(hospede, HospedeVO.class);
        }
        return null;
    }

    public String delete(Long id) {
        var dbHospede = repository.findById(Long.valueOf(id));
        if (dbHospede.isPresent()) {
            repository.deleteById(Long.valueOf(id));
            return "Hospede with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }

    private boolean verifyHospede(HospedeVO hospedeVO) {
        if (!hospedeVO.getNome().isBlank() && !hospedeVO.getNome().isEmpty() &&
                !hospedeVO.getCpf().isBlank() && !hospedeVO.getCpf().isEmpty() &&
                !hospedeVO.getTelefone().isBlank() && !hospedeVO.getTelefone().isEmpty() &&
                !hospedeVO.getDataNascimento().isBlank() && !hospedeVO.getDataNascimento().isEmpty()) {
            return true;
        }
        return false;
    }
}
