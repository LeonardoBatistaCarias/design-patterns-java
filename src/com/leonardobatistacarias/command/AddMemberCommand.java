package com.leonardobatistacarias.command;

public class AddMemberCommand implements Command{

    private String emailAddress;
    private String listName;

    private EWSService service;

    public AddMemberCommand(String emailAddress, String listName, EWSService service) {
        this.emailAddress = emailAddress;
        this.listName = listName;
        this.service = service;
    }

    @Override
    public void execute() {
        service.addMember(emailAddress, listName);
    }
}
