package study.inno.rest_example;

import java.text.NumberFormat;
import java.util.Locale;

public class Util {
    static void setPriceString(Place place){
        PlacePricingQuote ppq = place.getPricingQuote();
        int price = ppq.getPrice();
        String priceString = NumberFormat.getNumberInstance(Locale.KOREA).format(price);
        ppq.setPriceString(priceString);
        return;
    }
}
