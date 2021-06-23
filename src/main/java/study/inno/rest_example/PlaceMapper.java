package study.inno.rest_example;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlaceMapper {
    @Insert("INSERT INTO pictures (" +
            "placeId, url" +
            ") VALUES (" +
            " #{placeId},#{picture}" +
            ");")
    int addPicture(@Param("picture") String picture,@Param("placeId") String placeId);

    @Insert("INSERT INTO place (" +
            "placeId, name," +
            "avgRating, reviewsCount, lat, lng," +
            "price"+
            ") VALUES (" +
            "#{place.placeId},#{place.info.name}," +
            "#{place.info.avgRating},#{place.info.reviewsCount}," +
            "#{place.info.lat},#{place.info.lng},#{place.pricingQuote.price}"+
            ");")
    int addPlace(@Param("place") Place place);

    @Select("SELECT url FROM pictures WHERE placeId=#{placeId}")
    List<String> getPicturesByPlaceId(@Param("placeId") String placeId);

    @Select("SELECT * FROM place WHERE placeId=#{placeId}")
    @Results(id="PlaceProfileMap", value = {
            @Result(property = "placeId", column = "placeId"),
            @Result(property = "info.name",column = "name"),
            @Result(property = "info.avgRating", column = "avgRating"),
            @Result(property = "info.reviewsCount",column = "reviewsCount"),
            @Result(property = "info.lat",column = "lat"),
            @Result(property = "info.lng",column = "lng"),
            @Result(property = "pricingQuote.price",column = "price"),
            @Result(property = "pictures", column = "placeId", many = @Many(select="study.inno.rest_example.PlaceMapper.getPicturesByPlaceId"))
    })
    Place getPlace(@Param("placeId") String placeId);


    @Select("SELECT * FROM place")
    @ResultMap("PlaceProfileMap")
    List<Place> getPlaces();


    @Delete("DELETE FROM place WHERE placeId=#{placeId}")
    int deletePlace(@Param("placeId") String placeId);
}
