package com.movie.dto;

public class BookingDTO {
    private Long id;
    private String bookingDate;
    private int seats;

    private String movieTitle;
    private String theaterName;
    private String customerName;

    // Constructors
    public BookingDTO(Long id, String bookingDate, int seats,
                      String movieTitle, String theaterName, String customerName) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.seats = seats;
        this.movieTitle = movieTitle;
        this.theaterName = theaterName;
        this.customerName = customerName;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

    // Getters and Setters
    
}
