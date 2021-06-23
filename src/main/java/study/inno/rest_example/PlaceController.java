package study.inno.rest_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping("/places")
public class PlaceController {
    @Autowired
    private PlaceMapper placeMapper;

    // 장소 등록
    @PostMapping("")
    public int addPlace(@RequestBody Place place){
        String placeId = UUID.randomUUID().toString();
        place.setPlaceId(placeId);
        int result = placeMapper.addPlace(place);

        List<String> pictures = place.getPictures();
        for (int i = 0; i < pictures.size(); i++) {
            placeMapper.addPicture(pictures.get(i),placeId);
        }
        return result;
    }
    // 모든 장소 조회
    @GetMapping("")
    public List<Place> getPlaceAll(){
        List<Place> places = placeMapper.getPlaces();
        for (int i = 0; i < places.size(); i++) {
            Util.setPriceString(places.get(i));
        }
        return places;
    }


    // 아이디로 장소 조회
    @GetMapping("/{placeId}")
    public Place getPlace(@PathVariable("placeId") String placeId){
        Place place = placeMapper.getPlace(placeId);
        Util.setPriceString(place);
        return place;
    }




    // 아이디로 장소 삭제
    @DeleteMapping("/{placeId}")
    public int removePlace(@PathVariable("placeId") String placeId){
        return placeMapper.deletePlace(placeId);
    }
}
