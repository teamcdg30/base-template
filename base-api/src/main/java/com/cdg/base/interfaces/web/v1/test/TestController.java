package com.cdg.base.interfaces.web.v1.test;

import com.cdg.base.interfaces.web.v1.test.vo.GetTestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @ApiOperation(value = "테스트 목록 조회")
    @CrossOrigin
    @GetMapping("/base/v1/tests")
    public Mono<GetTestResponse> getServiceGnbHierarchy() {
        return Mono.just(new GetTestResponse());
    }

}
