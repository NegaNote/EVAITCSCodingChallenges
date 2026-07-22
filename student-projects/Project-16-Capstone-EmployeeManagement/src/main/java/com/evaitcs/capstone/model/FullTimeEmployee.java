package com.evaitcs.capstone.model;

/**
 * ============================================================================
 * CLASS: FullTimeEmployee
 * TOPICS: Inheritance, Polymorphism (method overriding)
 * ============================================================================
 *
 * Full-time employees have:
 * - A fixed annual salary
 * - A bonus percentage
 * - Monthly salary = annualSalary / 12
 * - Annual salary = annualSalary + (annualSalary * bonusPercent / 100)
 * ============================================================================
 */
public class FullTimeEmployee extends Employee {

    private static final long serialVersionUID = 1L;

    private double annualBaseSalary;
    private double bonusPercentage;

    public FullTimeEmployee(String employeeId, String firstName, String lastName, String email, Department department, int hireYear, double annualBaseSalary, double bonusPercentage) {
        super(employeeId, firstName, lastName, email, department, hireYear);
        if (annualBaseSalary <= 0 || bonusPercentage < 0 || bonusPercentage > 50) {
            throw new IllegalArgumentException();
        }

        this.annualBaseSalary = annualBaseSalary;
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateMonthlySalary() {
        return annualBaseSalary / 12;
    }

    @Override
    public double calculateAnnualSalary() {
        return annualBaseSalary + (annualBaseSalary * bonusPercentage / 100.0);
    }

    @Override
    public String getEmployeeType() {
        return "Full-Time";
    }

    public double getAnnualBaseSalary() {
        return annualBaseSalary;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(double bonusPercentage) {
        if (bonusPercentage < 0 || bonusPercentage > 50) {
            throw new IllegalArgumentException();
        }
        this.bonusPercentage = bonusPercentage;
    }
}

