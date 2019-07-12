package support.android.v4.tts;

import b.b.x.l.r.e;
import b.b.x.l.x.a;
import java.util.ArrayList;
import support.android.v4.util.SimpleArrayMap;

public final class e
  implements x.a<r.e>
{
  public e(String paramString) {}
  
  public void a(m paramM)
  {
    Object localObject = Frame.e;
    try
    {
      ArrayList localArrayList = (ArrayList)Frame.b.get(a);
      if (localArrayList == null) {
        return;
      }
      Frame.b.remove(a);
      int i = 0;
      while (i < localArrayList.size())
      {
        ((c)localArrayList.get(i)).a(paramM);
        i += 1;
      }
      return;
    }
    catch (Throwable paramM)
    {
      throw paramM;
    }
  }
}
