
# Título do Projeto

Uma breve descrição sobre o que esse projeto faz e para quem ele é


## Documentação da API

#### Retorna todos os itens

```http
  Post /usuario
```

```http
  Post /usuario
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `string` | **Obrigatório**. O nome do Usuário |
| `email`      | `string` | **Obrigatório**. O email do Usuário |
| `password`      | `string` | **Obrigatório**. A do Usuário |

#### createUser(UserDto)

Faz Cadastro do Usuário


```http
  Put /usuario
```

```http
  Put /usuario
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `Id`      | `UUID` | **Obrigatório**. O id do Usuário |
| `name`      | `string` | **Obrigatório**. O nome do Usuário |
| `email`      | `string` | **Obrigatório**. O email do Usuário |
| `password`      | `string` | **Obrigatório**. A do Usuário |

#### editUser(UserDto)

Faz a Edição do Usuário


```http
  Post /login
```

```http
  Post /login
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `email`      | `string` | **Obrigatório**. O email do Usuário |
| `password`      | `string` | **Obrigatório**. O password do Usuário |

#### login(DataRequestLogin)

Faz a Autentificação e Retorna um Token de Acesso


```http
  Post /curso
```

```http
  Post /curso
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `string` | **Obrigatório**. O nome do Curso |
| `cateogory`      | `string` | **Obrigatório**. A Categoria do Curso |

#### createCourse(CourseDto)

Faz o cadastro do Curso

```http
  Get /curso/{id}
```

```http
  Get /curso/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `Id`      | `UUID` | **Obrigatório**. O id Obrigatório do Curso |

#### getCourseById(UUID id)

Faz a busca  do Curso por Identificação


```http
  Post /respostas
```

```http
  Post /respostas
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `message`      | `String` | Não pode ser Nulo a messagem|
| `topicId`      | `UUID` | Não pode ser Nulo a identificacão|
| `authorId`      | `UUID` | Não pode ser Nulo a identificacão|
| `solution`      | `boolean` | Opcional|


#### createResponse(ResponseDto)

Faz a Resposta Ao Topico


```http
  Get /respostas/{id}
```

```http
  Get /respostas/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `UUID` | Não pode ser Nulo o Identificador|



#### getResponseById(UUID)

Busca A resposta por Identificação


```http
  Post /topico
```

```http
  Post /topico
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `title`      | `string` | Não pode ser Nulo o Titulo|
| `message`      | `string` | Não pode ser Nulo a messagem|
| `status`      | `string` | Não pode ser Nulo o status|
| `userId`      | `UUID` | Não pode ser Nulo a identificacão do Usuário|
| `courseId`      | `UUID` | Não pode ser Nulo a identificacão do Curso|

#### createTopic(TopicDto)

Criar Topico 


```http
  Get /topico/{id}
```

```http
  Get /topico/{id}
```

| `id`      | `UUID` | Não pode ser Nulo a identificacão do Tópico|

#### getTopicById(TopicDto)

Busca o Tópico por Identificação

```http
  Put /topico/{id}
```

```http
  Put /topico/{id}
```

| `id`      | `UUID` | Não pode ser Nulo a identificacão do Tópico|
| `title`      | `string` | Não pode ser Nulo o Titulo|
| `message`      | `string` | Não pode ser Nulo a messagem|
| `status`      | `string` | Não pode ser Nulo o status|
| `userId`      | `UUID` | Não pode ser Nulo a identificacão do Usuário|
| `courseId`      | `UUID` | Não pode ser Nulo a identificacão do Curso|


#### updateTopic(TopicDto)

Atualização do Tópico


```http
  Delete /topico/{id}
```

```http
  Delete /topico/{id}
```

| `id`      | `UUID` | Não pode ser Nulo a identificacão do Tópico|

#### deleteTopic(UUID)

Deleta Tópico por Identificação


```http
  Get /topico
```

```http
  Get /topico
```
#### getAllTopics(UUID)

Retorna os Tópicos Paginados



