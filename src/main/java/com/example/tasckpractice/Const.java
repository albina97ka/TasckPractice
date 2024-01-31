package com.example.tasckpractice;

public class Const {
    //База данных с информацией о клиентах
    public static final String USER_TABLE = "users";
    public static final String USER_ID = "idusers";
    public static final String USER_FIRSTNAME = "name";
    public static final String USER_LASTNAME = "lastname";
    public static final String USER_NUMBER = "number";
    public static final String USER_MAIL = "mail";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_SERVICE = "service";
    public static final String USER_ISADMIN = "isAdmin";
    //База данных зарегистрированных заявок
    public static final String SERVICEADMIN_TABLE="registeredservice";
    public static final String SERVICEADMIN_ID="idRegisteredService";
    public static final String SERVICEADMIN_LASTNAME="UserNameService";
    public static final String SERVICEREGISTERED="ServiceRegistered";
    public static final String USERMAILSERVICE="UserMailService";
    public static final String USERPHONESERVICE="UserPhoneService";
    public static final String USERCOSTSERVICE="UserCostService";
    //Архив зарегистрированных заявок
    public static final String SERVICEADMIN_TABLE_ARCHIVE="archive";
    public static final String SERVICEADMIN_ID_ARCHIVE="idArchive";
    public static final String SERVICEADMIN_LASTNAME_ARCHIVE="UserNameService_Archive";
    public static final String SERVICEREGISTERED_ARCHIVE="ServiceRegistered_Archive";
    public static final String USERMAILSERVICE_ARCHIVE="UserMailService_Archive";
    public static final String USERPHONESERVICE_ARCHIVE="UserPhoneService_Archive";
    public static final String USERCOSTSERVICE_ARCHIVE="UserCostService_Archive";
}