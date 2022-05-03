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
					"\n Digite a distância que deseja andar");
			
			// chama o metodo e verifica se é um num memsmo
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
						JOptionPane.showMessageDialog(null, "O distancia escolhida é acima do limite, nessa posição você poderia usar no máximo: "+(limiteY-eixoY)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}else if(comando.equals("Tras")) {
					if(tras(distancia)) {
						eixoY-=distancia;
						verific=true;
					}else {
						JOptionPane.showMessageDialog(null, "O distancia escolhida é acima do limite, nessa posição você poderia usar no máximo: "+(0000000)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
				}else if (comando.equals("Esquerda")) {
					if(esquerda(distancia)) {
						eixoX-=distancia;
						verific=true;
					}else {
						JOptionPane.showMessageDialog(null, "O distancia escolhida é acima do limite, nessa posição você poderia usar no máximo: "+(0000000)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
				}else if(comando.equals("Direita")) {
					if(direita(distancia)) {
						eixoX+=distancia;
						verific=true;
					}else {
						JOptionPane.showMessageDialog(null, "O distancia escolhida é acima do limite, nessa posição você poderia usar no máximo: "+(0000000)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				verific=true; // altera a variavel para quebrar o loop
			}else {
				JOptionPane.showMessageDialog(null, "Você digitou algo diferente de um número ou um número negativo em: "+distanciaStr+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
				// não quebra o loop e explica para o user o porque
			}
			
		}while(verific==false);
		
		
	}
	public boolean frente(int num) { 
		//ATRIBUI UM LIMITE MÁXIMO PARA O Y
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
			System.out.println("ERRO NAS POSIÇÕES");
		}
		
		//VERIFICA SE É POSSÍVEL COM ESSE VALOR SEM QUEBRAR O LIMITE
		if((eixoY+num)>limiteY) {
			// não pode
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
