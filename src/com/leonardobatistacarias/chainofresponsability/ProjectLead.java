package com.leonardobatistacarias.chainofresponsability;

public class ProjectLead extends Employee {

    public static final String ROLE = "Project Lead";

    public ProjectLead(LeaveApprover successor) {
        super(ROLE, successor);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        if(application.getType() == LeaveApplication.Type.SICK ) {
            if(application.getNoOfDays() <= 2) {
                application.approve(getApproverRole());
                return true;
            }
        }

        return false;
    }
}
