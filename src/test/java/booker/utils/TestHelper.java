package booker.utils;

import booker.models.Booking;
import booker.models.BookingDates;
import java.time.LocalDate;

public class TestHelper {
    public static Booking createTestBooking() {
        Booking booking = new Booking();
        BookingDates dates = new BookingDates();


        dates.setCheckin(LocalDate.now().plusDays(1).toString());
        dates.setCheckout(LocalDate.now().plusDays(5).toString());

        booking.setFirstname("Test");
        booking.setLastname("User");
        booking.setTotalprice(100);
        booking.setDepositpaid(true);
        booking.setBookingdates(dates);
        booking.setAdditionalneeds("Breakfast");

        return booking;
    }
}
