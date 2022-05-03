package br.com.fiap.sprint;

import javax.swing.JOptionPane;

public class Sprint {
	
	
	int eixoX=19, eixoY=12, limiteY=0;
	public static void main(String[] args) {
		Sprint sprint= new Sprint();
			
}
	public Sprint() {
		run();
	}
	public void run() {
		
		// Escolha da dire��o
		String[] comandosVet = {"Frente","Tras","Esquerda","Direita"};
		String comando = (String) JOptionPane.showInputDialog(null,"Suas coordenadas s�o:"
				+ "\n  X= "+eixoX+"     Y= "+eixoY+" "
				+ "\n Escolha o comando", "Comandos",JOptionPane.INFORMATION_MESSAGE, null,comandosVet, comandosVet[0]);
		System.out.println(comando);
		
	
		// Escolha da quantidade de quadrados
		int distancia;
		boolean verific = false; // boolean para o loop se verifica se � um num
		
		// loop para verifica��o de num
		do {
			
			String distanciaStr =JOptionPane.showInputDialog(null,"Suas coordenadas s�o:"
					+ "\n  X= "+eixoX+"     Y= "+eixoY+
					"\n Digite a dist�ncia que deseja andar");
			
			// chama o metodo e verifica se � um num memsmo
			if(verificaNum(distanciaStr)) {
				distancia= Integer.parseInt(distanciaStr);
				
				//FAZER DPS
				// IF PARA CHAMAR O VERIFICADOR SEGUNDO O COMANDO
				//COLOCAR OS VERIFICADORES MODIFICANDO O verific para true
				
				if(comando.equals("Frente")) {
					if(frente(distancia)) {
						eixoY+=distancia;
						verific=true;
					}else {
						JOptionPane.showMessageDialog(null, "O distancia escolhida � acima do limite, nessa posi��o voc� poderia usar no m�ximo: "+(limiteY-eixoY)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}else if(comando.equals("Tras")) {
					if(tras(distancia)) {
						eixoY-=distancia;
						verific=true;
					}else {
						JOptionPane.showMessageDialog(null, "O distancia escolhida � acima do limite, nessa posi��o voc� poderia usar no m�ximo: "+(0000000)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
				}else if (comando.equals("Esquerda")) {
					if(esquerda(distancia)) {
						eixoX-=distancia;
						verific=true;
					}else {
						JOptionPane.showMessageDialog(null, "O distancia escolhida � acima do limite, nessa posi��o voc� poderia usar no m�ximo: "+(0000000)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
				}else if(comando.equals("Direita")) {
					if(direita(distancia)) {
						eixoX+=distancia;
						verific=true;
					}else {
						JOptionPane.showMessageDialog(null, "O distancia escolhida � acima do limite, nessa posi��o voc� poderia usar no m�ximo: "+(0000000)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				verific=true; // altera a variavel para quebrar o loop
			}else {
				JOptionPane.showMessageDialog(null, "Voc� digitou algo diferente de um n�mero ou um n�mero negativo em: "+distanciaStr+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
				// n�o quebra o loop e explica para o user o porque
			}
			
		}while(verific==false);
		
		
	}
	public boolean frente(int num) { 
		//ATRIBUI UM LIMITE M�XIMO PARA O Y
		if(eixoX<=20 && (eixoY>=14 && eixoY<=16)) {
			 limiteY= 16;

		}else if((eixoX<=20 && eixoX>=18) && (eixoY>=11 && eixoY<=16)) {
			 limiteY=16;
				
		}else if((eixoX<=17 && eixoX>=15) && (eixoY>=8 && eixoY<=13)) {
			 limiteY=13;
					
		}else if((eixoX<=14 && eixoX>=2) && (eixoY>=8 && eixoY<=10)) {
			 limiteY=10;
			
		}else if((eixoX<=11 && eixoX>=8) && (eixoY>=2 && eixoY<=7)) {
			 limiteY=10;
			
		}else if((eixoX<=19 && eixoX>=12) && (eixoY>=2 && eixoY<=4)) {
			 limiteY=4;
		}else {
			System.out.println("ERRO NAS POSI��ES");
		}
		
		//VERIFICA SE � POSS�VEL COM ESSE VALOR SEM QUEBRAR O LIMITE
		if((eixoY+num)>limiteY) {
			// n�o pode
			return false;
		}else {
			return true;
			//pode
		}
	}
	
	public boolean tras(int num) {
		
		return false;
	}
	public boolean esquerda(int num) {
		
		return false;
	}
	public boolean direita(int num) {
		
		return false;
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
