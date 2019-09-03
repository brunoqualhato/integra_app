package br.edu.ifgoiano.ceres.eventoapp.model;

import java.util.List;

public class Tickets {
    private String title;
    private List<Prices> prices;

    public Tickets(String title, List<Prices> prices) {
        this.title = title;
        this.prices = prices;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Prices> getPrices() {
        return prices;
    }

    public void setPrices(List<Prices> prices) {
        this.prices = prices;
    }
}
