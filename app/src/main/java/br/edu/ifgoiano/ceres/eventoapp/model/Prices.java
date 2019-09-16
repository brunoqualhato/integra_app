package br.edu.ifgoiano.ceres.eventoapp.model;

public class Prices {
    private int id_ticket;
    private int id_ticket_price;
    private double price;
    private String due_date;

    public Prices(int id_ticket, int id_ticket_price, double price, String due_date) {
        this.id_ticket = id_ticket;
        this.id_ticket_price = id_ticket_price;
        this.price = price;
        this.due_date = due_date;
    }

    @Override
    public String toString() {
        return "Prices{" +
                "id_ticket=" + id_ticket +
                ", id_ticket_price=" + id_ticket_price +
                ", price=" + price +
                ", due_date='" + due_date + '\'' +
                '}';
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public int getId_ticket_price() {
        return id_ticket_price;
    }

    public void setId_ticket_price(int id_ticket_price) {
        this.id_ticket_price = id_ticket_price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
}
