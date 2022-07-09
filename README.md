# ls_server

This is the example server that will host the endpoint for the LoanStreet API.  It's part of MVP 1 in response to the take home code quiz.

The API has the following endpoints:
GET: "/api/health" - checks the healh of the server, returns "up" if server is healthy
POST: "/api/create?amount=<loan_amount>&rate=<interest_rate>&length=<length_in_months>&payment=<monthly_payment>" - creates a new loan, returning the uuid of the loan
    NOTE: ALL paramaters are required.

GET: "/api/get?id=<id_of_loan>" - takes a string loan_id, and returns the loan information in the format:
  "id:<loan_id>,amount:<loan_amount>,rate:<interest_rate>,length:<length_in_months>,payment:<monthly_payment>"

POST: "/api/update?id=<loan_id>&amount=<loan_amount>&rate=<interest_rate>&length=<length_in_months>&payment=<monthly_payment"
    NOTE: All parameters are optional except id
 
  
GET: "api/all" - returns all loans that have been created

There is currently an EC2 instance hosted here:
http://ec2-35-175-133-100.compute-1.amazonaws.com:8888
