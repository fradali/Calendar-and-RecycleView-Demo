package continuousnet.calender;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Calendar;

/**
 * Created by thedarkslayer on 16/08/17.
 */

public class BackgroundCurrentDayDecorator implements DayViewDecorator {
    private Calendar cal;
    private Drawable currentDayBackgroundDrawable;
    private Context context;

    public BackgroundCurrentDayDecorator(Context context) {
        super();
        this.context = context;
        Calendar calendar = Calendar.getInstance();
        this.cal = calendar;
        Drawable drawable = ContextCompat.getDrawable(this.context, R.drawable.background_dayview_current_selector);
        this.currentDayBackgroundDrawable = drawable;
    }

    public final Calendar getCal() {
        return this.cal;
    }

    public final Drawable getCurrentDayBackgroundDrawable() {
        return this.currentDayBackgroundDrawable;
    }

    public boolean shouldDecorate(CalendarDay day) {
        return CalendarDay.from(cal) == day;
    }

    public void decorate(DayViewFacade view) {
        if (view != null) {
            view.setBackgroundDrawable(this.currentDayBackgroundDrawable);
        }

        if (view != null) {
            view.setSelectionDrawable(this.currentDayBackgroundDrawable);
        }

    }


    public final Context getContext() {
        return this.context;
    }


}

