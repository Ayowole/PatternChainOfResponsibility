package com.ayowole.chainofresponsibility;

class DiscountAboveThreeItems extends AbstractDiscount {
    
    @Override
    public Budget doDiscount(Budget budget) {
        if (budget.getTotalItems() > 3) {
            double value = budget.getGrossValue() * 0.15;
            budget.addDiscountValue(value);
            
            System.out.println("budget receive discount above three items: " + value);
        }
        
        return super.hasMoreDiscount() ? super.nextDiscount.doDiscount(budget) : budget;
    }

    @Override
    public void setNextDiscount(AbstractDiscount nextDiscount) {
        super.nextDiscount = nextDiscount;
    }
    
}
