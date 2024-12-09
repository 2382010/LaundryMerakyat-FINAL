module LaundryApp {
    requires spring.context;
    requires spring.beans;
    requires java.sql;

    opens LaundryApp;
    opens LaundryApp.entities;
    opens LaundryApp.repositories;
    opens LaundryApp.services;
    opens LaundryApp.view;
    opens LaundryApp.config;
}