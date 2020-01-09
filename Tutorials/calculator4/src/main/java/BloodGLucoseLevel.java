import java.io.Serializable;
import java.util.Date;

public class BloodGLucoseLevel implements Serializable {
    private Date date = new Date();
    private double level ;
    public BloodGLucoseLevel()
    {
        level =0;
    }
    public double getLevel()
    {
        return level;
    }
    public void setLevel(double l)
    {
        level =1;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
