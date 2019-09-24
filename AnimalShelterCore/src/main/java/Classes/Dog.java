package Classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dog extends Animal {


    public Calendar lastWalk = Calendar.getInstance();
    public Calendar currentDate = Calendar.getInstance();

//    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm");
    Date date = new Date(System.currentTimeMillis());

    public boolean needsWalk() {

        if (currentDate.get(Calendar.DAY_OF_YEAR) - lastWalk.get(Calendar.DAY_OF_YEAR) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Dog(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public String toString() {
        return super.toString() + ", last walk: " + formatter.format(date);
    }
}
