package com.google.android.android.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;
import com.google.android.android.measurement.AppMeasurement.Event;
import com.google.android.android.measurement.AppMeasurement.UserProperty;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class zzcfw
  extends zzcdu
{
  public static String[] zzixe = { "firebase_" };
  public SecureRandom zzixf;
  public final AtomicLong zzixg = new AtomicLong(0L);
  public int zzixh;
  
  public zzcfw(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  private final boolean add(String paramString1, String paramString2, int paramInt, Object paramObject, boolean paramBoolean)
  {
    if (paramObject == null) {
      return true;
    }
    if ((!(paramObject instanceof Long)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Byte)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Boolean)))
    {
      if ((paramObject instanceof Double)) {
        return true;
      }
      if ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence)))
      {
        if (((paramObject instanceof Bundle)) && (paramBoolean)) {
          return true;
        }
        int i;
        if (((paramObject instanceof Parcelable[])) && (paramBoolean))
        {
          paramString1 = (Parcelable[])paramObject;
          i = paramString1.length;
          paramInt = 0;
          while (paramInt < i)
          {
            paramObject = paramString1[paramInt];
            if (!(paramObject instanceof Bundle))
            {
              zzaul().zzayf().append("All Parcelable[] elements must be of type Bundle. Value type, name", paramObject.getClass(), paramString2);
              return false;
            }
            paramInt += 1;
          }
          return true;
        }
        if ((paramObject instanceof ArrayList))
        {
          if (paramBoolean)
          {
            paramString1 = (ArrayList)paramObject;
            i = paramString1.size();
            paramInt = 0;
            while (paramInt < i)
            {
              paramObject = paramString1.get(paramInt);
              paramInt += 1;
              if (!(paramObject instanceof Bundle))
              {
                zzaul().zzayf().append("All ArrayList elements must be of type Bundle. Value type, name", paramObject.getClass(), paramString2);
                return false;
              }
            }
            return true;
          }
        }
        else {
          return false;
        }
      }
      else
      {
        paramObject = String.valueOf(paramObject);
        if (paramObject.codePointCount(0, paramObject.length()) <= paramInt) {
          break label306;
        }
        zzaul().zzayf().attribute("Value is too long; discarded. Value kind, name, value length", paramString1, paramString2, Integer.valueOf(paramObject.length()));
        return false;
      }
    }
    else
    {
      return true;
    }
    return false;
    label306:
    return true;
  }
  
  private final boolean attribute(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null)
    {
      zzaul().zzayd().append("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.codePointCount(0, paramString2.length()) > paramInt)
    {
      zzaul().zzayd().attribute("Name is too long. Type, maximum supported length, name", paramString1, Integer.valueOf(paramInt), paramString2);
      return false;
    }
    return true;
  }
  
  public static boolean d(zzcbk paramZzcbk, zzcas paramZzcas)
  {
    zzbp.append(paramZzcbk);
    zzbp.append(paramZzcas);
    if (TextUtils.isEmpty(zzilu))
    {
      zzcax.zzawk();
      return false;
    }
    return true;
  }
  
  private final int decode(String paramString, Object paramObject, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      zzcax.zzavs();
      boolean bool = paramObject instanceof Parcelable[];
      int k = 1;
      int i;
      if (bool)
      {
        i = ((Parcelable[])paramObject).length;
      }
      else
      {
        j = k;
        if (!(paramObject instanceof ArrayList)) {
          break label87;
        }
        i = ((ArrayList)paramObject).size();
      }
      int j = k;
      if (i > 1000)
      {
        zzaul().zzayf().attribute("Parameter array is too long; discarded. Value kind, name, array length", "param", paramString, Integer.valueOf(i));
        j = 0;
      }
      label87:
      if (j == 0) {
        return 17;
      }
    }
    if (zzkd(paramString))
    {
      zzcax.zzavr();
      paramBoolean = add("param", paramString, 256, paramObject, paramBoolean);
    }
    else
    {
      zzcax.zzavq();
      paramBoolean = add("param", paramString, 100, paramObject, paramBoolean);
    }
    if (paramBoolean) {
      return 0;
    }
    return 4;
  }
  
  public static boolean enable(Context paramContext, String paramString)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return false;
      }
      paramContext = localPackageManager.getServiceInfo(new ComponentName(paramContext, paramString), 4);
      if (paramContext != null)
      {
        if (enabled) {
          return true;
        }
      }
      else {
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean get(long[] paramArrayOfLong, int paramInt)
  {
    if (paramInt >= paramArrayOfLong.length << 6) {
      return false;
    }
    return (1L << paramInt % 64 & paramArrayOfLong[(paramInt / 64)]) != 0L;
  }
  
  public static boolean loadData(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("android.intent.extra.REFERRER_NAME");
    return ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(paramIntent)) || ("https://www.google.com".equals(paramIntent)) || ("android-app://com.google.appcrawler".equals(paramIntent));
  }
  
  public static byte[] marshall(Parcelable paramParcelable)
  {
    if (paramParcelable == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      paramParcelable.writeToParcel(localParcel, 0);
      paramParcelable = localParcel.marshall();
      localParcel.recycle();
      return paramParcelable;
    }
    catch (Throwable paramParcelable)
    {
      localParcel.recycle();
      throw paramParcelable;
    }
  }
  
  public static String matchName(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    zzbp.append(paramArrayOfString1);
    zzbp.append(paramArrayOfString2);
    int j = Math.min(paramArrayOfString1.length, paramArrayOfString2.length);
    int i = 0;
    while (i < j)
    {
      if (zzas(paramString, paramArrayOfString1[i])) {
        return paramArrayOfString2[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static Object read(int paramInt, Object paramObject, boolean paramBoolean)
  {
    if (paramObject == null) {
      return null;
    }
    if (!(paramObject instanceof Long))
    {
      if ((paramObject instanceof Double)) {
        return paramObject;
      }
      if ((paramObject instanceof Integer)) {
        return Long.valueOf(((Integer)paramObject).intValue());
      }
      if ((paramObject instanceof Byte)) {
        return Long.valueOf(((Byte)paramObject).byteValue());
      }
      if ((paramObject instanceof Short)) {
        return Long.valueOf(((Short)paramObject).shortValue());
      }
      if ((paramObject instanceof Boolean))
      {
        long l;
        if (((Boolean)paramObject).booleanValue()) {
          l = 1L;
        } else {
          l = 0L;
        }
        return Long.valueOf(l);
      }
      if ((paramObject instanceof Float)) {
        return Double.valueOf(((Float)paramObject).doubleValue());
      }
      if ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence))) {
        return null;
      }
      return toString(String.valueOf(paramObject), paramInt, paramBoolean);
    }
    return paramObject;
  }
  
  public static void set(Bundle paramBundle, Object paramObject)
  {
    zzbp.append(paramBundle);
    if ((paramObject != null) && (((paramObject instanceof String)) || ((paramObject instanceof CharSequence)))) {
      paramBundle.putLong("_el", String.valueOf(paramObject).length());
    }
  }
  
  public static boolean set(Bundle paramBundle, int paramInt)
  {
    if (paramBundle.getLong("_err") == 0L)
    {
      paramBundle.putLong("_err", paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean start(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return false;
      }
      paramContext = localPackageManager.getReceiverInfo(new ComponentName(paramContext, paramString), 2);
      if (paramContext != null)
      {
        if (enabled) {
          return true;
        }
      }
      else {
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private final boolean toHtml(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (paramString2 == null)
    {
      zzaul().zzayd().append("Name is required and can't be null. Type", paramString1);
      return false;
    }
    zzbp.append(paramString2);
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = zzixe;
      if (i >= arrayOfString.length) {
        break;
      }
      if (paramString2.startsWith(arrayOfString[i]))
      {
        i = 1;
        break label70;
      }
      i += 1;
    }
    i = 0;
    label70:
    if (i != 0)
    {
      zzaul().zzayd().append("Name starts with reserved prefix. Type, name", paramString1, paramString2);
      return false;
    }
    if (paramArrayOfString != null)
    {
      zzbp.append(paramArrayOfString);
      i = 0;
      while (i < paramArrayOfString.length)
      {
        if (zzas(paramString2, paramArrayOfString[i]))
        {
          i = 1;
          break label140;
        }
        i += 1;
      }
      i = 0;
      label140:
      if (i != 0)
      {
        zzaul().zzayd().append("Name is reserved. Type, name", paramString1, paramString2);
        return false;
      }
    }
    return true;
  }
  
  public static String toString(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString.codePointCount(0, paramString.length()) > paramInt)
    {
      if (paramBoolean) {
        return String.valueOf(paramString.substring(0, paramString.offsetByCodePoints(0, paramInt))).concat("...");
      }
      return null;
    }
    return paramString;
  }
  
  public static long[] toString(BitSet paramBitSet)
  {
    int k = (paramBitSet.length() + 63) / 64;
    long[] arrayOfLong = new long[k];
    int i = 0;
    while (i < k)
    {
      arrayOfLong[i] = 0L;
      int j = 0;
      while (j < 64)
      {
        int m = (i << 6) + j;
        if (m >= paramBitSet.length()) {
          break;
        }
        if (paramBitSet.get(m)) {
          arrayOfLong[i] |= 1L << j;
        }
        j += 1;
      }
      i += 1;
    }
    return arrayOfLong;
  }
  
  public static long update(byte[] paramArrayOfByte)
  {
    zzbp.append(paramArrayOfByte);
    int i = paramArrayOfByte.length;
    int j = 0;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.zzbg(bool);
    long l = 0L;
    i = paramArrayOfByte.length - 1;
    while ((i >= 0) && (i >= paramArrayOfByte.length - 8))
    {
      l += ((paramArrayOfByte[i] & 0xFF) << j);
      j += 8;
      i -= 1;
    }
    return l;
  }
  
  public static Bundle[] zzac(Object paramObject)
  {
    if ((paramObject instanceof Bundle)) {
      return new Bundle[] { (Bundle)paramObject };
    }
    if ((paramObject instanceof Parcelable[])) {
      paramObject = (Parcelable[])paramObject;
    }
    for (paramObject = Arrays.copyOf(paramObject, paramObject.length, [Landroid.os.Bundle.class);; paramObject = paramObject.toArray(new Bundle[paramObject.size()]))
    {
      return (Bundle[])paramObject;
      if (!(paramObject instanceof ArrayList)) {
        break;
      }
      paramObject = (ArrayList)paramObject;
    }
    return null;
  }
  
  /* Error */
  public static Object zzad(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 358	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 360	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_1
    //   14: new 362	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 365	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_2
    //   23: aload_2
    //   24: aload_0
    //   25: invokevirtual 369	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   28: aload_2
    //   29: invokevirtual 372	java/io/ObjectOutputStream:flush	()V
    //   32: new 374	java/io/ObjectInputStream
    //   35: dup
    //   36: new 376	java/io/ByteArrayInputStream
    //   39: dup
    //   40: aload_1
    //   41: invokevirtual 379	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   44: invokespecial 382	java/io/ByteArrayInputStream:<init>	([B)V
    //   47: invokespecial 385	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 389	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   55: astore_1
    //   56: aload_2
    //   57: invokevirtual 392	java/io/ObjectOutputStream:close	()V
    //   60: aload_0
    //   61: invokevirtual 393	java/io/ObjectInputStream:close	()V
    //   64: aload_1
    //   65: areturn
    //   66: astore_1
    //   67: goto +14 -> 81
    //   70: astore_1
    //   71: aconst_null
    //   72: astore_0
    //   73: goto +8 -> 81
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 392	java/io/ObjectOutputStream:close	()V
    //   89: aload_0
    //   90: ifnull +7 -> 97
    //   93: aload_0
    //   94: invokevirtual 393	java/io/ObjectInputStream:close	()V
    //   97: aload_1
    //   98: athrow
    //   99: astore_0
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: aconst_null
    //   104: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramObject	Object
    //   13	52	1	localObject	Object
    //   66	1	1	localThrowable1	Throwable
    //   70	1	1	localThrowable2	Throwable
    //   76	22	1	localThrowable3	Throwable
    //   22	64	2	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   51	56	66	java/lang/Throwable
    //   23	51	70	java/lang/Throwable
    //   6	23	76	java/lang/Throwable
    //   56	64	99	java/io/IOException
    //   85	89	99	java/io/IOException
    //   93	97	99	java/io/IOException
    //   97	99	99	java/io/IOException
    //   56	64	102	java/lang/ClassNotFoundException
    //   85	89	102	java/lang/ClassNotFoundException
    //   93	97	102	java/lang/ClassNotFoundException
    //   97	99	102	java/lang/ClassNotFoundException
  }
  
  private final boolean zzai(Context paramContext, String paramString)
  {
    Object localObject = new X500Principal("CN=Android Debug,O=Android,C=US");
    try
    {
      paramContext = zzbed.zzcr(paramContext).getPackageInfo(paramString, 64);
      if (paramContext == null) {
        break label123;
      }
      paramContext = signatures;
      if ((paramContext == null) || (paramContext.length <= 0)) {
        break label123;
      }
      paramContext = paramContext[0];
      paramString = CertificateFactory.getInstance("X.509");
      paramContext = paramString.generateCertificate(new ByteArrayInputStream(paramContext.toByteArray()));
      paramContext = (X509Certificate)paramContext;
      boolean bool = paramContext.getSubjectX500Principal().equals(localObject);
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramString = zzaul().zzayd();
      localObject = "Package name not found";
    }
    catch (CertificateException paramContext)
    {
      paramString = zzaul().zzayd();
      localObject = "Error obtaining certificate";
    }
    paramString.append((String)localObject, paramContext);
    label123:
    return true;
  }
  
  private final boolean zzaq(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      zzaul().zzayd().append("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.length() == 0)
    {
      zzaul().zzayd().append("Name is required and can't be empty. Type", paramString1);
      return false;
    }
    int i = paramString2.codePointAt(0);
    if (!Character.isLetter(i))
    {
      zzaul().zzayd().append("Name must start with a letter. Type, name", paramString1, paramString2);
      return false;
    }
    int j = paramString2.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString2.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k)))
      {
        zzaul().zzayd().append("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      }
      i += Character.charCount(k);
    }
    return true;
  }
  
  private final boolean zzar(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      zzaul().zzayd().append("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.length() == 0)
    {
      zzaul().zzayd().append("Name is required and can't be empty. Type", paramString1);
      return false;
    }
    int i = paramString2.codePointAt(0);
    if ((!Character.isLetter(i)) && (i != 95))
    {
      zzaul().zzayd().append("Name must start with a letter or _ (underscore). Type, name", paramString1, paramString2);
      return false;
    }
    int j = paramString2.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString2.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k)))
      {
        zzaul().zzayd().append("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      }
      i += Character.charCount(k);
    }
    return true;
  }
  
  public static boolean zzas(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if (paramString1 == null) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
  
  public static MessageDigest zzec(String paramString)
  {
    int i = 0;
    while (i < 2)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        if (localMessageDigest != null) {
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return null;
  }
  
  public static boolean zzju(String paramString)
  {
    zzbp.zzgg(paramString);
    return (paramString.charAt(0) != '_') || (paramString.equals("_ep"));
  }
  
  private final int zzjz(String paramString)
  {
    if (!zzaq("event param", paramString)) {
      return 3;
    }
    if (!toHtml("event param", null, paramString)) {
      return 14;
    }
    zzcax.zzavp();
    if (!attribute("event param", 40, paramString)) {
      return 3;
    }
    return 0;
  }
  
  private final int zzka(String paramString)
  {
    if (!zzar("event param", paramString)) {
      return 3;
    }
    if (!toHtml("event param", null, paramString)) {
      return 14;
    }
    zzcax.zzavp();
    if (!attribute("event param", 40, paramString)) {
      return 3;
    }
    return 0;
  }
  
  public static int zzkc(String paramString)
  {
    if ("_ldl".equals(paramString))
    {
      zzcax.zzavu();
      return 2048;
    }
    zzcax.zzavt();
    return 36;
  }
  
  public static boolean zzkd(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("_"));
  }
  
  public static boolean zzkf(String paramString)
  {
    return (paramString != null) && (paramString.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)")) && (paramString.length() <= 310);
  }
  
  public static boolean zzki(String paramString)
  {
    zzbp.zzgg(paramString);
    int i = paramString.hashCode();
    if (i != 94660)
    {
      if (i != 95025)
      {
        if ((i == 95027) && (paramString.equals("_ui")))
        {
          i = 1;
          break label81;
        }
      }
      else if (paramString.equals("_ug"))
      {
        i = 2;
        break label81;
      }
    }
    else if (paramString.equals("_in"))
    {
      i = 0;
      break label81;
    }
    i = -1;
    label81:
    return (i == 0) || (i == 1) || (i == 2);
  }
  
  public final void add(Bundle paramBundle, String paramString, Object paramObject)
  {
    if (paramBundle == null) {
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramBundle.putString(paramString, String.valueOf(paramObject));
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
      return;
    }
    if (paramString != null)
    {
      if (paramObject != null) {
        paramBundle = paramObject.getClass().getSimpleName();
      } else {
        paramBundle = null;
      }
      zzaul().zzayg().append("Not putting event parameter. Invalid value type. name, type", zzaug().zzjd(paramString), paramBundle);
    }
  }
  
  public final void add(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    paramString1 = new Bundle();
    set(paramString1, paramInt1);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.putString(paramString2, paramString3);
    }
    if ((paramInt1 == 6) || (paramInt1 == 7) || (paramInt1 == 2)) {
      paramString1.putLong("_el", paramInt2);
    }
    zzcax.zzawk();
    zziki.zzatz().put("auto", "_err", paramString1);
  }
  
  public final void append(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    add(null, paramInt1, paramString1, paramString2, paramInt2);
  }
  
  public final int attribute(String paramString, Object paramObject)
  {
    boolean bool;
    if ("_ldl".equals(paramString)) {
      bool = add("user property referrer", paramString, zzkc(paramString), paramObject, false);
    } else {
      bool = add("user property", paramString, zzkc(paramString), paramObject, false);
    }
    if (bool) {
      return 0;
    }
    return 7;
  }
  
  public final byte[] compress(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      localByteArrayOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      zzaul().zzayd().append("Failed to gzip content", paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public final byte[] decompress(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['?'];
      for (;;)
      {
        int i = localGZIPInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localGZIPInputStream.close();
      paramArrayOfByte.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      zzaul().zzayd().append("Failed to ungzip content", paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public final boolean evaluate(long paramLong1, long paramLong2)
  {
    if (paramLong1 != 0L)
    {
      if (paramLong2 <= 0L) {
        return true;
      }
      return Math.abs(zzvx().currentTimeMillis() - paramLong1) > paramLong2;
    }
    return true;
  }
  
  public final zzcbk get(String paramString1, Bundle paramBundle, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (zzjw(paramString1) == 0)
    {
      if (paramBundle != null) {
        paramBundle = new Bundle(paramBundle);
      } else {
        paramBundle = new Bundle();
      }
      paramBundle.putString("_o", paramString2);
      return new zzcbk(paramString1, new zzcbh(getNames(list(paramString1, paramBundle, Collections.singletonList("_o"), false, false))), paramString2, paramLong);
    }
    zzaul().zzayd().append("Invalid conditional property event name", zzaug().zzje(paramString1));
    throw new IllegalArgumentException();
  }
  
  public final Object get(String paramString, Object paramObject)
  {
    boolean bool = "_ev".equals(paramString);
    int i = 256;
    if (bool) {
      zzcax.zzavr();
    }
    for (bool = true;; bool = false)
    {
      return read(i, paramObject, bool);
      if (zzkd(paramString))
      {
        zzcax.zzavr();
      }
      else
      {
        zzcax.zzavq();
        i = 100;
      }
    }
  }
  
  public final Bundle getNames(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = get(str, paramBundle.get(str));
        if (localObject == null) {
          zzaul().zzayf().append("Param value can't be null", zzaug().zzjd(str));
        } else {
          add(localBundle, str, localObject);
        }
      }
    }
    return localBundle;
  }
  
  public final Bundle list(String paramString, Bundle paramBundle, List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Bundle localBundle;
    if (paramBundle != null)
    {
      localBundle = new Bundle(paramBundle);
      zzcax.zzavm();
      Iterator localIterator = paramBundle.keySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        int j;
        int k;
        if ((paramList != null) && (paramList.contains(str)))
        {
          j = 0;
        }
        else
        {
          if (paramBoolean1) {
            k = zzjz(str);
          } else {
            k = 0;
          }
          j = k;
          if (k == 0) {
            j = zzka(str);
          }
        }
        if (j != 0)
        {
          k = i;
          if (set(localBundle, j))
          {
            zzcax.zzavp();
            localBundle.putString("_ev", toString(str, 40, true));
            k = i;
            if (j == 3)
            {
              set(localBundle, str);
              k = i;
            }
          }
        }
        else
        {
          j = decode(str, paramBundle.get(str), paramBoolean2);
          if ((j != 0) && (!"_ev".equals(str)))
          {
            k = i;
            if (set(localBundle, j))
            {
              zzcax.zzavp();
              localBundle.putString("_ev", toString(str, 40, true));
              set(localBundle, paramBundle.get(str));
              k = i;
            }
          }
          else
          {
            if (!zzju(str)) {
              continue;
            }
            k = i + 1;
            i = k;
            if (k <= 25) {
              continue;
            }
            Object localObject = new StringBuilder(48);
            ((StringBuilder)localObject).append("Event can't contain more then 25 params");
            localObject = ((StringBuilder)localObject).toString();
            zzaul().zzayd().append((String)localObject, zzaug().zzjc(paramString), zzaug().toString(paramBundle));
            set(localBundle, 5);
          }
        }
        localBundle.remove(str);
        i = k;
      }
    }
    return null;
    return localBundle;
  }
  
  public final byte[] operate(zzcgj paramZzcgj)
  {
    try
    {
      int i = paramZzcgj.zzhi();
      byte[] arrayOfByte = new byte[i];
      i = arrayOfByte.length;
      zzeyf localZzeyf = zzeyf.toString(arrayOfByte, 0, i);
      paramZzcgj.multiply(localZzeyf);
      localZzeyf.zzctn();
      return arrayOfByte;
    }
    catch (IOException paramZzcgj)
    {
      zzaul().zzayd().append("Data loss. Failed to serialize batch", paramZzcgj);
    }
    return null;
  }
  
  public final Bundle parse(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    Bundle localBundle;
    try
    {
      boolean bool = paramUri.isHierarchical();
      String str2;
      String str3;
      String str4;
      if (bool)
      {
        str1 = paramUri.getQueryParameter("utm_campaign");
        str2 = paramUri.getQueryParameter("utm_source");
        str3 = paramUri.getQueryParameter("utm_medium");
        str4 = paramUri.getQueryParameter("gclid");
      }
      else
      {
        str1 = null;
        str2 = null;
        str3 = null;
        str4 = null;
      }
      if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str4))) {
        return null;
      }
      localBundle = new Bundle();
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("campaign", str1);
      }
      if (!TextUtils.isEmpty(str2)) {
        localBundle.putString("source", str2);
      }
      if (!TextUtils.isEmpty(str3)) {
        localBundle.putString("medium", str3);
      }
      if (!TextUtils.isEmpty(str4)) {
        localBundle.putString("gclid", str4);
      }
      String str1 = paramUri.getQueryParameter("utm_term");
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("term", str1);
      }
      str1 = paramUri.getQueryParameter("utm_content");
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("content", str1);
      }
      str1 = paramUri.getQueryParameter("aclid");
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("aclid", str1);
      }
      str1 = paramUri.getQueryParameter("cp1");
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("cp1", str1);
      }
      paramUri = paramUri.getQueryParameter("anid");
      if (!TextUtils.isEmpty(paramUri))
      {
        localBundle.putString("anid", paramUri);
        return localBundle;
      }
    }
    catch (UnsupportedOperationException paramUri)
    {
      zzaul().zzayf().append("Install referrer url isn't a hierarchical URI", paramUri);
      return null;
    }
    return localBundle;
  }
  
  public final void persist(zzcgi paramZzcgi, Object paramObject)
  {
    zzbp.append(paramObject);
    zzfwo = null;
    zzizb = null;
    zzixc = null;
    if ((paramObject instanceof String))
    {
      zzfwo = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      zzizb = ((Long)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      zzixc = ((Double)paramObject);
      return;
    }
    zzaul().zzayd().append("Ignoring invalid (type) event param value", paramObject);
  }
  
  public final void trim(zzcgm paramZzcgm, Object paramObject)
  {
    zzbp.append(paramObject);
    zzfwo = null;
    zzizb = null;
    zzixc = null;
    if ((paramObject instanceof String))
    {
      zzfwo = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      zzizb = ((Long)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      zzixc = ((Double)paramObject);
      return;
    }
    zzaul().zzayd().append("Ignoring invalid (type) user attribute value", paramObject);
  }
  
  public final Parcelable unmarshall(byte[] paramArrayOfByte, Parcelable.Creator paramCreator)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      int i = paramArrayOfByte.length;
      zzaul().zzayd().append("Failed to load parcelable from buffer");
    }
    catch (Throwable paramArrayOfByte)
    {
      try
      {
        localParcel.unmarshall(paramArrayOfByte, 0, i);
        localParcel.setDataPosition(0);
        paramArrayOfByte = paramCreator.createFromParcel(localParcel);
        paramArrayOfByte = (Parcelable)paramArrayOfByte;
        localParcel.recycle();
        return paramArrayOfByte;
      }
      catch (zzbcm paramArrayOfByte)
      {
        for (;;) {}
      }
      paramArrayOfByte = paramArrayOfByte;
    }
    localParcel.recycle();
    return null;
    localParcel.recycle();
    throw paramArrayOfByte;
  }
  
  public final Object valueOf(String paramString, Object paramObject)
  {
    int i;
    if ("_ldl".equals(paramString)) {
      i = zzkc(paramString);
    }
    for (boolean bool = true;; bool = false)
    {
      return read(i, paramObject, bool);
      i = zzkc(paramString);
    }
  }
  
  public final long zzah(Context paramContext, String paramString)
  {
    zzuj();
    zzbp.append(paramContext);
    zzbp.zzgg(paramString);
    PackageManager localPackageManager = paramContext.getPackageManager();
    MessageDigest localMessageDigest = zzec("MD5");
    if (localMessageDigest == null)
    {
      zzaul().zzayd().append("Could not get MD5 instance");
      return -1L;
    }
    if (localPackageManager != null) {
      try
      {
        boolean bool = zzai(paramContext, paramString);
        if (!bool)
        {
          paramContext = zzbed.zzcr(paramContext).getPackageInfo(getContext().getPackageName(), 64);
          if (signatures != null)
          {
            paramContext = signatures;
            if (paramContext.length > 0)
            {
              paramContext = paramContext[0];
              long l = update(localMessageDigest.digest(paramContext.toByteArray()));
              return l;
            }
          }
          zzaul().zzayf().append("Could not get signatures");
          return -1L;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        zzaul().zzayd().append("Package name not found", paramContext);
      }
    }
    return 0L;
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzcax.zzawk();
  }
  
  public final long zzazx()
  {
    long l1;
    if (zzixg.get() == 0L)
    {
      localAtomicLong = zzixg;
      try
      {
        l1 = new Random(System.nanoTime() ^ zzvx().currentTimeMillis()).nextLong();
        int i = zzixh + 1;
        zzixh = i;
        long l2 = i;
        return l1 + l2;
      }
      catch (Throwable localThrowable1)
      {
        throw localThrowable1;
      }
    }
    AtomicLong localAtomicLong = zzixg;
    try
    {
      zzixg.compareAndSet(-1L, 1L);
      l1 = zzixg.getAndIncrement();
      return l1;
    }
    catch (Throwable localThrowable2)
    {
      throw localThrowable2;
    }
  }
  
  public final SecureRandom zzazy()
  {
    zzuj();
    if (zzixf == null) {
      zzixf = new SecureRandom();
    }
    return zzixf;
  }
  
  public final boolean zzdt(String paramString)
  {
    zzuj();
    if (zzbed.zzcr(getContext()).checkCallingOrSelfPermission(paramString) == 0) {
      return true;
    }
    zzaul().zzayi().append("Permission not granted", paramString);
    return false;
  }
  
  public final int zzjv(String paramString)
  {
    if (!zzaq("event", paramString)) {
      return 2;
    }
    if (!toHtml("event", AppMeasurement.Event.zzikj, paramString)) {
      return 13;
    }
    zzcax.zzavn();
    if (!attribute("event", 40, paramString)) {
      return 2;
    }
    return 0;
  }
  
  public final int zzjw(String paramString)
  {
    if (!zzar("event", paramString)) {
      return 2;
    }
    if (!toHtml("event", AppMeasurement.Event.zzikj, paramString)) {
      return 13;
    }
    zzcax.zzavn();
    if (!attribute("event", 40, paramString)) {
      return 2;
    }
    return 0;
  }
  
  public final int zzjx(String paramString)
  {
    if (!zzaq("user property", paramString)) {
      return 6;
    }
    if (!toHtml("user property", AppMeasurement.UserProperty.zzikq, paramString)) {
      return 15;
    }
    zzcax.zzavo();
    if (!attribute("user property", 24, paramString)) {
      return 6;
    }
    return 0;
  }
  
  public final int zzjy(String paramString)
  {
    if (!zzar("user property", paramString)) {
      return 6;
    }
    if (!toHtml("user property", AppMeasurement.UserProperty.zzikq, paramString)) {
      return 15;
    }
    zzcax.zzavo();
    if (!attribute("user property", 24, paramString)) {
      return 6;
    }
    return 0;
  }
  
  public final boolean zzkb(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      zzaul().zzayd().append("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
      return false;
    }
    zzbp.append(paramString);
    if (!paramString.matches("^1:\\d+:android:[a-f0-9]+$"))
    {
      zzaul().zzayd().append("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", paramString);
      return false;
    }
    return true;
  }
  
  public final boolean zzke(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = zzaun().zzaxg();
    zzcax.zzawk();
    return str.equals(paramString);
  }
  
  public final boolean zzkg(String paramString)
  {
    return "1".equals(zzaui().zzan(paramString, "measurement.upload.blacklist_internal"));
  }
  
  public final boolean zzkh(String paramString)
  {
    return "1".equals(zzaui().zzan(paramString, "measurement.upload.blacklist_public"));
  }
  
  public final void zzuk()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    long l2 = localSecureRandom.nextLong();
    long l1 = l2;
    if (l2 == 0L)
    {
      long l3 = localSecureRandom.nextLong();
      l2 = l3;
      l1 = l2;
      if (l3 == 0L)
      {
        zzaul().zzayf().append("Utils falling back to Random for random id");
        l1 = l2;
      }
    }
    zzixg.set(l1);
  }
}
