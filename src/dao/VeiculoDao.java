package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


import model.Veiculo;



public class VeiculoDao {

	private Veiculo veiculo;
	private static final String LOCAL_ARQUIVO = "C:/Users/crica_000/movimentacao.ds1";
	
	public VeiculoDao(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public VeiculoDao() {
		
	}
	
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void salvar() {
		
		Path path = Paths.get("C:/Users/crica_000/movimentacao.ds1");
		
		try {
			
			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), 
					StandardOpenOption.APPEND
					,StandardOpenOption.WRITE);
			
			writer.write(veiculo.toString().toUpperCase());
			writer.newLine();
			writer.close();
			
		} catch (Exception e) {
			System.out.println("Não foi possivel gravar os dados");
			
		}
		
	}
	
	public ArrayList<Veiculo> listarMovimentos() {
		
	     

		 
		Path path = Paths.get(LOCAL_ARQUIVO);
		
		try{ 
		BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
		
		String linha = reader.readLine();
		
		 ArrayList<Veiculo> veiculos = new ArrayList<>(); 
		
		 while (linha != null) {
			 String[] vetorVeiculo = linha.split(";");
			 
			 
			 Veiculo veiculo = new Veiculo();
			 veiculo.setCodigo(vetorVeiculo[0]);
			 veiculo.setPlaca(vetorVeiculo[1]);
			 veiculo.setModelo(vetorVeiculo[2]);
			 veiculo.setData_entrada(vetorVeiculo[3]);
			 veiculo.setHora_entrada(vetorVeiculo[4]);
			 veiculo.setData_saida(vetorVeiculo[5]);
			 veiculo.setHora_saida(vetorVeiculo[6]);
			 veiculo.setTempo(vetorVeiculo[7]);
			 veiculo.setValor_a_pagar(vetorVeiculo[8]);
               
               
                veiculos.add(veiculo);
               
			 
			 linha = reader.readLine();
		}
		 reader.close();
		
		 return veiculos;
		
		} catch(Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
			e.printStackTrace();
			return null;
		}
	}
	

	

	public Veiculo buscarMovimentos(String placa) {
		Path path = Paths.get(LOCAL_ARQUIVO);
		
		try{ 
		BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
		
		String linha = reader.readLine();
		Veiculo veiculo = new Veiculo();
		 
		 while (linha != null) {
			 String[] vetorVeiculo = linha.split(";");
			
			 veiculo.setCodigo(vetorVeiculo[0]);
			 veiculo.setPlaca(vetorVeiculo[1]);
			 veiculo.setModelo(vetorVeiculo[2]);
			 veiculo.setData_entrada(vetorVeiculo[3]);
			 veiculo.setHora_entrada(vetorVeiculo[4]);
			 veiculo.setData_saida(vetorVeiculo[5]);
			 veiculo.setHora_saida(vetorVeiculo[6]);
			 veiculo.setTempo(vetorVeiculo[7]);
			 veiculo.setValor_a_pagar(vetorVeiculo[8]);
               
			 
			 linha = reader.readLine();
		}
		 reader.close();
		 
		 return veiculo;
		
		} catch(Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	


}
