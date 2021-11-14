package com.leonardobatistacarias.chainofresponsability;

import java.time.LocalDate;

public class Client {

    public static void main(String[] args) {
        final var application = LeaveApplication.getBuilder()
                                .withType(LeaveApplication.Type.SICK)
                                .from(LocalDate.now().minusDays(2))
                                .to(LocalDate.now())
                                .build();

        System.out.println(application);
        System.out.println("*********************************************");
        final var approver = createChain();
        approver.processLeaveApplication(application);
        System.out.println(application);
    }

    private static LeaveApprover createChain() {
        final var director = new Director(null);
        final var manager = new Manager(director);
        final var projectLead = new ProjectLead(manager);

        return projectLead;
    }
}
