package tripadvisor;
/*
 * User : Sekharan Natarajan
   Done as part of Trip Advisor Interview round 2:
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author sekhar natarajan
 */
class Hotel {

    private String name;
    private int numRooms;

    /**
     * No argument Constructor. Might become useful when we use Parsers
     */
    public Hotel() {
    }

    /**
     * Constructor
     *
     * @param name name of the hotel, Rooms is initialized to 0
     */
    public Hotel(String name) {
        this.name = name;
        this.numRooms = 0;
    }

    /**
     * Constructor
     *
     * @param name name of the hotel
     * @param rooms number of rooms available at the hotel
     */
    public Hotel(String name, int rooms) {
        this.name = name;
        this.numRooms = rooms;
    }

    /**
     * Get the name of the hotel
     *
     * @return name of the hotel
     */
    public String getName() {
        return name;
    }

    /**
     * Get the number of rooms available in the hotel
     *
     * @return number of rooms available in the hotel
     */
    public int getNumRooms() {
        return numRooms;
    }

    /**
     * Get the number of rooms available in the hotel
     *
     * @param numRooms number of rooms available in the hotel
     */
    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    /**
     * Returns a hash map of hotels
     *
     * @param list ArrayList of Strings
     * @return a map of hotel (key - hotel name, value - Hotel)
     */
    public static HashMap<String, Hotel> getHotels(ArrayList<String> list) {
//        System.out.println(list.toString());
        HashMap<String, Hotel> hotelMap = new HashMap<>();
        for (String str : list) {
            String[] items = str.split(",");
            hotelMap.put(items[0], new Hotel(items[0].trim(), Integer.parseInt(items[1].trim())));
        }

        return hotelMap;
    }

    @Override
    protected Hotel clone() {
        return new Hotel(this.name, this.numRooms);
    }

    @Override
    public String toString() {
        return this.name + "," + this.numRooms;
    }

}

/**
 *
 * @author sekhar natarajan
 */
class Booking {

    private String hotelName;
    private Date checkin;
    private Date checkOut;

    /**
     * No argument Constructor. Might become useful when we use Parsers
     */
    public Booking() {
    }

    /**
     * Constructor
     *
     * @param name
     * @param checkIn
     * @param checkOut
     */
    public Booking(String name, Date checkIn, Date checkOut) {
        this.hotelName = name;
        this.checkin = checkIn;
        this.checkOut = checkOut;
    }

    /**
     * Get the name of the hotel
     *
     * @return Name of the hotel
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Get the date of checking into hotel
     *
     * @return Date of checking into hotel
     */
    public Date getCheckin() {
        return checkin;
    }

    /**
     * Get the date of checking out of hotel
     *
     * @return Date of checking out of hotel
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * Helper to construct an array list of Booking instances from list of
     * strings
     *
     * @param list
     * @return ArrayList of Booking instances
     * @throws ParseException
     */
    public static ArrayList<Booking> getBookings(ArrayList<String> list) throws ParseException {
        ArrayList<Booking> bookingList = new ArrayList<>();
        for (String str : list) {
            String[] items = str.split(",");
            bookingList.add(new Booking(items[0].trim(), Util.parseDate(items[1].trim()), Util.parseDate(items[2].trim())));
        }

        return bookingList;
    }

    @Override
    public String toString() {
        return this.hotelName + "," + this.checkin + "," + this.checkOut;
    }

}

/**
 *
 * @author sekhar natarajan
 */
class Util {

    /**
     * Container class having constants to modify console print colors
     */
    static class ConsoleColors {

        static final String BLACK = "\033[0m";
        static final String RED = "\033[31m";
        static final String GREEN = "\033[32m";
        static final String YELLOW = "\033[33m";
        static final String BLUE = "\033[34m";
        static final String MAGENTA = "\033[35m";
        static final String CYAN = "\033[36m";
        static final String WHITE = "\033[37m";
    }

    /**
     * Take in string of the form yyyy-MM-dd and returns the equivalent Date
     *
     * @param date date string
     * @return Java Date object
     * @throws ParseException
     */
    public static Date parseDate(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date result = df.parse(date);
        return result;
    }

