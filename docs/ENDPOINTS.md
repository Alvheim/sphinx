## List of endpoints that reflects current REST service

<hr>

### StudentController

URL: "***/student***" <br>
Description: "get list of all students"  <br>
Method: "***GET***"  <br>
Parameters:
```
    None
```

URL: "***/student/new***" <br>
Description: "add new student"  <br>
Method: "***POST***"  <br>
Request header: "content-type: application/json" <br>
Parameters:
```
    {
    "firstName": "Ivan",
    "middleName": "Ivanovich",
    "lastName": "Ivanov",
    "username": "ilovecatsanddogs<3",
    "mobileNumber": "+380000000000",
    "additionalMobileNumber": "+380000000000"
    }
```
