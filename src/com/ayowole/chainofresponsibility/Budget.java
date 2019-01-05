package com.ayowole.chainofresponsibility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Budget {

    private List<Double> items;
    private List<Double> totalDiscount;
    
    public Budget() {
        items = new ArrayList<>();
        totalDiscount = new ArrayList<>();
    }
    
    public void addValue(double value) {
        this.items.add(value);
    }
    
    public void addDiscountValue(double value) {
        this.totalDiscount.add(value);
    }
    
    public double getAnItemWithTheLowerValue() {
        return Collections.min(items).doubleValue();
    }

    public double getGrossValue() {
        return items
                .stream()
                .collect( Collectors
                        .summarizingDouble( n -> Double.valueOf(n) ))
                .getSum();
    }
    
    public double getDiscountValue() {
        return totalDiscount
                .stream()
                .collect( Collectors
                        .summarizingDouble( (d) -> Double.valueOf(d) ))
                .getSum();
    }
    
    public int getTotalItems() {
        return items.size();
    }
    
    public double getNetValue() {
        return getGrossValue() - getDiscountValue();
    }
    
}
