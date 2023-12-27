# Actuator

Os endpoints do atuador são um conjunto de pontos de extremidade baseados na web fornecidos por um aplicativo de software para monitorar e interagir com o aplicativo em tempo de execução. Esses endpoints expõem várias informações operacionais e de gerenciamento sobre o aplicativo, facilitando a compreensão de seu comportamento, diagnóstico de problemas e realização de determinadas tarefas administrativas. Os endpoints do atuador são comumente usados no contexto de microsserviços e aplicativos da web.

Alguns endpoints típicos do atuador incluem:

1. **Endpoint de Saúde (`/actuator/health`):** Fornece informações sobre a saúde do aplicativo, indicando se está funcionando sem problemas ou se há algum problema.

2. **Endpoint de Informações (`/actuator/info`):** Exibe informações arbitrárias sobre o aplicativo. Os desenvolvedores podem personalizar este endpoint para incluir detalhes sobre a versão do aplicativo, informações de compilação, etc.

3. **Endpoint de Métricas (`/actuator/metrics`):** Expõe várias métricas e estatísticas sobre o aplicativo, como uso de memória, estatísticas de coleta de lixo e muito mais.

4. **Endpoint de Ambiente (`/actuator/env`):** Mostra informações sobre o ambiente do aplicativo, incluindo propriedades e configurações.

5. **Endpoint de Beans (`/actuator/beans`):** Lista todos os beans do Spring no aplicativo, fornecendo detalhes sobre cada bean.

6. **Endpoint de Mapeamentos (`/actuator/mappings`):** Exibe uma lista de todos os pontos de extremidade HTTP disponíveis no aplicativo, juntamente com informações sobre mapeamentos de solicitações.

7. **Endpoint de Desligamento (`/actuator/shutdown`):** Permite desligar o aplicativo de maneira controlada. Este endpoint pode exigir uma configuração de segurança adequada para evitar o acesso não autorizado.

É importante observar que, embora os endpoints do atuador sejam valiosos para monitorar e gerenciar aplicativos, sua exposição deve ser controlada em um ambiente de produção para garantir a segurança. O acesso a endpoints sensíveis, como o de desligamento, deve ser restrito e protegido com mecanismos apropriados de autenticação e autorização.

## Configurações Específicas 

A propriedade `management.endpoints.web.exposure.include` é uma configuração específica do Spring Boot que controla quais endpoints do atuador estarão expostos (habilitados) através da interface da web. O atuador fornece vários endpoints para monitorar e gerenciar a aplicação, e essa propriedade permite que defina quais deles devem ser acessíveis via HTTP.

A configuração `management.endpoints.web.exposure.include=*` indica que todos os endpoints do atuador devem ser expostos através da interface da web. Ou seja, todos os endpoints disponíveis, como `/actuator/health`, `/actuator/metrics`, `/actuator/info`, entre outros, estarão acessíveis via HTTP.

Essa configuração é útil quando você deseja expor todos os endpoints do atuador para fins de monitoramento, diagnóstico e gerenciamento. No entanto, em ambientes de produção, é importante considerar a segurança e restringir o acesso a certos endpoints, especialmente aqueles que podem ter informações sensíveis.

Exemplo de configuração no arquivo `application.properties`:

```properties
management.endpoints.web.exposure.include=*
```

Essa configuração pode ser ajustada para incluir apenas os endpoints específicos que deseja expor. Por exemplo, se estiver interessado apenas nos endpoints de saúde e informações, poderia ser configurado da seguinte maneira:

```properties
management.endpoints.web.exposure.include=health,info
```

Isso limitaria a exposição apenas aos endpoints de saúde e informações, proporcionando um controle mais fino sobre quais recursos estão disponíveis através da interface da web.

A propriedade `management.info.env.enabled` é uma configuração específica do Spring Boot que controla se as informações do ambiente (como propriedades do sistema, variáveis de ambiente, configurações do aplicativo, etc.) devem ser incluídas nos detalhes fornecidos pelo endpoint `/actuator/info`.

Quando `management.info.env.enabled=true`, significa que as informações do ambiente serão incluídas no endpoint `/actuator/info`. Este endpoint fornece informações arbitrárias sobre o aplicativo, e as informações do ambiente podem ser úteis para entender o contexto em que o aplicativo está sendo executado.

Por exemplo, as informações do ambiente podem incluir detalhes sobre:

- Propriedades do sistema (por exemplo, informações sobre o sistema operacional).
- Variáveis de ambiente definidas no sistema.
- Configurações específicas do ambiente de execução.

Exemplo de configuração no arquivo `application.properties`:

```properties
management.info.env.enabled=true
```

Ao acessar o endpoint `/actuator/info` da sua aplicação, você verá informações adicionais do ambiente, além de quaisquer outras informações personalizadas que você tenha configurado para serem exibidas nesse endpoint.

É importante ter cuidado ao expor informações do ambiente, especialmente em ambientes de produção, para garantir que dados sensíveis não sejam inadvertidamente divulgados. Certifique-se de revisar e restringir o acesso a essas informações, conforme necessário, dependendo dos requisitos de segurança da sua aplicação.

## Propriedades Customizadas

