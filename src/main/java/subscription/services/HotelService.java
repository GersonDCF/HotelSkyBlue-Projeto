package subscription.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import subscription.controllers.HotelController;
import subscription.dataVO.HotelVO;
import subscription.exceptions.RequiredObjectIsNullException;
import subscription.exceptions.ResourceNotFoundException;
import subscription.mapper.DozerMapper;
import subscription.models.Hotel;
import subscription.repositories.HotelRepository;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelVO> findAll() {
        var hotelDbList = hotelRepository.findAll();
        var hoteis = DozerMapper.parseListObject(hotelDbList, HotelVO.class);
        hoteis.stream().forEach(hotel -> {
            try {
                hotel.add(linkTo(methodOn(HotelController.class).findById(hotel.getId()))
                        .withSelfRel()
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        return hoteis;
    }

    public HotelVO findById(Long id) throws Exception {
        var hotelDb = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID."));
        var hotel = DozerMapper.parseObject(hotelDb, HotelVO.class);
        hotel.add(linkTo(methodOn(HotelController.class).findById(id)).withSelfRel());
        //user.add(linkTo(methodOn(UserController.class).update(user)).withSelfRel());
        //user.add(linkTo(methodOn(UserController.class).delete(id)).withSelfRel());
        return hotel;
    }


    public HotelVO save(HotelVO hotelVO) throws Exception{
        if(hotelVO == null) throw new RequiredObjectIsNullException();

        Hotel hotel = DozerMapper.parseObject(hotelVO, Hotel.class);
        var hotelDb = hotelRepository.save(hotel);
        hotelVO = DozerMapper.parseObject(hotelDb, HotelVO.class);
        hotelVO.add(linkTo(methodOn(HotelController.class).findById(hotelVO.getId())).withSelfRel());
        return hotelVO;
    }


    public HotelVO update(HotelVO hotelVO) throws Exception {
        if(hotelVO == null) throw new RequiredObjectIsNullException();

        var dbHotel = hotelRepository.findById(hotelVO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        Hotel hotel = DozerMapper.parseObject(hotelVO, Hotel.class);
        hotel = hotelRepository.save(hotel);
        hotelVO = DozerMapper.parseObject(hotel, HotelVO.class);
        hotelVO.add(linkTo(methodOn(HotelController.class).findById(hotelVO.getId())).withSelfRel());
        return hotelVO;
    }

    public String delete(Long id) {
        var dbHotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        hotelRepository.deleteById(id);
        return "Hotel with id " + id + " has been deleted!";
    }
}