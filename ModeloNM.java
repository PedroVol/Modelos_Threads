import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ModeloNM {
    private final int n;
    private final int m;
    private final int iteracoes;

    public ModeloNM(int n, int m, int iteracoes) {
        this.n = n;
        this.m = m;
        this.iteracoes = iteracoes;
    }

    public long executar() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(m);
        List<Callable<Void>> tarefas = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tarefas.add(() -> {
                new Tarefa(iteracoes).run();
                return null;
            });
        }

        long inicio = System.nanoTime();
        pool.invokeAll(tarefas);
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.HOURS);
        long fim = System.nanoTime();

        return TimeUnit.NANOSECONDS.toMillis(fim - inicio);
    }
}
