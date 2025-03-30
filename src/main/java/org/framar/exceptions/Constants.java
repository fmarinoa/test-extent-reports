package org.framar.exceptions;

public class Constants {
    private Constants() {
        throw new ConstantException();
    }

    protected static final String UTIL_CLASS = "This class is a utility";
    protected static final String CONSTANT_CLASS = "This class is a constants";
}
