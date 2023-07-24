package com.chaim.coupons.exceptions;

import com.chaim.coupons.dto.ErrorBean;
import com.chaim.coupons.enums.ErrorTypes;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionsHandler {
    //	Response - Object in Spring
    @ExceptionHandler
    @ResponseBody
    // Variable name is throwable in order to remember that it handles Exception and Error
    public ErrorBean toResponse(Throwable throwable, HttpServletResponse response) {

        //	ErrorBean errorBean;
        if(throwable instanceof ServerException) {

            ServerException appException = (ServerException) throwable;

            ErrorTypes errorType = appException.getErrorType();
            int errorCode = errorType.getErrorNumber();
            String errorMessage = errorType.getErrorMessage();
           // String errorName = errorType.getErrorName();
            response.setStatus(errorCode);

            if(appException.getErrorType().isShowStackTrace()) {
                appException.printStackTrace();
            }

            ErrorBean errorBean = new ErrorBean(errorCode,errorMessage);


            return errorBean;
        }

        response.setStatus(600);

        String errorMessage = throwable.getMessage();
        ErrorBean errorBean = new ErrorBean(601, "General error");
        throwable.printStackTrace();

        return errorBean;
    }

}

