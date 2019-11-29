package GUI;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import java.util.Date;

class TimeFormatter extends MaskFormatter {
  public TimeFormatter() {
    try {
      setMask("##/##/####");
      setPlaceholderCharacter('0');
      setAllowsInvalid(false);
      setOverwriteMode(true);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
  @Override
  public Object stringToValue(String string) throws ParseException {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    if (string == null) {
      string = "0000-00-00";
    }
    
    String today = df.format(new Date());
    int maxVal = Integer.parseInt(today.substring(0,4));
    if (Integer.parseInt(string.substring(0,4)) > maxVal) {
    	string = maxVal + string.substring(4, string.length());
    }
    	
    return df.parse(string);
  }
  @Override
  public String valueToString(Object value) throws ParseException {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    if (value == null) {
      value = new Date(0);
    }
    return df.format((Date) value);
  }
}