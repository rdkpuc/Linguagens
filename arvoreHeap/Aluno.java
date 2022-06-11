/** 
 * MIT License
 *
 * Copyright(c) 2022 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.Random;

/** Classe Aluno para demonstração de fila de prioridades (sem recursos de POO) */
public class Aluno {
    
    static Random sorteio = new Random();   //para sortear as matrículas
    static final int QTAS_AVALIACOES = 4;
    String nome; 
    int matricula;  //identificador
    double[] notas;
    int quantasNotas;
    
    /**
     * Construtor: recebe o nome do aluno, sorteia a matrícula e cria um vetor com 4 notas 0.0
     * @param nomeAluno
     */
    public Aluno(String nomeAluno){
        nome = nomeAluno;
        matricula = 100_000+ sorteio.nextInt(899_999);
        quantasNotas = 0;
        notas = new double[QTAS_AVALIACOES];
    }
    
    /**
     * Lança a nota na próxima avaliação livre. Caso contrário, ignora a operação
     * @param nota Nota a ser lançada - valor maior ou igual a 0
     */
    public void lancarNota(double nota){
        if(quantasNotas < QTAS_AVALIACOES){
            if (nota >= 0) {
                notas[quantasNotas] = nota;
                quantasNotas++;
            }
        }
    }

    /**
     * Calcula a nota atual do aluno a partir das notas lançadas.
     * @return A nota atual, em double
     */
    public double notaFinal(){
        double aux=0d;
        for(int j=0; j<quantasNotas; j++){
            aux+= notas[j];
        }
        return aux;
    }

    /**
     * Verifica se o aluno tem nota melhor que uma média recebida por parâmetro
     * @param mediaDaTurma O valor médio a comparar
     * @return TRUE para aluno acima da média, FALSE caso contrário
     */
    public boolean acimaDaMedia(double mediaDaTurma){
        return (notaFinal() > mediaDaTurma);
    }

    /**
     * Verifica se o aluno está aprovao em relação a uma nota mínima recebida por parâmetro
     * @param notaMinima O mínimo para aprovação
     * @return TRUE se aprovado, FALSE caso contrário
     */
    public boolean aprovado(double notaMinima){
        return acimaDaMedia(notaMinima);
    }

    //////// MÉTODOS DE COMPARAÇÃO: FILA DE PRIORIDADES E ORDENAÇÃO

    /**
     * Verifica se um aluno é igual ao outro, ou seja, têm matrículas iguais
     * @param outro O aluno a comparar com este
     * @return TRUE se têm a mesma matrícula, FALSE caso contrário
     */
    public  boolean ehIgual(Aluno outro){
        return this.matricula == outro.matricula;
    }
    
    /**
     * Verifica se um aluno tem matrícula menor que outro
     * @param outro O aluno a comparar com este
     * @return TRUE se a matrícula é menor, FALSE caso contrário
     */
   public  boolean ehMenor(Aluno outro){
       return this.matricula < outro.matricula;
   }

   /**
     * Verifica se um aluno tem matrícula prioritária em relação a outro (maior matrícula)
     * @param outro O aluno a comparar com este
     * @return TRUE se a matrícula é prioritária, FALSE caso contrário
     */
   public boolean prioritario(Aluno outro){
       return this.matricula > outro.matricula;
   }
}


/// DADOS: Aluno  (guarda os dados de interesse)
/// APONTADOR/ELEMENTO: Aluno + ponteiro (mantem a estrutura de dados)
/// ESTR.DADOS (regras de insercao, retirada (pesquisa))