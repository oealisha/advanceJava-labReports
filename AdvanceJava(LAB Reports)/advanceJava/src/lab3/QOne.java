package lab3;

import java.awt.*;
import java.awt.event.*;

public class QOne extends Frame implements MouseListener {
    Label label;

    public QOne() {
        // Set layout manager
        setLayout(new FlowLayout());

        // Initialize label
        label = new Label("Mouse Event Handler");

        // Add label to frame
        add(label);

        // Add mouse listener to the frame
        addMouseListener(this);

        // Set frame properties
        setTitle("Mouse Event Example");
        setSize(400, 200);
        setVisible(true);

        // Close the window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    // MouseListener methods
    public void mouseEntered(MouseEvent me) {
        label.setText("Mouse Entered");
    }

    public void mouseClicked(MouseEvent me) {
        label.setText("Mouse Clicked");
    }

    public void mouseExited(MouseEvent me) {
        label.setText("Mouse Exited");
    }

    public void mousePressed(MouseEvent me) {
        // Optional: Handle mouse pressed event
    }

    public void mouseReleased(MouseEvent me) {
        // Optional: Handle mouse released event
    }

    public static void main(String[] args) {
        new QOne();
    }
}
