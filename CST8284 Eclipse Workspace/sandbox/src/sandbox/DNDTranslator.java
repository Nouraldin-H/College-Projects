package sandbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class DNDTranslator extends JFrame {
    private JTextField inputField;
    private JTextField translationInputField;
    private JLabel outputLabel;

    private Map<String, String> translationMap;

    public DNDTranslator() {
        setTitle("D&D Translator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        translationMap = createTranslationMap();

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("D&D Translator");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel inputPanel = new JPanel();
        inputField = new JTextField(20);
        translationInputField = new JTextField(20);
        JButton translateToDNDButton = new JButton("Translate to D&D");
        JButton translateToCommonButton = new JButton("Translate to Common");
        TranslateButtonListener translateButtonListener = new TranslateButtonListener();
        translateToDNDButton.addActionListener(translateButtonListener);
        translateToCommonButton.addActionListener(translateButtonListener);

        inputPanel.add(inputField);
        inputPanel.add(translateToDNDButton);
        inputPanel.add(translationInputField);
        inputPanel.add(translateToCommonButton);

        outputLabel = new JLabel();

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(outputLabel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private Map<String, String> createTranslationMap() {
        Map<String, String> translationMap = new HashMap<>();
        // Add translation mappings here
        translationMap.put("hello", "greetings");
        translationMap.put("monster", "beast");
        translationMap.put("sword", "blade");
        // Add reverse translations as well
        translationMap.put("greetings", "hello");
        translationMap.put("beast", "monster");
        translationMap.put("blade", "sword");
        return translationMap;
    }

    private class TranslateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonText = ((JButton) e.getSource()).getText();

            if (buttonText.equals("Translate to D&D")) {
                String inputText = inputField.getText().toLowerCase();
                String translatedText = translationMap.getOrDefault(inputText, "Translation not found.");
                outputLabel.setText("Translated text: " + translatedText);
                translationInputField.setText(translatedText);
            } else if (buttonText.equals("Translate to Common")) {
                String inputText = translationInputField.getText().toLowerCase();
                String originalText = getOriginalText(inputText);
                outputLabel.setText("Original text: " + originalText);
                inputField.setText(originalText);
            }
        }

        private String getOriginalText(String translatedText) {
            for (Map.Entry<String, String> entry : translationMap.entrySet()) {
                if (entry.getValue().equals(translatedText)) {
                    return entry.getKey();
                }
            }
            return "Translation not found.";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DNDTranslator().setVisible(true);
            }
        });
    }
}

