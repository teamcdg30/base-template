package com.cdg.base.interfaces.web.v1.restaurant;

import com.cdg.base.interfaces.web.v1.restaurant.vo.GetRestaurantsResponse;
import com.cdg.base.interfaces.web.v1.test.vo.GetTestResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

@Slf4j
@RestController
public class RestaurantController {

    @Autowired
    private ObjectMapper objectMapper;

    @ApiOperation(value = "식당 목록 조회")
    @CrossOrigin
    @GetMapping("/cdg-1/v1/restaurants")
    public Mono<GetRestaurantsResponse> getRestaurants() {
//        return Mono.just(new GetTestResponse());
        GetRestaurantsResponse response = null;
        try {
            String json = FileUtils.readFileToString(new File("src/main/resources/mock/GetRestaurantsResponse.json"),
                                                     Charset.defaultCharset());
            response = objectMapper.readValue(json, new TypeReference<GetRestaurantsResponse>() { });
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return Mono.just(response);
    }

}
