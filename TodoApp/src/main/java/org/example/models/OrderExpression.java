package org.example.models;

public class OrderExpression {
    private final String propertyName;
    private final OrderType orderType;

    public OrderExpression(String propertyName, OrderType orderType) {
        this.propertyName = propertyName;
        this.orderType = orderType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public OrderType getOrderType() {
        return orderType;
    }
}
