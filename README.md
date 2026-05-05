# Multi-Tenant SaaS ERP (Spring Boot)

Production-ready backend scaffold for a **schema-per-tenant** SaaS ERP with Spring Boot + PostgreSQL.

## Implemented Requirements
- Hibernate multi-tenancy (`SCHEMA`) with:
  - `SchemaMultiTenantConnectionProvider`
  - `HeaderTenantIdentifierResolver`
- Tenant resolution from **JWT claim** and **HTTP header** (`X-Tenant-ID`).
- Public schema for tenant registry + dynamic per-tenant schemas.
- Flyway migrations:
  - `db/migration/public` for platform tables
  - `db/migration/tenant` for business tables
- JWT authentication + RBAC role claim strategy.
- Modules: Auth, Users/Roles, HR, Inventory, Finance.
- REST APIs with validation, pagination, sorting, global exception handling.

## Clean Architecture
- Controller -> Service -> Repository
- Package-by-domain:
  - `auth`, `user`, `tenant`, `hr`, `inventory`, `finance`, `security`, `common`

## Setup
1. Create DB:
```sql
CREATE DATABASE erp;
```
2. Update `application.yml` datasource + JWT secret.
3. Run:
```bash
mvn spring-boot:run
```
4. Register tenant:
```bash
curl -X POST http://localhost:8080/api/tenants \
  -H 'Content-Type: application/json' \
  -d '{"tenantId":"tenant_acme","name":"Acme Inc"}'
```

## Sample API Endpoints
- `POST /api/auth/register`
- `POST /api/auth/login`
- `GET|POST /api/hr/employees`
- `GET|POST /api/inventory/products`
- `GET|POST /api/finance/invoices`
- `POST /api/finance/payments`

## Sample Data Flow
1. Register tenant `tenant_acme`
2. Register user in that tenant:
```json
{"username":"admin@acme.com","password":"Admin@123","role":"ADMIN"}
```
3. Use JWT on protected APIs:
```http
Authorization: Bearer <token>
X-Tenant-ID: tenant_acme
```

## Production Hardening To-Do
- Method-level `@PreAuthorize` policy matrix per module.
- Audit logs + outbox for financial operations.
- Testcontainers integration test suite.
- Rate limiting and login lockout.
