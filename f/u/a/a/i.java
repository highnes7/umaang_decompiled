package f.u.a.a;

import android.app.Activity;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import f.u.a.a.a.d;
import f.u.a.a.a.o;
import f.u.a.a.a.y;
import f.u.a.a.b.u;
import f.u.a.a.c.ka;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import l.a.a.a.Item;
import l.a.a.a.l;

public class i
  extends Item
  implements l
{
  public final f.u.a.a.a.f b;
  public final Collection<? extends l.a.a.a.n> c;
  public final u d;
  public final ka e;
  
  public i(TwitterAuthConfig paramTwitterAuthConfig)
  {
    b = new f.u.a.a.a.f(paramTwitterAuthConfig);
    e = new ka();
    d = new u();
    c = Collections.unmodifiableCollection(Arrays.asList(new Item[] { b, e, d }));
  }
  
  public static void a()
  {
    if (l() != null) {
      return;
    }
    throw new IllegalStateException("Must start Twitter Kit with Fabric.with() first");
  }
  
  public static void a(Activity paramActivity, d paramD)
  {
    a();
    lb.a(paramActivity, paramD);
  }
  
  public static o b(y paramY)
  {
    a();
    return lb.a(paramY);
  }
  
  public static void d()
  {
    a();
    lb.f();
  }
  
  public static i l()
  {
    return (i)l.a.a.a.f.add(c.class);
  }
  
  public static f.u.a.a.a.n p()
  {
    a();
    return lb.p();
  }
  
  public static o removeItem()
  {
    a();
    return lb.b();
  }
  
  public Collection b()
  {
    return c;
  }
  
  public String c()
  {
    return "2.3.1.165";
  }
  
  public String getId()
  {
    return "com.twitter.sdk.android:twitter";
  }
  
  public Object run()
  {
    return null;
  }
}
