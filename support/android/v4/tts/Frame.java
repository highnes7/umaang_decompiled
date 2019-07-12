package support.android.v4.tts;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import b.b.a.N;
import b.b.x.l.r.e;
import b.b.x.l.x.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import support.android.v4.internal.Type;
import support.android.v4.internal.a;
import support.android.v4.util.LruCache;
import support.android.v4.util.SimpleArrayMap;

public class Frame
{
  public static final String KIND = "FontsContractCompat";
  @N({b.b.a.N.a.b})
  public static final String NULL = "font_results";
  @N({b.b.a.N.a.b})
  public static final int RESULT_MAX_LENGTH_EXCEEDED = -2;
  public static final int SIZE = 10000;
  @N({b.b.a.N.a.b})
  public static final int UNINITIALIZED = -1;
  public static final Comparator<byte[]> a = new Version.BuildAwareOrder();
  @b.b.a.t("sLock")
  public static final b.b.x.n.t<String, ArrayList<x.a<r.e>>> b;
  public static final f c;
  public static final Object e;
  public static final b.b.x.n.m<String, Typeface> this$0 = new LruCache(16);
  
  static
  {
    c = new f("fonts", 10, 10000);
    e = new Object();
    b = new SimpleArrayMap();
  }
  
  public Frame() {}
  
