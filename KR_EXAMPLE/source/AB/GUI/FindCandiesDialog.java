package AB.GUI;

import AB.Gift.*;
import AB.Sweets.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.function.Predicate;
import java.util.List;

public class FindCandiesDialog extends JDialog {
    private Gift inputGift;
    private Gift outputGift;
    private JComboBox<String> criteriaComboBox;
    private JComboBox<String> signComboBox;
    private JButton applyButton;
    private JTextField criteriaField;

    public FindCandiesDialog(JFrame parent, Gift inputGift, Gift outputGift) throws Exception {
        super(parent, "Find Gift", true);

        this.inputGift = inputGift;
        this.outputGift = outputGift;

        setLayout(new BorderLayout());

        String[] criteria = {"Name", "Sugar", "Price", "Weight"};
        criteriaComboBox = new JComboBox<>(criteria);
        String[] signs = {">", "<", ">=", "<=", "="};
        signComboBox = new JComboBox<>(signs);
        
        
        JPanel contentPanel = new JPanel();
        contentPanel.add(criteriaComboBox);
        contentPanel.add(signComboBox);

        criteriaField = new JTextField(10);
        contentPanel.add(criteriaField);
        
        add(contentPanel, BorderLayout.CENTER);
        
        applyButton = new JButton("Apply");
        
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String criteria = (String) criteriaComboBox.getSelectedItem();
                String sign = (String) signComboBox.getSelectedItem();
                String value = criteriaField.getText();

                Predicate<Candy> predicate = null;
                switch (criteria) {
                    case "Name":
                        predicate = candy -> candy.getName().equals(value);
                        break;
                    case "Sugar":
                        double sugarValue = Double.parseDouble(value);
                        switch (sign) {
                            case ">":
                                predicate = candy -> candy.getSugarAmount() > sugarValue;
                                break;
                            case "<":
                                predicate = candy -> candy.getSugarAmount() < sugarValue;
                                break;
                            case ">=":
                                predicate = candy -> candy.getSugarAmount() >= sugarValue;
                                break;
                            case "<=":
                                predicate = candy -> candy.getSugarAmount() <= sugarValue;
                                break;
                            case "=":
                                predicate = candy -> candy.getSugarAmount() == sugarValue;
                                break;
                        }
                        break;
                    case "Price":
                        double priceValue = Double.parseDouble(value);
                        switch (sign) {
                            case ">":
                                predicate = candy -> candy.getPrice() > priceValue;
                                break;
                            case "<":
                                predicate = candy -> candy.getPrice() < priceValue;
                                break;
                            case ">=":
                                predicate = candy -> candy.getPrice() >= priceValue;
                                break;
                            case "<=":
                                predicate = candy -> candy.getPrice() <= priceValue;
                                break;
                            case "=":
                                predicate = candy -> candy.getPrice() == priceValue;
                                break;
                        }
                        break;
                    case "Weight":
                        double weightValue = Double.parseDouble(value);
                        switch (sign) {
                            case ">":
                                predicate = candy -> candy.getWeight() > weightValue;
                                break;
                            case "<":
                                predicate = candy -> candy.getWeight() < weightValue;
                                break;
                            case ">=":
                                predicate = candy -> candy.getWeight() >= weightValue;
                                break;
                            case "<=":
                                predicate = candy -> candy.getWeight() <= weightValue;
                                break;
                            case "=":
                                predicate = candy -> candy.getWeight() == weightValue;
                                break;
                        }
                        break;
                }

                List<Candy> result = inputGift.findCandiesByPredicate(predicate);
                outputGift.clearGift();
                outputGift.setCandies(result);

                dispose();
            }
        });
        
        contentPanel.add(applyButton);
        
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}