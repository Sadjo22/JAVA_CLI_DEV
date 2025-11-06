package booking;

import car.Car;
import user.User;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class CarBooking {
    private UUID bookingId;
    private Car cars;
    private User users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarBooking that)) return false;
        return isCancelled == that.isCancelled && Objects.equals(bookingId, that.bookingId) && Objects.equals(cars, that.cars) && Objects.equals(users, that.users) && Objects.equals(bookingTime, that.bookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, cars, users, bookingTime, isCancelled);
    }

    @Override
    public String toString() {
        return "BookingModel{" +
                "bookingId=" + bookingId +
                ", cars=" + cars +
                ", users=" + users +
                ", bookingTime=" + bookingTime +
                ", isCancelled=" + isCancelled +
                '}';
    }

    public CarBooking(UUID bookingId, Car cars, User users, LocalDateTime bookingTime, boolean isCancelled) {
        this.bookingId = bookingId;
        this.cars = cars;
        this.users = users;
        this.bookingTime = bookingTime;
        this.isCancelled = isCancelled;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    private LocalDateTime bookingTime;
    private boolean isCancelled;


    public CarBooking(UUID bookingId, Car cars, User users) {
        this.bookingId = bookingId;
        this.cars = cars;
        this.users = users;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public Car getCars() {
        return cars;
    }

    public void setCars(Car cars) {
        this.cars = cars;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
