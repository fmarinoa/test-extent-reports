package org.framar.exceptions;

import static org.framar.exceptions.Constants.UTIL_CLASS;

public class UtilException extends IllegalArgumentException {
    public UtilException() {
        super(UTIL_CLASS);
    }
}
