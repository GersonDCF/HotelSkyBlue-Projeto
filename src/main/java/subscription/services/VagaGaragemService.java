package subscription.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import subscription.dataVO.VagaGaragemVO;
import subscription.exceptions.ResourceNotFoundException;
import subscription.mapper.DozerMapper;
import subscription.models.VagaGaragem;
import subscription.repositories.VagaGaragemRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Service
public class VagaGaragemService {

    @Autowired
    private VagaGaragemRepository repository;

    public List<VagaGaragemVO> findAll() {
        List<VagaGaragem> vagas = repository.findAll();
        return DozerMapper.parseListObject(vagas, VagaGaragemVO.class);
    }

    public VagaGaragemVO findById(Long id) {
        VagaGaragem vaga = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vaga de garagem não encontrada com o ID: " + id));
        return DozerMapper.parseObject(vaga, VagaGaragemVO.class);
    }

    public VagaGaragemVO save(VagaGaragemVO vagaVO) {
        VagaGaragem vaga = DozerMapper.parseObject(vagaVO, VagaGaragem.class);
        VagaGaragem savedVaga = repository.save(vaga);
        return DozerMapper.parseObject(savedVaga, VagaGaragemVO.class);
    }

    public VagaGaragemVO update(VagaGaragemVO vagaVO) {
        if (!repository.existsById(vagaVO.getId())) {
            throw new IllegalArgumentException("Vaga de garagem não encontrada com o ID: " + vagaVO.getId());
        }
        VagaGaragem vaga = DozerMapper.parseObject(vagaVO, VagaGaragem.class);
        VagaGaragem updatedVaga = repository.save(vaga);
        return DozerMapper.parseObject(updatedVaga, VagaGaragemVO.class);
    }

    public String delete(Long id) {
        var dbVaga = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.deleteById(id);
        return "Vaga with id " + id + " has been deleted!";
    }
}
