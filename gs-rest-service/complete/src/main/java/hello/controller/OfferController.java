package hello.controller;


import hello.model.Offer;
import hello.model.OfferRepository;
import hello.model.OfferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private OfferRepository offerRepository;

    private static final String SUCCESS_STATUS = "success";

    private static final String ERROR_STATUS = "error";

    private static final int CODE_SUCCESS = 100;

    private static final int AUTH_FAILURE = 102;


    @RequestMapping(value = "/createOrUpdate", method = RequestMethod.GET, produces = {"application/json"})
//@RequestMapping(value = "/createOrUpdate", method = RequestMethod.GET)
    public OfferResponse createOrUpdate(@RequestParam(value = "offerId") long offerId, @RequestParam(value = "description") String description) {
        Offer offer = null;
        if (!StringUtils.isEmpty(offerId)) {
            Optional<Offer> optionalOffer = offerRepository.findById(offerId);
            if (!optionalOffer.isPresent()) {
                Offer newOffer = new Offer();
                newOffer.setDescription(description);
                offerRepository.save(newOffer);
                return new OfferResponse(SUCCESS_STATUS, 200, newOffer.getId(), description);
            } else {
                offer.setDescription(description);
                offer = offerRepository.save(offer);
                return new OfferResponse(SUCCESS_STATUS, 201, offer.getId(), offer.getDescription());
            }
        }

        return new OfferResponse(ERROR_STATUS, 400, offerId, description);
    }
}
