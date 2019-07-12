package f.libs.asm.asm;

import f.c.a.a.I;
import f.c.a.a.ba;

public class File
  extends I<ba>
{
  public static final String EXTRA_START_METHOD = "method";
  public static final String PROTOCOL = "contentName";
  public static final String TAG = "contentId";
  public static final String data = "contentType";
  public static final String mType = "share";
  
  public File() {}
  
  public File a(String paramString)
  {
    c.add("contentName", paramString);
    return this;
  }
  
  public File close(String paramString)
  {
    c.add("method", paramString);
    return this;
  }
  
  public String getId()
  {
    return "share";
  }
  
  public File onCreateView(String paramString)
  {
    c.add("contentType", paramString);
    return this;
  }
  
  public File write(String paramString)
  {
    c.add("contentId", paramString);
    return this;
  }
}
