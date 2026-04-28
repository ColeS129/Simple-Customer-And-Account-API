# Simple Customer and Account API
A simple spring boot RESTful API that uses mysql for the database and can create and fetch
customers as well as create and fetch accounts for customers.  
  
## Sample Endpoints
For customers:
* GET /customers - to get all customers
* GET /customers/{id} - to get a customer by that ID
* POST /customers - to create a customer with the following JSON data ({"name": String, "email": String, "password": String})

For accounts:
* GET /accounts - to get all accounts
* GET /accounts/{customerId} - to get all accounts for a customer by that ID
