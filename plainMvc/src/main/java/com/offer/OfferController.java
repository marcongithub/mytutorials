package com.offer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private OfferRepository offerRepository;

    private static final String SUCCESS_STATUS = "success";

    private static final String ERROR_STATUS = "error";

    private static final int CODE_SUCCESS = 100;

    private static final int AUTH_FAILURE = 102;


    @RequestMapping(value = "/createOrUpdate", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public OfferResponse createOrUpdate(@RequestParam(value = "offerId") long offerId, @RequestParam(value = "description") String description) {
        Offer offer = null;
        if (!StringUtils.isEmpty(offerId)) {
            offer = offerRepository.find(offerId);
            if (offer == null) {
                Offer newOffer = new Offer();
                newOffer.setDescription(description);
                offerRepository.create(newOffer);
                return new OfferResponse(SUCCESS_STATUS, 200, newOffer.getId(), description);
            } else {
                offer.setDescription(description);
                offer = offerRepository.update(offer);
                return new OfferResponse(SUCCESS_STATUS, 201, offer.getId(), offer.getDescription());
            }
        }

        return new OfferResponse(ERROR_STATUS, 400, offerId, description);
    }
}
