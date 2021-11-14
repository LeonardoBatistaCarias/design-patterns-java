package com.leonardobatistacarias.chainofresponsability;

public class Manager extends Employee {

    public static final String ROLE = "Manager";

    public Manager(LeaveApprover nextApprover) {
        super(ROLE, nextApprover);
    }

    @Override
    public boolean processRequest(LeaveApplication application) {

        switch(application.getType()) {
            case SICK:
                application.approve(getApproverRole());
                return true;
            case PTO:
                if(application.getNoOfDays() <= 5) {
                    application.approve(getApproverRole());
                    return true;
                }
        }
        return false;

    }
}
