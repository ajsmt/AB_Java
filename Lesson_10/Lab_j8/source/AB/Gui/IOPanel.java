package AB.Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class IOPanel extends JPanel{
    private JButton saveButton;
    private JButton openButton;
    private DrawingPanel drawingPanel;
    private JFrame parentFrame;

    public IOPanel(JFrame parentFrame, DrawingPanel drawingPanel){
        this.parentFrame = parentFrame;
        this.drawingPanel = drawingPanel;
        setLayout(new GridLayout(1, 2));
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveImage();
            }
        });
        add(saveButton);
        openButton = new JButton("Open");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openImage();
            }
        });
        add(openButton);
    }

    private void saveImage() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = chooser.showSaveDialog(parentFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                BufferedImage image = drawingPanel.getImage();
                ImageIO.write(image, "png", file);
                JOptionPane.showMessageDialog(parentFrame, "Image saved successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(parentFrame, "Error saving image: " + ex.getMessage());
            }
        }
    }

    private void openImage() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = chooser.showOpenDialog(parentFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                BufferedImage image = ImageIO.read(file);
                drawingPanel.loadImage(image);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(parentFrame, "Error opening image: " + ex.getMessage());
            }
        }
    }
}
