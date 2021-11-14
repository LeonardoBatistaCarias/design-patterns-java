package com.leonardobatistacarias.chainofresponsability;

public class Director extends Employee {

    public static final String ROLE = "Director";

    public Director(LeaveApprover nextApprover) {
        super(ROLE, nextApprover);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        if(application.getType() == LeaveApplication.Type.PTO) {
            application.approve(getApproverRole());
            return true;
        }
        return false;
    }

}
