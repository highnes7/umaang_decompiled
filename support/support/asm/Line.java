package support.support.asm;

import b.a.b.A;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Line
{
  public final HashMap<String, A> content = new HashMap();
  
  public Line() {}
  
  public final Track init(String paramString)
  {
    return (Track)content.get(paramString);
  }
  
  public final void init(String paramString, Track paramTrack)
  {
    paramString = (Track)content.put(paramString, paramTrack);
    if (paramString != null) {
      paramString.onCleared();
    }
  }
  
  public final void reset()
  {
    Iterator localIterator = content.values().iterator();
    while (localIterator.hasNext()) {
      ((Track)localIterator.next()).onCleared();
    }
    content.clear();
  }
}
