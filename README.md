# 🎰 TeleSena

Simulação do sorteio da TeleSena feita em Java, desenvolvida como trabalho acadêmico.

## 📋 Sobre o projeto

O sistema simula uma edição completa da TeleSena, desde a venda das cartelas até o sorteio e premiação dos ganhadores.

## ⚙️ Como funciona

- 20 pessoas compram entre 1 e 15 TeleSenas cada
- Cada TeleSena possui 2 conjuntos de 25 números (de 1 a 60)
- O sorteio começa com 25 números e adiciona 1 por vez até haver um ganhador
- O prêmio equivale a 80% do total arrecadado, dividido igualmente entre os ganhadores
- O lucro do Sílvio Santos é os 20% restantes

## 📁 Estrutura

```
├── TeleSena.java         # Representa uma cartela
├── Pessoa.java           # Representa um participante
├── ControleTeleSena.java # Gerencia o sorteio e os resultados
├── Helper.java           # Métodos utilitários (sorteio, verificação de duplicatas)
└── App.java              # Classe principal
```

## 🚀 Como executar

```bash
javac *.java
java App
```

## 🛠️ Tecnologias

- Java
