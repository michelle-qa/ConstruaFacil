// 1 - Pacote <endereço; onde que fica>
package devcal;
// 2 - Bibliotecas <o que ele recebe dos outros programas>

import java.util.Scanner;

// 3 - Classes < quem é o JOão>
public class Calc {
    // 3.1 - Atributos <como ele é>
    static Scanner entrada = new Scanner(System.in); //entrada = input


    // 3.2 - Métodos e funções <são as ações >
    //os Métodos podem ser Públicos: que maria pode ver o que João faz. E
    //Privado ninguém pode ver apenas o João
    public static void main(String[] args){
        //exibe o menu da calculadora
        System.out.println(">>> CALCULADORA <<<<");
        System.out.println("(1) somar");
        System.out.println("(2) subtrair");
        System.out.println("(3) multiplicar");
        System.out.println("(4) dividir");
        System.out.println("Escolha o Calculo Desejado");
        System.out.println("Passou pelo método main");

        //recebe a opcao desejada
        int opcao = entrada.nextInt();
        int num1 = 0;
        int num2 = 0;
        //Pergunta os valores a serem usados no calculo

        if (opcao >= 1 && opcao <= 4) {
            System.out.println("Entre o 1º numero: ");
            num1 = entrada.nextInt();
            System.out.println("Entre o 2º numero: ");
            num2 = entrada.nextInt();
        }
        //Chama a função do calculo desejada
        switch (opcao){
            case 1:
                somarDoisNumeros(num1, num2);
                break;

            default:
                System.out.println("Opcao invalida");
                break;

        }

        System.out.print("Passou pelo método main");
    }

    public static int somarDoisNumeros(int num1, int num2){

        System.out.println("Passou pelo método somarDoisNumeros");
        return num1 + num2;



    }

}