  public static ProviderInfo a(PackageManager paramPackageManager, h paramH, android.content.res.Resources paramResources)
    throws PackageManager.NameNotFoundException
  {
    String str = paramH.f();
    int i = 0;
    ProviderInfo localProviderInfo = paramPackageManager.resolveContentProvider(str, 0);
    if (localProviderInfo != null)
    {
      if (packageName.equals(paramH.getGroupId()))
      {
        paramPackageManager = get(getPackageInfopackageName, 64).signatures);
        Collections.sort(paramPackageManager, a);
        paramH = a(paramH, paramResources);
        while (i < paramH.size())
        {
          paramResources = new ArrayList((Collection)paramH.get(i));
          Collections.sort(paramResources, a);
          if (get(paramPackageManager, paramResources)) {
            return localProviderInfo;
          }
          i += 1;
        }
        return null;
      }
      paramPackageManager = new StringBuilder();
      paramPackageManager.append("Found content provider ");
      paramPackageManager.append(str);
      paramPackageManager.append(", but package was not ");
      paramPackageManager.append(paramH.getGroupId());
      throw new PackageManager.NameNotFoundException(paramPackageManager.toString());
    }
    paramPackageManager = new PackageManager.NameNotFoundException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("No package found for authority: ", str));
    throw paramPackageManager;
  }
  
  public static Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, Label[] paramArrayOfLabel)
  {
    return Type.a(paramContext, paramCancellationSignal, paramArrayOfLabel, 0);
  }
  
  public static Typeface a(Context paramContext, h paramH, support.android.v4.content.asm.Label paramLabel, Handler paramHandler, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramH.a());
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    Typeface localTypeface = (Typeface)this$0.get(localObject);
    if (localTypeface != null)
    {
      if (paramLabel != null)
      {
        paramLabel.onFontRetrieved(localTypeface);
        return localTypeface;
      }
    }
    else
    {
      if ((paramBoolean) && (paramInt1 == -1))
      {
        paramContext = a(paramContext, paramH, paramInt2);
        if (paramLabel != null)
        {
          paramInt1 = f;
          if (paramInt1 == 0) {
            paramLabel.callbackSuccessAsync(t, paramHandler);
          } else {
            paramLabel.callbackFailAsync(paramInt1, paramHandler);
          }
        }
        return t;
      }
      paramH = new IntegerPolynomial.CombineTask(paramContext, paramH, paramInt2, (String)localObject);
      if (paramBoolean) {
        paramContext = c;
      }
      try
      {
        paramContext = paramContext.get(paramH, paramInt1);
        return t;
      }
      catch (InterruptedException paramContext)
      {
        return null;
      }
      if (paramLabel == null) {
        paramContext = null;
      } else {
        paramContext = new d(paramLabel, paramHandler);
      }
      paramLabel = e;
      try
      {
        if (b.containsKey(localObject))
        {
          if (paramContext != null) {
            ((ArrayList)b.get(localObject)).add(paramContext);
          }
          return null;
        }
        if (paramContext != null)
        {
          paramHandler = new ArrayList();
          paramHandler.add(paramContext);
          b.put(localObject, paramHandler);
        }
        c.a(paramH, new e((String)localObject));
        return null;
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
    return localTypeface;
  }
  
  public static List a(h paramH, android.content.res.Resources paramResources)
  {
    if (paramH.getTitle() != null) {
      return paramH.getTitle();
    }
    return support.android.v4.content.asm.Resources.getValue(paramResources, paramH.b());
  }
  
  public static Map a(Context paramContext, Label[] paramArrayOfLabel, CancellationSignal paramCancellationSignal)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfLabel.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfLabel[i];
      if (((Label)localObject).c() == 0)
      {
        localObject = ((Label)localObject).getName();
        if (!localHashMap.containsKey(localObject)) {
          localHashMap.put(localObject, a.read(paramContext, paramCancellationSignal, (Uri)localObject));
        }
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static ClassReader a(Context paramContext, CancellationSignal paramCancellationSignal, h paramH)
    throws PackageManager.NameNotFoundException
  {
    ProviderInfo localProviderInfo = a(paramContext.getPackageManager(), paramH, paramContext.getResources());
    if (localProviderInfo == null) {
      return new ClassReader(1, null);
    }
    return new ClassReader(0, load(paramContext, paramH, authority, paramCancellationSignal));
  }
  
  public static m a(Context paramContext, h paramH, int paramInt)
  {
    try
    {
      paramH = a(paramContext, null, paramH);
      int j = paramH.a();
      int i = -3;
      if (j == 0)
      {
        paramContext = Type.a(paramContext, null, paramH.b(), paramInt);
        if (paramContext != null) {
          i = 0;
        }
        return new m(paramContext, i);
      }
      if (paramH.a() == 1) {
        i = -2;
      }
      return new m(null, i);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return new m(null, -1);
  }
  
  public static void a(Context paramContext, h paramH, i paramI, Handler paramHandler)
  {
    paramHandler.post(new ClassWriter(paramContext, paramH, new Handler(), paramI));
  }
  
  public static void execute()
  {
    this$0.evictAll();
  }
  
  public static List get(Signature[] paramArrayOfSignature)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfSignature.length)
    {
      localArrayList.add(paramArrayOfSignature[i].toByteArray());
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean get(List paramList1, List paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      if (!Arrays.equals((byte[])paramList1.get(i), (byte[])paramList2.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static Label[] load(Context paramContext, h paramH, String paramString, CancellationSignal paramCancellationSignal)
  {
    ArrayList localArrayList = new ArrayList();
    Uri localUri1 = new Uri.Builder().scheme("content").authority(paramString).build();
    Uri localUri2 = new Uri.Builder().scheme("content").authority(paramString).appendPath("file").build();
    Object localObject = null;
    paramString = localObject;
    try
    {
      int i = Build.VERSION.SDK_INT;
      paramString = localObject;
      paramContext = paramContext.getContentResolver();
      paramString = localObject;
      paramH = paramH.i();
      paramString = localObject;
      paramCancellationSignal = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { paramH }, null, paramCancellationSignal);
      paramContext = paramCancellationSignal;
      paramH = localArrayList;
      if (paramCancellationSignal != null)
      {
        paramString = paramContext;
        i = paramCancellationSignal.getCount();
        paramH = localArrayList;
        if (i > 0)
        {
          paramString = paramContext;
          int m = paramCancellationSignal.getColumnIndex("result_code");
          paramString = paramContext;
          localArrayList = new ArrayList();
          paramString = paramContext;
          int n = paramCancellationSignal.getColumnIndex("_id");
          paramString = paramContext;
          int i1 = paramCancellationSignal.getColumnIndex("file_id");
          paramString = paramContext;
          int i2 = paramCancellationSignal.getColumnIndex("font_ttc_index");
          paramString = paramContext;
          int i3 = paramCancellationSignal.getColumnIndex("font_weight");
          paramString = paramContext;
          int i4 = paramCancellationSignal.getColumnIndex("font_italic");
          for (;;)
          {
            paramString = paramContext;
            boolean bool = paramCancellationSignal.moveToNext();
            paramH = localArrayList;
            if (!bool) {
              break;
            }
            if (m != -1)
            {
              paramString = paramContext;
              i = paramCancellationSignal.getInt(m);
            }
            else
            {
              i = 0;
            }
            int j;
            if (i2 != -1)
            {
              paramString = paramContext;
              j = paramCancellationSignal.getInt(i2);
            }
            else
            {
              j = 0;
            }
            if (i1 == -1)
            {
              paramString = paramContext;
              paramH = ContentUris.withAppendedId(localUri1, paramCancellationSignal.getLong(n));
            }
            else
            {
              paramString = paramContext;
              paramH = ContentUris.withAppendedId(localUri2, paramCancellationSignal.getLong(i1));
            }
            int k;
            if (i3 != -1)
            {
              paramString = paramContext;
              k = paramCancellationSignal.getInt(i3);
            }
            else
            {
              k = 400;
            }
            if (i4 != -1)
            {
              paramString = paramContext;
              int i5 = paramCancellationSignal.getInt(i4);
              if (i5 == 1)
              {
                bool = true;
                break label439;
              }
            }
            bool = false;
            label439:
            paramString = paramContext;
            localArrayList.add(new Label(paramH, j, k, bool, i));
          }
        }
      }
      if (paramCancellationSignal != null) {
        paramCancellationSignal.close();
      }
      return (Label[])paramH.toArray(new Label[0]);
    }
    catch (Throwable paramContext)
    {
      if (paramString != null) {
        paramString.close();
      }
      throw paramContext;
    }
  }
}
