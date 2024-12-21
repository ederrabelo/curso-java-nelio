package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String name;
    private String email;
    private LocalDate birthDate;

    public Client() {
    };

    public Client(String name, String email, String birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = LocalDate.parse(birthDate, formatter);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " (" + getBirthDate() + ") - " + email;  
    }

    public String getBirthDate() {
        return birthDate.format(formatter);
    }

}