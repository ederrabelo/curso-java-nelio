package application;

import java.util.Scanner;

public class MatrizExercicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Linhas: ");
        int l = sc.nextInt();
        System.out.print("Colunas: ");
        int c = sc.nextInt();

        int[][] mat = new int[l][c];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        Integer pos = sc.nextInt();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == pos) {
                    System.out.println();
                    System.out.println("Posição " + i + ", " + j + ": ");

                    int jEsquerda = j - 1;
                    int jDireita = j + 1;
                    int iCima = i - 1;
                    int iBaixo = i + 1;

                    Integer esquerda = null;
                    Integer direita = null;
                    Integer cima = null;
                    Integer baixo = null;

                    if (isPosicaoValida(l, c, jEsquerda, 'C')) {
                        esquerda = mat[i][jEsquerda];
                    }

                    if (isPosicaoValida(l, c, jDireita, 'C')) {
                        direita = mat[i][jDireita];
                    }

                    if (isPosicaoValida(l, c, iCima, 'L')) {
                        cima = mat[iCima][j];
                    }

                    if (isPosicaoValida(l, c, iBaixo, 'L')) {
                        baixo = mat[iBaixo][j];
                    }

                    if (esquerda != null) {
                        System.out.println("Esquerda: " + esquerda);
                    }

                    if (direita != null) {
                        System.out.println("Direita: " + direita);
                    }

                    if (cima != null) {
                        System.out.println("Cima: " + cima);
                    }

                    if (baixo != null) {
                        System.out.println("Baixo: " + baixo);
                    }

                }
            }
        }

        sc.close();
    }

    public static boolean isPosicaoValida(int qtdLinhas, int qtdColunas, int posicao, char linhaOuColuna) {
        if (posicao < 0 || (posicao > (qtdLinhas - 1) && linhaOuColuna == 'L')
                || (posicao > (qtdColunas - 1)) && linhaOuColuna == 'C') {
            return false;
        } else {
            return true;
        }
    }
}
