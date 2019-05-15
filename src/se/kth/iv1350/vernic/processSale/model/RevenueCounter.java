package se.kth.iv1350.vernic.processSale.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Counts revenue
 */
public class RevenueCounter {

    private List<RevenueObserver> revenueObservers = new ArrayList<>();
    private double lastRevenue;

    /**
     * adds revenueObservers
     * @param revenueObserver the added revenue Observer
     */
    public void addRevenueObserver(RevenueObserver revenueObserver){
        this.revenueObservers.add(revenueObserver);
    }

    /**
     * Sets the last Revenue and notifies the revenueObservers
     * @param revenue the last added revenue
     */
    public void setLastRevenue(double revenue){
        this.lastRevenue = revenue;
        this.notifyRevenueObservers();
    }

    private void notifyRevenueObservers(){
        for(int i=0; i < revenueObservers.size(); i++){
            revenueObservers.get(i).newRevenue(lastRevenue);
        }
    }
}
