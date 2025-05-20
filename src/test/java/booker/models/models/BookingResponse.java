package booker.models.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponse {
    @JsonProperty("bookingid")
    private Integer bookingid;
    
    @JsonProperty("booking")
    private BookingRequest booking;


    public Integer getBookingid() { return bookingid; }
    public void setBookingid(Integer bookingid) { this.bookingid = bookingid; }
    
    public BookingRequest getBooking() { return booking; }
    public void setBooking(BookingRequest booking) { this.booking = booking; }
} 