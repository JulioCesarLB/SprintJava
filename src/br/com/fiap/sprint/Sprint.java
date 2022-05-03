package br.com.fiap.sprint;

import javax.swing.JOptionPane;

public class Sprint {
	
	
	int eixoX=1, eixoY=15;
	public static void main(String[] args) {
		Sprint sprint= new Sprint();
			
}
	public Sprint() {
		run();
	}
	public void run() {
		
		// Escolha da direção
		String[] comandosVet = {"Frente","Tras","Esquerda","Direita"};
		String comando = (String) JOptionPane.showInputDialog(null,"Suas coordenadas são:"
				+ "\n  X= "+eixoX+"     Y= "+eixoY+" "
				+ "\n Escolha o comando", "Comandos",JOptionPane.INFORMATION_MESSAGE, null,comandosVet, comandosVet[0]);
		System.out.println(comando);
		
	
		// Escolha da quantidade de quadrados
		int distancia;
		boolean verific = false; // boolean para o loop se verifica se é um num
		
		// loop para verificação de num
		do {
			
			String distanciaStr =JOptionPane.showInputDialog(null,"Suas coordenadas são:"
					+ "\n  X= "+eixoX+"     Y= "+eixoY+
					"\n Digite a distância");
			
			// chama o metodo e verifica se é um num memsmo
			if(verificaNum(distanciaStr)) {
				distancia= Integer.parseInt(distanciaStr);
				verific=true; // altera a variavel para quebrar o loop
			}else {
				
				// não quebra o loop e explica para o user o porque
				JOptionPane.showMessageDialog(null, "Você digitou algo diferente de um número em: "+distanciaStr+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
		}while(verific==false);
		
		
	}
	public void frente(int num) {
		if(eixoX<=17 && (eixoY>=14 && eixoY<=16)) {
			
		}else if ((eixoX>17 && eixoX<=20) && (eixoY>=14 && eixoY<=16)){
			
		}else if ((eixoX>17 && eixoX<=20) && (eixoY>=11 && eixoY<=13)) {
			
		}else if((eixoX>14 && eixoX<=17) && (eixoY>=11 && eixoY<=13)) {
			
		}else if((eixoX>8 && eixoX<=11) && (eixoY>=8 && eixoY<=10)) {
			
		}
		else if((eixoX>18 && eixoX<=1) && (eixoY>=8 && eixoY<=10)) {
			
		}else if ((eixoX>8 && eixoX<=11) && (eixoY>=5 && eixoY<=7)) {
			
		}else if((eixoX>8 && eixoX<=19) && (eixoY>=2 && eixoY<=4)) {
			
		}else {
			
		}
	}
	public void tras(int num) {
		
	}
	public void esquerda(int num) {
		
	}
	public void direita(int num) {
		
	}
	// metodo que verifica se a string pode virar um int sem erros
	public boolean verificaNum(String palavra) {
		
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
