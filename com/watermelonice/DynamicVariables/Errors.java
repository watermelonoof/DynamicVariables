package com.watermelonice.DynamicVariables;

public enum Errors {
    EMPTY_LIST("List cannot be empty."),
    LENGTH_OF_LIST("Length of both lists must be the same."),
    VAR_NOT_EXIST("Variable does not exsit."),
    OLD_VAR_NOT_EXIST("Old variable does not exist.");

    private final String errMsg;

    private Errors (String errMsg) {
        this.errMsg = errMsg;
    }

    public String getMessage() {
        return errMsg;
    }
}
