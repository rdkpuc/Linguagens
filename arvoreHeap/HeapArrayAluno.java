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

/**
 * Classe Fila de Prioridades com array/vetor. Parcialmente implementada, sem recursos de polimorfismo.
 */
public class HeapArrayAluno {
    
    int tamanhoMaximo;
    int quantElementos;
    Aluno[] dados;

    /**
     * Construtor para heap de tamanho pré-definido
     * @param maximo O tamanho máximo da heap
     */
    public HeapArrayAluno(int maximo){
        tamanhoMaximo = maximo;
        quantElementos = 0;
        dados = new Aluno[tamanhoMaximo];
    }

    /**
     * Procedimento auxiliar para verificar a subida de elementos prioritários.
     * @param posicao Posição a ser verificada
     */
    public void upheap(int posicao){

        if(posicao==0)  // base da recursividade: raiz(pos 0) não tem pai
            return;
        else{
            int pai = (posicao-1)/2;

            if(dados[posicao].prioritario(dados[pai])){
                troca(posicao, pai);
                upheap(pai);    //só precisa verificar o pai se houve troca.
            }
        }
    }

    private void troca(int pos1, int pos2){
        Aluno aux = dados[pos1];
                dados[pos1] = dados[pos2];
                dados[pos2] = aux;
    }

    /**
     * Insere um novo elemento na fila de prioridade. Redimensiona a fila se necessário.
     * @param novo Aluno a ser inserido
     */
    public void inserir(Aluno novo){
        if(quantElementos==tamanhoMaximo)
            redimensionar();

        dados[quantElementos] = novo;
        upheap(quantElementos);
        quantElementos++;
    }

    /**                     
     * Método interno para redimensionar o vetor, caso atinja a capacidade máxima. Acrescenta 20 ao tamanho atual. A ser usado com responsabilidade, pois é uma operação lenta.
     */
    private void redimensionar(){
        Aluno[] novoVetor = new Aluno[this.dados.length+20];
        for (int i = 0; i < quantElementos; i++) {
           novoVetor[i] = dados[i];
        }
        tamanhoMaximo = novoVetor.length;
        this.dados = novoVetor;
    }
    
    /**
     Procedimento auxiliar para verificar a descida de elementos prioritários.
     * @param posicao Posição a ser verificada
     */
    public void downheap(int posicao){
        int posFilhoUm = (2*posicao)+1;
        int posFilhoDois = (2*posicao)+2;
        if(dados[posFilhoDois]!=null && dados[posFilhoUm]!=null){
            if(dados[posFilhoUm].prioritario(dados[posFilhoDois])){
                if(dados[posFilhoUm].prioritario(dados[posicao])){
                    Aluno aux = dados[posicao];
                    dados[posicao] = dados[posFilhoUm];
                    dados[posFilhoUm] = aux;
                }
            }
            else{
                if(dados[posFilhoDois].prioritario(dados[posicao])){
                    Aluno aux = dados[posicao];
                    dados[posicao] = dados[posFilhoDois];
                    dados[posFilhoDois] = aux;
                }
            }
        }
    }                 

    /**
     * Procedimento de retirada da fila. Retorna o mais prioritário (maior matrícula) e reorganiza a fila com downheap
     * @return Aluno retirado (null se a fila estiver vazia)
     */
    public Aluno retirar(){
        if(quantElementos > 0){
            Aluno retirada = dados[0];
            quantElementos--;
            dados[0] = dados[quantElementos];
            dados[quantElementos] = null;
            downheap(0);
            return retirada;
        }
        else
            return null;
    }  
    
    /**
     * Imprime a fila na ordem atual (mais prioritário na raiz/pos 0)
     * @return String com os elementos, um em cada linha
     */
    public String imprimir(){
        StringBuilder aux = new StringBuilder("Ordem da heap: \n");
        for(int i=0; i<quantElementos; i++)
            aux.append(dados[i].matricula + " -> "+dados[i].nome+"\n");

        aux.append("-------------------------------\n");
        return aux.toString();
    }
}
