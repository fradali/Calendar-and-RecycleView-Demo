package continuousnet.calender;

import android.support.v7.app.ActionBar;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("MMM - yyyy", Locale.getDefault());
    private List<CyclingActivity> cyclingActivities;

    CompactCalendarView compactCalendarView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compactCalendarView = (CompactCalendarView) findViewById(R.id.myCalender);
        textView = (TextView) findViewById(R.id.textView);
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(llm);
        initializeData();
        RVAdapter adapter = new RVAdapter(cyclingActivities);
        rv.setAdapter(adapter);

        textView.setText(dateFormatForMonth.format(compactCalendarView.getFirstDayOfCurrentMonth()));


        compactCalendarView.setUseThreeLetterAbbreviation(true);
        Event ev1 = new Event(R.color.colorAccent, 1517184000000L, "Some extra data that I want to store.");
        compactCalendarView.addEvent(ev1, true);

        // define a listener to receive callbacks when certain events happen.
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Log.e("dateClicked: ", dateClicked.toString());
                Date myDay = new Date(1517184000000L);
                Log.e("myDay: ", myDay.toString());
                if(dateClicked.equals(myDay)){
                    Toast.makeText(MainActivity.this, "My birthdate",Toast.LENGTH_LONG).show();

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
    private void initializeData(){
        cyclingActivities = new ArrayList<>();
        cyclingActivities.add(new CyclingActivity("12:30-14:00", "Activity 1", 1));
        cyclingActivities.add(new CyclingActivity("14:30-15:00", "Activity 2", 2));
        cyclingActivities.add(new CyclingActivity("15:30-15:40", "Activity 3", 3));
    }
}
