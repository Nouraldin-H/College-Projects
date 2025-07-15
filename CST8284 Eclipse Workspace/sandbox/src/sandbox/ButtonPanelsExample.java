package sandbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanelsExample {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Button Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JButton button1 = new JButton("Button 1");
        button1.setPreferredSize(new Dimension(100, 30));
        panel.add(button1, BorderLayout.NORTH);

        JButton button2 = new JButton("Button 2");
        button2.setPreferredSize(new Dimension(150, 50));
        panel.add(button2, BorderLayout.SOUTH);

        JButton button3 = new JButton("Button 3");
        button3.setPreferredSize(new Dimension(200, 70));
        panel.add(button3, BorderLayout.WEST);

        JButton button4 = new JButton("Button 4");
        button4.setPreferredSize(new Dimension(250, 90));
        panel.add(button4, BorderLayout.EAST);

        // ActionListener for Button 1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextArea textArea = new JTextArea("This is a sample message with a long text to demonstrate manual resizing based on the length of the content.");
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 200));

                int result = JOptionPane.showOptionDialog(frame, scrollPane, "Message", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);

                if (result == JOptionPane.OK_OPTION) {
                    String enteredText = textArea.getText();
                    System.out.println("Entered text: " + enteredText);
                }
            }
        });

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
