# kenzan-kcode-challenge

Employees REST Service. Project developed in Java8. It uses the Business Object design pattern which encapsulates the logic for CRUD opearations, it also uses Java 8 (streams to filter the employees who are active). Employees are loaded when the application starts make them available. Employees are stored in a in memory data base.

Build the application.
Within the terminal, run the following command:    ./mvnw clean package

Run the application.
Within the terminal, run the following command:    java -jar target/kcode-challenge-0.0.1-SNAPSHOT.jar 



Test the End Points
1. Get All the employees. Within the terminal, run the following command: 
curl -X GET \
  http://localhost:8080/employees/getAll \
  -H 'Postman-Token: 8f084633-eaa4-4a1d-a090-647025680a9c' \
  -H 'cache-control: no-cache'

2. Get employees by an ID. Within the terminal, run the following command: 
curl -X GET \
  http://localhost:8080/employees/getById/1 \
  -H 'Postman-Token: 2feb0953-7c50-4ded-9726-63afb4ce29ce' \
  -H 'cache-control: no-cache'

3. Create new employees. Within the terminal, run the following command: 
curl -X POST \
  http://localhost:8080/employees/new \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 1e7f5d95-0712-46a3-9265-6b4a53fa6805' \
  -H 'cache-control: no-cache' \
  -d '{
	"id": "10",
	"firstName": "Dikembe",
	"middleInitial": "M",
	"lastName": "Vampeta",
	"dateOfBirth": "1977-04-14",
	"dateOfEmployement": "2018-01-01",
	"status": "true"
}'

4. Update existing employees. Within the terminal, run the following command: 
curl -X PUT \
  http://localhost:8080/employees/update \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: d3e318cd-5479-4dc6-b06d-1e2ad497a0f0' \
  -H 'cache-control: no-cache' \
  -d '{
	"id": "10",
	"firstName": "Dikembe",
	"middleInitial": "Mutombo",
	"lastName": "Vampeta",
	"dateOfBirth": "1977-04-15",
	"dateOfEmployement": "2018-01-02",
	"status": "true"
}'

5. Delete employees. Within the terminal, run the following command: 
curl -X DELETE \
  http://localhost:8080/employees/delete/10 \
  -H 'Postman-Token: d6336e14-edac-48d4-937d-e0c3fecfe4c7' \
  -H 'cache-control: no-cache'


