package model;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Veiculo {
	private String codigo;
	private String placa;
	private String modelo;
	private String data_entrada;
	private String hora_entrada;
	private String data_saida;
	private String hora_saida;
	private double tempo;
	private double valor_a_pagar;
	private double valor1;
	private double valor2;


	
	public double getValor1() {
		return valor1;
	}
	public void setValor1(double valor1) {
		this.valor1 = valor1;
	}
	public double getValor2() {
		return valor2;
	}
	public void setValor2(double valor2) {
		this.valor2 = valor2;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(String data_entrada) {
		this.data_entrada = data_entrada;
	}
	public String getHora_entrada() {
		return hora_entrada;
	}
	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}
	public String getData_saida() {
		return data_saida;
	}
	public void setData_saida(String data_saida) {
		this.data_saida = data_saida;
	}
	public String getHora_saida() {
		return hora_saida;
	}
	public void setHora_saida(String hora_saida) {
		this.hora_saida = hora_saida;
	}
	
	
	public double getValor_a_pagar() {
		
		double valorPagar = (tempo *5) + 10 ;
		
		this.valor_a_pagar = valorPagar;
		
		return valor_a_pagar;
	}
	public void setValor_a_pagar(double valor_a_pagar) {
		
		
	}
	@Override
	public String toString() {
		return codigo + ";" + placa + ";" + modelo + ";"
				+ data_entrada + ";" + hora_entrada + ";" + data_saida + ";"
				+ hora_saida + ";" + tempo + ";" + valor_a_pagar;
		
	}
	
		public double getTempo() {
			
			LocalDateTime horaEntrada = LocalDateTime.parse(this.data_entrada + " " + this.hora_entrada, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) ;
			LocalDateTime horaSaida = LocalDateTime.parse(this.data_saida + " " + this.hora_saida, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) ;

			long tempoGasto = ChronoUnit.HOURS.between(horaEntrada, horaSaida);
			
		this.tempo = tempoGasto;
		
		return tempo;
		}
		public void setTempo(double tempo) {
			
			
		}
		
		public void setTempo(String string) {
			
		}
		public void setValor_a_pagar(String string) {
			
		}
		public void setValor1(String string) {

			
		}
		public void setValor2(String string) {

			
		}
		
	
	
	
	
	
	

}
