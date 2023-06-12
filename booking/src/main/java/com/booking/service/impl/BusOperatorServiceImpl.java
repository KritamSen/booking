package com.booking.service.impl;

import com.booking.entities.BusOperator;
import com.booking.payload.BusOperatorDTO;
import com.booking.repository.BusOperatorRepository;
import com.booking.service.BusOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BusOperatorServiceImpl implements BusOperatorService {

    @Autowired
    private BusOperatorRepository busOperatorRepository;

    @Override
    public List<BusOperator> getAllBusOperators() {
        return busOperatorRepository.findAll();
    }

    @Override
    public BusOperator getBusOperatorById(Long id) {
        Optional<BusOperator> busOperator = busOperatorRepository.findById(id);
        if (busOperator.isPresent()) {
            return busOperator.get();
        } else {
            throw new RuntimeException("Bus operator not found with id: " + id);
        }
    }


    @Override
    public BusOperatorDTO addBusOperator(BusOperatorDTO busOperatorDTO) {
       BusOperator busOperator= new BusOperator();
       busOperator.setOperatorName(busOperatorDTO.getOperatorName());
       busOperator.setContectEmail(busOperatorDTO.getContactEmail());
       busOperator.setContectPhone(busOperatorDTO.getContactPhone());
       busOperator.setLogoUrl(busOperatorDTO.getLogoUrl());
       busOperator.setCreatedAt(new Date());
       busOperator.setUpdatedAt(new Date());
        BusOperator save = busOperatorRepository.save(busOperator);

        BusOperatorDTO dto= new BusOperatorDTO();
        dto.setId(save.getId());
        dto.setOperatorName(save.getOperatorName());
        dto.setContactEmail(save.getContectEmail());
        dto.setContactPhone(save.getContectPhone());
        dto.setLogoUrl(save.getLogoUrl());
       dto.setCreatedAt(save.getCreatedAt());
       dto.setUpdatedAt(save.getUpdatedAt());
       return dto;

    }

    @Override
    public BusOperator updateBusOperator(Long id, BusOperator busOperator) {
        Optional<BusOperator> busOperatorOptional = busOperatorRepository.findById(id);
        if (busOperatorOptional.isPresent()) {
            busOperator.setId(id);
            return busOperatorRepository.save(busOperator);
        } else {
            throw new RuntimeException("Bus operator not found with id: " + id);
        }
    }

    @Override
    public void deleteBusOperator(Long id) {
        Optional<BusOperator> busOperator = busOperatorRepository.findById(id);
        if (busOperator.isPresent()) {
            busOperatorRepository.delete(busOperator.get());
        } else {
            throw new RuntimeException("Bus operator not found with id: " + id);
        }
    }

}
