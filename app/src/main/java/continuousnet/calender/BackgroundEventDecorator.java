package continuousnet.calender;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Calendar;
import java.util.List;

/**
 * Created by thedarkslayer on 16/08/17.
 */

public class BackgroundEventDecorator implements DayViewDecorator {
    private Drawable eventBackgroundDrawable;
    private int dotColor;

    private Context context;

    private List<CalendarDay> dateList;

    public BackgroundEventDecorator(Context context, List<CalendarDay> dateList) {
        super();
        this.context = context;
        this.dateList = dateList;
        Drawable drawable = ContextCompat.getDrawable(this.context, R.drawable.background_dayview_event_selector);
        this.eventBackgroundDrawable = drawable;
        this.dotColor = ContextCompat.getColor(this.context, R.color.white);
    }

    public final Drawable getEventBackgroundDrawable() {
        return this.eventBackgroundDrawable;
    }

    public final int getDotColor() {
        return this.dotColor;
    }

    public boolean shouldDecorate(@Nullable CalendarDay day) {
        return dateList.contains(day);
    }

    public void decorate(@Nullable DayViewFacade view) {
        if (view != null) {
            view.setBackgroundDrawable(this.eventBackgroundDrawable);
        }

        if (view != null) {
            view.setSelectionDrawable(this.eventBackgroundDrawable);
        }

    }


    public final Context getContext() {
        return this.context;
    }


    public final List<CalendarDay> getDateList() {
        return this.dateList;
    }


}
