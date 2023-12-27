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

# Autor
## Feito por: `Daniel Penelva de Andrade`