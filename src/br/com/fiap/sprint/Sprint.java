package br.com.fiap.sprint;

import javax.swing.JOptionPane;

public class Sprint {
	
	
	int eixoX=1, eixoY=15, limiteY=0, limiteX=0;
	public static void main(String[] args) {
		Sprint sprint= new Sprint();
			
}
	public Sprint() {
		run();
	}
	public void run() {
		
		boolean vitoria=false;
		int passos=0;
		//
		do {
		
		// Escolha da dire��o
		String[] comandosVet = {"Frente","Tras","Esquerda","Direita"};
		boolean verific = false; // boolean para o loop se o comando � poss�vel
		
		// loop para verifica��o do comando
		do {
		String comando = (String) JOptionPane.showInputDialog(null,"Suas coordenadas s�o:"
				+ "\n  X= "+eixoX+"     Y= "+eixoY+" "
				+ "\n Escolha o comando", "Comandos",JOptionPane.INFORMATION_MESSAGE, null,comandosVet, comandosVet[0]);
		System.out.println(comando);
		
	
		// Escolha da quantidade de quadrados
		int distancia;
			
			String distanciaStr =JOptionPane.showInputDialog(null,"Suas coordenadas s�o:"
					+ "\n  X= "+eixoX+"     Y= "+eixoY+
					"\n Digite a dist�ncia que deseja andar","Para "+comando,JOptionPane.INFORMATION_MESSAGE);
			
			// chama o metodo e verifica se � um num memsmo
			if(verificaNum(distanciaStr)) {
				distancia= Integer.parseInt(distanciaStr);
				
				//FAZER DPS
				// IF PARA CHAMAR O VERIFICADOR SEGUNDO O COMANDO
				//COLOCAR OS VERIFICADORES MODIFICANDO O verific para true
				
				if(comando.equals("Frente")) {
					if(frente(distancia)) {
						eixoY+=distancia;
						passos+=1;
						verific=true;
					}else {
						JOptionPane.showMessageDialog(null, "O distancia escolhida � acima do limite, nessa posi��o voc� poderia usar no m�ximo: "+(limiteY-eixoY)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}else if(comando.equals("Tras")) {
					if(tras(distancia)) {
						eixoY-=distancia;
						passos+=1;
						verific=true;
					}else {
						JOptionPane.showMessageDialog(null, "O distancia escolhida � acima do limite, nessa posi��o voc� poderia usar no m�ximo: "+(eixoY-limiteY)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
				}else if (comando.equals("Esquerda")) {
					if(esquerda(distancia)) {
						eixoX-=distancia;
						passos+=1;
						verific=true;
					}else {
						JOptionPane.showMessageDialog(null, "O distancia escolhida � acima do limite, nessa posi��o voc� poderia usar no m�ximo: "+(eixoX-limiteX)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
				}else if(comando.equals("Direita")) {
					if(direita(distancia)) {
						eixoX+=distancia;
						passos+=1;
						verific=true;
					}else {
						JOptionPane.showMessageDialog(null, "O distancia escolhida � acima do limite, nessa posi��o voc� poderia usar no m�ximo: "+(limiteX-eixoX)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				 
			}else {
				JOptionPane.showMessageDialog(null, "Voc� digitou algo diferente de um n�mero ou um n�mero negativo em: "+distanciaStr+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
				// n�o quebra o loop e explica para o user o porque
			}
			
		}while(verific==false);
		
		//Verifica a vit�ria
		if(eixoX>=20 && (eixoY>=2 && eixoY<=4)) {
			//vit�ria
			vitoria=true;
		}else {
			//ainda n�o chegou
		}
		}while(vitoria==false);
		
		JOptionPane.showMessageDialog(null,"Voc� ganhou com "+passos+" passos");
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
		if(eixoX<=17 && eixoX>=1 && (eixoY>=14 && eixoY<=16)) {
			 limiteY= 14;

		}else if((eixoX<=20 && eixoX>=18) && (eixoY>=11 && eixoY<=16)) {
			 limiteY=11;
				
		}else if(((eixoX<=17 && eixoX>=15) && (eixoY>=8 && eixoY<=13)) || ((eixoX<=14 && eixoX>=12) && (eixoY>=8 && eixoY<=10)) || ((eixoX<=8 && eixoX>=2) && (eixoY>=8 && eixoY<=10))) {
			 limiteY=8;
					
		}else if((eixoX<=11 && eixoX>=9) && (eixoY>=2 && eixoY<=10)) {
			 limiteY=2;
			
		}else if((eixoX<=19 && eixoX>=12) && (eixoY>=2 && eixoY<=4)) {
			 limiteY=2;
			
		}else {
			System.out.println("ERRO NAS POSI��ES");
		}
		
		//VERIFICA SE � POSS�VEL COM ESSE VALOR SEM QUEBRAR O LIMITE
		if((eixoY-num)<limiteY) {
			// n�o pode
			return false;
		}else {
			return true;
			//pode
		}
		
		
	}
	public boolean esquerda(int num) {
		if((eixoX<=20 && eixoX>=1) && (eixoY>=14 && eixoY<=16)) {
			limiteX=1;
			
		}else if((eixoX<=20 && eixoX>=15) && (eixoY>=11 && eixoY<=13)) {
			limiteX=15;
			
		}else if((eixoX<=17 && eixoX>=2) && (eixoY>=8 && eixoY<=10)) {
			limiteX=2;
		}else if((eixoX<=11 && eixoX>=9) && (eixoY>=5 && eixoY<=7)) {
			limiteX=9;
		}else if((eixoX<=19 && eixoX>=9) && (eixoY>=2 && eixoY<=4)) {
			limiteX=9;
		}else {
			System.out.println("ERRO NAS POSI��ES");
		}
		
		if((eixoX-num)<limiteX) {
			// n�o pode
			return false;
		}else {
			return true;
			//pode
		}
	}
	public boolean direita(int num) {
		if((eixoX<=20 && eixoX>=1) && (eixoY>=14 && eixoY<=16)) {
			limiteX=20;
			
		}else if((eixoX<=20 && eixoX>=15) && (eixoY>=11 && eixoY<=13)) {
			limiteX=20;
			
		}else if((eixoX<=17 && eixoX>=2) && (eixoY>=8 && eixoY<=10)) {
			limiteX=17;
		}else if((eixoX<=11 && eixoX>=9) && (eixoY>=5 && eixoY<=7)) {
			limiteX=11;
		}else if((eixoX<=19 && eixoX>=9) && (eixoY>=2 && eixoY<=4)) {
			limiteX=21;
		}else {
			System.out.println("ERRO NAS POSI��ES");
		}
		
		if((eixoX+num)>limiteX) {
			// n�o pode
			return false;
		}else {
			return true;
			//pode
		}
		
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
