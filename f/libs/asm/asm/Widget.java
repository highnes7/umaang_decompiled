package f.libs.asm.asm;

import l.a.a.a.Log;
import l.a.a.a.a.g.b;
import l.a.a.a.f;

public class Widget
  implements Runnable
{
  public Widget(d paramD, b paramB, String paramString) {}
  
  public void run()
  {
    AnnotationWriter localAnnotationWriter = a.b;
    b localB = c;
    String str = b;
    try
    {
      localAnnotationWriter.a(localB, str);
      return;
    }
    catch (Exception localException)
    {
      f.get().d("Answers", "Failed to set analytics settings data", localException);
    }
  }
}
