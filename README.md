# dio-spring-ai-budget-api
Desafio API Inteligente com Reconhecimento de Fala e Spring Boot na DIO
# API de Orçamento Inteligente - Trilha Spring Boot DIO

Este projeto foi desenvolvido como solução para o desafio de Spring AI da plataforma DIO. A API implementa um sistema de gerenciamento de orçamento que recebe comandos de voz, transcreve o áudio para texto e processa a intenção do usuário para registrar transações financeiras automaticamente através de funções reais do sistema (Tool Calling).

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3
- Spring AI Starter
- OpenAI (Whisper para transcrição e GPT para inferência de intenção)

## Estrutura do Projeto
A arquitetura foi dividida seguindo os princípios de responsabilidade e separação de conceitos:
- `domain`: Contém o record Transaction, que representa o modelo de dados imutável do sistema.
- `application`: Centraliza a lógica de negócio no BudgetService, coordenando a chamada ao modelo de áudio e o fluxo do ChatClient.
- `infrastructure`: Divide-se em `http` para expor o endpoint REST e `tools` para mapear os métodos funcionais que a IA pode disparar.

## Como Executar
1. Clone o repositório.
2. Configure a variável de ambiente da OpenAI:
   export SPRING_AI_OPENAI_API_KEY="sua_chave_aqui"
3. Execute a aplicação através do comando Maven:
   mvn spring-boot:run

## O que aprendi neste desafio
O desenvolvimento deste lab foi essencial para compreender como o ecossistema Spring AI abstrai a comunicação com LLMs, permitindo que ferramentas externas sejam acionadas via código Java (Tool Calling) a partir de comandos de voz não estruturados de forma simples e segura.
