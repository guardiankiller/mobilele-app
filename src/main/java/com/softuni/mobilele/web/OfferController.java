package com.softuni.mobilele.web;

import com.softuni.mobilele.model.AddOfferDTO;
import com.softuni.mobilele.model.enums.EngineTypeEnum;
import com.softuni.mobilele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService orderService;

    public OfferController(OfferService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/add")
    public String newOffer(Model model) {

        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", AddOfferDTO.empty());
        }
        model.addAttribute("allEngineTypes", EngineTypeEnum.values());

        return "offer-add";
    }

    @PostMapping("/add")
    public String createOffer(
            @Valid AddOfferDTO addOfferDTO,
            BindingResult bindingResult,
            RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("addOfferDTO", addOfferDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", bindingResult);
            return "redirect:/offers/add";
        }


        long newOfferId = orderService.createOrder(addOfferDTO);

        return "redirect:/offers/" + newOfferId;
    }
}
