package br.com.fiap.sprint;

import javax.swing.JOptionPane;

public class Sprint {
	int eixoX, eixoY;
	
	public static void main(String[] args) {

		String[] comandosVet = {"Frente","Tras","Esquerda","Direita"};
		String comando = (String) JOptionPane.showInputDialog(null,"Escolha o comando", "Comandos",JOptionPane.INFORMATION_MESSAGE, null,comandosVet, comandosVet[0]);
		System.out.println(comando);
		
		int distancia;
		boolean verific = false;
		do {
			String distanciaStr =JOptionPane.showInputDialog(null,"Digite a distância");
			
			if(verificaNum(distanciaStr)) {
				distancia= Integer.parseInt(distanciaStr);
				verific=true;
			}else {
				JOptionPane.showMessageDialog(null, "Você digitou algo diferente de um número em: "+distanciaStr+"\n TENTE NOVAMENTE!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
		}while(verific==false);
		
}
	public static void frente(int num) {
		
	}
	public static void tras(int num) {
		
	}
	public static void esquerda(int num) {
		
	}
	public static void direita(int num) {
		
	}
	public static boolean verificaNum(String palavra) {
		
		for(int i=0; i<palavra.length();i++) {
			char letra = palavra.charAt(i);
			if((letra>='0') && (letra<='9')) {
				
			}else {
				return false;
			}
		}
		return true;
		
	}
}
