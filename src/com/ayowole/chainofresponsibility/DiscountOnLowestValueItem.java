package com.ayowole.chainofresponsibility;

class DiscountOnLowestValueItem extends AbstractDiscount {

    @Override
    public Budget doDiscount(Budget budget) {
        if (!(budget.getTotalItems() > 1)) throw new IllegalArgumentException("The budget hasn't items"); 
        
        double value = budget.getAnItemWithTheLowerValue() * 0.05;
        budget.addDiscountValue(value);
        
        System.out.println("budget receive discount on lower value: " + value);
        
        return super.hasMoreDiscount() ? super.nextDiscount.doDiscount(budget) : budget;
    }

    @Override
    public void setNextDiscount(AbstractDiscount discount) {
        super.nextDiscount = discount;
    }

}
