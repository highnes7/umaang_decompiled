package com.google.android.android.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.android.common.TransactionInput;
import com.google.android.android.common.internal.zzbp;

public abstract class LockFactory<T>
{
  public final String zzgpf;
  public T zzgpg;
  
  public LockFactory(String paramString)
  {
    zzgpf = paramString;
  }
  
  public abstract Object asInterface(IBinder paramIBinder);
  
  public final Object zzcu(Context paramContext)
    throws InvalidPatternException
  {
    if (zzgpg == null)
    {
      zzbp.append(paramContext);
      paramContext = TransactionInput.getRemoteContext(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.getClassLoader();
        String str = zzgpf;
        try
        {
          paramContext = paramContext.loadClass(str).newInstance();
          paramContext = (IBinder)paramContext;
          paramContext = asInterface(paramContext);
          zzgpg = paramContext;
        }
        catch (IllegalAccessException paramContext)
        {
          throw new InvalidPatternException("Could not access creator.", paramContext);
        }
        catch (InstantiationException paramContext)
        {
          throw new InvalidPatternException("Could not instantiate creator.", paramContext);
        }
        catch (ClassNotFoundException paramContext)
        {
          throw new InvalidPatternException("Could not load creator class.", paramContext);
        }
      }
      else
      {
        throw new InvalidPatternException("Could not get remote context.");
      }
    }
    return zzgpg;
  }
}
