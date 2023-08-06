package org.deliveroo.cronexpressionparser.fields;

public class Weekday extends Base {
    public Weekday(String expression) {
        super(expression);
        this.min = 0;
        this.max = 6;
    }
}
