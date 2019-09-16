package br.edu.ifgoiano.ceres.eventoapp.model;

public class Pessoa {

    private long id_attendees;
    private long id_event;

    public Pessoa(long id_attendees, long id_event, String name, String bagde_name, String email, String gender, String photo, boolean confirmed) {
        this.id_attendees = id_attendees;
        this.id_event = id_event;
        this.name = name;
        this.bagde_name = bagde_name;
        this.email = email;
        this.gender = gender;
        this.photo = photo;
        this.confirmed = confirmed;
    }

    private String name;
    private String bagde_name;
    private String email;
    private String gender;
    private String photo;
    private boolean confirmed;

    @Override
    public String toString() {
        return "Pessoa{" +
                "id_attendees=" + id_attendees +
                ", id_event=" + id_event +
                ", name='" + name + '\'' +
                ", bagde_name='" + bagde_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", photo='" + photo + '\'' +
                ", confirmed=" + confirmed +
                '}';
    }

    public Pessoa() {
    }

    public long getId_attendees() {
        return id_attendees;
    }

    public void setId_attendees(int id_attendees) {
        this.id_attendees = id_attendees;
    }

    public long getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBagde_name() {
        return bagde_name;
    }

    public void setBagde_name(String bagde_name) {
        this.bagde_name = bagde_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

}
