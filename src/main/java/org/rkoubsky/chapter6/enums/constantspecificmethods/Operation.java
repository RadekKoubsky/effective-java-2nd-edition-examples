package org.rkoubsky.chapter6.enums.constantspecificmethods;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public enum Operation {
    PLUS("+") {
        @Override
        public BigDecimal apply(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    },
    MINUS("-") {
        @Override
        public BigDecimal apply(BigDecimal x, BigDecimal y) {
            return x.subtract(y);
        }
    },
    TIMES("*") {
        @Override
        public BigDecimal apply(BigDecimal x, BigDecimal y) {
            return x.multiply(y);
        }
    },
    DIVIDE("/") {
        @Override
        public BigDecimal apply(BigDecimal x, BigDecimal y) {
            return x.divide(y);
        }
    };
    private static final Map<String, Operation> stringToEnum = new HashMap<>();
    private final String symbol;

    static {
        // Initialize map from constant name to enum constant
        for (Operation op: Operation.values()) {
            stringToEnum.put(op.toString(), op);
        }
    }

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract BigDecimal apply(BigDecimal x, BigDecimal y);

    @Override
    public String toString() {
        return symbol;
    }

    // Returns Operation for string, or null if string is invalid
    public static Operation fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

}
