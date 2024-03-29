package org.deliveroo.cronexpressionparser.selectors;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public abstract class Base {
    protected static final String ANY = "*";
    protected static final String LIST = ",";
    protected static final String STEP = "/";
    protected static final String RANGE = "-";
    protected static final String EXACT = "e";
    private static final Map<String, Class> expressionSelectorMap = Map.of(
            ANY, Any.class,
            LIST, Values.class,
            STEP, Step.class,
            RANGE, Range.class,
            EXACT, Exact.class
    );
    protected org.deliveroo.cronexpressionparser.fields.Base field;

    public Base(org.deliveroo.cronexpressionparser.fields.Base field) {
        this.field = field;
    }

    public static Base get(org.deliveroo.cronexpressionparser.fields.Base field)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String selector = null;
        if (field.getExpression().equals(ANY)) selector = ANY;
        if (field.getExpression().matches(".*,.*")) selector = LIST;
        if (field.getExpression().matches("[0-9]+-[0-9]+")) selector = RANGE;
        if (field.getExpression().matches(".*\\/.*")) selector = STEP;
        if (field.getExpression().matches("^[0-9]+$")) selector = EXACT;

        if (selector == null) throw new RuntimeException("Invalid field expression : " + field.getExpression());

        return (Base) expressionSelectorMap
                .get(selector)
                .getDeclaredConstructor(org.deliveroo.cronexpressionparser.fields.Base.class).newInstance(field);
    }

    public abstract java.util.List<Integer> generatePossibilities();
}
