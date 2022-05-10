package br.com.fiap.sprint;

import javax.swing.JOptionPane;

public class Sprint {
	
	
	int eixoX=1, eixoY=15, limiteY=0, limiteX=0,bateria=-404,distancia;
	public static void main(String[] args) {
		Sprint sprint= new Sprint();
			
}
	public Sprint() {
		run();
	}
	public void run() {
		
		boolean vitoria=false;
		int passos=0;
		String bateriaStr;
				
				
		do {
		bateriaStr=JOptionPane.showInputDialog(null,"Digite a bateria do seu robo");
		if(verificaNum(bateriaStr)) {
			bateria=Integer.parseInt(bateriaStr);
		}else {
			JOptionPane.showMessageDialog(null, "Você digitou algo diferente de um número ou um número negativo em: "+bateriaStr+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		}while(bateria==-404);
		
		//
		do {
		
			// Escolha da direção
			String[] comandosVet = {"Frente","Tras","Esquerda","Direita"};
			boolean verific = false; // boolean para o loop se o comando é possível
			
			// loop para verificação do comando
			do {
			String comando = (String) JOptionPane.showInputDialog(null,"Suas coordenadas são:"
					+ "\n  X= "+eixoX+"     Y= "+eixoY+" "
					+ "\n Bateria= "+bateria
					+ "\n Escolha o comando", "Comandos",JOptionPane.INFORMATION_MESSAGE, null,comandosVet, comandosVet[0]);
			
		
			// Escolha da quantidade de quadrados
			
				
				String distanciaStr =JOptionPane.showInputDialog(null,"Suas coordenadas são:"
						+ "\n  X= "+eixoX+"     Y= "+eixoY
						+ "\n Bateria= "+bateria+
						"\n Digite a distância que deseja andar","Para "+comando,JOptionPane.INFORMATION_MESSAGE);
				
				// chama o metodo e verifica se é um num memsmo
				if(verificaNum(distanciaStr)) {
					distancia= Integer.parseInt(distanciaStr);
					
					if(comando.equals("Frente")) {
						if(frente(distancia)) {
							eixoY+=distancia;
							passos+=1;
							verific=true;
						}else {
							JOptionPane.showMessageDialog(null, "O distancia escolhida é acima do limite, nessa posição você poderia usar no máximo: "+(limiteY-eixoY)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}else if(comando.equals("Tras")) {
						if(tras(distancia)) {
							eixoY-=distancia;
							passos+=1;
							verific=true;
						}else {
							JOptionPane.showMessageDialog(null, "O distancia escolhida é acima do limite, nessa posição você poderia usar no máximo: "+(eixoY-limiteY)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
						}
						
					}else if (comando.equals("Esquerda")) {
						if(esquerda(distancia)) {
							eixoX-=distancia;
							passos+=1;
							verific=true;
						}else {
							JOptionPane.showMessageDialog(null, "O distancia escolhida é acima do limite, nessa posição você poderia usar no máximo: "+(eixoX-limiteX)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
						}
						
					}else if(comando.equals("Direita")) {
						if(direita(distancia)) {
							eixoX+=distancia;
							passos+=1;
							verific=true;
						}else {
							JOptionPane.showMessageDialog(null, "O distancia escolhida é acima do limite, nessa posição você poderia usar no máximo: "+(limiteX-eixoX)+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					
					 
				}else {
					// não quebra o loop e explica para o user o porque
					JOptionPane.showMessageDialog(null, "Você digitou algo diferente de um número ou um número negativo em: "+distanciaStr+"\n TENTE NOVAMENTE! ", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}while(verific==false);
		
			//Verifica a vitória
			if(eixoX>=20 && (eixoY>=2 && eixoY<=4)) {
				//vitória
				vitoria=true;
			}else {
				//ainda não chegou
			}
		}while(vitoria==false && bateria>0);
		
		if(vitoria) {
		JOptionPane.showMessageDialog(null,"Você ganhou com "+passos+" passos");}
		else {
			JOptionPane.showMessageDialog(null,"Sua bateria acabou na posição X= "+eixoX+" Y= "+eixoY+", sinto muito");
		}
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
			
			if(bateria>=num) {
				bateria-=num;
			}else {
				distancia= num - (num-bateria);
				bateria=bateria-(num+1);
			}
			
			//pode
			return true;
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
			System.out.println("ERRO NAS POSIÇÕES");
		}
		
		//VERIFICA SE É POSSÍVEL COM ESSE VALOR SEM QUEBRAR O LIMITE
		if((eixoY-num)<limiteY) {
			// não pode
			return false;
		}else {
			
			if(bateria>=num) {
				bateria-=num;
			}else {
				distancia= num - (num-bateria);
				bateria=bateria-(num+1);
			}
			
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
			System.out.println("ERRO NAS POSIÇÕES");
		}
		
		if((eixoX-num)<limiteX) {
			// não pode
			return false;
		}else {
			
			if(bateria>=num) {
				bateria-=num;
			}else {
				distancia= num - (num-bateria);
				bateria=bateria-(num+1);
			}
	
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
			System.out.println("ERRO NAS POSIÇÕES");
		}
		
		if((eixoX+num)>limiteX) {
			// não pode
			return false;
		}else {
			
			if(bateria>=num) {
				bateria-=num;
			}else {
				distancia= num - (num-bateria);
				bateria=bateria-(num+1);
			}
			
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
