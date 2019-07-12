package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.android.common.internal.zzbf;
import com.google.android.android.common.internal.zzbh;
import com.google.android.android.common.internal.zzbp;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbdl;
import com.google.android.gms.internal.zzbdw;
import java.util.Map;

public final class zzbdm<I, O>
  extends zzbck
{
  public static final zzbdp CREATOR = new zzbdp();
  public final int zzdxs;
  public final int zzfwq;
  public final boolean zzfwr;
  public final int zzfws;
  public final boolean zzfwt;
  public final String zzfwu;
  public final int zzfwv;
  public final Class<? extends zzbdl> zzfww;
  public String zzfwx;
  public zzbdr zzfwy;
  public com.google.android.gms.internal.zzbdn<I, O> zzfwz;
  
  public zzbdm(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, zzbdf paramZzbdf)
  {
    zzdxs = paramInt1;
    zzfwq = paramInt2;
    zzfwr = paramBoolean1;
    zzfws = paramInt3;
    zzfwt = paramBoolean2;
    zzfwu = paramString1;
    zzfwv = paramInt4;
    if (paramString2 == null)
    {
      zzfww = null;
      zzfwx = null;
    }
    else
    {
      zzfww = zzbdw.class;
      zzfwx = paramString2;
    }
    if (paramZzbdf == null)
    {
      zzfwz = null;
      return;
    }
    zzfwz = paramZzbdf.zzakp();
  }
  
  public zzbdm(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class paramClass, zzbdn paramZzbdn)
  {
    zzdxs = 1;
    zzfwq = paramInt1;
    zzfwr = paramBoolean1;
    zzfws = paramInt2;
    zzfwt = paramBoolean2;
    zzfwu = paramString;
    zzfwv = paramInt3;
    zzfww = paramClass;
    if (paramClass == null) {
      paramString = null;
    } else {
      paramString = paramClass.getCanonicalName();
    }
    zzfwx = paramString;
    zzfwz = paramZzbdn;
  }
  
  public static zzbdm add(String paramString, int paramInt)
  {
    return new zzbdm(0, false, 0, false, paramString, paramInt, null, null);
  }
  
  public static zzbdm get(String paramString, int paramInt)
  {
    return new zzbdm(7, true, 7, true, paramString, paramInt, null, null);
  }
  
  public static zzbdm get(String paramString, int paramInt, Class paramClass)
  {
    return new zzbdm(11, false, 11, false, paramString, paramInt, paramClass, null);
  }
  
  public static zzbdm getValue(String paramString, int paramInt)
  {
    return new zzbdm(7, false, 7, false, paramString, paramInt, null, null);
  }
  
  public static zzbdm getWordRangeAtCursor(String paramString, int paramInt, zzbdn paramZzbdn, boolean paramBoolean)
  {
    return new zzbdm(7, false, 0, false, paramString, paramInt, null, paramZzbdn);
  }
  
  public static zzbdm initFunction(String paramString, int paramInt)
  {
    return new zzbdm(8, false, 8, false, paramString, 4, null, null);
  }
  
  public static zzbdm removePlaylist(String paramString, int paramInt)
  {
    return new zzbdm(6, false, 6, false, paramString, paramInt, null, null);
  }
  
  public static zzbdm selectStatement(String paramString, int paramInt, Class paramClass)
  {
    return new zzbdm(11, true, 11, true, paramString, paramInt, paramClass, null);
  }
  
  private String zzakr()
  {
    String str = zzfwx;
    if (str == null) {
      return null;
    }
    return str;
  }
  
  public final void addPauseListener(zzbdr paramZzbdr)
  {
    zzfwy = paramZzbdr;
  }
  
  public final Object convertBack(Object paramObject)
  {
    return zzfwz.convertBack(paramObject);
  }
  
  public final String toString()
  {
    zzbh localZzbh = zzbf.peekPersisted(this).add("versionCode", Integer.valueOf(zzdxs)).add("typeIn", Integer.valueOf(zzfwq)).add("typeInArray", Boolean.valueOf(zzfwr)).add("typeOut", Integer.valueOf(zzfws)).add("typeOutArray", Boolean.valueOf(zzfwt)).add("outputFieldName", zzfwu).add("safeParcelFieldId", Integer.valueOf(zzfwv)).add("concreteTypeName", zzakr());
    Object localObject = zzfww;
    if (localObject != null) {
      localZzbh.add("concreteType.class", ((Class)localObject).getCanonicalName());
    }
    localObject = zzfwz;
    if (localObject != null) {
      localZzbh.add("converterName", localObject.getClass().getCanonicalName());
    }
    return localZzbh.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.setCustomVar(paramParcel, 2, zzfwq);
    zzbcn.onAction(paramParcel, 3, zzfwr);
    zzbcn.setCustomVar(paramParcel, 4, zzfws);
    zzbcn.onAction(paramParcel, 5, zzfwt);
    zzbcn.append(paramParcel, 6, zzfwu, false);
    zzbcn.setCustomVar(paramParcel, 7, zzfwv);
    zzbcn.append(paramParcel, 8, zzakr(), false);
    Object localObject = zzfwz;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = zzbdf.getId((zzbdn)localObject);
    }
    zzbcn.addMenuItem(paramParcel, 9, (Parcelable)localObject, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
  
  public final int zzakq()
  {
    return zzfwv;
  }
  
  public final boolean zzaks()
  {
    return zzfwz != null;
  }
  
  public final Map zzakt()
  {
    zzbp.append(zzfwx);
    zzbp.append(zzfwy);
    return zzfwy.zzgk(zzfwx);
  }
}
