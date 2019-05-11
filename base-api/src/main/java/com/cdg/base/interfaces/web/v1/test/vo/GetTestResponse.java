package com.cdg.base.interfaces.web.v1.test.vo;

import com.cdg.base.common.web.BaseResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class GetTestResponse extends BaseResponse {

    private Test test;

    public GetTestResponse() {
        this.test = new Test();
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Test {

        private String name = "test";
        private int count = 5;

    }

}
