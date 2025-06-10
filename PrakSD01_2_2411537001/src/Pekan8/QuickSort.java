package Pekan8;

import java.awt.*;
import javax.swing.*;

public class QuickSort extends JFrame {

    private static final long serialVersionUID = 1L;
    private int[] array;
    private JLabel[] labelArray;
    private JButton stepButton, resetButton, setButton;
    private JTextField inputField;
    private JPanel panelArray;
    private JTextArea stepArea;

    private java.util.Stack<int[]> stack = new java.util.Stack<>();
    private boolean sorting = false;
    private int stepCount = 1;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                QuickSort frame = new QuickSort();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public QuickSort() {
        setTitle("Quick Sort Langkah per Langkah");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputField = new JTextField(30);
        setButton = new JButton("Set Array");
        inputPanel.add(new JLabel("Masukkan angka (pisahkan dengan koma): "));
        inputPanel.add(inputField);
        inputPanel.add(setButton);

        panelArray = new JPanel(new FlowLayout());
        JPanel controlPanel = new JPanel();
        stepButton = new JButton("Langkah Selanjutnya");
        resetButton = new JButton("Reset");
        stepButton.setEnabled(false);
        controlPanel.add(stepButton);
        controlPanel.add(resetButton);

        stepArea = new JTextArea(8, 60);
        stepArea.setEditable(false);
        stepArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(stepArea);

        add(inputPanel, BorderLayout.NORTH);
        add(panelArray, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.EAST);

        setButton.addActionListener(e -> setArrayFromInput());
        stepButton.addActionListener(e -> performStep());
        resetButton.addActionListener(e -> reset());
    }

    private void setArrayFromInput() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return;

        String[] parts = text.split(",");
        array = new int[parts.length];
        try {
            for (int i = 0; i < parts.length; i++) {
                array[i] = Integer.parseInt(parts[i].trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan angka valid dipisahkan koma!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        sorting = true;
        stepCount = 1;
        stack.clear();
        stack.push(new int[]{0, array.length - 1});
        stepButton.setEnabled(true);
        stepArea.setText("");
        panelArray.removeAll();

        labelArray = new JLabel[array.length];
        for (int i = 0; i < array.length; i++) {
            labelArray[i] = new JLabel(String.valueOf(array[i]));
            labelArray[i].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray[i].setPreferredSize(new Dimension(50, 50));
            labelArray[i].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray.add(labelArray[i]);
        }

        panelArray.revalidate();
        panelArray.repaint();
    }

    private void performStep() {
        if (!sorting || stack.isEmpty()) return;

        int[] bounds = stack.pop();
        int low = bounds[0], high = bounds[1];
        if (low < high) {
            int pivotIndex = partition(low, high);
            stack.push(new int[]{low, pivotIndex - 1});
            stack.push(new int[]{pivotIndex + 1, high});
        }

        updateLabels();
        stepArea.append("Langkah " + (stepCount++) + ": " + arrayToString(array) + "\n");

        if (stack.isEmpty()) {
            sorting = false;
            stepButton.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting selesai!");
        }
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private void updateLabels() {
        for (int i = 0; i < array.length; i++) {
            labelArray[i].setText(String.valueOf(array[i]));
        }
    }

    private void reset() {
        inputField.setText("");
        panelArray.removeAll();
        panelArray.revalidate();
        panelArray.repaint();
        stepArea.setText("");
        stepButton.setEnabled(false);
        sorting = false;
        stepCount = 1;
        stack.clear();
    }

    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        return sb.toString();
    }
}
