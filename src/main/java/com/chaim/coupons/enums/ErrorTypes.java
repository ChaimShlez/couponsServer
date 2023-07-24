package com.chaim.coupons.enums;

public enum ErrorTypes {
    GENERAL_ERROR(600, " There seems to be a problem, please try again later ", true),
    INVALID_PRICE(601, "Invalid price ,please try another one", false),
    INVALID_START_DATE(602, "The start date of the promotion after is end", false),
    INVALID_PASSWORD(603,"invalid password ,please try another one " ,false ),
    PASSWORD_IS_NULL(604,"The password is null,please try anther one " ,false ),
    INVALID_USER_NAME(605, "Invalid user name ,please try another one ",false ),
    USER_NAME_IS_NULL(606,"The user name is null,please try another one" ,false ),
    INVALID_PHONE_NUMBER(607,"Invalid phone number,please try another one " ,false ),
    COMPANY_NAME_ALREADY_EXIST(609," The company name already exist ,please enter another name " ,false ),
    USER_ALREADY_EXIST(610,"The user name already exist,please enter another user name  " , false),
    USER_NAME_ALREADY_EXIST(611," The user name already exist ",false ),
    INVALID_ADDRESS(612, "Invalid address ,please try another one ",false ),
    ADDRESS_IS_NULL(613,"The address is null please try anther one " ,false ),
    LOGIN_FAILURE(614,"Login failure,user name or password wrong ", false),
    INVALID_CATEGORY_NAME(615,"Invalid name ,please try anther one " ,false ),
    PHONE_NUMBER_IS_NULL(616, "The phone number is null,please try another one ",false ),
    COMPANY_NAME_IS_NULL(617,"The company name is null " ,false ),
    CATEGORY_NAME_IS_NULL(618,"The category name s null " ,false ),
    COUPON_NAME_ALREADY_EXIST(619," The coupon name already exist ,please enter another name " ,false );





    private int errorNumber;
    private String errorMessage;
    private boolean isShowStackTrace;

    ErrorTypes(int errorNumber, String errorMessage, boolean isShowStackTrace) {
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
        this.isShowStackTrace = isShowStackTrace;
    }

    ErrorTypes(int errorNumber, String errorMessage) {
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
    }

    ErrorTypes(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(int errorNumber) {
        this.errorNumber = errorNumber;
    }

    public boolean isShowStackTrace() {
        return isShowStackTrace;
    }
}
