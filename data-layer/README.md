# Data Layer Module

This module demonstrates database connectivity and ORM (Object-Relational Mapping) concepts in Java using JDBC and Hibernate.

## Module Overview

The `data-layer` module provides examples of:
- Raw JDBC database operations
- Hibernate ORM framework usage
- Entity relationships and mappings
- Session management and transactions

## Package Structure

| Package | Description |
|---------|-------------|
| `com.jdbc` | JDBC examples for MySQL and Oracle databases |
| `com.hibernate` | Hibernate ORM main classes and entry points |
| `com.hibernate.entities` | JPA/Hibernate entity classes |
| `com.hibernate.util` | Hibernate utility classes (SessionFactory management) |

## Key Classes

### JDBC Examples

| Class | Description |
|-------|-------------|
| `MySQLJDBCMain` | MySQL JDBC connection and CRUD operations |
| `OracleJDBCMain` | Oracle database JDBC connectivity |

### Hibernate Examples

| Class | Description |
|-------|-------------|
| `HibernateMain` | Basic Hibernate session and transaction demo |
| `StudentMain` | Student entity CRUD operations |
| `CourseMain` | Course entity with relationships |
| `EventOrganizerMain` | Complex entity relationships demo |

### Entity Classes

| Entity | Description |
|--------|-------------|
| `User` | Basic user entity |
| `Student` | Student with address relationship |
| `StudentAddress` | One-to-One relationship example |
| `Course` | Many-to-Many relationship example |
| `Event` | Event with details (One-to-One) |
| `EventDetails` | Embedded event details |
| `Speaker` | Many-to-Many with Event |
| `Attendee` | Event attendees |
| `Location` | Location entity |
| `Vehicle` | Vehicle entity with User relationship |

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**
- **MySQL Server** (for MySQL examples)
- **Oracle Database** (for Oracle examples, optional)

### Database Setup

1. Install and start MySQL server
2. Create a database and user:

```sql
CREATE DATABASE java_examples;
CREATE USER 'srinath'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON java_examples.* TO 'srinath'@'localhost';
FLUSH PRIVILEGES;
```

3. Update connection details in `hibernate.cfg.xml` if needed

## Configuration

### Hibernate Configuration (`src/main/resources/hibernate.cfg.xml`)

The Hibernate configuration file contains:
- Database connection properties
- Dialect settings
- Entity mappings
- Session factory settings

Example configuration:
```xml
<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/java_examples</property>
<property name="hibernate.connection.username">srinath</property>
<property name="hibernate.connection.password">password</property>
<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
<property name="hibernate.hbm2ddl.auto">update</property>
```

## Building the Module

```bash
# From the root project directory
mvn clean install -pl data-layer

# Or from the data-layer directory
cd data-layer
mvn clean install
```

## Running Examples

### Run Hibernate Main

```bash
cd data-layer
mvn compile exec:java -Dexec.mainClass="com.hibernate.HibernateMain"
```

### Run JDBC Examples

```bash
mvn compile exec:java -Dexec.mainClass="com.jdbc.MySQLJDBCMain"
```

## Key Concepts Covered

### JDBC
- DriverManager connection handling
- PreparedStatement for parameterized queries
- ResultSet processing
- Connection pooling concepts
- Transaction management

### Hibernate
- SessionFactory and Session lifecycle
- Entity annotations (@Entity, @Table, @Id, etc.)
- Relationship mappings:
  - One-to-One (@OneToOne)
  - One-to-Many / Many-to-One (@OneToMany, @ManyToOne)
  - Many-to-Many (@ManyToMany)
- Cascade operations
- Fetch strategies (EAGER vs LAZY)
- HQL (Hibernate Query Language)
- Criteria API

## Dependencies

- Hibernate Core 4.3.6
- Hibernate EntityManager
- Hibernate C3P0 (Connection Pooling)
- Hibernate EhCache (Second Level Cache)
- MySQL JDBC Driver (runtime dependency)

## Best Practices Demonstrated

1. **Use PreparedStatement** - Prevents SQL injection
2. **Close Resources** - Proper resource cleanup in finally blocks
3. **Session Management** - Proper session lifecycle handling
4. **Transaction Boundaries** - Explicit transaction demarcation
5. **Connection Pooling** - C3P0 for efficient connection management

## Troubleshooting

### Common Issues

1. **Connection Refused**: Ensure database server is running
2. **Access Denied**: Verify username/password in configuration
3. **Driver Not Found**: Add MySQL/Oracle driver to classpath
4. **Schema Issues**: Set `hbm2ddl.auto` to `create` for initial setup

## Related Modules

- `core-java` - Uses this module for database-related examples

