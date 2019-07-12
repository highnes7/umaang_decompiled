package f.g.org.org.dom4j.asm;

import java.util.regex.Pattern;

public class Settings
{
  public static final Pattern ACCEPTED_URI_SCHEMA = Pattern.compile("\\s*error\\s*=\\s*\"?invalid_token\"?");
  public static final String TOKEN = "access_token";
  
  public Settings() {}
  
  public static ResponseHandler createResponseHandler()
  {
    return new BasicResponseHandler();
  }
  
  public static ResponseHandler digest()
  {
    return new Credential();
  }
  
  public static ResponseHandler getJid()
  {
    return new ContentResponseHandler();
  }
}
