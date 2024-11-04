package AB.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.awt.image.*;

public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {
    private Stack<List<PaintPoint>> lines = new Stack<>();
    private List<PaintPoint> currentLine = new ArrayList<>();
    private Color currentColor;
    private int currentBrushSize;
    private BufferedImage canvas;

    public class PaintPoint extends Point {
        private Color color;
        private int brushSize;

        public PaintPoint(int x, int y, Color color, int brushSize) {
            super(x, y);
            this.color = color;
            this.brushSize = brushSize;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public int getBrushSize() {
            return brushSize;
        }

        public void setBrushSize(int brushSize) {
            this.brushSize = brushSize;
        }
    }

    public DrawingPanel(int WIDTH, int HEIGHT) {
        currentBrushSize = 5;
        currentColor = Color.BLACK;
        canvas = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = canvas.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g2d.dispose();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    private void drawLines(Graphics2D g2d) {
        for (List<PaintPoint> line : lines) {
            for (int i = 1; i < line.size(); i++) {
                PaintPoint point = line.get(i - 1);
                PaintPoint nextPoint = line.get(i);
                g2d.setColor(point.getColor());
                g2d.setStroke(new BasicStroke(point.getBrushSize(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2d.drawLine(point.x, point.y, nextPoint.x, nextPoint.y);
            }
        }
        for (int i = 1; i < currentLine.size(); i++) {
            PaintPoint point = currentLine.get(i - 1);
            PaintPoint nextPoint = currentLine.get(i);
            g2d.setColor(point.getColor());
            g2d.setStroke(new BasicStroke(point.getBrushSize(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawLine(point.x, point.y, nextPoint.x, nextPoint.y);
        }
    }

    private void redrawCanvas() {
        Graphics2D g2d = canvas.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g2d.dispose();
        g2d = canvas.createGraphics();
        drawLines(g2d);
        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        currentLine.add(new PaintPoint(e.getX(), e.getY(), currentColor, currentBrushSize));

        Graphics2D g2d = canvas.createGraphics();
        drawLines(g2d);
        g2d.dispose();

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        lines.push(currentLine);
        currentLine = new ArrayList<>();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void undo(){
        if (!lines.isEmpty()) {
            lines.pop();
            redrawCanvas();
            repaint();
        }
    }

    public void setColor(Color color) {
        currentColor = color;
    }

    public Color getColor() {
        return currentColor;
    }

    public void setBrushSize(int size) {
        currentBrushSize = size;
    }

    public int getBrushSize() {
        return currentBrushSize;
    }

    public BufferedImage getImage() {
        BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.drawImage(canvas, 0, 0, null);
        g2d.dispose();
        return image;
    }

    public void loadImage(BufferedImage loadedImage){
        lines.clear();
        currentLine = new ArrayList<>();
        currentBrushSize = 5;
        currentColor = Color.BLACK;
        Graphics2D g2d = canvas.createGraphics();
        g2d.drawImage(loadedImage, 0, 0, null);
        g2d.dispose();
        repaint();
    }
}
