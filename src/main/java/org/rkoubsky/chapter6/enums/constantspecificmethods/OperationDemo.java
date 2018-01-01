package org.rkoubsky.chapter6.enums.constantspecificmethods;

import java.math.BigDecimal;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class OperationDemo {
    public static void main(String[] args) {
        BigDecimal x = new BigDecimal("8");
        BigDecimal y = new BigDecimal("2");
        for (Operation operation : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
        }

        System.out.println("Testing fromString method:");
        System.out.printf("The constant name returned from Operation.fromString('+'): %s",
                Operation.fromString("+").name());
    }
}
