
package coursera;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

/**
 *
 * @author mns
 */
public class CourseraSessions {

    /*
    Sample input
    1470096000000
    2
    1470787200000
     */
    //Number of succeessive sessions to show
    static final int NUM_NEXT = 3;
    static final int NUM_DAYS_WEEK = 7;
    static final boolean DEBUG = true;

    static Date getAddedDate(Date startDate, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    static long[] getUpcomingSessions(long launch_date, int repeat_frequency, long enrollment_date) {

        //Setting the UTC time zone...(Wasted hell lot of time here) Wish I was from London!!!!!!!
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        long[] result = new long[NUM_NEXT];
        Date date_launch = new Date(launch_date);
        Date date_enrollment = new Date(enrollment_date);

        //Number of days to next monday
        int buffer = (1 - date_launch.getDay() >= 0) ? 1 - date_launch.getDay() : NUM_DAYS_WEEK - date_launch.getDay() + 1;

        if (DEBUG) {
            System.out.println("Buffer " + buffer);
        }

        //Date of next monday
        Date date_session_start = getAddedDate(date_launch, buffer);

        if (DEBUG) {
            System.out.println(date_session_start.toString());
            System.out.println(date_launch.toGMTString());
            System.out.println(date_enrollment.toGMTString());
        }

        if (date_session_start.getTime() - enrollment_date >= 0) {
            result[0] = date_session_start.getTime();
            for (int i = 1; i < NUM_NEXT; i++) {
                result[i] = getAddedDate(date_session_start, repeat_frequency * NUM_DAYS_WEEK * i).getTime();
            }
        } else {
            int ind = 0;
            int i = 0;

            while (ind < NUM_NEXT) {
                Date date_next_session = getAddedDate(date_session_start, repeat_frequency * NUM_DAYS_WEEK * i++);

                //Checking if the session has crossed the enrollment date
                if (date_next_session.getTime() - enrollment_date >= 0) {
                    result[ind++] = date_next_session.getTime();
                }
            }
        }

        if (DEBUG) {
            print(result);
        }
        return result;
    }

    static void print(long[] arr) {
        for (long l : arr) {
            System.out.println(l);
        }
    }

    static long[][] getSpecializationSessionSchedule(long[][] specialization_courses, long enrollment_date) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        final int NUM_DETAILS = 2;
        long[][] result = new long[specialization_courses.length][NUM_DETAILS];

        Date date_enrollment = new Date(enrollment_date);
        for (int i = 0; i < specialization_courses.length; i++) {
            //System.out.println(specialization_courses[i][0] + " " + specialization_courses[i][1]);
            Date start = new Date(getUpcomingSessions(specialization_courses[i][0],
                    new Long(specialization_courses[i][1]).intValue(), enrollment_date)[0]);
            Date end = getAddedDate(start, new Long(specialization_courses[i][2]).intValue() * NUM_DAYS_WEEK);
            result[i][0] = start.getTime();
            result[i][1] = end.getTime();
            enrollment_date = end.getTime();
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        long launch_date = Long.parseLong(input);
        input = in.nextLine();
        int repeat_grequency = Integer.parseInt(input);
        input = in.nextLine();
        long enrollment_date = Long.parseLong(input);

        getUpcomingSessions(launch_date, repeat_grequency, enrollment_date);
    }
}
