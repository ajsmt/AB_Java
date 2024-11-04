package AB.Gui;

import javax.swing.*;

import java.awt.*;

public class MyFrame extends JFrame{
    private final int WIDTH = 700;
    private final int HEIGHT = 500;
    private DrawingPanel drawingPanel;
    private ControlsPanel controlsPanel;
    private IOPanel iopPanel;

    public MyFrame(String title) {
        super(title);

        setResizable(false);
        setLayout(new BorderLayout());
        
        drawingPanel = new DrawingPanel(WIDTH, HEIGHT);
        drawingPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        iopPanel = new IOPanel(this, drawingPanel);
        iopPanel.setPreferredSize(new Dimension(WIDTH, 30));
        
        controlsPanel = new ControlsPanel(drawingPanel);
        controlsPanel.setPreferredSize(new Dimension(WIDTH, 70));
                
        add(iopPanel, BorderLayout.NORTH);
        add(new JScrollPane(drawingPanel), BorderLayout.CENTER);
        add(controlsPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
