
public class exercicio1 {

	public static int metodo(int valor, int[] vetor, int pos) {
		if(pos == vetor.length)
			return -1;
		if(valor == vetor[pos])
			return pos;
		else
			return metodo(valor, vetor, pos+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vet = {12, 7, 3, 6, 8, 10};
		System.out.println(metodo(8, vet, 0));
	}

}
