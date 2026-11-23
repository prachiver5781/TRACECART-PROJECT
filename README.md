# TraceCart — Prachi's Authentication & Database Module

This folder contains **only Prachi's assigned module** from TraceCart.

## Included responsibilities
- Application entry point and authentication menu
- Customer registration and login
- User model and DAO (JDBC prepared statements)
- SQLite database connection and shared project schema initialization
- Console input and table-heading utilities

## Files owned by Prachi
- `app/Main.java`
- `ui/MainMenu.java`
- `dao/UserDao.java`
- `service/AuthService.java`
- `model/User.java`
- `db/Database.java`
- `db/Schema.java`
- `util/Input.java`
- `util/TablePrinter.java`

## Run
Requirements: JDK 17+ and Maven.

```bash
mvn clean compile exec:java
```

Demo admin credentials created by the schema: `admin@tracecart.com` / `admin123`.

## Team integration boundary
This branch intentionally does not contain Vanshika's inventory, Mannat's order/billing, or Ruhani's recall/return implementation. The authentication menu currently confirms the authenticated user's role; the role-specific menus are to be connected after the other members' modules are merged.

The schema creates the shared TraceCart tables so the team can integrate the modules against the same table names and columns. Demo passwords are stored in plain text for classroom demonstration only; do not use real credentials.
