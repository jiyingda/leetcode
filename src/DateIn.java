import java.time.LocalDate;

public class DateIn extends Pair<LocalDate> {
    public void setSecond(LocalDate second){
        if(second.compareTo(getFirst()) >= 0){
            super.setSecond(second);
        }
    }
}
