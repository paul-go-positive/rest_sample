package study.inno.rest_example;

import java.util.List;

public class Place {
    private String placeId;
    private List<String> pictures;
    private PlacePricingQuote pricingQuote;
    private PlaceInfo info;

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public PlacePricingQuote getPricingQuote() {
        return pricingQuote;
    }

    public void setPricingQuote(PlacePricingQuote pricingQuote) {
        this.pricingQuote = pricingQuote;
    }

    public PlaceInfo getInfo() {
        return info;
    }

    public void setInfo(PlaceInfo info) {
        this.info = info;
    }
}
