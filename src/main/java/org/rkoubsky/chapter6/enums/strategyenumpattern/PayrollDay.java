package org.rkoubsky.chapter6.enums.strategyenumpattern;

import java.math.BigDecimal;

/**
 * The strategy enum pattern.
 * <p>
 * Consider the strategy enum pattern if multiple enum
 * constants share common behaviors
 * (Mo - Fri are weekdays -> first common behavior represented by {@link PayType#WEEKDAY}, Sat - Sun are weekend days -> second
 * common behavior represented by {@link PayType#WEEKEND}).
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public enum PayrollDay {
    MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY), FRIDAY(
            PayType.WEEKDAY), SATURDAY(
            PayType.WEEKEND), SUNDAY(PayType.WEEKEND);
    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    public BigDecimal pay(BigDecimal hoursWorked, BigDecimal payRate) {
        return payType.pay(hoursWorked, payRate);
    }

    /**
     * The strategy enum type.
     */
    private enum PayType {
        WEEKDAY {
            @Override
            public BigDecimal overtimePay(BigDecimal hoursWorked, BigDecimal payRate) {
                return hoursWorked.compareTo(HOURS_PER_SHIFT) <= 0 ? BigDecimal.ZERO : hoursWorked
                        .subtract(HOURS_PER_SHIFT).multiply(payRate).divide(BigDecimal.valueOf(2));
            }
        }, WEEKEND {
            @Override
            public BigDecimal overtimePay(BigDecimal hoursWorked, BigDecimal payRate) {
                return hoursWorked.multiply(payRate).divide(BigDecimal.valueOf(2));
            }
        };
        private static final BigDecimal HOURS_PER_SHIFT = new BigDecimal("8");

        public abstract BigDecimal overtimePay(BigDecimal hoursWorked, BigDecimal payRate);

        public BigDecimal pay(BigDecimal hoursWorked, BigDecimal payRate) {
            BigDecimal basePay = hoursWorked.multiply(payRate);
            return basePay.add(overtimePay(hoursWorked, payRate));
        }
    }
}
