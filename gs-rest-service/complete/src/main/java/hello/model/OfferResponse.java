package hello.model;


import hello.BaseResponse;

public class OfferResponse extends BaseResponse {

    private long offerId;

    private String description;

    public OfferResponse(String status, Integer code, long offerId, String description) {
        super(status, code);
        this.offerId = offerId;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getOfferId() {
        return offerId;
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }
}
