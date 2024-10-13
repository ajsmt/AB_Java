import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SeriesRadioButtons extends JPanel {
    private JRadioButton linear;
    private JRadioButton exponential;

    public SeriesRadioButtons() {
        JLabel seriesVariation = new JLabel("Select series variation:");
        linear = new JRadioButton("Linear");
        exponential = new JRadioButton("Exponential");

        linear.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(linear);
        group.add(exponential);

        this.add(seriesVariation);
        this.add(linear);
        this.add(exponential);
    }

    public String getSelectedOption() {
        if (linear.isSelected()) {
            return "Linear";
        } else if (exponential.isSelected()) {
            return "Exponential";
        }
        return null;
    }
}