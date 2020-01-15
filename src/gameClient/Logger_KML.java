package gameClient;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Icon;
import de.micromata.opengis.kml.v_2_2_0.IconStyle;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;
import de.micromata.opengis.kml.v_2_2_0.TimeSpan;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;
import org.junit.experimental.theories.Theories;
import utils.StdDraw;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Logger_KML {

    public void CreateOBJforKML() throws ParseException, InterruptedException {
        Kml k = new Kml ();
        Document doc = k.createAndSetDocument();
        int i = 0 ;
        if (StdDraw.theMain.fullGame.getGame() != null) {
            while (StdDraw.theMain.fullGame.getGame().isRunning()) {
                Thread.sleep(100);
                i++;
                ArrayList<Players> pla = StdDraw.theMain.fullGame.getP();
                ArrayList<Fruits> fru = StdDraw.theMain.fullGame.getF();

                for (Players p : pla) {
                    Placemark plmark = doc.createAndAddPlacemark();
                    plmark.withDescription("Mac: " + "\nType: CAR").withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(p.getLocation().x(), p.getLocation().y());
                    String time1 = MillisToString(StringToMillis(TimeNow()) + i * 1000);
                    String time2 = MillisToString(StringToMillis(TimeNow()) + (i + 1) * 1000);
                    String[] aa = time1.split(" ");
                    time1 = aa[0] + "T" + aa[1] + "Z";
                    String[] bb = time2.split(" ");
                    time2 = bb[0] + "T" + bb[1] + "Z";
                    TimeSpan a = plmark.createAndSetTimeSpan();
                    a.setBegin(time1);
                    a.setEnd(time2);
                }

                for (Fruits f : fru) {
                    Placemark placmark = doc.createAndAddPlacemark();
                    Icon ff = new Icon();
                    ff.setHref("http://www.coal-ash.co.il/maps/sites/all/modules/coalash/icons/red.png");
                    ff.setViewBoundScale(1);
                    ff.setViewRefreshTime(1);
                    ff.withRefreshInterval(1);
                    IconStyle pp = new IconStyle();
                    pp.setScale(1);
                    pp.setHeading(1);
                    pp.setColor("ff007db3");
                    pp.setIcon(ff);
                    placmark.createAndAddStyle().setIconStyle(pp);
                    placmark.withDescription("MAC: " + "\nType: FRUIT").withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(f.getLocation().x(), f.getLocation().y());
                    String time1 = MillisToString(StringToMillis(TimeNow()) + i * 1000);
                    String time2 = MillisToString(StringToMillis(TimeNow()) + (i + 1) * 1000);
                    String[] aa = time1.split(" ");
                    time1 = aa[0] + "T" + aa[1] + "Z";
                    String[] bb = time2.split(" ");
                    time2 = bb[0] + "T" + bb[1] + "Z";
                    TimeSpan b = placmark.createAndSetTimeSpan();
                    b.setBegin(time1);
                    b.setEnd(time2);
                }
            }
        }
        try {
            k.marshal(new File("KmlRun.kml"));
            System.out.println("create");
        } catch (Exception e) {
            System.out.println("Fail create");
        }
    }


    public String MillisToString(Long millis)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(millis));
    }


    public long StringToMillis(String TimeAsString) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        Date date = format.parse(TimeAsString.toString());
        long millis = date.getTime();
        return millis;
    }

    public String TimeNow()
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }

}
