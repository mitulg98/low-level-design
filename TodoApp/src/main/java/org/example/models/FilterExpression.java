package org.example.models;

public class FilterExpression {
    private final String propertyName;
    private final Operator operator;
    private final String value;

    public FilterExpression(String propertyName, Operator operator, String value) {
        this.propertyName = propertyName;
        this.operator = operator;
        this.value = value;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getValue() {
        return value;
    }
}
