
public class recursividade {
	static void inverter(String frase, int pos) {
		char letra;
		letra = frase.charAt(pos);
		if(letra!='.') {
			inverter(frase, pos+1);
			System.out.println(letra);
		}
	}
	
	///////////////////////////////////////////////////////
	static int potencia(int a, int b) {
		int resultado = a;
		if(b==0)
			return 1;
		else 
			return resultado*=potencia(a, b-1);
	}
	
	///////////////////////////////////////////////////////
	static int somaRecursiva(int[] vetor, int pos) {
	if(pos==vetor.length)
		return 0;
	else
		return vetor[pos]+somaRecursiva(vetor, pos+1);
	}
	
	public static void main(String[] args) {
		int[] vetor = {12, 2, 3, 4, 5, 8};
		System.out.print(somaRecursiva(vetor, 0));
	}

}
