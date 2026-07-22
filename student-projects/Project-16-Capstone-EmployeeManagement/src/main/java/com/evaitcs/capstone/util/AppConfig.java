package com.evaitcs.capstone.util;

/**
 * ============================================================================
 * CLASS: AppConfig (SINGLETON)
 * TOPICS: Singleton Pattern, Configuration Management
 * ============================================================================
 *
 * Holds application-wide configuration like file paths and settings.
 * Only ONE instance exists in the entire application.
 * ============================================================================
 */
public class AppConfig {

    private static volatile AppConfig INSTANCE;

    private String dataFilePath = "data/employees.dat";
    private String reportFilePath = "data/reports/";
    private String companyName = "EVAITCS Corporation";
    private int maxEmployeesPerDepartment = 50;

    private AppConfig() {}

    public static AppConfig getInstance() {
        if (INSTANCE == null) {
            synchronized (AppConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppConfig();
                }
            }
        }
        return INSTANCE;
    }

    public String getDataFilePath() {
        return dataFilePath;
    }

    public String getReportFilePath() {
        return reportFilePath;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getMaxEmployeesPerDepartment() {
        return maxEmployeesPerDepartment;
    }

    public void setDataFilePath(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    public void setReportFilePath(String reportFilePath) {
        this.reportFilePath = reportFilePath;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setMaxEmployeesPerDepartment(int maxEmployeesPerDepartment) {
        this.maxEmployeesPerDepartment = maxEmployeesPerDepartment;
    }
}

