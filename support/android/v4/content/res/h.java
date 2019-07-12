package support.android.v4.content.res;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.IconCompat;
import android.text.TextUtils;
import java.util.Arrays;

public class h
{
  public CharSequence a;
  public String b;
  public Context c;
  public CharSequence d;
  public boolean e;
  public Intent[] f;
  public ComponentName g;
  public IconCompat j;
  public CharSequence o;
  
  public h() {}
  
  public Intent a(Intent paramIntent)
  {
    Object localObject1 = f;
    paramIntent.putExtra("android.intent.extra.shortcut.INTENT", localObject1[(localObject1.length - 1)]).putExtra("android.intent.extra.shortcut.NAME", a.toString());
    if (j != null)
    {
      Object localObject3 = null;
      Object localObject4 = null;
      PackageManager localPackageManager;
      if (e)
      {
        localPackageManager = c.getPackageManager();
        localObject3 = g;
        localObject1 = localObject4;
        if (localObject3 == null) {}
      }
      try
      {
        localObject1 = localPackageManager.getActivityIcon((ComponentName)localObject3);
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = c.getApplicationInfo().loadIcon(localPackageManager);
        }
        j.a(paramIntent, (Drawable)localObject3, c);
        return paramIntent;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          Object localObject2 = localObject4;
        }
      }
    }
    return paramIntent;
  }
  
  public CharSequence a()
  {
    return d;
  }
  
  public String c()
  {
    return b;
  }
  
  public CharSequence d()
  {
    return o;
  }
  
  public ShortcutInfo e()
  {
    ShortcutInfo.Builder localBuilder = new ShortcutInfo.Builder(c, b).setShortLabel(a).setIntents(f);
    Object localObject = j;
    if (localObject != null) {
      localBuilder.setIcon(((IconCompat)localObject).remove());
    }
    if (!TextUtils.isEmpty(o)) {
      localBuilder.setLongLabel(o);
    }
    if (!TextUtils.isEmpty(d)) {
      localBuilder.setDisabledMessage(d);
    }
    localObject = g;
    if (localObject != null) {
      localBuilder.setActivity((ComponentName)localObject);
    }
    return localBuilder.build();
  }
  
  public Intent f()
  {
    Intent[] arrayOfIntent = f;
    return arrayOfIntent[(arrayOfIntent.length - 1)];
  }
  
  public ComponentName getIntent()
  {
    return g;
  }
  
  public Intent[] getView()
  {
    Intent[] arrayOfIntent = f;
    return (Intent[])Arrays.copyOf(arrayOfIntent, arrayOfIntent.length);
  }
  
  public CharSequence n()
  {
    return a;
  }
}
