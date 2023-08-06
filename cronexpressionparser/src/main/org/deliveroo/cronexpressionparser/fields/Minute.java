package org.deliveroo.cronexpressionparser.fields;

public class Minute extends Base {
    public Minute(String expression) {
        super(expression);
        this.min = 0;
        this.max = 59;
    }
}
