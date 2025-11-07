public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] quantidades = {10, 100, 500, 1000};
        int iteracoes = 50000;
        int m = 8;

        System.out.println("=== COMPARAÇÃO MODELOS N:M e 1:1 ===");
        System.out.println("Iterações por tarefa: " + iteracoes);
        System.out.println("M (threads do sistema no N:M): " + m + "\n");

        System.out.printf("%8s | %12s | %12s | %8s%n", "N", "N:M (ms)", "1:1 (ms)", "Mais Rápido");
        System.out.println("----------+--------------+--------------+----------");

        for (int n : quantidades) {
            ModeloNM modeloNM = new ModeloNM(n, m, iteracoes);
            Modelo1para1 modelo11 = new Modelo1para1(n, iteracoes);

            long tempoNM = modeloNM.executar();
            long tempo11 = modelo11.executar();

            String melhor = (tempoNM < tempo11) ? "N:M" : (tempo11 < tempoNM) ? "1:1" : "igual";
            System.out.printf("%8d | %12d | %12d | %8s%n", n, tempoNM, tempo11, melhor);
        }
    }
}
