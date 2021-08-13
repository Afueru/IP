import java.util.Scanner;
import java.util.Locale;
public class ep1 {
	/****************************************
nome: Mark Poll Herrmann
nusp: 11208291
*****************************************/
	public static void main (String [] args) {
		Scanner ler = new Scanner (System.in);
		double m = 0;		
		ler.useLocale(Locale.ENGLISH);		
		int nCargos = ler.nextInt();
		String [] cargo = new String [nCargos];				
		double [][] peso = new double [nCargos] [14];		
		for (int i = 0; i < nCargos; i++) {
			cargo[i] = ler.nextLine(); // O programa não funciona corretamente sem esses dois leitores, com apenas um não há leitura do nome do cargo, motivo: ?
			cargo[i] = ler.nextLine(); // Soluções estranhas que dão certo!			
						
		for (int u = 0; u < 14; u++) {
			peso [i] [u] = ler.nextDouble();
									
		  }
	   }
	   int nPessoas = ler.nextInt();
	   String [] nome = new String [nPessoas];
	   double [][] pontos = new double [nPessoas] [14];
	   double media = 0;
	   for (int D = 0; D < nPessoas; D++) {
		   nome [D] = ler.nextLine(); // Mesmo caso do Scanner nextLine anterior
		   nome [D] = ler.nextLine();   // Só isso continua estranho...
		   for (int c = 0; c < 14; c++) {                          
			   pontos [D] [c] = ler.nextDouble();		   
			   
		   }
		   	   
	   }	   
	   double s = 0;
	   double s1 = 0;
	   double den = 0;
	   double [][] pts = new double [nCargos] [nPessoas];                      
	   for (int i = 0; i < nCargos; i++) {                             // Algo está errado por aqui
		   for (int k = 0; k < nPessoas; k++) {                       // Tentativa: trocar o último "for" por um método que calcula a média ponderada
			  pts [i][k] = calculaM (pontos[k],peso[i],s,s1,den,m);
		   }
		                                                              //Funcionou... só para o primeiro cargo
	   }
	   String [] nomes2 = nome.clone();
	   double te = 0;
	   String tem = "";
	   double [] [] pts2 = pts.clone();	   
	   for (int i = 0; i < nCargos; i++) {
		   System.out.println (cargo[i]);
		                                                                       //Tem algo errado por aqui... as médias estão corretas, mas as pessoas são mostradas em ordem diferente nos cargos diferentes do primeiro
		   organizar(te,tem,nomes2,i,pts2,nPessoas);                           // 3 "for" de novo.... tentar trocar o último por outro método talvez?
           System.out.println();                                              //Duplicar um objeto é diferente de duplicar algo do tipo primitivo....
		   pts2 = pts.clone();                                                //object.clone resolve o problema!
		   nomes2 = nome.clone();
           		   
			   

	   }	   
	}
	public static double calculaM (double [] po,double [] pe,double s,double s1,double den,double m) {
		for (int c = 0; c < 14; c++) {
			s1 = po[c] * pe[c];                  
			den += pe[c];                               
			s += s1;			
			  }
		m = s/den;		
		return (m);
	}
	public static void organizar (double te,String tem,String [] nomes2,int i,double [][] pts2,int nPessoas) {
		for (int g = 30; g > 0; g--) {
	        for (int k = nPessoas - 1; k > 0; k--) {
		        if ( pts2 [i] [k] > pts2 [i] [k-1]) {          
				    te = pts2 [i] [k];                        
				    pts2 [i] [k] = pts2 [i] [k-1];
				    pts2 [i] [k-1] = te;
				    tem = nomes2[k];
				    nomes2 [k] = nomes2 [k-1];
				    nomes2 [k-1] = tem;
				}
			}						
		}
		for (int c = 0; c < nomes2.length; c++) {
			   System.out.println (nomes2 [c]);
			}
		
	}
	

}
