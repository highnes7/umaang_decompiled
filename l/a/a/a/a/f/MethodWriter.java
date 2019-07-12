package l.a.a.a.a.f;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;
import l.a.a.a.Item;
import l.a.a.a.Log;
import l.a.a.a.f;

public class MethodWriter
  implements a
{
  public final String b;
  public final Context c;
  public final String f;
  
  public MethodWriter(Item paramItem)
  {
    if (paramItem.getContext() != null)
    {
      c = paramItem.getContext();
      b = paramItem.getString();
      paramItem = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Android/");
      paramItem.append(c.getPackageName());
      f = paramItem.toString();
      return;
    }
    throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
  }
  
  public File a()
  {
    return a(c.getFilesDir());
  }
  
  public File a(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists())
      {
        if (paramFile.mkdirs()) {
          return paramFile;
        }
        f.get().remove("Fabric", "Couldn't create file");
      }
      else
      {
        return paramFile;
      }
    }
    else {
      f.get().d("Fabric", "Null File");
    }
    return null;
  }
  
  public File b()
  {
    boolean bool = save();
    File localFile = null;
    if (bool)
    {
      int i = Build.VERSION.SDK_INT;
      localFile = c.getExternalFilesDir(null);
    }
    return a(localFile);
  }
  
  public File c()
  {
    File localFile;
    if (save())
    {
      int i = Build.VERSION.SDK_INT;
      localFile = c.getExternalCacheDir();
    }
    else
    {
      localFile = null;
    }
    return a(localFile);
  }
  
  public File d()
  {
    return a(c.getCacheDir());
  }
  
  public boolean save()
  {
    if (!"mounted".equals(Environment.getExternalStorageState()))
    {
      f.get().remove("Fabric", "External Storage is not mounted and/or writable\nHave you declared android.permission.WRITE_EXTERNAL_STORAGE in the manifest?");
      return false;
    }
    return true;
  }
}
