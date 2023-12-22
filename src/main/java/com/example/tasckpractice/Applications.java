package com.example.tasckpractice;

public class Applications {
    int idUserRequests;
    String ClientName, ClientNumber,ClientMail,ApplicationService;

    public Applications(int idUserRequests, String clientName, String clientNumber, String clientMail, String applicationService) {
        this.idUserRequests = idUserRequests;
        ClientName = clientName;
        ClientNumber = clientNumber;
        ClientMail = clientMail;
        ApplicationService = applicationService;
    }

    public int getIdUserRequests() {
        return idUserRequests;
    }

    public void setIdUserRequests(int idUserRequests) {
        this.idUserRequests = idUserRequests;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getClientNumber() {
        return ClientNumber;
    }

    public void setClientNumber(String clientNumber) {ClientNumber = clientNumber;}

    public String getClientMail() {
        return ClientMail;
    }

    public void setClientMail(String clientMail) {
        ClientMail = clientMail;
    }

    public String getApplicationService() {
        return ApplicationService;
    }

    public void setApplicationService(String applicationService) {
        ApplicationService = applicationService;
    }
}

