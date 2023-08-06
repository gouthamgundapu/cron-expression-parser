package org.deliveroo.cronexpressionparser.selectors;

import org.deliveroo.cronexpressionparser.fields.Base;
import org.deliveroo.cronexpressionparser.fields.Minute;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StepTest {

    @Test
    public void testStepParserPossibilities()
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Base m = new Minute("*/15");
        assertEquals(m.parse(), List.of(0, 15, 30, 45));
    }

    @Test
    public void testStepWithMissingValues() {
        Base m = new Minute("*/");
        RuntimeException exp = assertThrows(RuntimeException.class, () -> {
            m.parse();
        });
        assertEquals(exp.getMessage(), "Step does not have valid expression : */");
    }

    @Test
    public void testStepWithInvalidStepStart() {
        Base m = new Minute("a/15");
        RuntimeException exp = assertThrows(RuntimeException.class, () -> {
            m.parse();
        });
        assertEquals(exp.getMessage(), "Step does not have valid expression : a/15");
    }

    @Test
    public void testStepWithWrongStepStart() {
        Base m = new Minute("60/15");
        RuntimeException exp = assertThrows(RuntimeException.class, () -> {
            m.parse();
        });
        assertEquals(exp.getMessage(), "Step start is more than maximum value");
    }

    @Test
    public void testStepWithWrongStepValue() {
        Base m = new Minute("*/60");
        RuntimeException exp = assertThrows(RuntimeException.class, () -> {
            m.parse();
        });
        assertEquals(exp.getMessage(), "Step size is more than maximum value");
    }
}
