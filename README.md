# Explorando Marte

Solução do problema proposto pelo teste.

 ## Build do projeto
```sh
$ mvn clean install assembly:single
```
## Execução

 A solução foi contruida com uma interface baseada em aquivo texto de comandos que deve ser passado como parâmetro do comando de execução.

* Formato do arquivo:
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

 Onde a primeira linha são as dimensões do Planalto onde a Sonda está, a segunda linha as coordenadas da Sonda e para qual direção está apontando e por fim a terceira linha os comandos de movimentação da Sonda.

* comando para execução
```sh
$ java -jar ARQUIVO_JAR ARQUIVO_TEXTO
```

* exemplo de execução
```sh
$ java -jar marte-0.0.1-SNAPSHOT-jar-with-dependencies.jar /tmp/i.txt
```

* saída

 O formato da saída é o seguinte:
```
1 3 N
5 1 E
```

 Onde as duas primeiras posições representam as coordenadas em que a Sonda ficou depois da execução dos comandos e a ultima posição representa para qual direção ela está apontando. E cada linha representa uma sonda por ordem de criação.
 
 ## Considerações
 
  Quando a sonda estiver se movimentando e chegar ao fim do planalto, foi considerado que ela não conseguira se movimentar e permanecerá na mesma posição em que estava.

 No arquivo de instruções sempre que for passado uma linha que representa um planalto, será considerado como uma atualização da informação. Uma linha de Sonda, sempre criará uma nova Sonda e por fim a linha de comandos será executada sempre pelas sondas em ordem de criação, portando se existir duas sondas criadas e três linhas de comandos de movimento, o primeiro e o ultimo conjunto de movimentos serão executados pela primeira sonda e o segundo pela segunda Sonda.
