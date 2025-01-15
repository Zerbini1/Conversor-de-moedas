import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsultaMoedas consultaMoedas = new ConsultaMoedas();
        Scanner leitura = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("1) Dolar -> Peso argentino");
            System.out.println("2) Peso argentino -> Dolar");
            System.out.println("3) Dolar -> Real");
            System.out.println("4) Real -> Dolar");
            System.out.println("5) Dolar -> Peso colombiano");
            System.out.println("6) Peso colombiano -> Dolar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção: ");
            var opcoes = Integer.parseInt(leitura.nextLine());

            if (opcoes == 7) {
                continuar = false;
                System.out.println("Encerrando o programa...");
                break;
            }

            System.out.println("Digite o valor que deseja converter: ");
            double valor = Double.parseDouble(leitura.nextLine());

            String moedaDe = "";
            String moedaPara = "";
            double conversao;

            switch (opcoes) {
                case 1:
                    moedaDe = "USD";
                    moedaPara = "ARG";
                    break;

                case 2:
                    moedaDe = "ARG";
                    moedaPara = "USD";
                    break;

                case 3:
                    moedaDe = "USD";
                    moedaPara = "BRL";
                    break;

                case 4:
                    moedaDe = "BRL";
                    moedaPara = "USD";
                    break;

                case 5:
                    moedaDe = "USD";
                    moedaPara = "COP";
                    break;

                case 6:
                    moedaDe = "COP";
                    moedaPara = "USD";
                    break;

                default:
                    System.out.println("Opção inválida");
                    continue;
            }

            Moedas cotacao = consultaMoedas.buscaMoedas(moedaDe, moedaPara);
            if (cotacao == null || cotacao.conversion_rate() == null) {
                System.out.println("Erro ao obter a taxa de conversão. Tente novamente.");
                continue;
            }

            conversao = cotacao.conversion_rate() * valor;
            System.out.println("Valor " + valor + " " + moedaDe + " equivale a " + conversao + " " + moedaPara);
        }

        leitura.close();
    }
}
