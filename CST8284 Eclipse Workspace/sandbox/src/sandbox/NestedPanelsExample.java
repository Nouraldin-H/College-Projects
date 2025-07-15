package sandbox;

import javax.swing.*;
import java.awt.*;

public class NestedPanelsExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Nested Panels Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the top panel
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.RED);
        topPanel.setPreferredSize(new Dimension(400, 50));

        // Create the left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.GREEN);
        leftPanel.setPreferredSize(new Dimension(100, 200));

        // Create the right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLUE);
        rightPanel.setPreferredSize(new Dimension(100, 200));

        // Create the bottom panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.YELLOW);
        bottomPanel.setPreferredSize(new Dimension(400, 50));

        // Add buttons to the panels
        JButton topLeftButton = new JButton("Top Left");
        topPanel.add(topLeftButton);

        JButton bottomLeftButton = new JButton("Bottom Left");
        leftPanel.add(bottomLeftButton);

        JButton topRightButton = new JButton("Top Right");
        rightPanel.add(topRightButton);

        JButton bottomRightButton = new JButton("Bottom Right");
        bottomPanel.add(bottomRightButton);

        // Add the panels to the main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Set the frame visible
        frame.setVisible(true);
    }
}
