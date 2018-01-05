package continuousnet.calender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {
    private SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("MMM - yyyy", Locale.getDefault());
    private List<CyclingActivity> cyclingActivities;

    CompactCalendarView compactCalendarView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cyclingActivities = new ArrayList<>();
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        compactCalendarView = (CompactCalendarView) findViewById(R.id.myCalender);
        textView = (TextView) findViewById(R.id.textView);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(llm);
        CyclingActivitiesAdapter adapter = new CyclingActivitiesAdapter(cyclingActivities);
        rv.setAdapter(adapter);


        textView.setText(dateFormatForMonth.format(compactCalendarView.getFirstDayOfCurrentMonth()));


        compactCalendarView.setUseThreeLetterAbbreviation(true);
        //Added Event Using parse
        try {
            Event ev1 = new Event(R.color.colorAccent, date.parse("29-01-2018").getTime(), "Some extra data that I want to store.");
            compactCalendarView.addEvent(ev1, true);
        } catch (Exception e) {
            Log.e("event: ", e.toString());
        }
        // Added Event Using epoch Time
        Event ev2 = new Event(R.color.colorAccent, 1516838400000L, "Some extra data that I want to store.");
        compactCalendarView.addEvent(ev2, true);
        // define a listener to receive callbacks when certain events happen.
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {

                Log.e("dateClicked: ", dateClicked.toString());
                Log.e("dateClickedInMS: ", dateClicked.getTime() + "");
//                Date currentDay = new Date(System.currentTimeMillis());
//                Log.e("currentDayFromSystem: ", currentDay.toString());
                String timeCurrentDayCalendar = epochToDate(dateClicked, "yyyy-mm-dd");

                // Log.e("t1: ", System.currentTimeMillis() / 1000 + "");
                Log.e("t2: ", timeCurrentDayCalendar + "");

//                if (timeCurrentDayCalendar.equals(epochToDate(System.get,"dd-mm-yyyy"))) {
//                    Log.e("CurrentDay: ", dateClicked.toString());
//                }

                Date myDay = new Date(1517184000000L);
                //Log.e("myDay: ", myDay.toString());

                if (epochToDate(dateClicked, "yyyy-mm-dd").equals("2018-00-29")) {
                    //Toast.makeText(MainActivity.this, "My birthdate",Toast.LENGTH_LONG).show();
                    initializeData();
                    CyclingActivitiesAdapter adapter = new CyclingActivitiesAdapter(cyclingActivities);
                    rv.setAdapter(adapter);
                }

                Date mySecDay = new Date(1516838400000L);
                if (dateClicked.equals(mySecDay)) {
                    //Toast.makeText(MainActivity.this, "Test",Toast.LENGTH_LONG).show();
                    initializeArray();
                    CyclingActivitiesAdapter adapter = new CyclingActivitiesAdapter(cyclingActivities);
                    rv.setAdapter(adapter);
                }

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                textView.setText(dateFormatForMonth.format(firstDayOfNewMonth));
            }
        });
    }


    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData() {
        //cyclingActivities = new ArrayList<>();
        cyclingActivities.clear();
        cyclingActivities.add(new CyclingActivity("12:30-14:00", "Activity 1", 1));
        cyclingActivities.add(new CyclingActivity("14:30-15:00", "Activity 2", 2));
        cyclingActivities.add(new CyclingActivity("15:30-15:40", "Activity 3", 3));
    }

    private void initializeArray() {
        //cyclingActivities = new ArrayList<>();
        cyclingActivities.clear();
        cyclingActivities.add(new CyclingActivity("11:30-12:00", "Activity 1", 1));
        cyclingActivities.add(new CyclingActivity("15:30-15:40", "Activity 2", 2));

    }

    String epochToDate(Date date, String outputFormat) {
        String returnDate = "";
        if (null != date) {
            SimpleDateFormat formatter = new SimpleDateFormat(outputFormat);
            returnDate = formatter.format(date);
        }
        return returnDate;
    }
}
