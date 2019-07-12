package com.google.android.android.auth.dashclock.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import b.b.a.W;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.credentials.PasswordSpecification> CREATOR = new DownloadProgressInfo.1();
  public static final PasswordSpecification zzeax = new zza().writeInt(12, 16).zzek("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").lookup("abcdefghijkmnopqrstxyz", 1).lookup("ABCDEFGHJKLMNPQRSTXY", 1).lookup("3456789", 1).zzaaa();
  public static PasswordSpecification zzeay = new zza().writeInt(12, 16).zzek("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").lookup("abcdefghijklmnopqrstuvwxyz", 1).lookup("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).lookup("1234567890", 1).zzaaa();
  public final Random zzbds;
  @W
  public String zzeaz;
  @W
  public List<String> zzeba;
  @W
  public List<Integer> zzebb;
  @W
  public int zzebc;
  @W
  public int zzebd;
  public final int[] zzebe;
  
  public PasswordSpecification(String paramString, List paramList1, List paramList2, int paramInt1, int paramInt2)
  {
    zzeaz = paramString;
    zzeba = Collections.unmodifiableList(paramList1);
    zzebb = Collections.unmodifiableList(paramList2);
    zzebc = paramInt1;
    zzebd = paramInt2;
    paramString = new int[95];
    Arrays.fill(paramString, -1);
    paramList1 = zzeba.iterator();
    paramInt1 = 0;
    while (paramList1.hasNext())
    {
      paramList2 = ((String)paramList1.next()).toCharArray();
      int i = paramList2.length;
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        paramString[(paramList2[paramInt2] - ' ')] = paramInt1;
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
    zzebe = paramString;
    zzbds = new SecureRandom();
  }
  
  public static String parse(Collection paramCollection)
  {
    char[] arrayOfChar = new char[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfChar[i] = ((Character)paramCollection.next()).charValue();
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static boolean set(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 < 32) || (paramInt1 > 126);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 1, zzeaz, false);
    zzbcn.readString(paramParcel, 2, zzeba, false);
    zzbcn.write(paramParcel, 3, zzebb, false);
    zzbcn.setCustomVar(paramParcel, 4, zzebc);
    zzbcn.setCustomVar(paramParcel, 5, zzebd);
    zzbcn.zzah(paramParcel, paramInt);
  }
  
  public final class zza
  {
    public final List<String> zzeba = new ArrayList();
    public final List<Integer> zzebb = new ArrayList();
    public int zzebc = 12;
    public int zzebd = 16;
    public final TreeSet<Character> zzebf = new TreeSet();
    
    public zza() {}
    
    public static TreeSet load(String paramString1, String paramString2)
    {
      TreeSet localTreeSet;
      if (!TextUtils.isEmpty(paramString1))
      {
        localTreeSet = new TreeSet();
        paramString1 = paramString1.toCharArray();
        int j = paramString1.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label104;
          }
          char c = paramString1[i];
          if (PasswordSpecification.add(c, 32, 126)) {
            break;
          }
          localTreeSet.add(Character.valueOf(c));
          i += 1;
        }
        throw new PasswordSpecification.zzb(String.valueOf(paramString2).concat(" must only contain ASCII printable characters"));
      }
      paramString1 = new PasswordSpecification.zzb(String.valueOf(paramString2).concat(" cannot be null or empty"));
      throw paramString1;
      label104:
      return localTreeSet;
    }
    
    public final zza lookup(String paramString, int paramInt)
    {
      paramString = load(paramString, "requiredChars");
      zzeba.add(PasswordSpecification.parse(paramString));
      zzebb.add(Integer.valueOf(1));
      return this;
    }
    
    public final zza writeInt(int paramInt1, int paramInt2)
    {
      zzebc = 12;
      zzebd = 16;
      return this;
    }
    
    public final PasswordSpecification zzaaa()
    {
      if (!zzebf.isEmpty())
      {
        localObject = zzebb.iterator();
        int i = 0;
        while (((Iterator)localObject).hasNext()) {
          i += ((Integer)((Iterator)localObject).next()).intValue();
        }
        if (i <= zzebd)
        {
          localObject = new boolean[95];
          Iterator localIterator = zzeba.iterator();
          while (localIterator.hasNext())
          {
            char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
            int j = arrayOfChar.length;
            i = 0;
            char c;
            while (i < j)
            {
              c = arrayOfChar[i];
              int k = c - ' ';
              if (localObject[k] != 0) {
                break label145;
              }
              localObject[k] = 1;
              i += 1;
            }
            continue;
            label145:
            localObject = new StringBuilder(58);
            ((StringBuilder)localObject).append("character ");
            ((StringBuilder)localObject).append(c);
            ((StringBuilder)localObject).append(" occurs in more than one required character set");
            throw new PasswordSpecification.zzb(((StringBuilder)localObject).toString());
          }
          return new PasswordSpecification(PasswordSpecification.parse(zzebf), zzeba, zzebb, zzebc, zzebd);
        }
        throw new PasswordSpecification.zzb("required character count cannot be greater than the max password size");
      }
      Object localObject = new PasswordSpecification.zzb("no allowed characters specified");
      throw ((Throwable)localObject);
    }
    
    public final zza zzek(String paramString)
    {
      zzebf.addAll(load(paramString, "allowedChars"));
      return this;
    }
  }
  
  public final class zzb
    extends Error
  {
    public zzb()
    {
      super();
    }
  }
}
