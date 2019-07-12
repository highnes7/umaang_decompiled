package f.g.org.org.dom4j.asm;

import f.g.b.a.a.b.q;
import f.g.b.a.g.b.d;
import f.g.b.a.g.h;
import f.g.org.org.util.store.DataStore;
import f.g.org.org.util.store.DataStoreFactory;
import java.io.IOException;

@h
public final class HashCrossContextPsuedoSession
  implements e
{
  public final d<q> _cookieName;
  public final String _data;
  
  public HashCrossContextPsuedoSession(String paramString, DataStore paramDataStore)
  {
    if (paramString != null)
    {
      _data = paramString;
      if (paramDataStore != null)
      {
        _cookieName = paramDataStore;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public HashCrossContextPsuedoSession(String paramString, DataStoreFactory paramDataStoreFactory)
    throws IOException
  {
    this(paramString, Range.set(paramDataStoreFactory));
  }
  
  public void a(ClassWriter paramClassWriter, Plot paramPlot)
    throws IOException
  {
    clear(paramClassWriter);
  }
  
  public DataStore clear()
  {
    return _cookieName;
  }
  
  public void clear(ClassWriter paramClassWriter)
    throws IOException
  {
    _cookieName.set(_data, new Range(paramClassWriter));
  }
  
  public void clear(ClassWriter paramClassWriter, Set paramSet)
    throws IOException
  {
    clear(paramClassWriter);
  }
}
