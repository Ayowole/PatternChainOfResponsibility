package com.ayowole.chainofresponsibility;

class Main {
    
    public static void main(String[] args) {
        Budget budget = new Budget();
        budget.addValue(2.50);
        budget.addValue(5.25);
        budget.addValue(10.00);
        budget.addValue(5.00);
        
        AbstractDiscount d1 = new DiscountAboveOneHundred();
        AbstractDiscount d2 = new DiscountAboveThreeItems();
        AbstractDiscount d3 = new DiscountOnLowestValueItem();
        
        d2.setNextDiscount(d3);
        d1.setNextDiscount(d2);
        
        Budget returnedBudget = d1.doDiscount(budget);
        
        System.out.println(returnedBudget.getTotalItems());
        System.out.println(returnedBudget.getGrossValue());
        System.out.println(returnedBudget.getDiscountValue());
        System.out.println(returnedBudget.getNetValue());
    }
    
}