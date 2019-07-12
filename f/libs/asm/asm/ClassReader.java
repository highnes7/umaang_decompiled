package f.libs.asm.asm;

import android.content.Context;
import l.a.a.a.Log;
import l.a.a.a.f;

public class ClassReader
{
  public k a;
  public final ClassWriter b;
  public final Context c;
  
  public ClassReader(Context paramContext)
  {
    c = paramContext;
    b = localClassWriter;
  }
  
  public ClassReader(Context paramContext, ClassWriter paramClassWriter)
  {
    c = paramContext;
    b = paramClassWriter;
  }
  
  public void a(Label paramLabel)
  {
    Object localObject1 = b();
    if (localObject1 == null)
    {
      f.get().d("Answers", "Firebase analytics logging was enabled, but not available...");
      return;
    }
    Object localObject2 = b.b(paramLabel);
    if (localObject2 == null)
    {
      localObject1 = f.get();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Fabric event was not mappable to Firebase event: ");
      ((StringBuilder)localObject2).append(paramLabel);
      ((Log)localObject1).d("Answers", ((StringBuilder)localObject2).toString());
      return;
    }
    ((k)localObject1).a(((e.a)localObject2).a(), ((e.a)localObject2).b());
    if ("levelEnd".equals(a)) {
      ((k)localObject1).a("post_score", ((e.a)localObject2).b());
    }
  }
  
  public k b()
  {
    if (a == null) {
      a = l.a(c);
    }
    return a;
  }
}
