package AB.GUI;

import AB.Gift.*;
import AB.Sweets.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Comparator;

public class SortGiftDialog extends JDialog {
    private Gift inputGift;
    private Gift outputGift;
    private JComboBox<String> criteriaComboBox;
    private JComboBox<String> orderComboBox;
    private JButton applyButton;

    public SortGiftDialog(JFrame parent, Gift inputGift, Gift outputGift) throws Exception {
        super(parent, "Sort Gift", true);

        this.inputGift = inputGift;
        this.outputGift = outputGift;

        setLayout(new BorderLayout());

        String[] criteria = {"Name", "Sugar", "Price", "Weight"};
        criteriaComboBox = new JComboBox<>(criteria);
        String[] order = {"Ascending", "Descending"};
        orderComboBox = new JComboBox<>(order);
        
        
        JPanel contentPanel = new JPanel();
        contentPanel.add(new JLabel("Sort by:"));
        contentPanel.add(criteriaComboBox);
        contentPanel.add(new JLabel("Order:"));
        contentPanel.add(orderComboBox);
        
        add(contentPanel, BorderLayout.CENTER);
        
        applyButton = new JButton("Apply");
        
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String criteria = (String) criteriaComboBox.getSelectedItem();
                String order = (String) orderComboBox.getSelectedItem();
                Comparator<Candy> comparator = null;
                switch (criteria) {
                    case "Name":
                        comparator = Comparator.comparing(Candy::getName);
                        break;
                    case "Sugar":
                        comparator = Comparator.comparingDouble(Candy::getSugarAmount);
                        break;
                    case "Price":
                        comparator = Comparator.comparingDouble(Candy::getPrice);
                        break;
                    case "Weight":
                        comparator = Comparator.comparingDouble(Candy::getWeight);
                        break;
                }
                if (order.equals("Descending")) {
                    comparator = comparator.reversed();
                }

                outputGift.clearGift();
                inputGift.copyAllCandiesTo(outputGift);
                outputGift.sortCandies(comparator);

                dispose();
            }
        });
        
        contentPanel.add(applyButton);
        
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}