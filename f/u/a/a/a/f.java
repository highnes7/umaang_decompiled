package f.u.a.a.a;

import android.app.Activity;
import android.content.Context;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import f.u.a.a.a.a.l;
import f.u.a.a.a.b.a;
import f.u.a.a.a.b.h;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSocketFactory;
import l.a.a.a.Item;
import l.a.a.a.Log;
import l.a.a.a.a.e.TShortCollection;
import l.a.a.a.a.e.p;
import l.a.a.a.a.f.Settings;

public class f
  extends l.a.a.a.n<Boolean>
{
  public static final String A = "twittersession";
  public static final String ACTION_VIEW_STATES_KEY = "Twitter";
  public static final String e = "active_guestsession";
  public static final String g = "guestsession";
  public static final String t = "active_twittersession";
  public static final String w = "session_store";
  public volatile o a;
  public n<y> b;
  public f.u.a.a.a.b.d<y> c;
  public volatile g d;
  public final TwitterAuthConfig i;
  public volatile SSLSocketFactory k;
  public n<e> l;
  public final ConcurrentHashMap<m, o> m;
  
  public f(TwitterAuthConfig paramTwitterAuthConfig)
  {
    i = paramTwitterAuthConfig;
    m = localConcurrentHashMap;
    a = null;
  }
  
  public f(TwitterAuthConfig paramTwitterAuthConfig, ConcurrentHashMap paramConcurrentHashMap, o paramO)
  {
    i = paramTwitterAuthConfig;
    m = paramConcurrentHashMap;
    a = paramO;
  }
  
  private void a()
  {
    try
    {
      Object localObject = k;
      if (localObject == null) {
        try
        {
          localObject = new w(getContext());
          localObject = (TShortCollection)localObject;
          localObject = p.a((TShortCollection)localObject);
          k = ((SSLSocketFactory)localObject);
          l.a.a.a.f.get().d("Twitter", "Custom SSL pinning enabled");
        }
        catch (Exception localException)
        {
          l.a.a.a.f.get().d("Twitter", "Exception setting up custom SSL pinning", localException);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void b(o paramO)
  {
    try
    {
      if (a == null) {
        a = paramO;
      }
      return;
    }
    catch (Throwable paramO)
    {
      throw paramO;
    }
  }
  
  private void clear()
  {
    f.u.a.a.a.b.c.o.a(this, p(), add(), getName());
  }
  
  private void close()
  {
    try
    {
      if (a == null) {
        a = new o();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void d()
  {
    try
    {
      if (d == null) {
        d = new g(new OAuth2Service(this, i(), new f.u.a.a.a.b.f()), l);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static f l()
  {
    next();
    return (f)l.a.a.a.f.add(u.class);
  }
  
  public static void next()
  {
    if (l.a.a.a.f.add(u.class) != null) {
      return;
    }
    throw new IllegalStateException("Must start Twitter Kit with Fabric.with() first");
  }
  
  public o a(y paramY)
  {
    
    if (!m.containsKey(paramY)) {
      m.putIfAbsent(paramY, new o(paramY));
    }
    return (o)m.get(paramY);
  }
  
  public void a(Activity paramActivity, d paramD)
  {
    next();
    new l().a(paramActivity, paramD);
  }
  
  public void a(o paramO)
  {
    
    if (a == null) {
      b(paramO);
    }
  }
  
  public g add()
  {
    
    if (d == null) {
      d();
    }
    return d;
  }
  
  public void add(y paramY, o paramO)
  {
    
    if (!m.containsKey(paramY)) {
      m.putIfAbsent(paramY, paramO);
    }
  }
  
  public o b()
  {
    next();
    y localY = (y)b.c();
    if (localY == null) {
      return k();
    }
    return a(localY);
  }
  
  public String c()
  {
    return "2.3.0.163";
  }
  
  public void f()
  {
    next();
    n localN = p();
    if (localN != null) {
      localN.a();
    }
  }
  
  public TwitterAuthConfig g()
  {
    return i;
  }
  
  public String getId()
  {
    return "com.twitter.sdk.android:twitter-core";
  }
  
  public SSLSocketFactory i()
  {
    
    if (k == null) {
      a();
    }
    return k;
  }
  
  public o k()
  {
    
    if (a == null) {
      close();
    }
    return a;
  }
  
  public boolean onCreate()
  {
    a localA = new a();
    Context localContext = getContext();
    String str = getId();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getId());
    localStringBuilder.append(":");
    localStringBuilder.append("session_store");
    localStringBuilder.append(".xml");
    localA.a(localContext, str, localStringBuilder.toString());
    b = new j(new Settings(getContext(), "session_store"), new y.a(), "active_twittersession", "twittersession");
    l = new j(new Settings(getContext(), "session_store"), new e.a(), "active_guestsession", "guestsession");
    c = new f.u.a.a.a.b.d(b, e().b(), new h());
    return true;
  }
  
  public n p()
  {
    next();
    return b;
  }
  
  public Boolean run()
  {
    b.c();
    l.c();
    i();
    add();
    clear();
    c.a(e().g());
    return Boolean.valueOf(true);
  }
}
