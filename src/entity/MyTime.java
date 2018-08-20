package entity;

/**
 * Created by mac on 2018/8/18.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

    public class MyTime {


        public long days(String b) throws ParseException{
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String str = df.format(new Date());
            long to = df.parse(str).getTime();
            long from = df.parse(b).getTime();
            long i = (to - from) / (1000 * 60 * 60 * 24);
            return i;
        }

    }


