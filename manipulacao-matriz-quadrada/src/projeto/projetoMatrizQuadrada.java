package projeto;
import javax.swing.JOptionPane;

public class projetoMatrizQuadrada {
    
    //Amanda Silva Fonseca
    
    public static void main(String[] args) {
        //Variável para encerrar o programa
        int op = 0;

        //Loop para o usuário digitar a matriz quantas vezes quiser
        do {
            //Variável que determina o tamanho da matriz
            int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho da matriz: "));

            //IF -> Para garantir que a matriz seja gerada corretamente
            if (tamanho > 1) {
                //Criação da matriz
                double matriz[][] = new double[tamanho][tamanho];

                //Preenchimento da matriz
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        matriz[i][j] = Double.parseDouble(JOptionPane.showInputDialog("Digite os números desejados: \n"
                                + "POSIÇÃO [" + i + "][" + j + "]"));
                    }
                }

                //Mostrar a matriz 
                String mostraMatriz = "";
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        mostraMatriz += String.format("%10.2f", matriz[i][j]) + " ";
                    }
                    mostraMatriz += "\n";
                }

                //Mostrar a matriz e os cálculos
                JOptionPane.showMessageDialog(null,
                                "Matriz:\n\n" + mostraMatriz +
                                "\nSoma: " + soma(matriz) +
                                "\nMaior: " + maior(matriz) +
                                "\nMenor: " + menor(matriz) +
                                "\nSoma diagonal pricipal: " + somaDp(matriz) +
                                "\nSoma diagonal secundária: " + somaDs(matriz) +
                                "\nSoma das diagonais: " + (somaDp(matriz)+somaDs(matriz)));
                
                //Pergunta se o usuário deseja inserir uma nova matriz
                op = JOptionPane.showConfirmDialog(null,
                        "Deseja inserir uma nova matriz?","Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Digite um número maior que 1!");
                
            }
                
        } while (op == 0);
    }

    //Método para cálculo da soma
    public static double soma(double m[][]) {
        double res = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                res += m[i][j];
            }
        }
        return res;
    }
    
    //Método para cálculo do maior número
    public static double maior(double m[][]) {
        double maior = m[0][0];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] > maior) {
                    maior = m[i][j];
                }
            }
        }
        return maior;
    }

    //Método para cálculo do menor número
    public static double menor(double m[][]) {
        double menor = m[0][0];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] < menor) {
                    menor = m[i][j];
                }
            }
        }
        return menor;
    }

    //Método para cálculo da soma da diagonal principal
    public static double somaDp(double m [][]){
        double dp = 0;
        for (int i = 0; i < m.length; i++) {
            dp += m[i][i];
        }
        return dp;
    }
    
    //Método para cálculo da soma da diagonal secundária
    public static double somaDs(double m [][]){
        double ds = 0; 
        int n = m.length;
        for (int i = 0; i < n; i++) {
            ds += m[i][n - 1 - i];
        }
        return ds;
    }
    
}
