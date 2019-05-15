package se.kth.iv1350.vernic.processSale.view;

import se.kth.iv1350.vernic.processSale.model.RevenueObserver;

import javax.swing.*;
import java.awt.*;

/**
 *Gui display for showing the total revenue
 */
public class TotalRevenueView implements RevenueObserver {
    private JLabel revenueLabel = new JLabel("", SwingConstants.CENTER);
    private double totalRevenue;

    /**
     * Connects to the revenueView display and shows the initial revenue number <code>zero</code>.
     */
    public TotalRevenueView() {
        totalRevenue = 0;
        contactDisplay();
        showTotalRevenue(totalRevenue);
    }

    /**
     * Displays the specified revenue.
     *
     * @param revenue The revenue to display
     */
    private void showTotalRevenue(double revenue) {
        revenueLabel.setText(Double.toString(revenue));
    }

    private void contactDisplay() {
        JWindow frame = new JWindow();
        Font labelFont = new Font(Font.SERIF, Font.BOLD, 50);
        revenueLabel.setFont(labelFont);
        frame.getContentPane().setBackground(Color.BLACK);
        revenueLabel.setForeground(Color.WHITE);
        frame.getContentPane().add(revenueLabel);
        frame.setBounds(0, 0, 200, 80);
        frame.setVisible(true);
    }

    /**
     * adds the new revenue to the total and displays it
     */
    @Override
    public void newRevenue(double revenue) {
        totalRevenue = totalRevenue + revenue;
        showTotalRevenue(totalRevenue);
    }
}
