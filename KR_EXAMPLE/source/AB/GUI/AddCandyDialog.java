package AB.GUI;

import AB.Gift.*;
import AB.Sweets.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCandyDialog extends JDialog {
    private Gift outputGift;
    private JComboBox<String> candyTypeComboBox;
    private JButton addCandyButton;
    private JTextField candyInfoTextField;

    public AddCandyDialog(JFrame parent, Gift outputGift) throws Exception {
        super(parent, "Find Gift", true);

        this.outputGift = outputGift;

        setLayout(new BorderLayout());

        String[] candyType = {"Chocolate bar", "Lollipop"};
        candyTypeComboBox = new JComboBox<>(candyType);
        JPanel contentPanel = new JPanel();
        contentPanel.add(candyTypeComboBox);
        candyInfoTextField = new JTextField(25);
        contentPanel.add(candyInfoTextField);

        add(contentPanel, BorderLayout.CENTER);

        addCandyButton = new JButton("Add Candy");

        addCandyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = (String) candyTypeComboBox.getSelectedItem();
                String candyInfo = candyInfoTextField.getText().trim();
                if(type.equals("Chocolate bar")){
                    try{
                        ChocolateBar chocolateBar = ChocolateBar.parseCandy(candyInfo);
                        outputGift.add(chocolateBar);
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(AddCandyDialog.this, "Error: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if(type.equals("Lollipop")){
                    try{
                        Lollipop lollipop = Lollipop.parseCandy(candyInfo);
                        outputGift.add(lollipop);
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(AddCandyDialog.this, "Error: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        contentPanel.add(addCandyButton);

        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}