As propriedades (`info.app.name`, `info.app.version`, `info.app.description`, `info.author`) são propriedades personalizadas de informações do aplicativo que pode configurar no arquivo de propriedades (`application.properties` ou `application.yml`) do seu projeto Spring Boot. Essas informações personalizadas podem ser acessadas através do endpoint `/actuator/info`.

Vamos supor que você tenha as seguintes configurações no seu arquivo `application.properties`:

```properties
info.app.name=Spring Boot Actuator Example
info.app.version=V1.0.0
info.app.description="This is Spring Boot Actuator POC Project"
info.author=Daniel
```

Agora, ao acessar o endpoint `/actuator/info` da sua aplicação Spring Boot (por exemplo, `http://localhost:8080/actuator/info`), você verá um JSON contendo as informações personalizadas que você configurou:

```json
{
  "app": {
    "name": "Spring Boot Actuator Example",
    "version": "V1.0.0",
    "description": "This is Spring Boot Actuator POC Project"
  },
  "author": "Daniel"
}
```

Cada propriedade personalizada é agrupada sob uma chave correspondente no JSON de resposta do endpoint `/actuator/info`.

Portanto, ao acessar `http://localhost:8080/actuator/info`, você verá as informações personalizadas do seu aplicativo, além de quaisquer outras informações padrão ou personalizadas configuradas nesse endpoint. Isso pode ser útil para fornecer detalhes sobre a versão do aplicativo, descrição, autor e outros dados relevantes. Lembre-se de que o formato exato pode variar dependendo da versão específica do Spring Boot e das configurações adicionais que você tenha no seu projeto.

## Spring Security para Actuator Endpoints 

As propriedades `spring.security.user.name` e `spring.security.user.password` são usadas para configurar um usuário com nome de usuário (username) e senha (password) quando você está configurando a segurança básica (Basic Authentication) em um aplicativo Spring Boot. Essa configuração é útil ao precisar restringir o acesso a certas partes do aplicativo ou a determinados endpoints por meio da autenticação.

No seu exemplo:

```properties
spring.security.user.name=Daniel
spring.security.user.password=admin
```

- `spring.security.user.name`: Define o nome de usuário associado ao usuário configurado para fins de autenticação. Neste caso, o nome de usuário é "Daniel".

- `spring.security.user.password`: Define a senha associada ao usuário configurado. Neste caso, a senha é "admin".

Quando configura essas propriedades e, em seguida, tenta acessar partes do seu aplicativo que exigem autenticação, o Spring Boot utilizará as credenciais fornecidas para autenticar o usuário. No entanto, é importante observar que esta é uma configuração básica e não deve ser usada em ambientes de produção para sistemas reais, pois as credenciais são mantidas no arquivo de propriedades, o que não é seguro.

Em um ambiente de produção, geralmente usaria mecanismos mais robustos de autenticação, como OAuth, LDAP, ou integração com sistemas de gerenciamento de identidade.

Lembre-se de que a autenticação básica transmite as credenciais em texto simples, então é essencial usar HTTPS para criptografar a comunicação e proteger as informações de autenticação durante a transmissão.

## Spring Actuator customizando endpoints - Classe MyCustomActuator

O código abaixo é um exemplo de como criar um endpoint personalizado para o Spring Boot Actuator. Vou explicar cada parte:

```java
@Endpoint(id = "myendpoint")
@Component
public class MyCustomActuator {

    @ReadOperation
    @Bean
    public String endPoint(){
        return "Hello this is a message from Custom Actuator Endpoint.";
    }
}
```

1. `@Endpoint(id = "myendpoint")`: Esta anotação é usada para marcar a classe como um endpoint do Spring Boot Actuator. O parâmetro `id` é opcional e fornece um identificador exclusivo para o endpoint. Neste caso, o identificador é definido como "myendpoint".

2. `@Component`: Esta anotação é usada para indicar que a classe é um componente gerenciado pelo Spring. Isso permite que o Spring Boot a detecte e o inclua no contexto da aplicação.

3. `@ReadOperation`: Esta anotação é usada para indicar que o método `endPoint()` é uma operação de leitura do endpoint, ou seja, é uma operação que recupera informações e não faz alterações no estado do aplicativo.

4. `@Bean`: Esta anotação é usada para indicar que o método `endPoint()` produz um bean gerenciado pelo Spring. Embora seja comumente usado com métodos em classes de configuração, neste contexto, está sendo usado para criar o conteúdo que será retornado pelo endpoint personalizado.

5. O método `endPoint()`: Este método retorna uma mensagem de saudação que será exibida quando o endpoint personalizado for acessado.

A propriedade abaixo:

```properties
management.endpoints.web.exposure.include=myendpoint
```

Esta configuração controla quais endpoints do Spring Boot Actuator são expostos via HTTP. No exemplo, `myendpoint` é incluído, o que significa que o endpoint personalizado que eu criei (`MyCustomActuator`) estará disponível via HTTP no caminho `/actuator/myendpoint`.

Se acessar `http://localhost:8080/actuator/myendpoint`, você verá a mensagem retornada pelo método `endPoint()`.

Essa abordagem é útil quando precisa criar endpoints personalizados para expor informações específicas ou funcionalidades adicionais através do Spring Boot Actuator.

# Autor
## Feito por: `Daniel Penelva de Andrade`