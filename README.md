### poc-rabbit

Poc to demonstrate how do using rabbitmq with java and spring boot.

#### Requirements

```
$ docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 rabbitmq:3-management
```

#### Testing

```bash
curl -X POST \
  http://localhost:8080/orders \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: f2c51178-85a4-4818-84db-b6460e64ee5d' \
  -H 'cache-control: no-cache' \
  -d '{
	"name": "teste",
	"description": "alallalalal",
	"items" : [{
		"name": "teste",
		"description": "alallalalal"
	}]
}'
```