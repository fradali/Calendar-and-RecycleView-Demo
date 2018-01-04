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

public class BackgroundDecorator implements DayViewDecorator {

    private Calendar cal;
    private Drawable defaultBackgroundDrawable;
    private Context context;
    private List<CalendarDay> dateList;

    public BackgroundDecorator(Context context, List<CalendarDay> dateList) {
        super();
        this.context = context;
        this.dateList = dateList;
        Calendar calendar = Calendar.getInstance();
        this.cal = calendar;
        Drawable drawable = ContextCompat.getDrawable(this.context, R.drawable.background_dayview_selector);
        this.defaultBackgroundDrawable = drawable;
    }

    public final Calendar getCal() {
        return this.cal;
    }

    public final Drawable getDefaultBackgroundDrawable() {
        return this.defaultBackgroundDrawable;
    }

    public boolean shouldDecorate(@Nullable CalendarDay day) {
        return CalendarDay.from(cal) != day && !dateList.contains(day);
    }

    public void decorate(@Nullable DayViewFacade view) {
        if (view != null) {
            view.setBackgroundDrawable(this.defaultBackgroundDrawable);
        }

        if (view != null) {
            view.setSelectionDrawable(this.defaultBackgroundDrawable);
        }

    }


    public final Context getContext() {
        return this.context;
    }


    public final List<CalendarDay> getDateList() {
        return this.dateList;
    }


}