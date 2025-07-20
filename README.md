# Event Booking Platform

A simple full-stack Event Booking application using:

- **Frontend**: Angular 17 (Standalone API, No `app.module.ts`)
- **Backend**: Spring Boot 3 with JWT Authentication (Mock Data, No DB)

---

## Project Structure

```bash
prime-event-booking/
├── ebp/        # Spring Boot application
└── ebp-web/    # Angular 17 standalone app


### Run the Backend (Spring Boot)

```
cd ebp
mvn spring-boot:run
```

Backend will run on: http://localhost:8080

### Run the Frontend (Angular)

```
cd ./ebp-web
npm install
ng serve
```

Frontend will run on: http://localhost:4200

## Login Credentials 

| Username | Password  |
| -------- | --------- |
| user     | user      |
| admin    | admin123  |

