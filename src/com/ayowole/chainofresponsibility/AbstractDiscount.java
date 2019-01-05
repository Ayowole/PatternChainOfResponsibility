package com.ayowole.chainofresponsibility;

import java.util.Objects;

abstract class AbstractDiscount {
    
    protected AbstractDiscount nextDiscount;
    
    protected boolean hasMoreDiscount() {
        return !Objects.isNull(nextDiscount);
    }
    
    public abstract Budget doDiscount(Budget budget);
    public abstract void setNextDiscount(AbstractDiscount discount);
    
}
