package br.com.cbf.campeonatobrasileiro.service;

import br.com.cbf.campeonatobrasileiro.dto.TimeDTO;
import br.com.cbf.campeonatobrasileiro.entity.Time;
import br.com.cbf.campeonatobrasileiro.exception.TimeNotFoundException;
import br.com.cbf.campeonatobrasileiro.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public TimeDTO cadastrarTime(TimeDTO timeDTO) throws Exception {
        Time time = toEntity(timeDTO);
        if(time.getId() == null){
            time = repository.save(time);
            return toDto(time);
        } else {
            throw new Exception("Time já existe.");
        }
    }

    public List<TimeDTO> listarTimes() {
        return repository.findAll().stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }

    public TimeDTO obterTime(Integer id) {
        return repository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new TimeNotFoundException(id));
    }

    private Time toEntity(TimeDTO timeDTO) {
        Time time = new Time();
        time.setId(timeDTO.getId());
        time.setEstadio(timeDTO.getEstadio());
        time.setNome(timeDTO.getNome());
        time.setSigla(timeDTO.getSigla());
        time.setUf(timeDTO.getUf());
        return time;
    }

    public TimeDTO toDto(Time time) {
        TimeDTO timeDTO = new TimeDTO();
        timeDTO.setId(time.getId());
        timeDTO.setEstadio(time.getEstadio());
        timeDTO.setNome(time.getNome());
        timeDTO.setSigla(time.getSigla());
        timeDTO.setUf(time.getUf());
        return timeDTO;
    }

    public List<Time> findAll() {
        return repository.findAll();
    }
}
