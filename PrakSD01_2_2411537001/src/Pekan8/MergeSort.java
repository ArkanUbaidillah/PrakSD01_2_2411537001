package Pekan8;

import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class MergeSort extends JFrame {

    private static final long serialVersionUID = 1L;
    private int[] array;
    private JLabel[] labelArray;
    private JButton stepButton, resetButton, setButton;
    private JTextField inputField;
    private JPanel panelArray;
    private JTextArea stepArea;

    private Queue<int[]> queue = new LinkedList<>();
    private boolean sorting = false;
    private int stepCount = 1;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MergeSort frame = new MergeSort();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MergeSort() {
        setTitle("Merge Sort Langkah per Langkah");
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

        queue.clear();
        for (int size = 1; size < array.length; size *= 2) {
            for (int left = 0; left < array.length - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, array.length - 1);
                queue.offer(new int[]{left, mid, right});
            }
        }

        sorting = true;
        stepCount = 1;
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
        if (!sorting || queue.isEmpty()) return;

        int[] bounds = queue.poll();
        int left = bounds[0], mid = bounds[1], right = bounds[2];
        merge(left, mid, right);

        stepArea.append("Langkah " + (stepCount++) + ": Merge index " + left + " sampai " + right + "\n");
        stepArea.append("Hasil: " + arrayToString(array) + "\n\n");

        updateLabels();

        if (queue.isEmpty()) {
            sorting = false;
            stepButton.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting selesai!");
        }
    }

    private void merge(int left, int mid, int right) {
        int[] leftArr = java.util.Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArr = java.util.Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            array[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) array[k++] = leftArr[i++];
        while (j < rightArr.length) array[k++] = rightArr[j++];
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
        queue.clear();
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
