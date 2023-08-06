package org.deliveroo.cronexpressionparser.fields;

public class Month extends Base {
    public Month(String expression) {
        super(expression);
        this.min = 1;
        this.max = 12;
    }
}
