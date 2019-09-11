import java.util.Date;

public class Reservor {

    private String name;
    private Date reservedAt;

    public Reservor(String name, Date newDate) {

        this.name = name;
        this.reservedAt = newDate;

    }

    //Getter
    public String getName() {
        return name;
    }

    //Setter
    public void setName(String newName) {
        this.name = newName;
    }


}
