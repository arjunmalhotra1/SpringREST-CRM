This is a CRM (Customer Relationship Management) app that allows a user to Create, Read, Update and Delete.
This poject has 
@GetMapping("/customers") - Returns all the customers

@GetMapping("/customers/{customerId}") - Returns a customer with a customerId

@PostMapping("/customers") - mapping for POST /customers - add new customer

@PutMapping("/customers") - mapping for PUT /customers -update existing customer

@DeleteMapping("/customers/{customerId}") - mapping for DELETE, /customers/{customerId} - delete customer