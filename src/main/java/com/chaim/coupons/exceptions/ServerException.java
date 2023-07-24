package com.chaim.coupons.exceptions;

import com.chaim.coupons.enums.ErrorTypes;


public class ServerException  extends Exception{
    private ErrorTypes errorTypes;

    public ServerException(ErrorTypes errorTypes, String message) {
        super(errorTypes.getErrorMessage()+","+ message);
        this.errorTypes = errorTypes;
    }

    public ServerException(ErrorTypes errorTypes, String message, Exception e) {
        super(errorTypes.getErrorMessage()+","+ message, e);
        this.errorTypes = errorTypes;
    }

    public ErrorTypes getErrorType() {
        return errorTypes;
    }
}
