package f.libs.asm.asm;

import android.content.Context;
import java.util.Map;
import java.util.UUID;
import l.a.a.a.a.b.ClassWriter;
import l.a.a.a.a.b.f;
import l.a.a.a.a.b.y.a;

public class Type
{
  public final Context a;
  public final f b;
  public final String c;
  public final String d;
  
  public Type(Context paramContext, f paramF, String paramString1, String paramString2)
  {
    a = paramContext;
    b = paramF;
    c = paramString1;
    d = paramString2;
  }
  
  public m a()
  {
    Object localObject = b.apply();
    String str1 = b.e();
    String str2 = b.a();
    Boolean localBoolean = b.k();
    localObject = (String)((Map)localObject).get(y.a.c);
    String str3 = ClassWriter.c(a);
    String str4 = b.i();
    String str5 = b.getString();
    return new m(str1, UUID.randomUUID().toString(), str2, localBoolean, (String)localObject, str3, str4, str5, c, d);
  }
}
