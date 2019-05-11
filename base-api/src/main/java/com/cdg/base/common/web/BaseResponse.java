package com.cdg.base.common.web;

import com.cdg.base.common.exception.BaseExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class BaseResponse {

    private Header header;

    public BaseResponse() {
        this.header = new Header();
    }

    public BaseResponse(BaseExceptionCode ex) {
        this.header = new Header(ex.getCode(), ex.getMessage(), false);
    }

    public BaseResponse(int resultCode, String resultMessage, Boolean isSuccessful) {
        this.header = new Header(resultCode, resultMessage, isSuccessful);
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header {

        private int resultCode = 0;
        private String resultMessage = "";
        private Boolean isSuccessful = true;

    }

}
