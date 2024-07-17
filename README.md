# play-crud-operaton-with-scala

## CURL

### GET ALL => 
```
curl --location 'http://localhost:9000/users'
```
### GET => 
```
curl --location 'http://localhost:9000/users/1'
```
### POST => 
```
curl --location 'http://localhost:9000/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 3,
    "name": "kuki",
    "email": "kuki@example.com"
}'
```
### PUT => 
```
curl --location --request PUT 'http://localhost:9000/users/3' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 100,
    "name": "kuki DD",
    "email": "kuki@example.com"
}'
```
### DELETE =>  

```
curl --location --request DELETE 'http://localhost:9000/users/2'
```
