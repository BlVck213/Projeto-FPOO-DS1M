package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.VeiculoDao;
import model.Veiculo;

import util.Util;



public class FrameVeiculo {
	
	protected static final java.time.LocalTime localTimeFormat = null;
	private JLabel labelEntrada;
	private JLabel labelPlacaEntrada;
	private JTextField textPlacaEntrada;
	private JLabel labelModeloEntrada;
	private JTextField textModeloEntrada;
	private JButton buttonEntrar;
	
	private JScrollPane scrollTable;
	private JTable tabelaVeiculos;
	private DefaultTableModel tabelaVeiculosModelo;
	
	private JLabel labelSaida;
	private JLabel labelPlacaSaida;
	private JTextField textPlacaSaida;
	private JButton buttonBuscar;
	
	private JLabel labelModeloSaida;
	private JTextField textModeloSaida;
	private JLabel labelDataEntrada;
	private JTextField textDataEntrada;
	private JLabel labelHoraEntrada;
	private JTextField textHoraEntrada;
	private JLabel labelDataSaida;
	private JTextField textDataSaida;
	private JLabel labelHoraSaida;
	private JTextField textHoraSaida;
	private JLabel labelTempo;
	private JTextField textTempo;
	
	private JLabel labelValorPagar;
	private JTextField textValorPagar;
	private JButton buttonEfetuarSaida;
	private JButton buttonFecharSistema;
	
	
		public void criarTela() {
		JFrame tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Estaciona Bem");
		tela.setSize(725, 625);
		tela.setLayout(null);
		tela.setResizable(false);
		tela.setLocationRelativeTo(tela);
		
		
		labelEntrada = new JLabel ("ENTRADA");
		labelEntrada.setBounds(40, 10, 150, 30);
		labelEntrada.setForeground(Color.GREEN);
	
		
		labelPlacaEntrada = new JLabel ("Placa:");
		labelPlacaEntrada.setBounds(40, 40, 50, 30);
		textPlacaEntrada = new JTextField();
		textPlacaEntrada.setBounds(40, 75, 200, 30);
		textPlacaEntrada.setForeground(Color.GREEN);
		
		
		labelModeloEntrada = new JLabel ("Modelo:");
		labelModeloEntrada.setBounds(260, 40, 50, 30);
		textModeloEntrada = new JTextField();
		textModeloEntrada.setBounds(260, 75, 200, 30);
		textModeloEntrada.setForeground(Color.GREEN);
		
		buttonEntrar = new JButton("ENTRAR");
		buttonEntrar.setBounds(480, 75, 200, 30); 
		
		criarTabela();
		
		scrollTable = new JScrollPane(tabelaVeiculos);
		scrollTable.setBounds(40, 115, 640, 140);
		
		labelSaida = new JLabel ("SAÍDA");
		labelSaida.setBounds(40, 260, 110, 30);
		labelSaida.setForeground(Color.GREEN);
		
		labelPlacaSaida = new JLabel ("Placa:");
		labelPlacaSaida.setBounds(40, 290, 50, 30);
		textPlacaSaida = new JTextField();
		textPlacaSaida.setBounds(40, 325, 200, 30);
		textPlacaSaida.setForeground(Color.GREEN);
		
		buttonBuscar = new JButton("BUSCAR");
		buttonBuscar.setBounds(260, 325, 200, 30); 
		
		labelModeloSaida = new JLabel ("Modelo:");
		labelModeloSaida.setBounds(40, 375, 50, 30);
		textModeloSaida = new JTextField();
		textModeloSaida.setBounds(40, 405, 75, 30);
		textModeloSaida.setForeground(Color.GREEN);
		
		labelDataEntrada = new JLabel ("Data de Entrada:");
		labelDataEntrada.setBounds(125, 375, 100, 30);
		textDataEntrada = new JTextField();
		textDataEntrada.setBounds(125, 405, 100, 30);
		textDataEntrada.setForeground(Color.GREEN);
		
		labelHoraEntrada = new JLabel ("Horário de Entrada:");
		labelHoraEntrada.setBounds(235, 375, 125, 30);
		textHoraEntrada = new JTextField();
		textHoraEntrada.setBounds(235, 405, 125, 30);
		textHoraEntrada.setForeground(Color.GREEN);
		
		labelDataSaida = new JLabel ("Data de Saída:");
		labelDataSaida.setBounds(370, 375, 100, 30);
		textDataSaida = new JTextField();
		textDataSaida.setBounds(370, 405, 100, 30);
		textDataSaida.setForeground(Color.GREEN);
		
		labelHoraSaida = new JLabel ("Horário de Saída:");
		labelHoraSaida.setBounds(480, 375, 100, 30);
		textHoraSaida = new JTextField();
		textHoraSaida.setBounds(480, 405, 100, 30);
		textHoraSaida.setForeground(Color.GREEN);
		
		labelTempo = new JLabel ("Tempo:");
		labelTempo.setBounds(590, 375, 75, 30);
		textTempo = new JTextField();
		textTempo.setBounds(590, 405, 75, 30);
		textTempo.setForeground(Color.GREEN);
		
		labelValorPagar = new JLabel ("Valor á Pagar:");
		labelValorPagar.setBounds(40, 480, 100, 30);
		textValorPagar = new JTextField();
		textValorPagar.setBounds(140, 475, 100, 50);
		textValorPagar.setForeground(Color.GREEN);


		buttonEfetuarSaida = new JButton("EFETUAR SAIDA");
		buttonEfetuarSaida.setBounds(270, 475, 150, 50); 
		
		buttonFecharSistema = new JButton("FECHAR SISTEMA");
		buttonFecharSistema.setBounds(450, 475, 150, 50); 
		buttonFecharSistema.setBackground(Color.RED);
		buttonFecharSistema.setForeground(Color.WHITE);

		
		
		
		tela.getContentPane().add(labelEntrada);
		tela.getContentPane().add(labelPlacaEntrada);
		tela.getContentPane().add(textPlacaEntrada);
		tela.getContentPane().add(labelModeloEntrada);
		tela.getContentPane().add(textModeloEntrada);
		tela.getContentPane().add(buttonEntrar);
		tela.getContentPane().add(scrollTable);
		tela.getContentPane().add(labelSaida);
		tela.getContentPane().add(labelPlacaSaida);
		tela.getContentPane().add(textPlacaSaida);
		tela.getContentPane().add(buttonBuscar);
		tela.getContentPane().add(labelModeloSaida);
		tela.getContentPane().add(textModeloSaida);
		tela.getContentPane().add(labelDataEntrada);
		tela.getContentPane().add(textDataEntrada);
		tela.getContentPane().add(labelHoraEntrada);
		tela.getContentPane().add(textHoraEntrada);
		tela.getContentPane().add(labelDataSaida);
		tela.getContentPane().add(textDataSaida);
		tela.getContentPane().add(labelHoraSaida);
		tela.getContentPane().add(textHoraSaida);
		tela.getContentPane().add(labelTempo);
		tela.getContentPane().add(textTempo);
		tela.getContentPane().add(labelValorPagar);
		tela.getContentPane().add(textValorPagar);
		tela.getContentPane().add(buttonEfetuarSaida);
		tela.getContentPane().add(buttonFecharSistema);
		
		
		tela.setVisible(true);
		
		
		buttonEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(validarFormularioEntrada()) 	{
					
					
					Veiculo veiculo = new Veiculo();
					veiculo.setCodigo(Util.gerarCodigo());
					veiculo.setPlaca(textPlacaEntrada.getText());
					veiculo.setModelo(textModeloEntrada.getText());
					veiculo.setData_entrada(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					veiculo.setHora_entrada(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
					veiculo.setData_saida("");
					veiculo.setHora_saida("");
					veiculo.setTempo("");
					veiculo.setValor_a_pagar("");
					
					VeiculoDao dao = new VeiculoDao(veiculo);
					dao.salvar();
				
					JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!");
					limparFormularioEntrada();
					
				} else {
					JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos!", "Atenção!", JOptionPane.ERROR_MESSAGE);
				}
			}

		
		});
		
		
		buttonBuscar.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				if(validarFormularioSaida()) {
					
					String placa = null;
					
					VeiculoDao veiculoDao = new VeiculoDao();
					Veiculo veiculo = veiculoDao.buscarMovimentos(placa);
					
					textModeloSaida.setText(veiculo.getModelo());
					textDataEntrada.setText(veiculo.getData_entrada());
					textHoraEntrada.setText(veiculo.getHora_entrada());
					veiculo.setData_saida(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					veiculo.setHora_saida(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
					textDataSaida.setText(veiculo.getData_saida());
					textHoraSaida.setText(veiculo.getHora_saida());
					textTempo.setText(String.valueOf(veiculo.getTempo() + " Horas"));
					textValorPagar.setText("R$: " + veiculo.getValor_a_pagar());
				
				}else {
					JOptionPane.showMessageDialog(null, "Você deve preencher o campo!", "Atenção!", JOptionPane.ERROR_MESSAGE);
				}
			}

			
			
		});
		
		buttonEfetuarSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarEfetuarSaida()) {
				
					Veiculo veiculo = new Veiculo();
					veiculo.setCodigo(Util.gerarCodigo());
					veiculo.setPlaca(textPlacaSaida.getText());
					veiculo.setModelo(textModeloSaida.getText());
					veiculo.setData_entrada(textDataEntrada.getText());
					veiculo.setHora_entrada(textHoraEntrada.getText());
					veiculo.setData_saida(textDataSaida.getText());
					veiculo.setHora_saida(textHoraSaida.getText());
					veiculo.setTempo(veiculo.getTempo());
					veiculo.setValor_a_pagar(veiculo.getValor_a_pagar());
					
					VeiculoDao dao = new VeiculoDao(veiculo);
					dao.salvar();

					JOptionPane.showMessageDialog(null, "Saída efetuada com sucesso!");
				limparFormularioSaida();
				}else {
					JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos!", "Atenção!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		buttonFecharSistema.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Runtime.getRuntime().exit(0);
			}
		});
		
}
			
	
		
		
		
	
	private void criarTabela() {
		tabelaVeiculosModelo = new DefaultTableModel();
		tabelaVeiculosModelo.addColumn("Código");
		tabelaVeiculosModelo.addColumn("Placa");
		tabelaVeiculosModelo.addColumn("Modelo");
		tabelaVeiculosModelo.addColumn("Data de Entrada");
		

		VeiculoDao veiculoDao = new VeiculoDao();
		ArrayList<Veiculo> veiculos = veiculoDao.listarMovimentos();
		
		for (Veiculo veiculo : veiculos) {
			String[] vetorVeiculo = {veiculo.getCodigo(), veiculo.getPlaca(), veiculo.getModelo(), veiculo.getData_entrada()};
			tabelaVeiculosModelo.addRow(vetorVeiculo);
		}
		
		tabelaVeiculos = new JTable(tabelaVeiculosModelo);
		
		}
	
	
	private void limparFormularioEntrada() {
		textModeloEntrada.setText("");
		textPlacaEntrada.setText("");
		textPlacaEntrada.requestFocus();
		
	}

	private boolean validarFormularioEntrada() {
		boolean valido = true;
		
		if(textPlacaEntrada.getText().trim().length() == 0) {
			labelPlacaEntrada.setForeground(Color.RED);
			valido = false;	
		} else if(textModeloEntrada.getText().trim().length() == 0) {
			labelModeloEntrada.setForeground(Color.RED);
			valido = false;
		}
		
		return valido;

		
	}
	
	private boolean validarFormularioSaida() {
		boolean valido = true;
		
		if(textPlacaSaida.getText().trim().length() == 0) {
			labelPlacaSaida.setForeground(Color.RED);
			valido = false;	
		} 
		
		return valido;
		}
		
	private void limparFormularioSaida() {
		textPlacaSaida.setText("");
		textModeloSaida.setText("");
		textDataEntrada.setText("");
		textHoraEntrada.setText("");
		textDataSaida.setText("");
		textHoraSaida.setText("");
		textTempo.setText("");
		textValorPagar.setText("");
		textPlacaSaida.requestFocus();
		
	}
	private boolean validarEfetuarSaida() {
		boolean valido = true;
		
		if(textModeloSaida.getText().trim().length() == 0) {
			labelModeloSaida.setForeground(Color.RED);
			valido = false;
		} else if(textDataEntrada.getText().trim().length() == 0) {
			labelDataEntrada.setForeground(Color.RED);
			valido = false;
		}else if(textHoraEntrada.getText().trim().length() == 0) {
			labelHoraEntrada.setForeground(Color.RED);
			valido = false;
		}else if(textDataSaida.getText().trim().length() == 0) {
			labelDataSaida.setForeground(Color.RED);
			valido = false;
		}else if(textHoraSaida.getText().trim().length() == 0) {
			labelHoraSaida.setForeground(Color.RED);
			valido = false;
		}else if(textTempo.getText().trim().length() == 0) {
			labelTempo.setForeground(Color.RED);
			valido = false;
		}else if(textValorPagar.getText().trim().length() == 0) {
			labelValorPagar.setForeground(Color.RED);
			valido = false;
		}
		return valido;
		}
	
	
	


	
		
}
