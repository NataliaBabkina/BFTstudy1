package booker.models.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingRequest {
    @JsonProperty("firstname")
    private String firstname;
    
    @JsonProperty("lastname")
    private String lastname;
    
    @JsonProperty("totalprice")
    private Integer totalprice;
    
    @JsonProperty("depositpaid")
    private Boolean depositpaid;
    
    @JsonProperty("bookingdates")
    private BookingDates bookingdates;
    
    @JsonProperty("additionalneeds")
    private String additionalneeds;

    // Конструктор
    public BookingRequest(String firstname, String lastname, Integer totalprice, 
                         Boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    // Геттеры и сеттеры
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    
    public Integer getTotalprice() { return totalprice; }
    public void setTotalprice(Integer totalprice) { this.totalprice = totalprice; }
    
    public Boolean getDepositpaid() { return depositpaid; }
    public void setDepositpaid(Boolean depositpaid) { this.depositpaid = depositpaid; }
    
    public BookingDates getBookingdates() { return bookingdates; }
    public void setBookingdates(BookingDates bookingdates) { this.bookingdates = bookingdates; }
    
    public String getAdditionalneeds() { return additionalneeds; }
    public void setAdditionalneeds(String additionalneeds) { this.additionalneeds = additionalneeds; }
} 