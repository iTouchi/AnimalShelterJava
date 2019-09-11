import java.util.Calendar;

public class Dog extends Animal {

    //    public Date lastWalk;
    //    Date currentDate = new Date();

    public Calendar lastWalk = Calendar.getInstance();
    public Calendar currentDate = Calendar.getInstance();

    public boolean needsWalku() {

        if (currentDate.get(Calendar.DAY_OF_YEAR) - lastWalk.get(Calendar.DAY_OF_YEAR) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Dog(String name, Gender gender) {
        super(name, gender);
        this.lastWalk = currentDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", last walk: " + this.lastWalk.toString();
    }
}
