package booker.models.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDates {
    @JsonProperty("checkin")
    private String checkin;
    
    @JsonProperty("checkout")
    private String checkout;

    // Конструктор по умолчанию
    public BookingDates() {}

    // Конструктор с параметрами
    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    // Геттеры и сеттеры
    public String getCheckin() { return checkin; }
    public void setCheckin(String checkin) { this.checkin = checkin; }
    
    public String getCheckout() { return checkout; }
    public void setCheckout(String checkout) { this.checkout = checkout; }
} 