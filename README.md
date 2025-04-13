# 🧙 RPG Character Management API 🛡️

Sistema desenvolvido em **Java + Spring Boot** para gerenciar personagens de RPG, seus atributos e itens mágicos (armas, armaduras, amuletos), com regras específicas para validação e atualização de atributos.


## 🚀 Funcionalidades

- Cadastrar Personagem (◕‿◕)
- Cadastrar Item Mágico (｡♥‿♥｡)
- Listar Personagem (¬‿¬)
- Buscar Personagem por Identificador (✿◠‿◠)
- Atualizar Nome Aventureiro por Identificador (｡•̀ᴗ•́｡)
- Remover Personagem (╯︵╰,)
- Listar Itens Mágicos (｡◕‿◕｡)
- Buscar Item Mágico por Identificador (o˘◡˘o)
- Adicionar Item Mágico ao Personagem (｡♥‿♥｡)
- Listar Itens Mágicos por Personagem (｡•̀ᴗ•́｡)
- Remover Item Mágico do Personagem (︶︹︶)
- Buscar Amuleto do Personagem (•̀ᴗ•́)و

## ⚙️ Tecnologias Utilizadas

- Java 17+ ☕
- Spring Boot ⚡
- Spring Data JPA 💾
- ModelMapper 🔄
- Lombok ✨
- H2 🍃
- Bean Validation (javax.validation) ✅

## 📌 Regras de Negócio

- ✅ **Força máxima permitida na criação do personagem:** `forca <= 10`
- ✅ **Só pode existir 1 amuleto por personagem**
- ✅ **Adição de item atualiza a força e defesa** automaticamente com base nos valores do item.


## 📬 Endpoints
| Método | Rota                                                   | Descrição                           |
|--------|--------------------------------------------------------|-------------------------------------|
| POST   | `/personagens   `                                      | Criar um novo personagem            |
| GET    | `/personagens  `                                       | Listar todos os personagens         |
| GET    | `/personagens/{id} `                                   | Buscar personagem por ID            |
| PUT    | `/personagens/{id} `                                   | Atualizar nome de aventureiro       |
| DELETE | `/personagens/{id} `                                   | Deletar personagem por ID           |
| POST   | `/personagens/{idCharacter}/itens-magicos/{idItem}`	  | Adicionar item mágico               |
| GET    |	`/personagens/{id}/itens-magicos`                     | Listar itens mágicos do personagem  |
| DELETE | `/personagens/{id}/itens-magicos/{itemId} `            | Deletar item mágico por ID          |
| GET    | `/personagens/{id}/amuleto`                            | Atribuir item mágico a personagem   |
| POST   | `/itens-magicos      `                                 | Criar um novo item mágico           |
| GET    | `/itens-magicos   `                                    | Listar todos os itens mágicos       |
| GET    | `/itens-magicos/{id} `                                 | Buscar item mágico por ID           |

📘 A documentação completa das rotas está disponível na coleção do Postman:  
👉 [Ver Collection]([https://www.postman.com/your-collection-link](https://www.postman.com/rhayssa/rpg/overview)) 🪄✨