    /**
     * Returns a Date that comes numDays after startDate
     *
     * @param startDate start date
     * @param numDays number of days to add to startDate
     * @return a Date that is numDays after startDate
     */
    public static Date getAddedDate(Date startDate, int numDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DATE, numDays);
        return cal.getTime();
    }

    /**
     * Returns a hash map command line options and corresponding values
     *
     * @param args string array of arguments
     * @return a map of the options and values
     */
    public static HashMap<String, String> extractOptions(String[] args) {
        HashMap<String, String> optionsMap = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].trim().startsWith("--")) {
                if (i + 1 < args.length) {
                    optionsMap.put(args[i].trim().substring(2), args[i + 1].trim());
                }
            }
        }
        return optionsMap;
    }

    /**
     * Utility function to read a CSV file and return a list of strings
     *
     * @param path path of the csv file
     * @return ArrayList of Strings
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<String> csvToString(String path) throws FileNotFoundException, IOException {
        ArrayList<String> list = new ArrayList<>();
        Path inputPath = Paths.get(path);
        File file = new File(inputPath.toAbsolutePath().normalize().toString());
        FileInputStream fin = new FileInputStream(file);
        Scanner sc = new Scanner(fin);

        String str;
        if (sc.hasNextLine()) {
            str = sc.nextLine().trim();
            //Assuming the header starts with #
            if (str != null && !str.isEmpty() && !str.startsWith("#")) {
                list.add(str);
            }
        }
        while (sc.hasNextLine()) {
            str = sc.nextLine().trim();
            
            //Ignores empty strings (ex.new lines)
            if (str != null && !str.isEmpty()) {
                list.add(str);
            }
        }

        fin.close();
        sc.close();
        return list;

    }

    /**
     * Prints the help information for the application
     */
    public static void printHelp() {
        System.out.println(new StringBuilder().append("Usage\n")
                .append("==============\n")
                .append("HotelAvailabilityChecker ")
                .append(ConsoleColors.RED + "--hotels ")
                .append(ConsoleColors.GREEN + "your_hotel.csv ")
                .append(ConsoleColors.RED + "--bookings ")
                .append(ConsoleColors.GREEN + "your_bookings.csv ")
                .append(ConsoleColors.RED + "--checkin ")
                .append(ConsoleColors.GREEN + "your_checkin_date ")
                .append(ConsoleColors.RED + "--checkout ")
                .append(ConsoleColors.GREEN + "your_checkout_date ")
        );

        System.out.println(ConsoleColors.YELLOW);
        System.out.println("your_hotel.csv       -    A CSV file with a header and of the form 'Name, Rooms' (EXAMPLE) Westin, 10 ");
        System.out.println("your_bookings.csv    -    A CSV file with a header and of the form 'Name, Checkin, Checkout' --->example Westin, 2015-05-01, 2015-05-20");
        System.out.println("your_checkin_date    -    A date string of the form 'yyyy-MM-dd' (EXAMPLE) 2015-08-01");
        System.out.println("your_checkout_date   -    A date string of the form 'yyyy-MM-dd' (EXAMPLE) 2015-08-05");

    }

}

/**
 * 
 * @author sekhar natarajan
 */
public class HotelAvailablityChecker {

    private static final boolean TEST_MODE = Boolean.FALSE;
    private static final int NUM_ARGS = 8;
    // List of required options for the program to run
    private static final String[] REQUIRED_OPTIONS = new String[]{"hotels", "bookings", "checkin", "checkout"};
    // Stores the commandline options as a hash map
    private static Map<String, String> optionsMap = new HashMap<>();
    // Stores the list of booked (Atleast one booking) hotels on a give date.
    private HashMap<Date, HashMap<String, Hotel>> dateHotelMap = new HashMap<>();

