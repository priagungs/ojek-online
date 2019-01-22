package com.future.ojekonline.service.interf;

import com.future.ojekonline.entity.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    Booking createBooking(Booking booking);
    Page<Booking> getBookingByCustomer(String id, Pageable pageable);
    Page<Booking> getBookingByDriver(String id, Pageable pageable);
    Booking updateBooking(Booking booking);
    Boolean deleteBooking(String id);

}
