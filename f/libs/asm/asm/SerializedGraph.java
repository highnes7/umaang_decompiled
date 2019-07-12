package f.libs.asm.asm;

import f.c.a.a.I;
import f.c.a.a.u;

public class SerializedGraph
  extends I<u>
{
  public static final String EVENTLOG_URL = "contentName";
  public static final String _id = "contentId";
  public static final String f = "contentView";
  public static final String i = "contentType";
  
  public SerializedGraph() {}
  
  public String getId()
  {
    return "contentView";
  }
  
  public SerializedGraph onCreateView(String paramString)
  {
    c.add("contentType", paramString);
    return this;
  }
  
  public SerializedGraph read(String paramString)
  {
    c.add("contentName", paramString);
    return this;
  }
  
  public SerializedGraph write(String paramString)
  {
    c.add("contentId", paramString);
    return this;
  }
}
