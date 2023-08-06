package org.deliveroo.cronexpressionparser.fields;

public class Day extends Base {
    public Day(String expression) {
        super(expression);
        this.min = 0;
        this.max = 31;
    }
}
