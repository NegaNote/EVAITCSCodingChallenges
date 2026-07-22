package com.evaitcs.capstone.model;

/**
 * ============================================================================
 * CLASS: PartTimeEmployee
 * TOPICS: Inheritance, Polymorphism (method overriding)
 * ============================================================================
 *
 * Part-time employees have:
 * - An hourly rate
 * - Hours worked per week
 * - Monthly salary = hourlyRate * hoursPerWeek * 4 (approx weeks/month)
 * - Annual salary = monthly * 12 (no bonus for part-time)
 * ============================================================================
 */
public class PartTimeEmployee extends Employee {

    private static final long serialVersionUID = 1L;

    public PartTimeEmployee(String employeeId, String firstName, String lastName, String email, Department department, int hireYear, double hourlyRate, int hoursPerWeek) {
        super(employeeId, firstName, lastName, email, department, hireYear);

        if (hourlyRate <= 0 || !(hoursPerWeek >= 1 && hoursPerWeek <= 40)) {
            throw new IllegalArgumentException();
        }

        this.hourlyRate = hourlyRate;
        this.hoursPerWeek = hoursPerWeek;

    }

    private double hourlyRate;
    private int hoursPerWeek;


    @Override
    public double calculateMonthlySalary() {
        return hourlyRate * hoursPerWeek * 4;
    }

    @Override
    public double calculateAnnualSalary() {
        return calculateMonthlySalary() * 12;
    }

    @Override
    public String getEmployeeType() {
        return "Part-Time";
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException();
        }
        this.hourlyRate = hourlyRate;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        if (!(hoursPerWeek >= 1 && hoursPerWeek <= 40)) {
            throw new IllegalArgumentException();
        }
        this.hoursPerWeek = hoursPerWeek;
    }
}

