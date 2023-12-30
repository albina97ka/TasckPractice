package com.example.tasckpractice;
public class Service {
    int idRegisteredService;
    String UserNameService,ServiceRegistered,UserMailService,UserPhoneService,UserCostService;

    public Service(int idRegisteredService, String userNameService, String serviceRegistered, String userMailService, String userPhoneService, String userCostService) {
        this.idRegisteredService = idRegisteredService;
        UserNameService = userNameService;
        ServiceRegistered = serviceRegistered;
        UserMailService = userMailService;
        UserPhoneService = userPhoneService;
        UserCostService = userCostService;
    }

    public Service(String name, String registered, String mail, String phone, String cost) {
    }

    public int getIdRegisteredService() {
        return idRegisteredService;
    }

    public void setIdRegisteredService(int idRegisteredService) {
        this.idRegisteredService = idRegisteredService;
    }

    public String getUserNameService() {
        return UserNameService;
    }

    public void setUserNameService(String userNameService) {
        UserNameService = userNameService;
    }

    public String getServiceRegistered() {
        return ServiceRegistered;
    }

    public void setServiceRegistered(String serviceRegistered) {
        ServiceRegistered = serviceRegistered;
    }

    public String getUserMailService() {
        return UserMailService;
    }

    public void setUserMailService(String userMailService) {
        UserMailService = userMailService;
    }

    public String getUserPhoneService() {
        return UserPhoneService;
    }

    public void setUserPhoneService(String userPhoneService) {
        UserPhoneService = userPhoneService;
    }

    public String getUserCostService() {
        return UserCostService;
    }

    public void setUserCostService(String userCostService) {
        UserCostService = userCostService;
    }
}

