#Descrição do Código
Este programa é uma ferramenta que pega instruções de um código Assembly MIPS e as transforma em código binário, que é o formato que os computadores entendem para executar as operações.

Aqui está o que o código faz, passo a passo:

#Leitura do Arquivo: O programa começa lendo um arquivo de texto que contém as instruções Assembly MIPS. Cada linha desse arquivo tem uma instrução diferente.

#Conversão de Instruções: Para cada instrução, o programa faz algumas traduções:

Se é uma instrução para carregar ou armazenar dados (como lw ou sw), ele transforma isso em um formato binário que o computador pode usar.
Se é uma instrução para fazer cálculos ou mover dados (como add ou sll), o programa também converte isso em binário.
Mapeamento de Dados: O programa usa uma "tabela de consulta" para saber qual número binário corresponde a cada comando e registrador. Assim, quando encontra algo como $t0, ele sabe exatamente qual código binário usar.

#Criação do Arquivo de Saída: Depois de converter todas as instruções, o programa escreve o resultado em um novo arquivo de texto, onde cada linha agora contém a instrução original em sua forma binária.

#Então, basicamente, o código transforma um programa escrito em Assembly MIPS em um formato que um computador pode executar, ajudando a fazer a transição do código humano para o código que a máquina entende!
