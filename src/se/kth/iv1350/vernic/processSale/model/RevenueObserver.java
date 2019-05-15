package se.kth.iv1350.vernic.processSale.model;

/**
 * Revenue observer interface used for observer pattern
 */
public interface RevenueObserver {

    void newRevenue(double revenue);
}
