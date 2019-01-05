package com.ayowole.chainofresponsibility;

class DiscountAboveOneHundred extends AbstractDiscount {

    @Override
    public Budget doDiscount(Budget budget) {
        if (budget.getGrossValue() > 100) {
            double value = budget.getGrossValue() * 0.1;
            budget.addDiscountValue(value);
            
            System.out.println("budget receive discount above one hundred: " + value);
        }
        
        return hasMoreDiscount() ? super.nextDiscount.doDiscount(budget) : budget;
    }

    @Override
    public void setNextDiscount(AbstractDiscount nextDiscount) {
        super.nextDiscount = nextDiscount;
    }

}
