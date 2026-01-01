# Low-Level Design (LLD) Module

This module contains low-level design implementations of real-world systems, demonstrating object-oriented design principles, design patterns, and best practices.

## Module Overview

The `lld` module provides complete implementations of common system design interview problems, showcasing:
- Object-oriented design principles
- Design pattern applications
- Clean code practices
- Service-oriented architecture

## Systems Implemented

### 1. Parking Lot System

A comprehensive parking lot management system with the following features:

#### Features
- Vehicle entry and ticket generation
- Multiple parking spot types (CAR, BIKE, TRUCK)
- Slot allocation strategies
- Entry/Exit gate management
- Invoice generation and payment processing

#### Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                    ParkingLotApplication                     │
│                       (Entry Point)                          │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                     Controllers Layer                        │
│  ┌───────────────────────────────────────────────────────┐  │
│  │              TicketController                          │  │
│  │  - generateTicket(GenerateTicketRequest)              │  │
│  └───────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                      Services Layer                          │
│  ┌─────────────────┐  ┌─────────────────────────────────┐  │
│  │ EntryGateService│  │      SlotAllocationService      │  │
│  │ TicketService   │  │                                 │  │
│  └─────────────────┘  └─────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                    Repositories Layer                        │
│  ┌─────────────────────────┐  ┌───────────────────────────┐ │
│  │    TicketRepository     │  │  ParkingSpotRepository    │ │
│  └─────────────────────────┘  └───────────────────────────┘ │
└─────────────────────────────────────────────────────────────┘
```

#### Package Structure

| Package | Description |
|---------|-------------|
| `com.parkinglot` | Main application entry point |
| `com.parkinglot.controllers` | Request handling and response formatting |
| `com.parkinglot.dto` | Data Transfer Objects for API requests/responses |
| `com.parkinglot.exceptions` | Custom exception classes |
| `com.parkinglot.model` | Domain entities (Vehicle, Ticket, Gate, etc.) |
| `com.parkinglot.repositories` | Data access layer |
| `com.parkinglot.services` | Business logic layer |

#### Key Classes

| Class | Description |
|-------|-------------|
| `ParkingLotApplication` | Main entry point |
| `TicketController` | Handles ticket generation requests |
| `EntryGateService` | Orchestrates entry gate operations |
| `TicketService` | Creates and manages tickets |
| `SlotAllocationService` | Allocates parking spots |
| `Vehicle` | Represents a vehicle with type and registration |
| `Ticket` | Parking ticket with entry time and spot details |
| `ParkingSpot` | Individual parking spot with status |
| `Gate` | Entry/Exit gate with attendant |

#### Design Patterns Used

- **Builder Pattern** - For creating complex objects (Vehicle, Ticket, Gate)
- **Repository Pattern** - For data access abstraction
- **Service Layer Pattern** - For business logic encapsulation
- **DTO Pattern** - For clean API contracts

### 2. Splitwise (Basic)

A simplified expense-sharing application.

| Class | Description |
|-------|-------------|
| `SplitwiseMain` | Entry point for the Splitwise application |

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**
- **Lombok** (for boilerplate reduction)

## Building the Module

```bash
# From the root project directory
mvn clean install -pl lld

# Or from the lld directory
cd lld
mvn clean install
```

## Running Examples

### Run Parking Lot Application

```bash
cd lld
mvn compile exec:java -Dexec.mainClass="com.parkinglot.ParkingLotApplication"
```

### Run Splitwise

```bash
mvn compile exec:java -Dexec.mainClass="com.splitwise.SplitwiseMain"
```

## Object-Oriented Design Principles Applied

### SOLID Principles

| Principle | Application |
|-----------|-------------|
| **Single Responsibility** | Each class has one responsibility (TicketService only manages tickets) |
| **Open/Closed** | Services can be extended without modification |
| **Liskov Substitution** | Vehicle types are substitutable |
| **Interface Segregation** | Small, focused interfaces |
| **Dependency Inversion** | High-level modules don't depend on low-level modules |

### Clean Architecture

- **Separation of Concerns** - Controllers, Services, Repositories
- **Dependency Flow** - Outer layers depend on inner layers
- **Testability** - Each layer can be tested independently

## Extending the System

### Adding a New Vehicle Type

1. Add the type to `VehicleType` enum
2. Update `SlotAllocationService` if needed
3. Add corresponding `ParkingSpot` types

### Adding Exit Gate Functionality

1. Create `ExitGateService`
2. Create `InvoiceService` for billing
3. Add `PaymentService` for payment processing
4. Update repositories as needed

## Interview Tips

When discussing this LLD in interviews:

1. **Start with requirements clarification**
2. **Identify key entities/actors**
3. **Define relationships between entities**
4. **Discuss design patterns used and why**
5. **Consider scalability and extensibility**
6. **Handle edge cases and exceptions**

## Common Follow-up Questions

- How would you handle multiple floors?
- How to implement reservation system?
- How to add different pricing strategies?
- How to handle concurrent access?
- How to add electric vehicle charging spots?

## Related Modules

- `design-patterns` - Patterns used in this module
- `core-java` - Java concepts applied here

