package org.framar.exceptions;

import static org.framar.exceptions.Constants.CONSTANT_CLASS;

public class ConstantException extends IllegalArgumentException {
    public ConstantException() {
        super(CONSTANT_CLASS);
    }
}