    /**
     * Prints available hotels
     *
     * @param hotels hash map of Hotel
     * @param bookings ArrayList of Booking
     * @param checkinDate Check in date
     * @param checkoutDate Check out date
     * @return HashMap of hotels
     */
    public HashMap<String, Hotel> getAvailableHotels(HashMap<String, Hotel> hotels, ArrayList<Booking> bookings, Date checkinDate, Date checkoutDate) {

        for (int i = 0; i < bookings.size(); i++) {
            Date currDate = bookings.get(i).getCheckin();
            Date endDate = bookings.get(i).getCheckOut();

            do {
                HashMap<String, Hotel> bookedHotels = dateHotelMap.get(currDate);
                if (bookedHotels == null) {
                    bookedHotels = new HashMap<>();
                    //Important to clone and not use the same reference
                    Hotel hotel = hotels.get(bookings.get(i).getHotelName()).clone();
                    hotel.setNumRooms(hotel.getNumRooms() - 1);
                    bookedHotels.put(hotel.getName(), hotel);
                    dateHotelMap.put(currDate, bookedHotels);
                } else {
                    Hotel hotel = bookedHotels.get(bookings.get(i).getHotelName());
                    if (hotel == null) {
                        //Important to clone and not use the same reference
                        hotel = hotels.get(bookings.get(i).getHotelName()).clone();
                        hotel.setNumRooms(hotel.getNumRooms() - 1);
                        bookedHotels.put(hotel.getName(), hotel);
                    } else {
                        //For the current date, and for the current hotel, reduce the number of rooms by 1
                        hotel.setNumRooms(hotel.getNumRooms() - 1);
                    }
                }
                currDate = Util.getAddedDate(currDate, 1);
            } while (currDate.compareTo(endDate) <= 0);
        }

        Date currDate = checkinDate;
        Date endDate = checkoutDate;

        // Start with all hotels as available
        HashMap<String, Hotel> finalList = new HashMap<>();
        for (String hotel : hotels.keySet()) {
            if (hotels.get(hotel).getNumRooms() > 0) {
                finalList.put(hotel, hotels.get(hotel).clone());
            }
        }

        do {

            HashMap<String, Hotel> availableOnCurrDate = dateHotelMap.get(currDate);
            if (availableOnCurrDate != null) {
                for (String hotelName : availableOnCurrDate.keySet()) {
                    if (availableOnCurrDate.get(hotelName).getNumRooms() <= 0) {
                        finalList.remove(hotelName);
                    }
                }
            }

            currDate = Util.getAddedDate(currDate, 1);
        } while (currDate.compareTo(endDate) <= 0);

        return finalList;

    }

    /**
     * Driver function - Main
     *
     * @param args
     * @throws IOException
     * @throws ParseException
     */
    public static void main(String[] args) throws IOException, ParseException {
        HotelAvailablityChecker hack = new HotelAvailablityChecker();
        if (verifyOptions(args)) {

            HashMap<String, Hotel> hotels = Hotel.getHotels(Util.csvToString(optionsMap.get("hotels")));
            ArrayList<Booking> bookings = Booking.getBookings(Util.csvToString(optionsMap.get("bookings")));
            Date checkinDate = Util.parseDate(optionsMap.get("checkin"));
            Date checkoutDate = Util.parseDate(optionsMap.get("checkout"));
            HashMap<String, Hotel> finalList = hack.getAvailableHotels(hotels, bookings, checkinDate, checkoutDate);

            for (String hotel : finalList.keySet()) {
                System.out.println(hotel);
            }
        } else {
            Util.printHelp();
        }

        if (TEST_MODE) {
            HotelTest ht = new HotelTest();
            ht.test();
        }

    }

    /**
     * Checks if the command is properly formed.
     *
     * @param args
     * @return boolean indicating if the command is valid or not
     */
    public static boolean verifyOptions(String[] args) {
        if (args.length != NUM_ARGS) {
            System.err.println("Wrong number of arguments");
            return false;
        }
        optionsMap = Util.extractOptions(args);
        if (optionsMap.keySet().containsAll(Arrays.asList(REQUIRED_OPTIONS))) {
            try {
                if (Util.parseDate(optionsMap.get("checkin")).compareTo(Util.parseDate(optionsMap.get("checkout"))) > 0) {
                    System.err.println("Checkin Date is after checkout Date");
                    return false;
                }
            } catch (ParseException ex) {
                System.err.println("Date format error");
                return false;
            }
            return true;
        }
        return false;
    }

}

/**
 * Some test cases. Not Exhaustive though
 *
 * @author sekhar natarajan
 */
class HotelTest {

    public static final String PASS = "PASS";
    public static final String FAIL = "FAIL";

