package com.bookmyshow.service.implementation;

import com.bookmyshow.domain.ShowDTO;
import com.bookmyshow.entity.Show;
import com.bookmyshow.entity.Theatre;
import com.bookmyshow.exception.CustomException;
import com.bookmyshow.repository.ShowRepository;
import com.bookmyshow.repository.TheatreRepository;
import com.bookmyshow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.bookmyshow.mapper.ShowMapper.MAPPER;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheatreRepository theatreRepository;


    @Override
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    @Override
    public Long addShow(ShowDTO showDTO) {
        Show show = showRepository.save(MAPPER.mapDTOToEntity(showDTO));
        return show.getShowId();
    }

    @Override
    public List<Show> getShowsByTheatreId(Long theatreId) {
        Optional<Theatre> theatreOptional = theatreRepository.findById(theatreId);
        return theatreOptional.map(theatre -> {
            return showRepository.findAllByTheatre(theatre);
        }).orElseThrow(()-> new CustomException("No theatre found by Id","getShowsByTheatreId"));

    }
}
