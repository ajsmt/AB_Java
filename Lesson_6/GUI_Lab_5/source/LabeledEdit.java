import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class LabeledEdit extends JPanel {
    private JLabel label;
    private JTextField textField;

    public LabeledEdit(String labelText) {
        this.label = new JLabel(labelText);
        this.textField = new JTextField(10); 
        add(label);
        add(textField);
    }
    public LabeledEdit(String labelText, String initialText) {
        this(labelText);
        this.textField.setText(initialText); 
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
    }
}
