package android.support.v4.media;

import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.package_7.BundleCompat;
import android.text.TextUtils;
import android.util.Log;
import b.b.a.K;
import b.b.a.N;
import b.b.x.n.b;
import b.b.x.n.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import support.android.v4.asm.AnnotationVisitor;
import support.android.v4.asm.ByteVector;
import support.android.v4.asm.FieldVisitor;
import support.android.v4.asm.FieldWriter;
import support.android.v4.asm.Frame;
import support.android.v4.asm.ImageManager;
import support.android.v4.asm.Main;
import support.android.v4.asm.MainActivity.3;
import support.android.v4.asm.MediaBrowserCompat.MediaBrowserImplBase;
import support.android.v4.asm.MediaBrowserCompat.MediaBrowserImplBase.7;
import support.android.v4.asm.MediaBrowserServiceCompat.1;
import support.android.v4.asm.MediaBrowserServiceCompat.3;
import support.android.v4.asm.MediaBrowserServiceCompat.4;
import support.android.v4.asm.MediaBrowserServiceCompat.ConnectionRecord;
import support.android.v4.asm.MediaBrowserServiceCompat.Result;
import support.android.v4.asm.MediaBrowserServiceCompat.ServiceBinder.1;
import support.android.v4.asm.MediaBrowserServiceCompat.ServiceBinder.3;
import support.android.v4.asm.MediaBrowserServiceCompat.ServiceBinder.4;
import support.android.v4.asm.MediaBrowserServiceCompat.ServiceCallbacksApi21;
import support.android.v4.asm.MediaBrowserServiceCompat.ServiceImpl.6;
import support.android.v4.asm.MediaBrowserServiceCompat.ServiceImpl.7;
import support.android.v4.asm.MethodVisitor;
import support.android.v4.asm.Plot.a;
import support.android.v4.asm.RegisteredMediaRouteProvider.Connection.2;
import support.android.v4.asm.Result;
import support.android.v4.asm.SMTPAppenderBase.SenderRunnable;
import support.android.v4.asm.SimpleArrayMap;
import support.android.v4.asm.TransactionListener;
import support.android.v4.asm.Unit;
import support.android.v4.asm.d;
import support.android.v4.asm.e;
import support.android.v4.asm.ea.b;
import support.android.v4.asm.i;
import support.android.v4.asm.x;
import support.android.v4.util.ArrayMap;

