package org.deliveroo.cronexpressionparser.fields;

public class Hour extends Base {
    public Hour(String expression) {
        super(expression);
        this.min = 0;
        this.max = 23;
    }
}
