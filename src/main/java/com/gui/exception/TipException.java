package com.gui.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Administrator on 2017/6/15.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class TipException extends RuntimeException {

    private String errMsg;
    private int code;

    public TipException() {
        super();
    }

    public TipException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

    public TipException(String errMsg, int code) {
        super(errMsg);
        this.errMsg = errMsg;
        this.code = code;
    }


}
