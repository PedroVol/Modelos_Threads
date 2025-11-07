public class Modelo1para1 {
    private final int n;
    private final int iteracoes;

    public Modelo1para1(int n, int iteracoes) {
        this.n = n;
        this.iteracoes = iteracoes;
    }

    public long executar() throws InterruptedException {
        Thread[] threads = new Thread[n];

        long inicio = System.nanoTime();

        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(new Tarefa(iteracoes));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long fim = System.nanoTime();
        return (fim - inicio) / 1_000_000; 
    }
}
