import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounting extends JFrame {
    private JTextField textField;
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JButton countButton;

    public WordCounting() {
        setTitle("Word Count GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField(30);
        textArea = new JTextArea(15, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        wordCountLabel = new JLabel("Word Count: ");
        countButton = new JButton("Count Words");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Text or File Path:"));
        inputPanel.add(textField);
        inputPanel.add(countButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(wordCountLabel, BorderLayout.SOUTH);

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
    }

    private void countWords() {
        String inputText = textField.getText();
        String resultText = "";
        int wordCount = 0;
        Map<String, Integer> wordFrequency = new HashMap<>();

        if (!inputText.isEmpty()) {
            if (inputText.endsWith(".txt")) {
                try {
                    inputText = readTextFromFile(inputText);
                } catch (IOException e) {
                    resultText = "Error reading the file.";
                }
            }

            String[] words = inputText.split("[\\s.,;?!]+");
            wordCount = words.length;

            wordFrequency = countWordFrequency(words);

            resultText = "Total word count: " + wordCount + "\n";
            resultText += "Word frequency: \n";
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                resultText += entry.getKey() + ": " + entry.getValue() + "\n";
            }
        } else {
            resultText = "Please enter text or a valid file path.";
        }

        textArea.setText(resultText);
        wordCountLabel.setText("Word Count: " + wordCount);
    }

    private String readTextFromFile(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append(" ");
            }
        }
        return text.toString();
    }

    private Map<String, Integer> countWordFrequency(String[] words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCounting wordCountGUI = new WordCounting();
            wordCountGUI.setVisible(true);
        });
    }
}
