package com.google.android.android.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteClosable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.TextUtils;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.common.annotation.KeepName;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepName
public final class DataHolder
  extends zzbck
  implements Closeable
{
  public static final Parcelable.Creator<com.google.android.gms.common.data.DataHolder> CREATOR = new VerticalProgressBar.SavedState.1();
  public static final zza zzfqs = new f(new String[0], null);
  public boolean mClosed = false;
  public int zzdxs;
  public final int zzfac;
  public final String[] zzfql;
  public Bundle zzfqm;
  public final CursorWindow[] zzfqn;
  public final Bundle zzfqo;
  public int[] zzfqp;
  public int zzfqq;
  public boolean zzfqr = true;
  
  public DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle)
  {
    zzdxs = paramInt1;
    zzfql = paramArrayOfString;
    zzfqn = paramArrayOfCursorWindow;
    zzfac = paramInt2;
    zzfqo = paramBundle;
  }
  
  public DataHolder(zza paramZza, int paramInt, Bundle paramBundle)
  {
    this(zzfql, doInBackground(paramZza, -1), paramInt, null);
  }
  
  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle)
  {
    zzdxs = 1;
    zzbp.append(paramArrayOfString);
    zzfql = ((String[])paramArrayOfString);
    zzbp.append(paramArrayOfCursorWindow);
    zzfqn = ((CursorWindow[])paramArrayOfCursorWindow);
    zzfac = paramInt;
    zzfqo = paramBundle;
    zzaiv();
  }
  
  public static CursorWindow[] doInBackground(zza paramZza, int paramInt)
  {
    paramInt = zzfql.length;
    int k = 0;
    if (paramInt == 0) {
      return new CursorWindow[0];
    }
    ArrayList localArrayList2 = zzfqt;
    int m = localArrayList2.size();
    Object localObject1 = new CursorWindow(false);
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(localObject1);
    ((CursorWindow)localObject1).setNumColumns(zzfql.length);
    paramInt = 0;
    int i = 0;
    while (paramInt < m) {
      try
      {
        boolean bool = ((CursorWindow)localObject1).allocRow();
        Object localObject2;
        if (!bool)
        {
          localObject1 = new StringBuilder(72);
          ((StringBuilder)localObject1).append("Allocating additional cursor window for large data set (row ");
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append(")");
          ((StringBuilder)localObject1).toString();
          localObject2 = new CursorWindow(false);
          ((CursorWindow)localObject2).setStartPosition(paramInt);
          ((CursorWindow)localObject2).setNumColumns(zzfql.length);
          localArrayList1.add(localObject2);
          bool = ((CursorWindow)localObject2).allocRow();
          localObject1 = localObject2;
          if (!bool)
          {
            localArrayList1.remove(localObject2);
            paramZza = (CursorWindow[])localArrayList1.toArray(new CursorWindow[localArrayList1.size()]);
            return paramZza;
          }
        }
        Map localMap = (Map)localArrayList2.get(paramInt);
        int j = 0;
        bool = true;
        Object localObject3;
        for (;;)
        {
          localObject2 = zzfql;
          int n = localObject2.length;
          if ((j >= n) || (!bool)) {
            break label600;
          }
          localObject2 = localObject2[j];
          localObject3 = localMap.get(localObject2);
          if (localObject3 == null)
          {
            bool = ((CursorWindow)localObject1).putNull(paramInt, j);
          }
          else if ((localObject3 instanceof String))
          {
            bool = ((CursorWindow)localObject1).putString((String)localObject3, paramInt, j);
          }
          else
          {
            long l;
            if ((localObject3 instanceof Long)) {
              l = ((Long)localObject3).longValue();
            }
            for (;;)
            {
              bool = ((CursorWindow)localObject1).putLong(l, paramInt, j);
              break label510;
              if ((localObject3 instanceof Integer))
              {
                n = ((Integer)localObject3).intValue();
                l = n;
                bool = ((CursorWindow)localObject1).putLong(l, paramInt, j);
                break label510;
              }
              if (!(localObject3 instanceof Boolean)) {
                break;
              }
              bool = ((Boolean)localObject3).booleanValue();
              if (bool) {
                l = 1L;
              } else {
                l = 0L;
              }
            }
            if ((localObject3 instanceof byte[]))
            {
              bool = ((CursorWindow)localObject1).putBlob((byte[])localObject3, paramInt, j);
            }
            else if ((localObject3 instanceof Double))
            {
              bool = ((CursorWindow)localObject1).putDouble(((Double)localObject3).doubleValue(), paramInt, j);
            }
            else
            {
              if (!(localObject3 instanceof Float)) {
                break;
              }
              float f = ((Float)localObject3).floatValue();
              double d = f;
              bool = ((CursorWindow)localObject1).putDouble(d, paramInt, j);
            }
          }
          label510:
          j += 1;
        }
        paramZza = String.valueOf(localObject3);
        paramInt = String.valueOf(localObject2).length();
        i = paramZza.length();
        localObject1 = new StringBuilder(paramInt + 32 + i);
        ((StringBuilder)localObject1).append("Unsupported object for column ");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(": ");
        ((StringBuilder)localObject1).append(paramZza);
        throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
        label600:
        if (!bool)
        {
          if (i == 0)
          {
            localObject2 = new StringBuilder(74);
            ((StringBuilder)localObject2).append("Couldn't populate window data for row ");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(" - allocating new window.");
            ((StringBuilder)localObject2).toString();
            ((CursorWindow)localObject1).freeLastRow();
            localObject1 = new CursorWindow(false);
            ((CursorWindow)localObject1).setStartPosition(paramInt);
            ((CursorWindow)localObject1).setNumColumns(zzfql.length);
            localArrayList1.add(localObject1);
            paramInt -= 1;
            i = 1;
          }
          else
          {
            throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
          }
        }
        else {
          i = 0;
        }
        paramInt += 1;
      }
      catch (RuntimeException paramZza)
      {
        i = localArrayList1.size();
        paramInt = k;
        while (paramInt < i)
        {
          ((CursorWindow)localArrayList1.get(paramInt)).close();
          paramInt += 1;
        }
        throw paramZza;
      }
    }
    return (CursorWindow[])localArrayList1.toArray(new CursorWindow[localArrayList1.size()]);
  }
  
  private final void get(String paramString, int paramInt)
  {
    Bundle localBundle = zzfqm;
    if ((localBundle != null) && (localBundle.containsKey(paramString)))
    {
      if (!isClosed())
      {
        if ((paramInt >= 0) && (paramInt < zzfqq)) {
          return;
        }
        throw new CursorIndexOutOfBoundsException(paramInt, zzfqq);
      }
      throw new IllegalArgumentException("Buffer is closed.");
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "No such column: ".concat(paramString);
    } else {
      paramString = new String("No such column: ");
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static zza serialize(String[] paramArrayOfString)
  {
    return new zza(null);
  }
  
  public static DataHolder zzby(int paramInt)
  {
    zza localZza = zzfqs;
    return new DataHolder(zzfql, doInBackground(localZza, -1), paramInt, null);
  }
  
  public final void close()
  {
    try
    {
      if (!mClosed)
      {
        mClosed = true;
        int i = 0;
        while (i < zzfqn.length)
        {
          zzfqn[i].close();
          i += 1;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void finalize()
    throws Throwable
  {
    try
    {
      boolean bool = zzfqr;
      if (bool)
      {
        int i = zzfqn.length;
        if (i > 0)
        {
          bool = isClosed();
          if (!bool)
          {
            close();
            String str = toString();
            i = String.valueOf(str).length();
            StringBuilder localStringBuilder = new StringBuilder(i + 178);
            localStringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
            localStringBuilder.append(str);
            localStringBuilder.append(")");
            localStringBuilder.toString();
          }
        }
      }
      super.finalize();
      return;
    }
    catch (Throwable localThrowable)
    {
      super.finalize();
      throw localThrowable;
    }
  }
  
  public final byte[] get(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return zzfqn[paramInt2].getBlob(paramInt1, zzfqm.getInt(paramString));
  }
  
  public final int getCount()
  {
    return zzfqq;
  }
  
  public final String getData(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return zzfqn[paramInt2].getString(paramInt1, zzfqm.getInt(paramString));
  }
  
  public final void getData(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    get(paramString, paramInt1);
    zzfqn[paramInt2].copyStringToBuffer(paramInt1, zzfqm.getInt(paramString), paramCharArrayBuffer);
  }
  
  public final float getFloat(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return zzfqn[paramInt2].getFloat(paramInt1, zzfqm.getInt(paramString));
  }
  
  public final int getInt(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return zzfqn[paramInt2].getInt(paramInt1, zzfqm.getInt(paramString));
  }
  
  public final long getLong(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return zzfqn[paramInt2].getLong(paramInt1, zzfqm.getInt(paramString));
  }
  
  public final int getStatusCode()
  {
    return zzfac;
  }
  
  public final boolean isClosed()
  {
    try
    {
      boolean bool = mClosed;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final boolean isNull(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return zzfqn[paramInt2].isNull(paramInt1, zzfqm.getInt(paramString));
  }
  
  public final boolean put(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return Long.valueOf(zzfqn[paramInt2].getLong(paramInt1, zzfqm.getInt(paramString))).longValue() == 1L;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.a(paramParcel, 1, zzfql, false);
    zzbcn.writeHeader(paramParcel, 2, zzfqn, paramInt, false);
    zzbcn.setCustomVar(paramParcel, 3, zzfac);
    zzbcn.writeString(paramParcel, 4, zzfqo, false);
    zzbcn.setCustomVar(paramParcel, 1000, zzdxs);
    zzbcn.zzah(paramParcel, i);
    if ((paramInt & 0x1) != 0) {
      close();
    }
  }
  
  public final Bundle zzafi()
  {
    return zzfqo;
  }
  
  public final void zzaiv()
  {
    zzfqm = new Bundle();
    int k = 0;
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = zzfql;
      if (i >= localObject.length) {
        break;
      }
      zzfqm.putInt(localObject[i], i);
      i += 1;
    }
    zzfqp = new int[zzfqn.length];
    int j = 0;
    i = k;
    for (;;)
    {
      localObject = zzfqn;
      if (i >= localObject.length) {
        break;
      }
      zzfqp[i] = j;
      k = localObject[i].getStartPosition();
      j += zzfqn[i].getNumRows() - (j - k);
      i += 1;
    }
    zzfqq = j;
  }
  
  public final int zzbx(int paramInt)
  {
    int i = 0;
    boolean bool;
    if ((paramInt >= 0) && (paramInt < zzfqq)) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.zzbg(bool);
    int j;
    for (;;)
    {
      int[] arrayOfInt = zzfqp;
      j = i;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (paramInt < arrayOfInt[i])
      {
        j = i - 1;
        break;
      }
      i += 1;
    }
    if (j == zzfqp.length) {
      return j - 1;
    }
    return j;
  }
  
  public final boolean zzfu(String paramString)
  {
    return zzfqm.containsKey(paramString);
  }
  
  public class zza
  {
    public final String[] zzfql;
    public final ArrayList<HashMap<String, Object>> zzfqt;
    public final String zzfqu;
    public final HashMap<Object, Integer> zzfqv;
    public boolean zzfqw;
    public String zzfqx;
    
    public zza(String paramString)
    {
      zzbp.append(this$1);
      zzfql = ((String[])this$1);
      zzfqt = new ArrayList();
      zzfqu = paramString;
      zzfqv = new HashMap();
      zzfqw = false;
      zzfqx = null;
    }
    
    public zza a(HashMap paramHashMap)
    {
      TextUtils.replace(paramHashMap);
      Object localObject = zzfqu;
      if (localObject == null) {}
      Integer localInteger;
      for (;;)
      {
        i = -1;
        break label77;
        localObject = paramHashMap.get(localObject);
        if (localObject != null)
        {
          localInteger = (Integer)zzfqv.get(localObject);
          if (localInteger != null) {
            break;
          }
          zzfqv.put(localObject, Integer.valueOf(zzfqt.size()));
        }
      }
      int i = localInteger.intValue();
      label77:
      if (i == -1)
      {
        zzfqt.add(paramHashMap);
      }
      else
      {
        zzfqt.remove(i);
        zzfqt.add(i, paramHashMap);
      }
      zzfqw = false;
      return this;
    }
    
    public zza add(ContentValues paramContentValues)
    {
      TextUtils.replace(paramContentValues);
      HashMap localHashMap = new HashMap(paramContentValues.size());
      paramContentValues = paramContentValues.valueSet().iterator();
      while (paramContentValues.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContentValues.next();
        localHashMap.put((String)localEntry.getKey(), localEntry.getValue());
      }
      return a(localHashMap);
    }
    
    public final DataHolder zzbz(int paramInt)
    {
      return new DataHolder(this, 0, null);
    }
  }
  
  public final class zzb
    extends RuntimeException
  {
    public zzb()
    {
      super();
    }
  }
}
