package com.evaitcs.capstone.model;

/**
 * ============================================================================
 * ENUM: EmployeeStatus
 * TOPIC: Simple enum for tracking employee state
 * ============================================================================
 */
public enum EmployeeStatus {
    ACTIVE,
    ON_LEAVE,
    TERMINATED,
    PROBATION;

    @Override
    public String toString() {
        return switch (this) {
            case ACTIVE -> "ACTIVE";
            case ON_LEAVE -> "ON_LEAVE";
            case TERMINATED -> "TERMINATED";
            case PROBATION -> "PROBATION";
        };
    }
}

