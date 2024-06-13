package filaDoSupermercado;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCaixas = sc.nextInt();
        int numClientes = sc.nextInt();
        int[] produtosPorCaixa = new int[numCaixas];
        int[] produtosPorCliente = new int[numClientes];
        
        for (int i = 0; i < numCaixas; i++)
            produtosPorCaixa[i] = sc.nextInt();
        
        for (int i = 0; i < numClientes; i++)
            produtosPorCliente[i] = sc.nextInt();
        
        int[] tempoPorCaixa = new int[numCaixas];
        int indiceCliente = 0;
        while (indiceCliente < numClientes) {
            if (indiceCliente < numCaixas) {
                tempoPorCaixa[indiceCliente] = produtosPorCaixa[indiceCliente] * produtosPorCliente[indiceCliente];
                indiceCliente++;
            } else {
                int menorTempo = tempoPorCaixa[0];
                int indiceMenorTempo = 0;
                for (int i = 1; i < numCaixas; i++) {
                    if (tempoPorCaixa[i] < menorTempo) {
                        menorTempo = tempoPorCaixa[i];
                        indiceMenorTempo = i;
                    }
                }
                tempoPorCaixa[indiceMenorTempo] += produtosPorCaixa[indiceMenorTempo] * produtosPorCliente[indiceCliente];
                indiceCliente++;
            }
        }
        
        int maxTempo = tempoPorCaixa[0];
        for (int i = 1; i < numCaixas; i++) {
            if (tempoPorCaixa[i] > maxTempo)
                maxTempo = tempoPorCaixa[i];
        }
        
        System.out.println(maxTempo);

        sc.close();
    }
}