    private String testParseDate() {
        String date = "2015-02-28";
        try {
            Date d = Util.parseDate(date);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
//            System.out.println(c.get(Calendar.YEAR) + " " + c.get(Calendar.DATE) + " " + c.get(Calendar.MONTH));
            return (c.get(Calendar.YEAR) == 2015 && c.get(Calendar.DATE) == 28 && c.get(Calendar.MONTH) == 1) ? PASS : FAIL;
        } catch (ParseException pe) {
            return FAIL;
        }
    }

    private String testParseDate2() {
        String date = "2015-02-29";
        try {
            Date d = Util.parseDate(date);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            return c.get(Calendar.YEAR) == 2015 && c.get(Calendar.DATE) != 28 && c.get(Calendar.MONTH) != 1 ? PASS : FAIL;
        } catch (ParseException pe) {
            return FAIL;
        }
    }

    private String testAddDate() {
        String date = "2016-02-28";
        try {
            Date d = Util.parseDate(date);
            Date dt = Util.getAddedDate(d, 1);
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            return c.get(Calendar.YEAR) == 2016 && c.get(Calendar.DATE) == 29 && c.get(Calendar.MONTH) == 1 ? PASS : FAIL;
        } catch (ParseException pe) {
            return FAIL;
        }
    }

    /**
     * Check for empty hotel and bookings (empty csv file)
     *
     * @return
     */
    private String testAvailability() {
        String date = "2016-02-28";
        String date2 = "2016-02-28";

        HotelAvailablityChecker hac = new HotelAvailablityChecker();
        HashMap<String, Hotel> hotels = new HashMap<>();
        ArrayList<Booking> bookings = new ArrayList<>();
        try {
            Date checkinDate = Util.parseDate(date);
            Date checkoutDate = Util.parseDate(date2);
            HashMap<String, Hotel> finalList = hac.getAvailableHotels(hotels, bookings, checkinDate, checkoutDate);
            return (finalList.isEmpty()) ? PASS : FAIL;
        } catch (ParseException pe) {
            return FAIL;
        }
    }

    /**
     * Check for hotels with 0 rooms
     *
     * @return
     */
    private String testAvailability2() {
        try {
            String date = "2016-02-28";
            String date2 = "2016-02-28";

            ArrayList<Booking> list2 = new ArrayList<>();

            HotelAvailablityChecker hac = new HotelAvailablityChecker();
            HashMap<String, Hotel> hotels = new HashMap<>();
            ArrayList<Booking> bookings = new ArrayList<>();

            hotels.put("h1", new Hotel("h1", 0));
            hotels.put("h2", new Hotel("h2", 0));
            hotels.put("h3", new Hotel("h3", 0));
            bookings.add(new Booking("h1", Util.parseDate(date), Util.parseDate(date2)));
            bookings.add(new Booking("h2", Util.parseDate(date), Util.parseDate(date2)));
            bookings.add(new Booking("h3", Util.parseDate(date), Util.parseDate(date2)));

            try {
                Date checkinDate = Util.parseDate(date);
                Date checkoutDate = Util.parseDate(date2);
                HashMap<String, Hotel> finalList = hac.getAvailableHotels(hotels, bookings, checkinDate, checkoutDate);
                return (finalList.isEmpty()) ? PASS : FAIL;
            } catch (ParseException pe) {
                return FAIL;
            }
        } catch (ParseException ex) {
            return FAIL;
        }
    }

    private String testAvailability3() {
        try {
            String date = "2016-02-28";
            String date2 = "2016-02-28";

            ArrayList<Booking> list2 = new ArrayList<>();

            HotelAvailablityChecker hac = new HotelAvailablityChecker();
            HashMap<String, Hotel> hotels = new HashMap<>();
            ArrayList<Booking> bookings = new ArrayList<>();

            hotels.put("h1", new Hotel("h1", 2));
            hotels.put("h2", new Hotel("h2", 3));
            hotels.put("h3", new Hotel("h3", 1));
            bookings.add(new Booking("h1", Util.parseDate(date), Util.parseDate(date2)));
            bookings.add(new Booking("h2", Util.parseDate(date), Util.parseDate(date2)));
            bookings.add(new Booking("h3", Util.parseDate(date), Util.parseDate(date2)));

            try {
                Date checkinDate = Util.parseDate(date);
                Date checkoutDate = Util.parseDate(date2);
                HashMap<String, Hotel> finalList = hac.getAvailableHotels(hotels, bookings, checkinDate, checkoutDate);
                //System.out.println(finalList.keySet().toString());
                return (finalList.size() == 2 && finalList.keySet().contains("h1") && finalList.keySet().contains("h2")) ? PASS : FAIL;
            } catch (ParseException pe) {
                return FAIL;
            }
        } catch (ParseException ex) {
            return FAIL;
        }
    }

