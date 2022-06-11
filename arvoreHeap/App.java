import java.util.Random;
import java.util.Scanner;

public class App {
    
    static String[] nomes = {"Lucas", "Americo", "Daniel", "Brenda", "Fernanda",
                             "Leonardo", "Diogo", "Nathan", "Luiz", "Matheus", "Caio"};
    static Random sorteio = new Random(System.currentTimeMillis());
    
    static void testeAluno(){
        HeapArrayAluno filaPrioProd = new HeapArrayAluno(10);
        int quantAlunos = nomes.length;
        
        System.out.println("Alunos inseridos: ");
        for(int i=0; i<quantAlunos; i++){
            Aluno novo = new Aluno(nomes[i]);
            System.out.println(novo.matricula+ " - "+novo.nome);
            filaPrioProd.inserir(novo);
        }
      
        System.out.println("-----------------------");
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();
        System.out.println(filaPrioProd.imprimir());
        
        //PARA TESTAR QUANDO O DOWNHEAP FOR IMPLEMENTADO
        Aluno maiorMatricula = filaPrioProd.retirar();
        Aluno segundaMaiorMatricula = filaPrioProd.retirar();
        System.out.println("Última matrícula: "+maiorMatricula.matricula+" - "+maiorMatricula.nome);

        System.out.println("Segundo: "+segundaMaiorMatricula.matricula+" - "+segundaMaiorMatricula.nome);
        System.out.println("\n"+filaPrioProd.imprimir());
        System.out.println("FIM");
        teclado.close();
    }

    static void testeTamanho(){
        HeapArrayAluno filaPrioProd = new HeapArrayAluno(2);
        int quantAlunos = nomes.length;
        
        System.out.println("Alunos inseridos: ");
        for(int i=0; i<quantAlunos; i++){
            Aluno novo = new Aluno(nomes[i]);
            System.out.println(novo.matricula+ " - "+novo.nome);
            filaPrioProd.inserir(novo);
        }
      
        System.out.println("-----------------------");
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();
        System.out.println(filaPrioProd.imprimir());

               
        System.out.println("FIM");
        teclado.close();
    }
       
    
    public static void main(String[] args) throws Exception {
       testeAluno();
       
    }
}
