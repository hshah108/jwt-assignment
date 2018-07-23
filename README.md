# jwt-assignment
jwt demo assignment

curl to generate token:
curl -H "Content-Type: application/json" -X POST -d '{"password":"hardik", "userName":"hardik", "group":"admin"}' http://localhost:8080/token

curl to get admin access:
curl -H "Authorization: Bearer <generated token>" -X GET http://localhost:8080/admin
