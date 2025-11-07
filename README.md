Relatorio
O presente relatório tem como objetivo comparar o desempenho entre dois modelos clássicos de mapeamento de threads — N:M e 1:1 — através de implementações em linguagem Java.

O modelo 1:1 cria uma thread de sistema para cada thread de usuário, proporcionando concorrência real, porém com maior consumo de recursos. Já o modelo N:M multiplica várias threads de usuário sobre um conjunto reduzido de threads do sistema operacional, o que diminui o custo de gerenciamento e melhora a escalabilidade.
