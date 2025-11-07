Relatorio



Nesse trabalho iremos comparar dois modelos de mapeamento de threads (N:M e 1:1). O modelo 1:1 cria uma thread de sistema para cada thread de usuário, proporcionando concorrência real, mas com maior consumo de recursos. E no modelo N:M, multiplica várias threads de usuário sobre um conjunto reduzido de threads do sistema operacional, o que diminui o custo de gerenciamento e melhora a escalabilidade.

No codigo o modelo N:M utiliza um pool fixo de threads com M = 8 threads reais, sendo distribuídas N tarefas de usuário. E no modelo 1:1 cada tarefa é executada em uma thread real independente.

<img width="611" height="336" alt="Captura de tela 2025-11-06 221019" src="https://github.com/user-attachments/assets/c0669bc4-8a93-4292-8032-1e046598ee43" />

No modelo 1:1 é bastante eficiente mas limitado a pequenas quantidades de threads, pois cada thread é executada diretamente como uma entidade do sistema operacional. No entanto, conforme o número de threads aumenta, o custo de criação e troca de contexto entre threads reais se torna relevante, levando à perda de desempenho. Já o modelo N:M, ao utilizar um número limitado de threads reais e multiplicar as tarefas, apresenta melhor escalabilidade e aproveitamento dos núcleos disponíveis, mantendo o crescimento do tempo de execução mais controlado. Provando que o modelo 1:1 é indicado para aplicações com poucas threads e alta necessidade de paralelismo real. No entanto, o modelo N:M é mais eficiente em aplicações altamente concorrentes, reduzindo a sobrecarga de criação e gerenciamento de threads.
Portanto, para workloads massivamente concorrentes, o modelo N:M se mostra mais vantajoso em termos de escalabilidade e estabilidade de desempenho.