public abstract class MediaBrowserServiceCompat
  extends Service
{
  @N({b.b.a.N.a.a})
  public static final int BUTTON_WEEK_INDEX = 1;
  public static final int CALENDARS_INDEX_CAN_ORGANIZER_RESPOND = 4;
  public static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
  public static final float EPS = 1.0E-5F;
  public static final int HINT_CONTEXT_CAR_HOME = 2;
  @N({b.b.a.N.a.a})
  public static final int Icode_DUP = -1;
  @N({b.b.a.N.a.a})
  public static final String KEY_MEDIA_ITEM = "media_item";
  @N({b.b.a.N.a.a})
  public static final int QUIET_HOURS_DEFAULT_END_MINUTE = 0;
  public static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
  public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
  @N({b.b.a.N.a.a})
  public static final String TABLE_NAME = "search_results";
  public static final String TAG = "MBServiceCompat";
  public b c;
  public final b<IBinder, b> m = new ArrayMap();
  public c mHandler;
  public MediaSessionCompat.Token mSession;
  public final m this$0 = new m();
  
  public MediaBrowserServiceCompat() {}
  
  public abstract a a(String paramString, int paramInt, Bundle paramBundle);
  
  public void a(String paramString, Bundle paramBundle, b paramB, ResultReceiver paramResultReceiver)
  {
    paramResultReceiver = new MediaBrowserServiceCompat.4(this, paramString, paramResultReceiver);
    c = paramB;
    c(paramString, paramBundle, paramResultReceiver);
    c = null;
    if (paramResultReceiver.equals()) {
      return;
    }
    paramB = new StringBuilder();
    paramB.append("onCustomAction must call detach() or sendResult() or sendError() before returning for action=");
    paramB.append(paramString);
    paramB.append(" extras=");
    paramB.append(paramBundle);
    throw new IllegalStateException(paramB.toString());
  }
  
  public void a(String paramString, b paramB, Bundle paramBundle1, Bundle paramBundle2)
  {
    paramBundle2 = new MediaBrowserServiceCompat.3(this, paramString, paramB, paramString, paramBundle1, paramBundle2);
    c = paramB;
    if (paramBundle1 == null) {
      a(paramString, paramBundle2);
    } else {
      c(paramString, paramBundle2, paramBundle1);
    }
    c = null;
    if (paramBundle2.equals()) {
      return;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("onLoadChildren must call detach() or sendResult() before returning for package="), d, " id=", paramString));
  }
  
  public void a(String paramString, b paramB, IBinder paramIBinder, Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a7 = a6\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  public void a(String paramString, b paramB, ResultReceiver paramResultReceiver)
  {
    paramResultReceiver = new MediaBrowserServiceCompat.ConnectionRecord(this, paramString, paramResultReceiver);
    c = paramB;
    b(paramString, paramResultReceiver);
    c = null;
    if (paramResultReceiver.equals()) {
      return;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("onLoadItem must call detach() or sendResult() before returning for id=", paramString));
  }
  
  public abstract void a(String paramString, i paramI);
  
  public boolean a(String paramString, b paramB, IBinder paramIBinder)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramIBinder == null) {}
    try
    {
      paramIBinder = c.remove(paramString);
      if (paramIBinder != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      c = paramB;
      onLoadChildren(paramString);
      c = null;
      return bool1;
    }
    catch (Throwable paramIBinder)
    {
      List localList;
      Iterator localIterator;
      int i;
      c = paramB;
      onLoadChildren(paramString);
      c = null;
      throw paramIBinder;
    }
    localList = (List)c.get(paramString);
    bool2 = bool3;
    if (localList != null)
    {
      localIterator = localList.iterator();
      for (;;)
      {
        bool2 = localIterator.hasNext();
        if (!bool2) {
          break;
        }
        Object localObject = nextc;
        if (paramIBinder == localObject)
        {
          localIterator.remove();
          bool1 = true;
        }
      }
      i = localList.size();
      bool2 = bool1;
      if (i == 0)
      {
        c.remove(paramString);
        bool2 = bool1;
      }
    }
    c = paramB;
    onLoadChildren(paramString);
    c = null;
    return bool2;
  }
  
  public List applyOptions(List paramList, Bundle paramBundle)
  {
    if (paramList == null) {
      return null;
    }
    int i = paramBundle.getInt("android.media.browse.extra.PAGE", -1);
    int n = paramBundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    if ((i == -1) && (n == -1)) {
      return paramList;
    }
    int k = n * i;
    int j = k + n;
    if ((i >= 0) && (n >= 1) && (k < paramList.size()))
    {
      i = j;
      if (j > paramList.size()) {
        i = paramList.size();
      }
      return paramList.subList(k, i);
    }
    return Collections.emptyList();
  }
  
  public void b(String paramString, Bundle paramBundle, i paramI)
  {
    paramI.a(4);
    paramI.a(null);
  }
  
  public void b(String paramString, i paramI)
  {
    paramI.a(2);
    paramI.a(null);
  }
  
  public void c(String paramString, Bundle paramBundle, b paramB, ResultReceiver paramResultReceiver)
  {
    paramResultReceiver = new x(this, paramString, paramResultReceiver);
    c = paramB;
    b(paramString, paramBundle, paramResultReceiver);
    c = null;
    if (paramResultReceiver.equals()) {
      return;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("onSearch must call detach() or sendResult() before returning for query=", paramString));
  }
  
  public void c(String paramString, Bundle paramBundle, i paramI)
  {
    paramI.b(null);
  }
  
  public void c(String paramString, i paramI, Bundle paramBundle)
  {
    paramI.a(1);
    a(paramString, paramI);
  }
  
  public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public MediaSessionCompat.Token getSessionToken()
  {
    return mSession;
  }
  
  public boolean isValidPackage(String paramString, int paramInt)
  {
    if (paramString == null) {
      return false;
    }
    String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (arrayOfString[paramInt].equals(paramString)) {
        return true;
      }
      paramInt += 1;
    }
    return false;
  }
  
  public final ea.b notifyChildrenChanged()
  {
    return mHandler.b();
  }
  
  public void notifyChildrenChanged(String paramString)
  {
    if (paramString != null)
    {
      mHandler.b(paramString, null);
      return;
    }
    throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
  }
  
  public void notifyChildrenChanged(String paramString, Bundle paramBundle)
  {
    if (paramString != null)
    {
      if (paramBundle != null)
      {
        mHandler.b(paramString, paramBundle);
        return;
      }
      throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    }
    throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
  }
  
  public void notifyChildrenChanged(ea.b paramB, String paramString, Bundle paramBundle)
  {
    if (paramB != null)
    {
      if (paramString != null)
      {
        if (paramBundle != null)
        {
          mHandler.b(paramB, paramString, paramBundle);
          return;
        }
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
      }
      throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }
    throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
  }
  
  public final Bundle onBind()
  {
    return mHandler.d();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return mHandler.onBind(paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      mHandler = new g();
    } else if (i >= 26) {
      mHandler = new f();
    } else if (i >= 23) {
      mHandler = new e();
    } else if (i >= 21) {
      mHandler = new d();
    } else {
      mHandler = new h();
    }
    mHandler.onCreate();
  }
  
  public void onLoadChildren(String paramString) {}
  
  public void performLoadChildren(String paramString, Bundle paramBundle) {}
  
  public void setContext(Context paramContext)
  {
    attachBaseContext(paramContext);
  }
  
  public void setSessionToken(MediaSessionCompat.Token paramToken)
  {
    if (paramToken != null)
    {
      if (mSession == null)
      {
        mSession = paramToken;
        mHandler.post(paramToken);
        return;
      }
      throw new IllegalStateException("The session token has already been set.");
    }
    throw new IllegalArgumentException("Session token may not be null.");
  }
  
  public static final class a
  {
    public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
    public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
    public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
    @Deprecated
    public static final String PAGE_KEY = "android.service.media.extra.SUGGESTION_KEYWORDS";
    public final Bundle a;
    public final String d;
    
    public a(String paramString, Bundle paramBundle)
    {
      if (paramString != null)
      {
        d = paramString;
        a = paramBundle;
        return;
      }
      throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
    }
    
    public String b()
    {
      return d;
    }
    
    public Bundle c()
    {
      return a;
    }
  }
  
  private class b
    implements IBinder.DeathRecipient
  {
    public MediaBrowserServiceCompat.a b;
    public final HashMap<String, List<p<IBinder, Bundle>>> c = new HashMap();
    public final MediaBrowserServiceCompat.k callbacks;
    public final String d;
    public final int g;
    public final ea.b i;
    public final int j;
    public final Bundle s;
    
    public b(String paramString, int paramInt1, int paramInt2, Bundle paramBundle, MediaBrowserServiceCompat.k paramK)
    {
      d = paramString;
      g = paramInt1;
      j = paramInt2;
      i = new ea.b(paramString, paramInt1, paramInt2);
      s = paramBundle;
      callbacks = paramK;
    }
    
    public void binderDied()
    {
      this$0.post(new RegisteredMediaRouteProvider.Connection.2(this));
    }
  }
  
  public static abstract interface c
  {
    public abstract ea.b b();
    
    public abstract void b(String paramString, Bundle paramBundle);
    
    public abstract void b(ea.b paramB, String paramString, Bundle paramBundle);
    
    public abstract Bundle d();
    
    public abstract IBinder onBind(Intent paramIntent);
    
    public abstract void onCreate();
    
    public abstract void post(MediaSessionCompat.Token paramToken);
  }
  
  @K(21)
  public class d
    implements MediaBrowserServiceCompat.c, TransactionListener
  {
    public final List<Bundle> a = new ArrayList();
    public Object b;
    public Messenger c;
    
    public d() {}
    
    public void a(MediaBrowserServiceCompat.b paramB, String paramString, Bundle paramBundle)
    {
      Object localObject = (List)c.get(paramString);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          support.android.v4.util.Type localType = (support.android.v4.util.Type)((Iterator)localObject).next();
          if (Frame.get(paramBundle, (Bundle)b)) {
            a(paramString, paramB, (Bundle)b, paramBundle);
          }
        }
      }
    }
    
    public void a(String paramString, Bundle paramBundle)
    {
      this$0.post(new Plot.a(this, paramString, paramBundle));
    }
    
    public void a(ea.b paramB, String paramString, Bundle paramBundle)
    {
      this$0.post(new d(this, paramB, paramString, paramBundle));
    }
    
    public ea.b b()
    {
      MediaBrowserServiceCompat.b localB = c;
      if (localB != null) {
        return i;
      }
      throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public void b(String paramString, Bundle paramBundle)
    {
      f(paramString, paramBundle);
      a(paramString, paramBundle);
    }
    
    public void b(ea.b paramB, String paramString, Bundle paramBundle)
    {
      a(paramB, paramString, paramBundle);
    }
    
    public Bundle d()
    {
      if (c == null) {
        return null;
      }
      Object localObject = c;
      if (localObject != null)
      {
        localObject = s;
        if (localObject == null) {
          return null;
        }
        return new Bundle((Bundle)localObject);
      }
      throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public void d(String paramString, MediaBrowserCompat.MediaBrowserImplBase paramMediaBrowserImplBase)
    {
      paramMediaBrowserImplBase = new MediaBrowserServiceCompat.ServiceCallbacksApi21(this, paramString, paramMediaBrowserImplBase);
      a(paramString, paramMediaBrowserImplBase);
    }
    
    public void f(String paramString, Bundle paramBundle)
    {
      ((MediaBrowserService)b).notifyChildrenChanged(paramString);
    }
    
    public IBinder onBind(Intent paramIntent)
    {
      return ImageManager.onBind(b, paramIntent);
    }
    
    public void onCreate()
    {
      b = new Unit(MediaBrowserServiceCompat.this, this);
      ((MediaBrowserService)b).onCreate();
    }
    
    public void post(MediaSessionCompat.Token paramToken)
    {
      this$0.postOrRun(new SMTPAppenderBase.SenderRunnable(this, paramToken));
    }
    
    public Result run(String paramString, int paramInt, Bundle paramBundle)
    {
      Object localObject1;
      if ((paramBundle != null) && (paramBundle.getInt("extra_client_version", 0) != 0))
      {
        paramBundle.remove("extra_client_version");
        c = new Messenger(this$0);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("extra_service_version", 2);
        localObject1 = c.getBinder();
        int i = Build.VERSION.SDK_INT;
        ((Bundle)localObject2).putBinder("extra_messenger", (IBinder)localObject1);
        localObject1 = mSession;
        if (localObject1 != null)
        {
          localObject1 = ((MediaSessionCompat.Token)localObject1).e();
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = ((IInterface)localObject1).asBinder();
          }
          i = Build.VERSION.SDK_INT;
          ((Bundle)localObject2).putBinder("extra_session_binder", (IBinder)localObject1);
          localObject1 = localObject2;
        }
        else
        {
          a.add(localObject2);
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = null;
      }
      Object localObject2 = MediaBrowserServiceCompat.this;
      c = new MediaBrowserServiceCompat.b((MediaBrowserServiceCompat)localObject2, paramString, -1, paramInt, paramBundle, null);
      paramBundle = a(paramString, paramInt, paramBundle);
      c = null;
      if (paramBundle == null) {
        return null;
      }
      if (localObject1 == null)
      {
        paramString = paramBundle.c();
      }
      else
      {
        paramString = (String)localObject1;
        if (paramBundle.c() != null)
        {
          ((Bundle)localObject1).putAll(paramBundle.c());
          paramString = (String)localObject1;
        }
      }
      return new Result(paramBundle.b(), paramString);
    }
  }
  
  @K(23)
  public class e
    extends MediaBrowserServiceCompat.d
    implements AnnotationVisitor
  {
    public e()
    {
      super();
    }
    
    public void onCreate()
    {
      b = new FieldVisitor(MediaBrowserServiceCompat.this, this);
      ((MediaBrowserService)b).onCreate();
    }
    
    public void visitArray(String paramString, MediaBrowserCompat.MediaBrowserImplBase paramMediaBrowserImplBase)
    {
      paramMediaBrowserImplBase = new MediaBrowserServiceCompat.Result(this, paramString, paramMediaBrowserImplBase);
      b(paramString, paramMediaBrowserImplBase);
    }
  }
  
  @K(26)
  public class f
    extends MediaBrowserServiceCompat.e
    implements MethodVisitor
  {
    public f()
    {
      super();
    }
    
    public Bundle d()
    {
      Object localObject = c;
      if (localObject != null)
      {
        localObject = s;
        if (localObject == null) {
          return null;
        }
        return new Bundle((Bundle)localObject);
      }
      return support.android.v4.asm.Type.d(b);
    }
    
    public void d(String paramString, SimpleArrayMap paramSimpleArrayMap, Bundle paramBundle)
    {
      paramSimpleArrayMap = new Main(this, paramString, paramSimpleArrayMap);
      c(paramString, paramSimpleArrayMap, paramBundle);
    }
    
    public void f(String paramString, Bundle paramBundle)
    {
      if (paramBundle != null)
      {
        support.android.v4.asm.Type.a(b, paramString, paramBundle);
        return;
      }
      ((MediaBrowserService)b).notifyChildrenChanged(paramString);
    }
    
    public void onCreate()
    {
      b = support.android.v4.asm.Type.a(MediaBrowserServiceCompat.this, this);
      ((MediaBrowserService)b).onCreate();
    }
  }
  
  @K(28)
  public class g
    extends MediaBrowserServiceCompat.f
  {
    public g()
    {
      super();
    }
    
    public ea.b b()
    {
      MediaBrowserServiceCompat.b localB = c;
      if (localB != null) {
        return i;
      }
      return new ea.b(((MediaBrowserService)b).getCurrentBrowserInfo());
    }
  }
  
  public class h
    implements MediaBrowserServiceCompat.c
  {
    public Messenger messenger;
    
    public h() {}
    
    public void a(MediaBrowserServiceCompat.b paramB, String paramString, Bundle paramBundle)
    {
      Object localObject = (List)c.get(paramString);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          support.android.v4.util.Type localType = (support.android.v4.util.Type)((Iterator)localObject).next();
          if (Frame.get(paramBundle, (Bundle)b)) {
            a(paramString, paramB, (Bundle)b, paramBundle);
          }
        }
      }
    }
    
    public ea.b b()
    {
      MediaBrowserServiceCompat.b localB = c;
      if (localB != null) {
        return i;
      }
      throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public void b(String paramString, Bundle paramBundle)
    {
      this$0.post(new ByteVector(this, paramString, paramBundle));
    }
    
    public void b(ea.b paramB, String paramString, Bundle paramBundle)
    {
      this$0.post(new i(this, paramB, paramString, paramBundle));
    }
    
    public Bundle d()
    {
      Object localObject = c;
      if (localObject != null)
      {
        localObject = s;
        if (localObject == null) {
          return null;
        }
        return new Bundle((Bundle)localObject);
      }
      throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public IBinder onBind(Intent paramIntent)
    {
      if ("android.media.browse.MediaBrowserService".equals(paramIntent.getAction())) {
        return messenger.getBinder();
      }
      return null;
    }
    
    public void onCreate()
    {
      messenger = new Messenger(this$0);
    }
    
    public void post(MediaSessionCompat.Token paramToken)
    {
      this$0.post(new MediaBrowserServiceCompat.1(this, paramToken));
    }
  }
  
  public static class i<T>
  {
    public boolean d;
    public final Object k;
    public boolean l;
    public boolean o;
    public boolean reverse;
    public int t;
    
    public i(Object paramObject)
    {
      k = paramObject;
    }
    
    private void get(Bundle paramBundle)
    {
      if (paramBundle == null) {
        return;
      }
      if (paramBundle.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS"))
      {
        float f = paramBundle.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
        if ((f >= -1.0E-5F) && (f <= 1.00001F)) {
          return;
        }
        throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
      }
    }
    
    public void a(int paramInt)
    {
      t = paramInt;
    }
    
    public void a(Bundle paramBundle)
    {
      paramBundle = f.sufficientlysecure.rootcommands.util.StringBuilder.append("It is not supported to send an error for ");
      paramBundle.append(k);
      throw new UnsupportedOperationException(paramBundle.toString());
    }
    
    public void a(Object paramObject)
    {
      if ((!d) && (!l))
      {
        d = true;
        onResultSent(paramObject);
        return;
      }
      paramObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("sendResult() called when either sendResult() or sendError() had already been called for: ");
      paramObject.append(k);
      throw new IllegalStateException(paramObject.toString());
    }
    
    public void b(Bundle paramBundle)
    {
      if ((!d) && (!l))
      {
        l = true;
        a(paramBundle);
        return;
      }
      paramBundle = f.sufficientlysecure.rootcommands.util.StringBuilder.append("sendError() called when either sendResult() or sendError() had already been called for: ");
      paramBundle.append(k);
      throw new IllegalStateException(paramBundle.toString());
    }
    
    public void c(Bundle paramBundle)
    {
      paramBundle = f.sufficientlysecure.rootcommands.util.StringBuilder.append("It is not supported to send an interim update for ");
      paramBundle.append(k);
      throw new UnsupportedOperationException(paramBundle.toString());
    }
    
    public void d(Bundle paramBundle)
    {
      if ((!d) && (!l))
      {
        get(paramBundle);
        o = true;
        c(paramBundle);
        return;
      }
      paramBundle = f.sufficientlysecure.rootcommands.util.StringBuilder.append("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: ");
      paramBundle.append(k);
      throw new IllegalStateException(paramBundle.toString());
    }
    
    public void detach()
    {
      if (!reverse)
      {
        if (!d)
        {
          if (!l)
          {
            reverse = true;
            return;
          }
          localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("detach() called when sendError() had already been called for: ");
          localStringBuilder.append(k);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("detach() called when sendResult() had already been called for: ");
        localStringBuilder.append(k);
        throw new IllegalStateException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("detach() called when detach() had already been called for: ");
      localStringBuilder.append(k);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    public boolean equals()
    {
      return (reverse) || (d) || (l);
    }
    
    public int get()
    {
      return t;
    }
    
    public void onResultSent(Object paramObject) {}
  }
  
  private class j
  {
    public j() {}
    
    public void addSubscription(String paramString, IBinder paramIBinder, MediaBrowserServiceCompat.k paramK)
    {
      this$0.postOrRun(new MediaBrowserServiceCompat.ServiceBinder.3(this, paramK, paramString, paramIBinder));
    }
    
    public void connect(MediaBrowserServiceCompat.k paramK, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
    {
      this$0.postOrRun(new MainActivity.3(this, paramK, paramString, paramInt1, paramInt2, paramBundle));
    }
    
    public void connect(String paramString, int paramInt1, int paramInt2, Bundle paramBundle, MediaBrowserServiceCompat.k paramK)
    {
      if (isValidPackage(paramString, paramInt2))
      {
        this$0.postOrRun(new e(this, paramK, paramString, paramInt1, paramInt2, paramBundle));
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("Package/uid mismatch: uid=");
      paramBundle.append(paramInt2);
      paramBundle.append(" package=");
      paramBundle.append(paramString);
      throw new IllegalArgumentException(paramBundle.toString());
    }
    
    public void getMediaItem(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver, MediaBrowserServiceCompat.k paramK)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramResultReceiver == null) {
          return;
        }
        this$0.postOrRun(new MediaBrowserServiceCompat.ServiceBinder.1(this, paramK, paramString, paramBundle, paramResultReceiver));
      }
    }
    
    public void getMediaItem(String paramString, ResultReceiver paramResultReceiver, MediaBrowserServiceCompat.k paramK)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramResultReceiver == null) {
          return;
        }
        this$0.postOrRun(new FieldWriter(this, paramK, paramString, paramResultReceiver));
      }
    }
    
    public void registerCallbacks(MediaBrowserServiceCompat.k paramK)
    {
      this$0.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.6(this, paramK));
    }
    
    public void removeSubscription(String paramString, IBinder paramIBinder, Bundle paramBundle, MediaBrowserServiceCompat.k paramK)
    {
      this$0.postOrRun(new MediaBrowserServiceCompat.ServiceBinder.4(this, paramK, paramString, paramIBinder, paramBundle));
    }
    
    public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver, MediaBrowserServiceCompat.k paramK)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramResultReceiver == null) {
          return;
        }
        this$0.postOrRun(new MediaBrowserCompat.MediaBrowserImplBase.7(this, paramK, paramString, paramBundle, paramResultReceiver));
      }
    }
    
    public void unregisterCallbacks(MediaBrowserServiceCompat.k paramK)
    {
      this$0.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.7(this, paramK));
    }
  }
  
  private static abstract interface k
  {
    public abstract IBinder asBinder();
    
    public abstract void deleteContact()
      throws RemoteException;
    
    public abstract void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
      throws RemoteException;
    
    public abstract void onLoadChildren(String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2)
      throws RemoteException;
  }
  
  private static class l
    implements MediaBrowserServiceCompat.k
  {
    public final Messenger mCallbacks;
    
    public l(Messenger paramMessenger)
    {
      mCallbacks = paramMessenger;
    }
    
    private void sendRequest(int paramInt, Bundle paramBundle)
      throws RemoteException
    {
      Message localMessage = Message.obtain();
      what = paramInt;
      arg1 = 2;
      localMessage.setData(paramBundle);
      mCallbacks.send(localMessage);
    }
    
    public IBinder asBinder()
    {
      return mCallbacks.getBinder();
    }
    
    public void deleteContact()
      throws RemoteException
    {
      sendRequest(2, null);
    }
    
    public void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
      throws RemoteException
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putInt("extra_service_version", 2);
      paramBundle = new Bundle();
      paramBundle.putString("data_media_item_id", paramString);
      paramBundle.putParcelable("data_media_session_token", paramToken);
      paramBundle.putBundle("data_root_hints", localBundle);
      sendRequest(1, paramBundle);
    }
    
    public void onLoadChildren(String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putBundle("data_options", paramBundle1);
      localBundle.putBundle("data_notify_children_changed_options", paramBundle2);
      if (paramList != null)
      {
        if ((paramList instanceof ArrayList)) {
          paramString = (ArrayList)paramList;
        } else {
          paramString = new ArrayList(paramList);
        }
        localBundle.putParcelableArrayList("data_media_item_list", paramString);
      }
      sendRequest(3, localBundle);
    }
  }
  
  private final class m
    extends Handler
  {
    public final MediaBrowserServiceCompat.j mServiceImpl = new MediaBrowserServiceCompat.j(MediaBrowserServiceCompat.this);
    
    public m() {}
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject = paramMessage.getData();
      switch (what)
      {
      default: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unhandled message: ");
        ((StringBuilder)localObject).append(paramMessage);
        ((StringBuilder)localObject).append("\n  Service version: ");
        ((StringBuilder)localObject).append(2);
        ((StringBuilder)localObject).append("\n  Client version: ");
        ((StringBuilder)localObject).append(arg1);
        ((StringBuilder)localObject).toString();
        return;
      case 9: 
        localBundle = ((Bundle)localObject).getBundle("data_custom_action_extras");
        MediaSessionCompat.append(localBundle);
        mServiceImpl.getMediaItem(((Bundle)localObject).getString("data_custom_action"), localBundle, (ResultReceiver)((Bundle)localObject).getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.l(replyTo));
        return;
      case 8: 
        localBundle = ((Bundle)localObject).getBundle("data_search_extras");
        MediaSessionCompat.append(localBundle);
        mServiceImpl.sendCommand(((Bundle)localObject).getString("data_search_query"), localBundle, (ResultReceiver)((Bundle)localObject).getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.l(replyTo));
        return;
      case 7: 
        mServiceImpl.registerCallbacks(new MediaBrowserServiceCompat.l(replyTo));
        return;
      case 6: 
        localBundle = ((Bundle)localObject).getBundle("data_root_hints");
        MediaSessionCompat.append(localBundle);
        mServiceImpl.connect(new MediaBrowserServiceCompat.l(replyTo), ((Bundle)localObject).getString("data_package_name"), ((Bundle)localObject).getInt("data_calling_pid"), ((Bundle)localObject).getInt("data_calling_uid"), localBundle);
        return;
      case 5: 
        mServiceImpl.getMediaItem(((Bundle)localObject).getString("data_media_item_id"), (ResultReceiver)((Bundle)localObject).getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.l(replyTo));
        return;
      case 4: 
        mServiceImpl.addSubscription(((Bundle)localObject).getString("data_media_item_id"), BundleCompat.getBinder((Bundle)localObject, "data_callback_token"), new MediaBrowserServiceCompat.l(replyTo));
        return;
      case 3: 
        localBundle = ((Bundle)localObject).getBundle("data_options");
        MediaSessionCompat.append(localBundle);
        mServiceImpl.removeSubscription(((Bundle)localObject).getString("data_media_item_id"), BundleCompat.getBinder((Bundle)localObject, "data_callback_token"), localBundle, new MediaBrowserServiceCompat.l(replyTo));
        return;
      case 2: 
        mServiceImpl.unregisterCallbacks(new MediaBrowserServiceCompat.l(replyTo));
        return;
      }
      Bundle localBundle = ((Bundle)localObject).getBundle("data_root_hints");
      MediaSessionCompat.append(localBundle);
      mServiceImpl.connect(((Bundle)localObject).getString("data_package_name"), ((Bundle)localObject).getInt("data_calling_pid"), ((Bundle)localObject).getInt("data_calling_uid"), localBundle, new MediaBrowserServiceCompat.l(replyTo));
    }
    
    public void postOrRun(Runnable paramRunnable)
    {
      if (Thread.currentThread() == getLooper().getThread())
      {
        paramRunnable.run();
        return;
      }
      post(paramRunnable);
    }
    
    public boolean sendMessageAtTime(Message paramMessage, long paramLong)
    {
      Bundle localBundle = paramMessage.getData();
      localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      localBundle.putInt("data_calling_uid", Binder.getCallingUid());
      localBundle.putInt("data_calling_pid", Binder.getCallingPid());
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
  }
}
