package com.softuni.mobilele.service;

import com.softuni.mobilele.model.AddOfferDTO;
import com.softuni.mobilele.model.OfferDetailsDTO;

public interface OfferService {

    long createOrder(AddOfferDTO addOfferDTO);
    OfferDetailsDTO getOfferDetails(Long id);
}
