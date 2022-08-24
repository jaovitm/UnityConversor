import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class UnityConversor {

	//

	private JFrame frame;
	private JTextField initialValue;
	private JTextField finalValue;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnityConversor window = new UnityConversor();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UnityConversor() {
		initialize();
	}

	private void initialize() {
		// Criação do Layout da Aplicação
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ImageIcon icon = new ImageIcon("resources/money.png");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);

		ImageIcon TermometerIcon = new ImageIcon("resources/temperature.png");
		Image img1 = TermometerIcon.getImage();
		Image newimg1 = img1.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
		TermometerIcon = new ImageIcon(newimg1);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "menuInicial");
		panel_1.setLayout(null);

		JLabel moneyImg = new JLabel(icon);
		moneyImg.setBounds(38, 36, 103, 66);
		panel_1.add(moneyImg);

		JLabel moneyImgLabel = new JLabel("Conversor de Moedas");
		moneyImgLabel.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 10));
		moneyImgLabel.setBounds(38, 113, 139, 14);
		panel_1.add(moneyImgLabel);

		JLabel termometerImg = new JLabel(TermometerIcon);
		termometerImg.setBounds(270, 36, 103, 66);
		panel_1.add(termometerImg);

		JLabel lblConversorDeTemperatura = new JLabel("Conversor de Temperatura");
		lblConversorDeTemperatura.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 10));
		lblConversorDeTemperatura.setBounds(257, 113, 139, 14);
		panel_1.add(lblConversorDeTemperatura);

		JLabel lblNewLabel = new JLabel("Criado por João Vitor Machado ©");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(84, 235, 275, 39);
		panel_1.add(lblNewLabel);

		JPanel conversorDeMoedas = new JPanel();
		conversorDeMoedas.setBackground(SystemColor.menu);
		panel.add(conversorDeMoedas, "conversorDeMoedas");
		conversorDeMoedas.setLayout(null);

		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnHome.setBounds(172, 227, 89, 23);
		conversorDeMoedas.add(btnHome);

		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Real", "Dolar", "Euro", "Libras Esterlinas", "Peso Argentino", "Peso Chileno" }));
		comboBox.setBounds(122, 50, 124, 22);
		conversorDeMoedas.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("para");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(245, 54, 46, 14);
		conversorDeMoedas.add(lblNewLabel_1);

		comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Real", "Dolar", "Euro", "Libras Esterlinas", "Peso Argentino", "Peso Chileno" }));
		comboBox_1.setBounds(300, 50, 124, 22);
		conversorDeMoedas.add(comboBox_1);

		JLabel lblNewLabel_2 = new JLabel("Total: ");
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(95, 116, 108, 29);
		conversorDeMoedas.add(lblNewLabel_2);

		initialValue = new JTextField();
		initialValue.setText("1.00");
		initialValue.setBounds(26, 51, 86, 21);
		conversorDeMoedas.add(initialValue);
		initialValue.setColumns(10);

		finalValue = new JTextField();
		finalValue.setText("1.00");
		finalValue.setFont(new Font("Rockwell", Font.ITALIC, 24));
		finalValue.setBorder(null);
		finalValue.setEditable(false);
		finalValue.setHorizontalAlignment(SwingConstants.CENTER);
		finalValue.setForeground(SystemColor.desktop);
		finalValue.setBounds(174, 116, 197, 29);
		conversorDeMoedas.add(finalValue);
		finalValue.setColumns(10);

		JPanel conversorDeTemperaturas = new JPanel();
		conversorDeTemperaturas.setBackground(Color.RED);
		panel.add(conversorDeTemperaturas, "conversorDeTemperaturas");
		conversorDeTemperaturas.setLayout(null);

		JButton btnHome1 = new JButton("Home");
		btnHome1.setBounds(172, 227, 89, 23);
		conversorDeTemperaturas.add(btnHome1);

		// Event Listeners do menu Inicial
		moneyImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
				moneyImg.setCursor(cursor);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "conversorDeMoedas");

			}
		});

		termometerImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
				termometerImg.setCursor(cursor);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "conversorDeTemperaturas");
			}
		});

		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "menuInicial");
			}
		});

		btnHome1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "menuInicial");
			}
		});

		// Chamada da Função Conversão de Moedas

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MoneyConvert();
			}
		});

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MoneyConvert();
			}
		});

		initialValue.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				MoneyConvert();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				MoneyConvert();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				MoneyConvert();
			}
		});

	}

	public void MoneyConvert() {
		String Moeda1 = (String) comboBox.getSelectedItem();
		String Moeda2 = (String) comboBox_1.getSelectedItem();
		
		if(Moeda1 =="Real" && Moeda2 == "Real") {
			double Dolar = 1;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Real" && Moeda2 == "Dolar") {
			double Dolar = 0.20;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Real" && Moeda2 == "Euro") {
			double Dolar = 0.20;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Real" && Moeda2 == "Libras Esterlinas") {
			double Dolar = 0.17;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Real" && Moeda2 == "Peso Argentino") {
			double Dolar = 26.82;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Real" && Moeda2 == "Peso Chileno") {
			double Dolar = 179.59;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Dolar" && Moeda2 == "Dolar") {
			double Dolar = 1;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Dolar" && Moeda2 == "Real") {
			double Dolar = 5.10;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Dolar" && Moeda2 == "Euro") {
			double Dolar = 1;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Dolar" && Moeda2 == "Libras Esterlinas") {
			double Dolar = 0.84;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Dolar" && Moeda2 == "Peso Argentino") {
			double Dolar = 136.94;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Dolar" && Moeda2 == "Peso Chileno") {
			double Dolar = 916.75;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Euro" && Moeda2 == "Euro") {
			double Dolar = 1;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Euro" && Moeda2 == "Dolar") {
			double Dolar = 1;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Euro" && Moeda2 == "Real") {
			double Dolar = 5.10;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Euro" && Moeda2 == "Libras Esterlinas") {
			double Dolar = 0.85;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Euro" && Moeda2 == "Peso Argentino") {
			double Dolar = 136.62;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Euro" && Moeda2 == "Peso Chileno") {
			double Dolar = 918.62;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Libras Esterlinas" && Moeda2 == "Libras Esterlinas") {
			double Dolar = 1;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Libras Esterlinas" && Moeda2 == "Real") {
			double Dolar = 6.03;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Libras Esterlinas" && Moeda2 == "Dolar") {
			double Dolar = 1.18;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Libras Esterlinas" && Moeda2 == "Euro") {
			double Dolar = 1.18;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Libras Esterlinas" && Moeda2 == "Peso Argentino") {
			double Dolar = 161.72;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Libras Esterlinas" && Moeda2 == "Peso Chileno") {
			double Dolar = 1088.10;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Peso Argentino" && Moeda2 == "Peso Argentino") {
			double Dolar = 1;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Peso Argentino" && Moeda2 == "Real") {
			double Dolar = 0.037;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Peso Argentino" && Moeda2 == "Dolar") {
			double Dolar = 0.0073;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Peso Argentino" && Moeda2 == "Euro") {
			double Dolar = 0.0073;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Peso Argentino" && Moeda2 == "Libras Esterlinas") {
			double Dolar = 0.0062;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Peso Argentino" && Moeda2 == "Peso Chileno") {
			double Dolar = 6.73;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Peso Chileno" && Moeda2 == "Peso Chileno") {
			double Dolar = 1;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Peso Chileno" && Moeda2 == "Real") {
			double Dolar = 0.0055;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Peso Chileno" && Moeda2 == "Dolar") {
			double Dolar = 0.0011;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Peso Chileno" && Moeda2 == "Euro") {
			double Dolar = 0.0011;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Peso Chileno" && Moeda2 == "Libras Esterlinas") {
			double Dolar = 0.00092;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
		if(Moeda1 =="Peso Chileno" && Moeda2 == "Peso Argentino") {
			double Dolar = 0.15;
			double toBeConverted;
			if(initialValue.getText().isEmpty()) {
				toBeConverted = 0.0;
			}else {
				toBeConverted = Double.parseDouble(initialValue.getText());
			}
			double newValue =  toBeConverted * Dolar;
			BigDecimal ConvertedValue = new BigDecimal(newValue).setScale(2, RoundingMode.HALF_EVEN);
			finalValue.setText(ConvertedValue.toString());
		}
		
	}
}