    /**
     * Testing for dates that cover all the hotel bookings
     *
     * @return
     */
    private String testAvailability4() {
        try {
            String date = "2016-01-01";
            String date2 = "2016-12-31";

            HashMap<String, Hotel> hotels = new HashMap<>();
            ArrayList<Booking> bookings = new ArrayList<>();
            hotels.put("h1", new Hotel("h1", 2));
            hotels.put("h2", new Hotel("h2", 3));
            hotels.put("h3", new Hotel("h3", 1));

            bookings.add(new Booking("h1", Util.parseDate("2016-01-28"), Util.parseDate("2016-02-28")));
            bookings.add(new Booking("h1", Util.parseDate("2016-01-28"), Util.parseDate("2016-02-28")));
            bookings.add(new Booking("h2", Util.parseDate("2016-02-28"), Util.parseDate("2016-03-28")));
            bookings.add(new Booking("h2", Util.parseDate("2016-02-28"), Util.parseDate("2016-03-28")));
            bookings.add(new Booking("h3", Util.parseDate("2016-03-28"), Util.parseDate("2016-04-28")));

            HotelAvailablityChecker hac = new HotelAvailablityChecker();

            try {
                Date checkinDate = Util.parseDate(date);
                Date checkoutDate = Util.parseDate(date2);
                HashMap<String, Hotel> finalList = hac.getAvailableHotels(hotels, bookings, checkinDate, checkoutDate);
                return (finalList.size() == 1 && finalList.keySet().contains("h2")) ? PASS : FAIL;
            } catch (ParseException pe) {
                return FAIL;
            }
        } catch (ParseException ex) {
            return FAIL;
        }
    }

    /**
     *
     * @return
     */
    private String testAvailability5() {
        try {
            String date = "2016-01-01";
            String date2 = "2016-12-31";

            HashMap<String, Hotel> hotels = new HashMap<>();
            ArrayList<Booking> bookings = new ArrayList<>();
            hotels.put("h1", new Hotel("h1", 2));
            hotels.put("h2", new Hotel("h2", 3));
            hotels.put("h3", new Hotel("h3", 1));

            bookings.add(new Booking("h1", Util.parseDate("2016-01-28"), Util.parseDate("2016-02-28")));
            bookings.add(new Booking("h1", Util.parseDate("2016-01-28"), Util.parseDate("2016-02-28")));
            bookings.add(new Booking("h2", Util.parseDate("2016-02-28"), Util.parseDate("2016-03-28")));
            bookings.add(new Booking("h2", Util.parseDate("2016-02-28"), Util.parseDate("2016-03-28")));
            bookings.add(new Booking("h2", Util.parseDate("2016-02-28"), Util.parseDate("2016-03-28")));
            bookings.add(new Booking("h3", Util.parseDate("2016-03-28"), Util.parseDate("2016-04-28")));

            HotelAvailablityChecker hac = new HotelAvailablityChecker();

            try {
                Date checkinDate = Util.parseDate(date);
                Date checkoutDate = Util.parseDate(date2);
                HashMap<String, Hotel> finalList = hac.getAvailableHotels(hotels, bookings, checkinDate, checkoutDate);
                return (finalList.size() == 0) ? PASS : FAIL;
            } catch (ParseException pe) {
                return FAIL;
            }
        } catch (ParseException ex) {
            return FAIL;
        }
    }

    public void test() {
        System.out.println(testParseDate());
        System.out.println(testParseDate2());
        System.out.println(testAddDate());
        System.out.println(testAvailability());
        System.out.println(testAvailability2());
        System.out.println(testAvailability3());
        System.out.println(testAvailability4());
        System.out.println(testAvailability5());
    }
}
