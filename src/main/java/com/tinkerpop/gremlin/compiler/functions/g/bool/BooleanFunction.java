package com.tinkerpop.gremlin.compiler.functions.g.bool;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BooleanFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "boolean";


    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() == 1) {
            Object object = parameters.get(0).compute().getValue();
            if (object instanceof Number) {
                if (((Number) object).doubleValue() > 0)
                    return new Atom<Boolean>(true);
                else
                    return new Atom<Boolean>(false);
            } else
                return new Atom<Boolean>(Boolean.parseBoolean(object.toString()));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}