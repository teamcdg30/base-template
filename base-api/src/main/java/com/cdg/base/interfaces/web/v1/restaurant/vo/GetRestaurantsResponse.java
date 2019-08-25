package com.cdg.base.interfaces.web.v1.restaurant.vo;

import com.cdg.base.common.type.CategoryType;
import com.cdg.base.common.type.HourType;
import com.cdg.base.common.type.ImageType;
import com.cdg.base.common.web.BaseResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class GetRestaurantsResponse extends BaseResponse {

    private List<Restaurant> restaurants;
    private long totalItems;

    /**
     * TODO DB연결 이전에 사용할 임시 데이터용 생성자
     */
    public GetRestaurantsResponse() {
        this.restaurants = restaurants;
        this.totalItems = 25;
    }

    //    public GetRestaurantsResponse(List<Restaurant> restaurants) {
    //        this.restaurants = restaurants;
    //    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Restaurant {

        private String id;
        private String name;
        private String description;
        private List<Image> imgs;
        private String address;
        private Location location;
        private String webSiteUrl;
        private String phoneNumber;
        private int priceRange;
        private int rating;
        private Hour hours;
        private CategoryType categoryType;

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Image {

        private String url;
        private String description;
        private ImageType imageType;

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Location {

        private long lat;
        private long lng;

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Hour {

        private HourType hourType;
        private ZonedDateTime open;
        private ZonedDateTime close;

    }

}
