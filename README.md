# 🏦 Java ATM Simulator - Bootcamp Project  
*A secure, MVC-based ATM system simulating real-world banking operations*  

**Mentor** [Ali Java Boy](https://github.com/aliJavaTar)
**Team**: [Amir Mohammad Ghazanfari](https://github.com/amirghazanfari), [Mohammad Asadi](https://github.com/mohammadasadi1998), [Mohammad Nourizade](http://github.com/mjnori)

---

## � Key Features  
### 1. **Realistic ATM Flow**  
- Users "insert" their card (enter card number/PIN).  
- **Collections**: Card/account data stored in `HashMap`/`ArrayList` for fast lookup.  
- **Error Handling**: Custom exceptions for invalid PINs, insufficient funds, etc.  

### 2. **MVC Architecture**  
- **Model**: `Account`, `Transaction`, `Card` classes (business logic).  
- **View**: Console-based UI (future-proof for GUI integration).  
- **Controller**: Mediates between Model and View.  

### 3. **Comprehensive Testing**  
- JUnit tests for core logic 

---

## 🛠️ Tech Stack  
- **Core**: Java 11+ (OOP, Collections, I/O)  
- **Error Handling**: Custom exceptions (`InvalidCardException`, `InsufficientBalanceException`)  
- **Testing**: JUnit 5
- **Tools**: Git, IntelliJ IDEA  

---

## 🚀 How to Run  
```bash
git clone https://github.com/your-repo/atm-simulator.git
cd atm-simulator
mvn test  # Run tests
mvn exec:java -Dexec.mainClass="com.bootcamp.atm.Main"
