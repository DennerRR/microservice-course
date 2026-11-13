# Microsserviços com Spring Boot e Spring Cloud (estudo)

Projeto de estudo, feito a partir de um curso, de um sistema de folha de pagamento (RH) dividido em microsserviços.
O objetivo foi praticar os principais padrões de uma arquitetura distribuída com Spring Cloud.

## Serviços

| Módulo | Porta | O que faz | Conceitos praticados |
|---|---|---|---|
| `hr-eureka-server` | 8761 | Registro e descoberta de serviços | Eureka Server |
| `hr-config-server` | 8888 | Configuração centralizada lida de um repositório Git | Spring Cloud Config |
| `hr-api-gateway-zuul` | 8765 | Porta de entrada, roteamento e autorização | Zuul, OAuth2 |
| `hr-oauth` | aleatória | Autenticação e emissão de tokens | OAuth2, JWT, Feign |
| `hr-user` | aleatória | Usuários e perfis | Spring Data JPA |
| `hr-worker` | aleatória | Cadastro de trabalhadores | Spring Data JPA, Config Client |
| `hr-payroll` | aleatória | Cálculo de pagamento consultando `hr-worker` | Feign, Ribbon (balanceamento), Hystrix (tolerância a falhas) |

"Aleatória" significa `server.port=${PORT:0}`: várias instâncias do mesmo serviço sobem ao mesmo tempo e o Eureka e o Ribbon
distribuem as requisições entre elas.

## Como executar

Pré-requisitos: Java 11 e Maven. Suba na ordem: `hr-config-server`, `hr-eureka-server`, os serviços de negócio e por fim
`hr-api-gateway-zuul`. Em cada pasta:

```bash
./mvnw spring-boot:run
```

**Tecnologias:** Java, Spring Boot, Spring Cloud Netflix (Eureka, Zuul, Ribbon, Hystrix), OpenFeign, Spring Cloud Config,
Spring Security OAuth2, JWT, Spring Data JPA, H2.
