package f.g.org.org.org.osmdroid;

import f.g.c.package_10.Splitter;
import f.g.c.package_8.Lists;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Request
{
  public static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
  
  public Request() {}
  
  public static Map parseQuery(String paramString)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    paramString = Splitter.on('&').split(paramString).iterator();
    while (paramString.hasNext())
    {
      Object localObject = (String)paramString.next();
      localObject = Lists.newArrayList(Splitter.on('=').split((CharSequence)localObject));
      if (((List)localObject).size() == 2) {
        localHashMap.put(URLDecoder.decode((String)((List)localObject).get(0), "UTF-8"), URLDecoder.decode((String)((List)localObject).get(1), "UTF-8"));
      } else {
        throw new IOException("Invalid Query String");
      }
    }
    return localHashMap;
  }
}
