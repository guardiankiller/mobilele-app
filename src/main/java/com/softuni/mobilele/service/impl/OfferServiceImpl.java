package com.softuni.mobilele.service.impl;

import com.softuni.mobilele.model.AddOfferDTO;
import com.softuni.mobilele.model.OfferDetailsDTO;
import com.softuni.mobilele.repository.OfferRepository;
import com.softuni.mobilele.model.entity.OfferEntity;
import com.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public long createOrder(AddOfferDTO addOfferDTO) {
        return offerRepository.save(offerEntity(addOfferDTO)).getId();
    }

    @Override
    public OfferDetailsDTO getOfferDetails(Long id) {

        return this.offerRepository
                .findById(id)
                .map(OfferServiceImpl::toOfferDetailsDTO)
                .orElseThrow();

    }

    private static OfferDetailsDTO toOfferDetailsDTO(OfferEntity offerEntity) {

        return new OfferDetailsDTO(
                offerEntity.getId(),
                offerEntity.getDescription(),
                offerEntity.getMileage(),
                offerEntity.getEngine());
    }

    private static OfferEntity offerEntity(AddOfferDTO addOfferDTO) {
//        OfferEntity offerEntity = new OfferEntity();
//        offerEntity.setDescription(addOfferDTO.description());
//        offerEntity.setEngine(addOfferDTO.engineType());
//        return offerEntity;

        return new OfferEntity()
                .setDescription(addOfferDTO.description())
                .setEngine(addOfferDTO.engineType())
                .setMileage(addOfferDTO.mileage());
    }
}
