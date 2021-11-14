package com.leonardobatistacarias.chainofresponsability;

public interface LeaveApprover {

    void processLeaveApplication(LeaveApplication application);

    String getApproverRole();

}
