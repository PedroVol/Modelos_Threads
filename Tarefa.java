public class Tarefa implements Runnable {
    private final int iteracoes;

    public Tarefa(int iteracoes) {
        this.iteracoes = iteracoes;
    }

    @Override
    public void run() {
        double acc = 0;
        for (int i = 1; i <= iteracoes; i++) {
            acc += Math.sqrt(i) * Math.sin(i);
        }
        if (acc == 0) {
            System.out.print("");
        }
    }
}
