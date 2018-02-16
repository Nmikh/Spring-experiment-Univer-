package com.models;

import java.io.Serializable;

public class Lector implements Serializable{

    static final int serialVersionUID = 2;
    private int id;
    private String name;
    private String surname;
    private String position;
    private String log;
    private String pass;

    public Lector(int id, String name, String surname,
                  String position, String log, String pass) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.log = log;
        this.pass = pass;
    }

    public Lector(int anInt, String string, String resultString, String s, String string1, String resultString1, String s1){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lector lector = (Lector) o;

        if (id != lector.id) return false;
        if (name != null ? !name.equals(lector.name) : lector.name != null) return false;
        if (surname != null ? !surname.equals(lector.surname) : lector.surname != null) return false;
        if (position != null ? !position.equals(lector.position) : lector.position != null) return false;
        if (log != null ? !log.equals(lector.log) : lector.log != null) return false;
        return pass != null ? pass.equals(lector.pass) : lector.pass == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (log != null ? log.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", log='" + log + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
