package com.google.android.android.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.EventHandler;
import com.google.android.android.common.util.MD5;
import com.google.android.android.common.util.MultidimensionalCounter;
import com.google.android.android.common.util.Resources;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzbdw
  extends zzbdo
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzbdw> CREATOR = new zzbdx();
  public final String mClassName;
  public final int zzdxs;
  public final zzbdr zzfwy;
  public final Parcel zzfxf;
  public final int zzfxg;
  public int zzfxh;
  public int zzfxi;
  
  public zzbdw(int paramInt, Parcel paramParcel, zzbdr paramZzbdr)
  {
    zzdxs = paramInt;
    zzbp.append(paramParcel);
    zzfxf = ((Parcel)paramParcel);
    zzfxg = 2;
    zzfwy = paramZzbdr;
    paramParcel = zzfwy;
    if (paramParcel == null) {
      paramParcel = null;
    } else {
      paramParcel = paramParcel.zzakv();
    }
    mClassName = paramParcel;
    zzfxh = 2;
  }
  
  private final void doInBackground(StringBuilder paramStringBuilder, Map paramMap, Parcel paramParcel)
  {
    SparseArray localSparseArray = new SparseArray();
    paramMap = paramMap.entrySet().iterator();
    Object localObject;
    while (paramMap.hasNext())
    {
      localObject = (Map.Entry)paramMap.next();
      localSparseArray.put(getValuezzfwv, localObject);
    }
    paramStringBuilder.append('{');
    int j = zzbcl.decode(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = paramParcel.readInt();
      localObject = (Map.Entry)localSparseArray.get(0xFFFF & k);
      if (localObject != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        paramMap = (String)((Map.Entry)localObject).getKey();
        localObject = (zzbdm)((Map.Entry)localObject).getValue();
        paramStringBuilder.append("\"");
        paramStringBuilder.append(paramMap);
        paramStringBuilder.append("\":");
        if (((zzbdm)localObject).zzaks())
        {
          i = zzfws;
          switch (i)
          {
          default: 
            throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(36, "Unknown field out type = ", i));
          case 11: 
            throw new IllegalArgumentException("Method does not accept concrete type.");
          case 10: 
            paramMap = format(zzbcl.add(paramParcel, k));
            break;
          case 8: 
          case 9: 
            paramMap = zzbcl.valueOf(paramParcel, k);
            break;
          case 7: 
            paramMap = zzbcl.readString(paramParcel, k);
            break;
          case 6: 
            paramMap = Boolean.valueOf(zzbcl.invoke(paramParcel, k));
            break;
          case 5: 
            paramMap = zzbcl.read(paramParcel, k);
            break;
          case 4: 
            paramMap = Double.valueOf(zzbcl.readLine(paramParcel, k));
            break;
          case 3: 
            paramMap = Float.valueOf(zzbcl.getNumber(paramParcel, k));
            break;
          case 2: 
            paramMap = Long.valueOf(zzbcl.getValue(paramParcel, k));
            break;
          case 1: 
            paramMap = zzbcl.sign(paramParcel, k);
            break;
          case 0: 
            paramMap = Integer.valueOf(zzbcl.getId(paramParcel, k));
          }
          getSize(paramStringBuilder, (zzbdm)localObject, zzbdl.get((zzbdm)localObject, paramMap));
        }
        else
        {
          execute(paramStringBuilder, (zzbdm)localObject, paramParcel, k);
        }
        i = 1;
      }
    }
    if (paramParcel.dataPosition() == j)
    {
      paramStringBuilder.append('}');
      return;
    }
    paramStringBuilder = new zzbcm(f.sufficientlysecure.rootcommands.util.StringBuilder.add(37, "Overread allowed size end=", j), paramParcel);
    throw paramStringBuilder;
  }
  
  private final void execute(StringBuilder paramStringBuilder, zzbdm paramZzbdm, Parcel paramParcel, int paramInt)
  {
    boolean bool = zzfwt;
    int j = 0;
    int i = 0;
    Object localObject1;
    if (bool)
    {
      paramStringBuilder.append("[");
      int k = zzfws;
      Object localObject2 = null;
      localObject1 = null;
      switch (k)
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 11: 
        paramParcel = zzbcl.zzae(paramParcel, paramInt);
        i = paramParcel.length;
        paramInt = 0;
      }
      while (paramInt < i)
      {
        if (paramInt > 0) {
          paramStringBuilder.append(",");
        }
        paramParcel[paramInt].setDataPosition(0);
        doInBackground(paramStringBuilder, paramZzbdm.zzakt(), paramParcel[paramInt]);
        paramInt += 1;
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        EventHandler.execute(paramStringBuilder, zzbcl.zzaa(paramParcel, paramInt));
        break;
        EventHandler.write(paramStringBuilder, zzbcl.finish(paramParcel, paramInt));
        break;
        EventHandler.toString(paramStringBuilder, zzbcl.readFromParcel(paramParcel, paramInt));
        break;
        paramInt = zzbcl.get(paramParcel, paramInt);
        i = paramParcel.dataPosition();
        if (paramInt == 0)
        {
          paramZzbdm = (zzbdm)localObject1;
        }
        else
        {
          paramZzbdm = paramParcel.createDoubleArray();
          paramParcel.setDataPosition(i + paramInt);
        }
        EventHandler.toString(paramStringBuilder, (double[])paramZzbdm);
        break;
        EventHandler.toString(paramStringBuilder, zzbcl.writeValue(paramParcel, paramInt));
        break;
        EventHandler.toString(paramStringBuilder, zzbcl.getList(paramParcel, paramInt));
        break;
        j = zzbcl.get(paramParcel, paramInt);
        k = paramParcel.dataPosition();
        if (j == 0)
        {
          paramZzbdm = localObject2;
        }
        else
        {
          int m = paramParcel.readInt();
          paramZzbdm = new BigInteger[m];
          paramInt = i;
          while (paramInt < m)
          {
            localObject1 = new BigInteger(paramParcel.createByteArray());
            ((java.io.Serializable[])paramZzbdm)[paramInt] = localObject1;
            paramInt += 1;
          }
          paramParcel.setDataPosition(k + j);
        }
        EventHandler.toString(paramStringBuilder, (Object[])paramZzbdm);
        break;
        paramZzbdm = zzbcl.getParameter(paramParcel, paramInt);
        i = paramZzbdm.length;
        paramInt = j;
        while (paramInt < i)
        {
          if (paramInt != 0) {
            paramStringBuilder.append(",");
          }
          paramStringBuilder.append(Integer.toString(paramZzbdm[paramInt]));
          paramInt += 1;
        }
      }
      paramStringBuilder.append("]");
      return;
    }
    switch (zzfws)
    {
    default: 
      throw new IllegalStateException("Unknown field type out");
    case 11: 
      paramParcel = zzbcl.zzad(paramParcel, paramInt);
      paramParcel.setDataPosition(0);
      doInBackground(paramStringBuilder, paramZzbdm.zzakt(), paramParcel);
      return;
    case 10: 
      paramZzbdm = zzbcl.add(paramParcel, paramInt);
      paramParcel = paramZzbdm.keySet();
      paramParcel.size();
      paramStringBuilder.append("{");
      paramParcel = paramParcel.iterator();
      for (paramInt = 1; paramParcel.hasNext(); paramInt = 0)
      {
        localObject1 = (String)paramParcel.next();
        if (paramInt == 0) {
          paramStringBuilder.append(",");
        }
        f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramStringBuilder, "\"", (String)localObject1, "\"", ":");
        paramStringBuilder.append("\"");
        paramStringBuilder.append(Resources.zzgl(paramZzbdm.getString((String)localObject1)));
        paramStringBuilder.append("\"");
      }
      paramStringBuilder.append("}");
      return;
    case 9: 
      paramZzbdm = zzbcl.valueOf(paramParcel, paramInt);
      paramStringBuilder.append("\"");
      paramStringBuilder.append(MD5.encode(paramZzbdm));
      paramStringBuilder.append("\"");
      return;
    case 8: 
      paramZzbdm = zzbcl.valueOf(paramParcel, paramInt);
      paramStringBuilder.append("\"");
      paramStringBuilder.append(MD5.decode(paramZzbdm));
      paramStringBuilder.append("\"");
      return;
    case 7: 
      paramZzbdm = zzbcl.readString(paramParcel, paramInt);
      paramStringBuilder.append("\"");
      paramStringBuilder.append(Resources.zzgl(paramZzbdm));
      paramStringBuilder.append("\"");
      return;
    case 6: 
      paramStringBuilder.append(zzbcl.invoke(paramParcel, paramInt));
      return;
    case 5: 
      paramStringBuilder.append(zzbcl.read(paramParcel, paramInt));
      return;
    case 4: 
      paramStringBuilder.append(zzbcl.readLine(paramParcel, paramInt));
      return;
    case 3: 
      paramStringBuilder.append(zzbcl.getNumber(paramParcel, paramInt));
      return;
    case 2: 
      paramStringBuilder.append(zzbcl.getValue(paramParcel, paramInt));
      return;
    case 1: 
      paramStringBuilder.append(zzbcl.sign(paramParcel, paramInt));
      return;
    }
    paramStringBuilder.append(zzbcl.getId(paramParcel, paramInt));
  }
  
  public static HashMap format(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    return localHashMap;
  }
  
  private final void getSize(StringBuilder paramStringBuilder, zzbdm paramZzbdm, Object paramObject)
  {
    if (zzfwr)
    {
      paramObject = (ArrayList)paramObject;
      paramStringBuilder.append("[");
      int j = paramObject.size();
      int i = 0;
      while (i < j)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        toString(paramStringBuilder, zzfwq, paramObject.get(i));
        i += 1;
      }
      paramStringBuilder.append("]");
      return;
    }
    toString(paramStringBuilder, zzfwq, paramObject);
  }
  
  public static void toString(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(26, "Unknown type = ", paramInt));
    case 11: 
      throw new IllegalArgumentException("Method does not accept concrete type.");
    case 10: 
      MultidimensionalCounter.toString(paramStringBuilder, (HashMap)paramObject);
      return;
    case 9: 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(MD5.encode((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(MD5.decode((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 7: 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(Resources.zzgl(paramObject.toString()));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private Parcel zzakx()
  {
    int i = zzfxh;
    if (i != 0)
    {
      if (i != 1) {
        break label44;
      }
    }
    else {
      zzfxi = zzbcn.writeValue(zzfxf);
    }
    zzbcn.zzah(zzfxf, zzfxi);
    zzfxh = 2;
    label44:
    return zzfxf;
  }
  
  public String toString()
  {
    zzbp.get(zzfwy, "Cannot convert to JSON on client side.");
    Parcel localParcel = zzakx();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    doInBackground(localStringBuilder, zzfwy.zzgk(mClassName), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.writeValue(paramParcel, 2, zzakx(), false);
    int j = zzfxg;
    zzbdr localZzbdr;
    if (j != 0)
    {
      if ((j != 1) && (j != 2)) {
        throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(34, "Invalid creation type: ", j));
      }
      localZzbdr = zzfwy;
    }
    else
    {
      localZzbdr = null;
    }
    zzbcn.addMenuItem(paramParcel, 3, localZzbdr, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
  
  public final Object zzgi(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public final boolean zzgj(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public final Map zzzz()
  {
    zzbdr localZzbdr = zzfwy;
    if (localZzbdr == null) {
      return null;
    }
    return localZzbdr.zzgk(mClassName);
  }
}
