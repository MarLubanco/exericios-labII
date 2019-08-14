## Relatório de desempenho de bibliotecas de leitura
#####  A analise das três bibliotecas deduziram que o Character Reader obteve um desempenho muito superior ao de seus concorrentes nos três tipos de arquivos (pequeno, médio e grande).

Nota: Primeiramente eu achei que o Byte Reader teria um desempenho melhor justamente por ser byte á byte, mas o Character Reader surpreendeu


| |Texto P (ms) | Texto M (ms) | Texto G (ms) | |
|---|---|---|---|---|
Byte Reader|19.0 milissegundos | 905.0 milissegundos| 28238.0 milissegundos | | |
Character Reader|  2.0 milissegundos| 12.0 milissegundos| 263.0 milissegundos| | |
Buffered Reader|42.0 milissegundos |82.0 milissegundos | 497.0 milissegundos| | |