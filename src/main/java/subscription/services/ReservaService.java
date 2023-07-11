package subscription.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import subscription.controllers.ReservaController;
import subscription.dataVO.ReservaVO;
import subscription.exceptions.RequiredObjectIsNullException;
import subscription.exceptions.ResourceNotFoundException;
import subscription.mapper.DozerMapper;
import subscription.models.Reserva;
import subscription.repositories.ReservaRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ReservaService {


    @Autowired
    private ReservaRepository reservaRepository;


    public List<ReservaVO> findAll() {
        var reservaDbList = reservaRepository.findAll();
        var reservas = DozerMapper.parseListObject(reservaDbList, ReservaVO.class);
        reservas.stream().forEach(reserva -> {
            try {
                reserva.add(linkTo(methodOn(ReservaController.class).findById(reserva.getId()))
                        .withSelfRel()
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        return reservas;
    }

    public ReservaVO findById(Long id) throws Exception {
        var reservaDb = reservaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID."));
        var reserva = DozerMapper.parseObject(reservaDb, ReservaVO.class);
        reserva.add(linkTo(methodOn(ReservaController.class).findById(id)).withSelfRel());
        //user.add(linkTo(methodOn(UserController.class).update(user)).withSelfRel());
        //user.add(linkTo(methodOn(UserController.class).delete(id)).withSelfRel());
        return reserva;
    }

    public ReservaVO save(ReservaVO reservaVO) throws Exception{
        if(reservaVO == null) throw new RequiredObjectIsNullException();

        Reserva reserva = DozerMapper.parseObject(reservaVO, Reserva.class);
        var reservaDb = reservaRepository.save(reserva);
        reservaVO = DozerMapper.parseObject(reservaDb, ReservaVO.class);
        reservaVO.add(linkTo(methodOn(ReservaController.class).findById(reservaVO.getId())).withSelfRel());
        return reservaVO;
    }

    public ReservaVO update(ReservaVO reservaVO) throws Exception {
        if(reservaVO == null) throw new RequiredObjectIsNullException();

        var dbReserva = reservaRepository.findById(reservaVO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        Reserva reserva = DozerMapper.parseObject(reservaVO, Reserva.class);
        reserva = reservaRepository.save(reserva);
        reservaVO = DozerMapper.parseObject(reserva, ReservaVO.class);
        reservaVO.add(linkTo(methodOn(ReservaController.class).findById(reservaVO.getId())).withSelfRel());
        return reservaVO;
    }

    public String delete(Long id) {
        var dbReserva = reservaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        reservaRepository.deleteById(id);
        return "Reserva with id " + id + " has been deleted!";
    }
}