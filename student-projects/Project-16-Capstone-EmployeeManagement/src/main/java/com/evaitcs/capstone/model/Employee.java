package com.evaitcs.capstone.model;

import java.io.Serializable;
import java.time.Year;

/**
 * ============================================================================
 * ABSTRACT CLASS: Employee
 * TOPICS: Abstraction, Inheritance, Encapsulation, Serialization
 * ============================================================================
 *
 * This is the BASE class for all employee types.
 * It demonstrates:
 * - ABSTRACTION: abstract methods for salary calculation
 * - ENCAPSULATION: private fields with validated setters
 * - INHERITANCE: FullTimeEmployee and PartTimeEmployee extend this
 * - SERIALIZATION: implements Serializable for file persistence
 *
 * INTERVIEW TIP:
 * "I designed Employee as an abstract class because different employee types
 *  share common data (name, id, department) but calculate pay differently.
 *  This follows the Open/Closed Principle — I can add new employee types
 *  without modifying existing code."
 * ============================================================================
 */
public abstract class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private Department department;
    private EmployeeStatus status;
    private int hireYear;

    public Employee(String employeeId, String firstName, String lastName, String email, Department department, int hireYear) {
        if (employeeId == null || firstName == null || lastName == null || email == null || department == null) {
            throw new IllegalArgumentException();
        }

        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException();
        }

        if (hireYear < 1970 || hireYear > Year.now().getValue()) {
            throw new IllegalArgumentException();
        }

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.status = EmployeeStatus.ACTIVE;
        this.hireYear = hireYear;
    }

    public int getHireYear() {
        return hireYear;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public Department getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    // =========================================================================
    // TODO 4: Create setters WITH VALIDATION for email, department, status
    //   - employeeId, firstName, lastName, hireYear should NOT have setters
    //     (they don't change after creation)
    // =========================================================================

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

    public void setDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException();
        }
        this.department = department;
    }

    public void setStatus(EmployeeStatus status) {
        if (status == null) {
            throw new IllegalArgumentException();
        }
        this.status = status;
    }


    // =========================================================================
    // ABSTRACT METHODS — Each employee type implements these differently
    // =========================================================================

    /**
     * @return the monthly salary for this employee type
     */
    public abstract double calculateMonthlySalary();

    /**
     * @return the annual salary including any bonuses
     */
    public abstract double calculateAnnualSalary();

    /**
     * @return "Full-Time" or "Part-Time"
     */
    public abstract String getEmployeeType();


    // =========================================================================
    // CONCRETE METHODS — Shared by all employee types
    // =========================================================================

    /**
     * @return full name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * @return number of years between hiring and now
     */
    public int getYearsOfService() {
        return Year.now().getValue() - hireYear;
    }

    @Override
    public String toString() {
        return "FullTime[id=" + employeeId + ", name=" + getFullName() + ", dept=" + department + ", status=" + status + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Employee other)) {
            return false;
        }

        return this.employeeId.equals(other.employeeId);
    }

    @Override
    public int hashCode() {
        return employeeId.hashCode();
    }
}

