import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Map;

public class Variable implements Segment {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (other !=  null && other.getClass() == this.getClass()) {
            Variable variable = (Variable) other;
            if (variable.name == null || name == null) {
                return false;
            } else {
                return name.equals(variable.name);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).toHashCode();
    }

    public String evaluate(Map<String, String> variables) {
        if (!variables.containsKey(name)){
            throw new MissingValueException("No value for ${" + name + "}");
        }
        return variables.get(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
