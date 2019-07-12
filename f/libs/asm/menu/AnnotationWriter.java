package f.libs.asm.menu;

import android.content.Context;
import l.a.a.a.a.b.ClassWriter;

public class AnnotationWriter
  implements k
{
  public final Context c;
  public final k d;
  public boolean e = false;
  public String f;
  
  public AnnotationWriter(Context paramContext, k paramK)
  {
    c = paramContext;
    d = paramK;
  }
  
  public String a()
  {
    if (!e)
    {
      f = ClassWriter.getString(c);
      e = true;
    }
    Object localObject = f;
    if (localObject != null) {
      return localObject;
    }
    localObject = d;
    if (localObject != null) {
      return ((k)localObject).a();
    }
    return null;
  }
}
