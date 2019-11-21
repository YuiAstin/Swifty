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
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    if (string == null) {
      string = "00/00/0000";
    }
    
    String today = df.format(new Date());
    int maxVal = Integer.parseInt(today.substring(today.length()-4));
    if (Integer.parseInt(string.substring(string.length()-4)) > maxVal) {
    	string = string.substring(0, string.length()-5) + maxVal;
    }
    	
    return df.parse(string);
  }
  @Override
  public String valueToString(Object value) throws ParseException {
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    if (value == null) {
      value = new Date(0);
    }
    return df.format((Date) value);
  }
}