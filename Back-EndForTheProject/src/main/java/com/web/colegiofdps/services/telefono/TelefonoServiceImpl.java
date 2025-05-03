package com.web.colegiofdps.services.telefono;

import com.web.colegiofdps.Entities.PadreDeFamilia;
import com.web.colegiofdps.Entities.Telefono;
import com.web.colegiofdps.Entities.TipoTelefono;
import com.web.colegiofdps.dtos.Telefono.TelefonoDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.TelefonoMapper;
import com.web.colegiofdps.repositories.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelefonoServiceImpl implements TelefonoService{

    public final TelefonoRepository telefonoRepository;

    public final TelefonoMapper telefonoMapper;

    @Autowired
    public TelefonoServiceImpl(TelefonoRepository telefonoRepository,
                               TelefonoMapper telefonoMapper) {
        this.telefonoRepository = telefonoRepository;
        this.telefonoMapper = telefonoMapper;
    }

    @Override
    public TelefonoDto saveTelefono(TelefonoDto telefono) {
        Telefono phoneToSave = telefonoMapper.phoneDtoToPhoneEntity(telefono);
        Telefono phoneSaved = telefonoRepository.save(phoneToSave);
        return telefonoMapper.phoneEntityToPhoneDto(phoneSaved);
    }

    @Override
    public TelefonoDto updateTelefonoByid(Long id, TelefonoDto telefono) {
        Optional<Telefono> phonesMatched = telefonoRepository.findById(id);

        if (phonesMatched.isEmpty()) throw new NotFoundException("El telefono con ID " + id + " no fue encontrado");

        Telefono phone = phonesMatched.get();

        if (telefono.tipoTelefono() != null) phone.setTipoTelefono(telefono.tipoTelefono());
        if (telefono.numeroTelefonico() != null) phone.setNumeroTelefonico(telefono.numeroTelefonico());

        Telefono updatedPhone = telefonoRepository.save(phone);
        return telefonoMapper.phoneEntityToPhoneDto(updatedPhone);
    }

    @Override
    public TelefonoDto findTelefonoByid(Long id) {
        Optional<Telefono> telefono = telefonoRepository.findById(id);
        if (telefono.isEmpty()) throw new NotFoundException("El telefono con ID " + id + " no fue encontrado");
        return telefonoMapper.phoneEntityToPhoneDto(telefono.get());
    }

    @Override
    public List<TelefonoDto> findAllTelefonos() {
        List<Telefono> phones = telefonoRepository.findAll();

        if (phones.isEmpty()) throw new NotFoundException("No se ha encontrado ningun telefono");

        List<TelefonoDto> allPhones = new ArrayList<>();

        phones.forEach( telefono -> {
            TelefonoDto t = telefonoMapper.phoneEntityToPhoneDto(telefono);
            allPhones.add(t);
        } );

        return allPhones;
    }

    @Override
    public TelefonoDto findTelefonoByNumeroTelefonico(String numeroTelefonico) {
        Optional<Telefono> foundPhone = telefonoRepository.findTelefonoByNumeroTelefonico(numeroTelefonico);
        if (foundPhone.isEmpty()) throw new NotFoundException("El telefono con numero telefonico " + numeroTelefonico + " no fue hallado");
        return telefonoMapper.phoneEntityToPhoneDto(foundPhone.get());
    }

    @Override
    public void deleteTelefonoByid(Long id) {
        Optional<Telefono> foundPhone = telefonoRepository.findById(id);
        if (foundPhone.isEmpty()) throw new NotFoundException("El telefono con el ID " + id + " no fue encontrado");
        telefonoRepository.deleteById(id);
    }

    @Override
    public List<TelefonoDto> findTelefonoByTipoTelefono(TipoTelefono tipoTelefono) {
        List<Telefono> phones = telefonoRepository.findTelefonosByTipoTelefono(tipoTelefono);

        if (phones.isEmpty()) throw new NotFoundException("Ningun telefono ha sido encontrado");

        List<TelefonoDto> ph = new ArrayList<>();

        phones.forEach( telefono -> {
            TelefonoDto t = telefonoMapper.phoneEntityToPhoneDto(telefono);
            ph.add(t);
        } );

        return ph;
    }

    @Override
    public TelefonoDto findTelefonoByPadreDeFamilia(PadreDeFamilia padreDeFamilia) {
        return null;
    }
}
