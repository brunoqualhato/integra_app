package br.edu.ifgoiano.ceres.eventoapp.model;

import java.io.Serializable;
import java.util.List;

public class Event implements Serializable {
    private int id;
    private String title;
    private String url;
    private String start_date;
    private String end_date;
    private String start_date_registration;
    private String end_date_registration;
    private String summary;
    private String description;
    private String url_image;
    private double credit_hour;
    private String country;
    private String state;
    private String city;
    private String venue;
    private double latitude;
    private double longitude;
    private String banner;
    private List<Tickets> tickets;

    public Event(int id, String title, String url, String start_date, String end_date, String start_date_registration, String end_date_registration, String summary, String description, String url_image, double credit_hour, String country, String state, String city, String venue, double latitude, double longitude, String banner) {
        this.setId(id);
        this.setTitle(title);
        this.setUrl(url);
        this.setStart_date(start_date);
        this.setEnd_date(end_date);
        this.setStart_date_registration(start_date_registration);
        this.setEnd_date_registration(end_date_registration);
        this.setSummary(summary);
        this.setDescription(description);
        this.setUrl_image(url_image);
        this.setCredit_hour(credit_hour);
        this.setCountry(country);
        this.setState(state);
        this.setCity(city);
        this.setVenue(venue);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setBanner(banner);
    }

    public Event(String title, String url, String start_date, String end_date, String start_date_registration, String end_date_registration, String summary, String description, String url_image, double credit_hour, String country, String state, String city, String venue, double latitude, double longitude, String banner, List<Tickets> tickets) {
        this.tickets = tickets;

        this.setTitle(title);
        this.setUrl(url);
        this.setStart_date(start_date);
        this.setEnd_date(end_date);
        this.setStart_date_registration(start_date_registration);
        this.setEnd_date_registration(end_date_registration);
        this.setSummary(summary);
        this.setDescription(description);
        this.setUrl_image(url_image);
        this.setCredit_hour(credit_hour);
        this.setCountry(country);
        this.setState(state);
        this.setCity(city);
        this.setVenue(venue);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setBanner(banner);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStart_date_registration() {
        return start_date_registration;
    }

    public void setStart_date_registration(String start_date_registration) {
        this.start_date_registration = start_date_registration;
    }

    public String getEnd_date_registration() {
        return end_date_registration;
    }

    public void setEnd_date_registration(String end_date_registration) {
        this.end_date_registration = end_date_registration;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public double getCredit_hour() {
        return credit_hour;
    }

    public void setCredit_hour(double credit_hour) {
        this.credit_hour = credit_hour;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public List<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }
}
