module LaundryApp {
    requires java.sql;
    requires spring.context;
    requires spring.beans;
    requires java.xml.crypto;

    opens LaundryApp;
    opens LaundryApp.entities;
    opens LaundryApp.repositories;
    opens LaundryApp.services;
    opens LaundryApp.view;
    opens LaundryApp.config;
}