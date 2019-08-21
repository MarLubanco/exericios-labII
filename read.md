
<div align="center">
      <img alt="react-sketchapp" src="contacts_ui_design-.png" style="max-height:163px; width:100; height: auto; max-width:100%" />
</div>

<div align="center">
  <strong>Lista Telefônica By Terminal</strong>
</div>

## Start Project🏃‍

Ao iniciar o projeto, será listado um menu com 4 opções:
- **INSERIR —** Essa função é para adicionar um novo contato, os parâmetros são nome e números (separados por ";") .
-  **DELETAR —** Essa função é para remover um usuário do banco de dados através de seu número de telefone.
- **PESQUISAR —** Essa função é para pesquisar por nome ou número do contato, é necessário inserir no minimo uma letra para realizar a pesquisa.
- **LISTAR —** Essa função é para listar todos os contatos existentes na lista telefônica do usuário.
First, make sure you have installed [Sketch](http://sketchapp.com) version 50+, & a recent [npm](https://nodejs.org/en/download/).

Colaborar para a atividade:

```bash
git https://github.com/MarLubanco/exericios-labIII.git
cd exericios-labIII

npm run render
```

## Documentação
- **Caso de Uso —**

![readme-intro](documentacao/caso de uso/caso-de-uso-final.png)

- **Diagrama de Sequência —**

![readme-intro](documentacao/diagrama-sequencia/diagrama-sequencia-final.png)

- **Diagrama de Classe —**

![readme-intro](documentacao/diagrama-classe/diagrama-classe-final.png)

[![npm](https://img.shields.io/npm/v/react-sketchapp.svg)](https://www.npmjs.com/package/react-sketchapp) ![Sketch.app](https://img.shields.io/badge/Sketch.app-43--50-brightgreen.svg) [![Travis](https://img.shields.io/travis/rust-lang/rust.svg)](https://travis-ci.org/airbnb/react-sketchapp) [![Gitter](https://img.shields.io/gitter/room/nwjs/nw.js.svg)](https://gitter.im/react-sketchapp/Lobby)

## Documentation

- [Examples](http://airbnb.io/react-sketchapp/docs/examples.html)
- [API Reference](http://airbnb.io/react-sketchapp/docs/API.html)
- [Styling](http://airbnb.io/react-sketchapp/docs/styling.html)
- [Universal Rendering](http://airbnb.io/react-sketchapp/docs/guides/universal-rendering.html)
- [Data Fetching](http://airbnb.io/react-sketchapp/docs/guides/data-fetching.html)
- [FAQ](http://airbnb.io/react-sketchapp/docs/FAQ.html)
- [Contributing](http://airbnb.io/react-sketchapp/CONTRIBUTING.html)



## Relatório de desempenho de bibliotecas de leitura
#####  A analise das três bibliotecas deduziram que o Character Reader obteve um desempenho muito superior ao de seus concorrentes nos três tipos de arquivos (pequeno, médio e grande).

Nota: Primeiramente eu achei que o Byte Reader teria um desempenho melhor justamente por ser byte á byte, mas o Character Reader surpreendeu


| |Texto P (ms) | Texto M (ms) | Texto G (ms) | |
|---|---|---|---|---|
Byte Reader|19.0 milissegundos | 905.0 milissegundos| 28238.0 milissegundos | | |
Character Reader|  2.0 milissegundos| 12.0 milissegundos| 263.0 milissegundos| | |
Buffered Reader|42.0 milissegundos |82.0 milissegundos | 497.0 milissegundos| | |