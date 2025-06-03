package Pekan7;
import java.awt.*;

import javax.swing.*;
// Arkan Ubaidillah Warman
//2411537001

public class InsertionSortGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private int[] array;
	private JLabel[] labelArray;
	private JButton stepButton, resetButton, setButton;
	private JTextField inputField;
	private JPanel panelArray;
	private JTextArea stepArea;
	
	private int i = 1, j;
	private boolean sorting = false;
	private int stepCount=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertionSortGUI frame = new InsertionSortGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertionSortGUI() {
		setTitle("Insertion Sort Langkah per Langkah");
		setSize(750,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//panel input
		JPanel inputPanel = new JPanel(new FlowLayout());
		inputField=new JTextField(30);
		setButton=new JButton("Set Array");
		inputPanel.add(new JLabel("Masukkan angka(pisahkan dengan koma): "));
		inputPanel.add(inputField);
		inputPanel.add(setButton);
		
		//panel array visual
		panelArray = new JPanel();
		panelArray.setLayout(new FlowLayout());
		
		//panel kontrol
		JPanel controlPanel = new JPanel();
		stepButton = new JButton("Langkah selanjutnya");
		resetButton = new JButton("reset");
		stepButton.setEnabled(false);
		controlPanel.add(stepButton);
		controlPanel.add(resetButton);
		
		
		//area teks untuk log langkah - langkah
		stepArea=new JTextArea(8,60);
		stepArea.setEditable(false);
		stepArea.setFont(new Font ("Monospaced", Font.PLAIN,14));
		JScrollPane scrollPane= new JScrollPane (stepArea);
		
		//tambahkan panel ke frame
		add(inputPanel , BorderLayout.NORTH);
		add(panelArray, BorderLayout.CENTER);
		add(controlPanel,BorderLayout.SOUTH);
		add(scrollPane,BorderLayout.EAST);
		
		//event set array
		setButton.addActionListener(e -> setArrayFromInput());
		
		//event langkah selanjutnya
		stepButton.addActionListener(e -> performStep());
		
		//event reset
		resetButton.addActionListener(e -> reset());
		
	}
	private void setArrayFromInput() {
		String text = inputField.getText().trim();
		if (text.isEmpty()) return;
		String[]parts=text.split(",");
		array = new int [parts.length];
		try {
			for (int k = 0; k< parts.length; k++) {
				array[k]= Integer.parseInt(parts[k].trim());				
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan" + "dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		i=1;
		stepCount=1;
		sorting= true;
		stepButton.setEnabled(true);
		stepArea.setText("");
		panelArray.removeAll();
		labelArray= new JLabel [array.length];
		for (int k = 0; k < array.length; k++) {
			labelArray[k]= new JLabel(String.valueOf(array[k]));
			labelArray[k].setFont(new Font ("Arial", Font.BOLD,24));
			labelArray[k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray[k].setPreferredSize(new Dimension(50,50));
			labelArray[k].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray.add(labelArray[k]);
		}
		panelArray.revalidate();
		panelArray.repaint();
	}
private void performStep() {
		
		int j;
		if(i < array.length && sorting) {
			int key = array[i];
			 j = i - 1;
			
			StringBuilder stepLog = new StringBuilder();
			stepLog.append("Langkah ").append(stepCount).append(": Memasukkan ").append(key).append("\n");
			while(j>= 0 && array[j] > key) {
				array[j+1] = array[j];
				j--;

			}
			array[j+1] = key;
			updateLabels();
			stepLog.append("Hasil: ").append(arrayToString(array)).append("\n\n");
			stepArea.append(stepLog.toString());
			i++;
			stepCount++;
			if( i== array.length) {
				sorting = false;
				stepButton.setEnabled(false);
				JOptionPane.showMessageDialog(this, "Sorting selesai!");
			}
		}
	}

	private void updateLabels() {
		for (int k=0; k< array.length; k ++) {
			labelArray[k].setText(String.valueOf(array[k]));
		}
		
	}
	private void reset( ) {
		inputField.setText("");
		panelArray.removeAll();
		panelArray.revalidate();
		panelArray.repaint();
		stepArea.setText("");
		stepButton.setEnabled(false);
		sorting=false;
		i = 1 ;
		stepCount=1;
	}
	private String arrayToString (int []arr) {
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k < arr.length; k++) {
			sb.append(arr[k]);
			if (k < arr.length -1 ) sb.append(",");
		}
		
		return sb.toString();	
	}
}
