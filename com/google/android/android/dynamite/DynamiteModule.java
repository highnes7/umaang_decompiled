package com.google.android.android.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.dynamic.Integer;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule
{
  public static Boolean zzgpi;
  public static Array zzgpj;
  public static OkHttpClient zzgpk;
  public static String zzgpl;
  public static final ThreadLocal<com.google.android.gms.dynamite.DynamiteModule.zza> zzgpm = new ThreadLocal();
  public static final Weather zzgpn = new Directory();
  public static final zzd zzgpo = new BuildInfo();
  public static zzd zzgpp = new Active();
  public static final zzd zzgpq = new LogEntry();
  public static final zzd zzgpr = new ScriptRuntime.DefaultMessageProvider();
  public static final zzd zzgps = new SolidColor();
  public static final zzd zzgpt = new ErrorMessage();
  public final Context zzgpu;
  
  public DynamiteModule(Context paramContext)
  {
    zzbp.append(paramContext);
    zzgpu = ((Context)paramContext);
  }
  
  /* Error */
  public static int create(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 105
    //   2: monitorenter
    //   3: getstatic 107	com/google/android/android/dynamite/DynamiteModule:zzgpi	Ljava/lang/Boolean;
    //   6: astore 6
    //   8: aload 6
    //   10: astore 5
    //   12: aload 6
    //   14: ifnonnull +289 -> 303
    //   17: aload_0
    //   18: invokevirtual 111	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   21: invokevirtual 115	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   24: astore 5
    //   26: aload 5
    //   28: ldc 117
    //   30: invokevirtual 123	java/lang/Class:getName	()Ljava/lang/String;
    //   33: invokevirtual 129	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   36: astore 6
    //   38: aload 6
    //   40: ldc -125
    //   42: invokevirtual 135	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   45: astore 5
    //   47: aload 6
    //   49: monitorenter
    //   50: aload 5
    //   52: aconst_null
    //   53: invokevirtual 140	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: checkcast 125	java/lang/ClassLoader
    //   59: astore 7
    //   61: aload 7
    //   63: ifnull +32 -> 95
    //   66: aload 7
    //   68: invokestatic 143	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   71: if_acmpne +11 -> 82
    //   74: getstatic 148	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   77: astore 5
    //   79: goto +142 -> 221
    //   82: aload 7
    //   84: invokestatic 151	com/google/android/android/dynamite/DynamiteModule:get	(Ljava/lang/ClassLoader;)V
    //   87: getstatic 154	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   90: astore 5
    //   92: goto +129 -> 221
    //   95: ldc -100
    //   97: aload_0
    //   98: invokevirtual 111	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   101: invokevirtual 159	android/content/Context:getPackageName	()Ljava/lang/String;
    //   104: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifeq +15 -> 122
    //   110: aload 5
    //   112: aconst_null
    //   113: invokestatic 143	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   116: invokevirtual 169	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   119: goto -45 -> 74
    //   122: aload_0
    //   123: aload_1
    //   124: iload_2
    //   125: invokestatic 171	com/google/android/android/dynamite/DynamiteModule:get	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   128: istore_3
    //   129: getstatic 173	com/google/android/android/dynamite/DynamiteModule:zzgpl	Ljava/lang/String;
    //   132: ifnull +69 -> 201
    //   135: getstatic 173	com/google/android/android/dynamite/DynamiteModule:zzgpl	Ljava/lang/String;
    //   138: astore 7
    //   140: aload 7
    //   142: invokevirtual 177	java/lang/String:isEmpty	()Z
    //   145: istore 4
    //   147: iload 4
    //   149: ifeq +6 -> 155
    //   152: goto +49 -> 201
    //   155: getstatic 173	com/google/android/android/dynamite/DynamiteModule:zzgpl	Ljava/lang/String;
    //   158: astore 7
    //   160: new 179	com/google/android/android/dynamite/Loader
    //   163: dup
    //   164: aload 7
    //   166: invokestatic 143	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   169: invokespecial 182	com/google/android/android/dynamite/Loader:<init>	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   172: astore 7
    //   174: aload 7
    //   176: invokestatic 151	com/google/android/android/dynamite/DynamiteModule:get	(Ljava/lang/ClassLoader;)V
    //   179: aload 5
    //   181: aconst_null
    //   182: aload 7
    //   184: invokevirtual 169	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   187: getstatic 154	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   190: putstatic 107	com/google/android/android/dynamite/DynamiteModule:zzgpi	Ljava/lang/Boolean;
    //   193: aload 6
    //   195: monitorexit
    //   196: ldc 105
    //   198: monitorexit
    //   199: iload_3
    //   200: ireturn
    //   201: aload 6
    //   203: monitorexit
    //   204: ldc 105
    //   206: monitorexit
    //   207: iload_3
    //   208: ireturn
    //   209: aload 5
    //   211: aconst_null
    //   212: invokestatic 143	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   215: invokevirtual 169	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   218: goto -144 -> 74
    //   221: aload 6
    //   223: monitorexit
    //   224: goto +74 -> 298
    //   227: astore 5
    //   229: aload 6
    //   231: monitorexit
    //   232: aload 5
    //   234: athrow
    //   235: astore 5
    //   237: goto +10 -> 247
    //   240: astore 5
    //   242: goto +5 -> 247
    //   245: astore 5
    //   247: aload 5
    //   249: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   252: astore 5
    //   254: new 188	java/lang/StringBuilder
    //   257: dup
    //   258: aload 5
    //   260: invokevirtual 192	java/lang/String:length	()I
    //   263: bipush 30
    //   265: iadd
    //   266: invokespecial 195	java/lang/StringBuilder:<init>	(I)V
    //   269: astore 6
    //   271: aload 6
    //   273: ldc -59
    //   275: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 6
    //   281: aload 5
    //   283: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 6
    //   289: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: pop
    //   293: getstatic 148	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   296: astore 5
    //   298: aload 5
    //   300: putstatic 107	com/google/android/android/dynamite/DynamiteModule:zzgpi	Ljava/lang/Boolean;
    //   303: ldc 105
    //   305: monitorexit
    //   306: aload 5
    //   308: invokevirtual 206	java/lang/Boolean:booleanValue	()Z
    //   311: ifeq +50 -> 361
    //   314: aload_0
    //   315: aload_1
    //   316: iload_2
    //   317: invokestatic 171	com/google/android/android/dynamite/DynamiteModule:get	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   320: istore_3
    //   321: iload_3
    //   322: ireturn
    //   323: astore_0
    //   324: aload_0
    //   325: invokevirtual 211	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   328: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   331: astore_0
    //   332: aload_0
    //   333: invokevirtual 192	java/lang/String:length	()I
    //   336: ifeq +13 -> 349
    //   339: ldc -43
    //   341: aload_0
    //   342: invokevirtual 217	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   345: pop
    //   346: goto +13 -> 359
    //   349: new 161	java/lang/String
    //   352: dup
    //   353: ldc -43
    //   355: invokespecial 220	java/lang/String:<init>	(Ljava/lang/String;)V
    //   358: pop
    //   359: iconst_0
    //   360: ireturn
    //   361: aload_0
    //   362: aload_1
    //   363: iload_2
    //   364: invokestatic 223	com/google/android/android/dynamite/DynamiteModule:insert	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   367: ireturn
    //   368: astore_0
    //   369: ldc 105
    //   371: monitorexit
    //   372: goto +3 -> 375
    //   375: aload_0
    //   376: athrow
    //   377: astore 5
    //   379: goto -292 -> 87
    //   382: astore 7
    //   384: goto -175 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	paramContext	Context
    //   0	387	1	paramString	String
    //   0	387	2	paramBoolean	boolean
    //   128	194	3	i	int
    //   145	3	4	bool	boolean
    //   10	200	5	localObject1	Object
    //   227	6	5	localThrowable	Throwable
    //   235	1	5	localNoSuchFieldException	NoSuchFieldException
    //   240	1	5	localIllegalAccessException	IllegalAccessException
    //   245	3	5	localClassNotFoundException	ClassNotFoundException
    //   252	55	5	localObject2	Object
    //   377	1	5	localZzc1	zzc
    //   6	282	6	localObject3	Object
    //   59	124	7	localObject4	Object
    //   382	1	7	localZzc2	zzc
    // Exception table:
    //   from	to	target	type
    //   50	61	227	java/lang/Throwable
    //   66	74	227	java/lang/Throwable
    //   74	79	227	java/lang/Throwable
    //   82	87	227	java/lang/Throwable
    //   87	92	227	java/lang/Throwable
    //   95	119	227	java/lang/Throwable
    //   122	129	227	java/lang/Throwable
    //   129	140	227	java/lang/Throwable
    //   140	147	227	java/lang/Throwable
    //   155	160	227	java/lang/Throwable
    //   160	187	227	java/lang/Throwable
    //   187	196	227	java/lang/Throwable
    //   201	204	227	java/lang/Throwable
    //   209	218	227	java/lang/Throwable
    //   221	224	227	java/lang/Throwable
    //   229	232	227	java/lang/Throwable
    //   17	26	235	java/lang/NoSuchFieldException
    //   26	47	235	java/lang/NoSuchFieldException
    //   232	235	235	java/lang/NoSuchFieldException
    //   17	26	240	java/lang/IllegalAccessException
    //   26	47	240	java/lang/IllegalAccessException
    //   232	235	240	java/lang/IllegalAccessException
    //   17	26	245	java/lang/ClassNotFoundException
    //   26	47	245	java/lang/ClassNotFoundException
    //   232	235	245	java/lang/ClassNotFoundException
    //   314	321	323	com/google/android/android/dynamite/DynamiteModule$zzc
    //   3	8	368	java/lang/Throwable
    //   17	26	368	java/lang/Throwable
    //   26	47	368	java/lang/Throwable
    //   47	50	368	java/lang/Throwable
    //   196	199	368	java/lang/Throwable
    //   204	207	368	java/lang/Throwable
    //   232	235	368	java/lang/Throwable
    //   247	298	368	java/lang/Throwable
    //   298	303	368	java/lang/Throwable
    //   303	306	368	java/lang/Throwable
    //   369	372	368	java/lang/Throwable
    //   82	87	377	com/google/android/android/dynamite/DynamiteModule$zzc
    //   122	129	382	com/google/android/android/dynamite/DynamiteModule$zzc
    //   140	147	382	com/google/android/android/dynamite/DynamiteModule$zzc
    //   160	187	382	com/google/android/android/dynamite/DynamiteModule$zzc
  }
  
  public static int get(Context paramContext, String paramString, boolean paramBoolean)
    throws DynamiteModule.zzc
  {
    zza localZza = null;
    Object localObject1;
    if (paramBoolean) {
      localObject1 = "api_force_staging";
    } else {
      localObject1 = "api";
    }
    int i;
    try
    {
      i = "content://com.google.android.gms.chimera/".length();
      int j = ((String)localObject1).length();
      int k = String.valueOf(paramString).length();
      Object localObject2 = new StringBuilder(i + 1 + j + k);
      ((StringBuilder)localObject2).append("content://com.google.android.gms.chimera/");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(paramString);
      paramString = Uri.parse(((StringBuilder)localObject2).toString());
      paramContext = paramContext.getContentResolver().query(paramString, null, null, null, null);
      paramString = paramContext;
      if (paramContext != null) {
        try
        {
          paramBoolean = paramContext.moveToFirst();
          if (paramBoolean)
          {
            i = paramContext.getInt(0);
            localObject1 = paramString;
            if (i > 0) {
              try
              {
                zzgpl = paramContext.getString(2);
                localObject1 = zzgpm;
                localObject1 = ((ThreadLocal)localObject1).get();
                localZza = (zza)localObject1;
                localObject1 = paramString;
                if (localZza != null)
                {
                  localObject2 = zzgpv;
                  localObject1 = paramString;
                  if (localObject2 == null)
                  {
                    zzgpv = paramContext;
                    localObject1 = null;
                  }
                }
              }
              catch (Throwable paramString)
              {
                throw paramString;
              }
            }
            if (localObject1 == null) {
              return i;
            }
            ((Cursor)localObject1).close();
            return i;
          }
        }
        catch (Throwable paramString)
        {
          break label290;
        }
        catch (Exception paramString) {}
      }
      paramString = new zzc("Failed to connect to dynamite module ContentResolver.", null);
      throw paramString;
    }
    catch (Throwable paramString)
    {
      paramContext = localZza;
    }
    catch (Exception paramString)
    {
      paramContext = null;
      try
      {
        paramBoolean = paramString instanceof zzc;
        if (paramBoolean) {
          throw paramString;
        }
        throw new zzc("V2 version check failed", paramString, null);
      }
      catch (Throwable paramString) {}
    }
    label290:
    if (paramContext != null) {
      paramContext.close();
    }
    throw paramString;
    return i;
  }
  
  public static Context get(Context paramContext, String paramString, int paramInt, Cursor paramCursor, OkHttpClient paramOkHttpClient)
  {
    try
    {
      paramContext = new Integer(paramContext);
      paramContext = Integer.get(paramOkHttpClient.getAbsoluteUrl(paramContext, paramString, paramInt, new Integer(paramCursor)));
      return (Context)paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = String.valueOf(paramContext.toString());
      if (paramContext.length() != 0) {
        "Failed to load DynamiteLoader: ".concat(paramContext);
      } else {
        new String("Failed to load DynamiteLoader: ");
      }
    }
    return null;
  }
  
  public static DynamiteModule get(Context paramContext, zzd paramZzd, String paramString)
    throws DynamiteModule.zzc
  {
    zza localZza1 = (zza)zzgpm.get();
    zza localZza2 = new zza(null);
    zzgpm.set(localZza2);
    try
    {
      Msg localMsg = paramZzd.getMessage(paramContext, paramString, zzgpn);
      int i = zzgpy;
      int j = zzgpz;
      int k = String.valueOf(paramString).length();
      int m = String.valueOf(paramString).length();
      Object localObject = new StringBuilder(k + 68 + m);
      ((StringBuilder)localObject).append("Considering local module ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" and remote module ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).toString();
      i = zzgqa;
      if (i != 0) {
        if (i == -1)
        {
          i = zzgpy;
          if (i == 0) {}
        }
        else
        {
          i = zzgqa;
          if (i == 1)
          {
            i = zzgpz;
            if (i == 0) {}
          }
          else
          {
            i = zzgqa;
            if (i == -1)
            {
              paramString = zzaf(paramContext, paramString);
              paramZzd = zzgpv;
              paramContext = paramString;
              if (paramZzd != null) {
                paramContext = paramString;
              }
            }
            for (;;)
            {
              paramZzd.close();
              label244:
              zzgpm.set(localZza1);
              return paramContext;
              if (i == 1)
              {
                i = zzgpz;
                try
                {
                  localObject = getObject(paramContext, paramString, i);
                  paramZzd = zzgpv;
                  paramContext = (Context)localObject;
                  if (paramZzd == null) {
                    break label244;
                  }
                  paramContext = (Context)localObject;
                }
                catch (zzc localZzc)
                {
                  String str = String.valueOf(localZzc.getMessage());
                  i = str.length();
                  if (i != 0) {
                    "Failed to load remote module: ".concat(str);
                  } else {
                    new String("Failed to load remote module: ");
                  }
                  i = zzgpy;
                  if (i != 0)
                  {
                    i = getMessagezzb0zzgqa;
                    if (i == -1)
                    {
                      paramZzd = zzaf(paramContext, paramString);
                      paramString = zzgpv;
                      paramContext = paramZzd;
                      if (paramString == null) {
                        break label244;
                      }
                      paramContext = paramZzd;
                      paramZzd = paramString;
                      continue;
                    }
                  }
                  throw new zzc("Remote load failed. No local fallback found.", localZzc, null);
                }
              }
            }
            paramContext = new StringBuilder(47);
            paramContext.append("VersionPolicy returned invalid code:");
            paramContext.append(i);
            throw new zzc(paramContext.toString(), null);
          }
        }
      }
      i = zzgpy;
      j = zzgpz;
      paramContext = new StringBuilder(91);
      paramContext.append("No acceptable module found. Local version is ");
      paramContext.append(i);
      paramContext.append(" and remote version is ");
      paramContext.append(j);
      paramContext.append(".");
      throw new zzc(paramContext.toString(), null);
    }
    catch (Throwable paramContext)
    {
      paramZzd = zzgpv;
      if (paramZzd != null) {
        paramZzd.close();
      }
      zzgpm.set(localZza1);
      throw paramContext;
    }
  }
  
  public static DynamiteModule get(Context paramContext, String paramString, int paramInt)
    throws DynamiteModule.zzc
  {
    Object localObject = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, 51));
    ((StringBuilder)localObject).append("Selected remote version of ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", version >= ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).toString();
    localObject = zzcv(paramContext);
    if (localObject != null) {
      try
      {
        paramContext = ((Array)localObject).getAbsoluteUrl(new Integer(paramContext), paramString, paramInt);
        if (Integer.get(paramContext) != null) {
          return new DynamiteModule((Context)Integer.get(paramContext));
        }
        throw new zzc("Failed to load remote module.", null);
      }
      catch (RemoteException paramContext)
      {
        throw new zzc("Failed to load remote module.", paramContext, null);
      }
    }
    throw new zzc("Failed to create IDynamiteLoader.", null);
  }
  
  public static void get(ClassLoader paramClassLoader)
    throws DynamiteModule.zzc
  {
    try
    {
      paramClassLoader = paramClassLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2");
      paramClassLoader = paramClassLoader.getConstructor(new Class[0]);
      paramClassLoader = paramClassLoader.newInstance(new Object[0]);
      paramClassLoader = (IBinder)paramClassLoader;
      if (paramClassLoader == null)
      {
        paramClassLoader = null;
      }
      else
      {
        IInterface localIInterface = paramClassLoader.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        if ((localIInterface instanceof OkHttpClient)) {
          paramClassLoader = (OkHttpClient)localIInterface;
        } else {
          paramClassLoader = new Utils(paramClassLoader);
        }
      }
      zzgpk = paramClassLoader;
      return;
    }
    catch (NoSuchMethodException paramClassLoader) {}catch (InvocationTargetException paramClassLoader) {}catch (InstantiationException paramClassLoader) {}catch (IllegalAccessException paramClassLoader) {}catch (ClassNotFoundException paramClassLoader) {}
    throw new zzc("Failed to instantiate dynamite loader", (Throwable)paramClassLoader, null);
  }
  
  public static DynamiteModule getInstance(Context paramContext, String paramString, int paramInt)
    throws DynamiteModule.zzc
  {
    Object localObject = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, 51));
    ((StringBuilder)localObject).append("Selected remote version of ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", version >= ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).toString();
    try
    {
      localObject = zzgpk;
      if (localObject != null)
      {
        zza localZza = (zza)zzgpm.get();
        if ((localZza != null) && (zzgpv != null))
        {
          paramContext = get(paramContext.getApplicationContext(), paramString, paramInt, zzgpv, (OkHttpClient)localObject);
          if (paramContext != null) {
            return new DynamiteModule(paramContext);
          }
          throw new zzc("Failed to get module context", null);
        }
        throw new zzc("No result cursor", null);
      }
      throw new zzc("DynamiteLoaderV2 was not cached.", null);
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static DynamiteModule getObject(Context paramContext, String paramString, int paramInt)
    throws DynamiteModule.zzc
  {
    try
    {
      Boolean localBoolean = zzgpi;
      if (localBoolean != null)
      {
        if (localBoolean.booleanValue()) {
          return getInstance(paramContext, paramString, paramInt);
        }
        return get(paramContext, paramString, paramInt);
      }
      throw new zzc("Failed to determine which loading route to use.", null);
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static int insert(Context paramContext, String paramString, boolean paramBoolean)
  {
    Array localArray = zzcv(paramContext);
    if (localArray == null) {
      return 0;
    }
    try
    {
      int i = localArray.insert(new Integer(paramContext), paramString, paramBoolean);
      return i;
    }
    catch (RemoteException paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() != 0)
      {
        "Failed to retrieve remote module version: ".concat(paramContext);
        return 0;
      }
      new String("Failed to retrieve remote module version: ");
    }
    return 0;
  }
  
  public static int zzad(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getApplicationContext().getClassLoader();
      int i = "com.google.android.gms.dynamite.descriptors.".length();
      int j = String.valueOf(paramString).length();
      int k = "ModuleDescriptor".length();
      Object localObject = new StringBuilder(i + 1 + j + k);
      ((StringBuilder)localObject).append("com.google.android.gms.dynamite.descriptors.");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append("ModuleDescriptor");
      localObject = paramContext.loadClass(((StringBuilder)localObject).toString());
      paramContext = ((Class)localObject).getDeclaredField("MODULE_ID");
      localObject = ((Class)localObject).getDeclaredField("MODULE_VERSION");
      boolean bool = paramContext.get(null).equals(paramString);
      if (!bool)
      {
        paramContext = String.valueOf(paramContext.get(null));
        i = paramContext.length();
        j = String.valueOf(paramString).length();
        localObject = new StringBuilder(i + 51 + j);
        ((StringBuilder)localObject).append("Module descriptor id '");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("' didn't match expected id '");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("'");
        ((StringBuilder)localObject).toString();
        return 0;
      }
      i = ((Field)localObject).getInt(null);
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() != 0)
      {
        "Failed to load module descriptor class: ".concat(paramContext);
        return 0;
      }
      new String("Failed to load module descriptor class: ");
      return 0;
      paramContext = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, 45));
      paramContext.append("Local module descriptor class for ");
      paramContext.append(paramString);
      paramContext.append(" not found.");
      paramContext.toString();
      return 0;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;) {}
    }
  }
  
  public static int zzae(Context paramContext, String paramString)
  {
    return create(paramContext, paramString, false);
  }
  
  public static DynamiteModule zzaf(Context paramContext, String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      "Selected local version of ".concat(paramString);
    } else {
      new String("Selected local version of ");
    }
    return new DynamiteModule(paramContext.getApplicationContext());
  }
  
  /* Error */
  public static Array zzcv(Context paramContext)
  {
    // Byte code:
    //   0: ldc 105
    //   2: monitorenter
    //   3: getstatic 464	com/google/android/android/dynamite/DynamiteModule:zzgpj	Lcom/google/android/android/dynamite/Array;
    //   6: ifnull +12 -> 18
    //   9: getstatic 464	com/google/android/android/dynamite/DynamiteModule:zzgpj	Lcom/google/android/android/dynamite/Array;
    //   12: astore_0
    //   13: ldc 105
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: getstatic 470	com/google/android/android/common/PingManager:zzffk	Lcom/google/android/android/common/PingManager;
    //   21: aload_0
    //   22: invokevirtual 474	com/google/android/android/common/PingManager:isGooglePlayServicesAvailable	(Landroid/content/Context;)I
    //   25: ifeq +8 -> 33
    //   28: ldc 105
    //   30: monitorexit
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: ldc -100
    //   36: iconst_3
    //   37: invokevirtual 478	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   40: invokevirtual 115	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   43: ldc_w 480
    //   46: invokevirtual 129	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   49: invokevirtual 482	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   52: astore_0
    //   53: aload_0
    //   54: checkcast 398	android/os/IBinder
    //   57: astore_0
    //   58: aload_0
    //   59: ifnonnull +8 -> 67
    //   62: aconst_null
    //   63: astore_0
    //   64: goto +37 -> 101
    //   67: aload_0
    //   68: ldc_w 484
    //   71: invokeinterface 404 2 0
    //   76: astore_1
    //   77: aload_1
    //   78: instanceof 369
    //   81: ifeq +11 -> 92
    //   84: aload_1
    //   85: checkcast 369	com/google/android/android/dynamite/Array
    //   88: astore_0
    //   89: goto +12 -> 101
    //   92: new 486	com/google/android/android/dynamite/ItemAdapter
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 487	com/google/android/android/dynamite/ItemAdapter:<init>	(Landroid/os/IBinder;)V
    //   100: astore_0
    //   101: aload_0
    //   102: ifnull +50 -> 152
    //   105: aload_0
    //   106: putstatic 464	com/google/android/android/dynamite/DynamiteModule:zzgpj	Lcom/google/android/android/dynamite/Array;
    //   109: ldc 105
    //   111: monitorexit
    //   112: aload_0
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 211	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   119: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 192	java/lang/String:length	()I
    //   127: ifeq +14 -> 141
    //   130: ldc_w 489
    //   133: aload_0
    //   134: invokevirtual 217	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   137: pop
    //   138: goto +14 -> 152
    //   141: new 161	java/lang/String
    //   144: dup
    //   145: ldc_w 489
    //   148: invokespecial 220	java/lang/String:<init>	(Ljava/lang/String;)V
    //   151: pop
    //   152: ldc 105
    //   154: monitorexit
    //   155: aconst_null
    //   156: areturn
    //   157: astore_0
    //   158: ldc 105
    //   160: monitorexit
    //   161: aload_0
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramContext	Context
    //   76	9	1	localIInterface	IInterface
    // Exception table:
    //   from	to	target	type
    //   33	53	114	java/lang/Exception
    //   67	77	114	java/lang/Exception
    //   92	101	114	java/lang/Exception
    //   3	16	157	java/lang/Throwable
    //   18	31	157	java/lang/Throwable
    //   33	53	157	java/lang/Throwable
    //   53	58	157	java/lang/Throwable
    //   67	77	157	java/lang/Throwable
    //   77	89	157	java/lang/Throwable
    //   92	101	157	java/lang/Throwable
    //   105	112	157	java/lang/Throwable
    //   115	138	157	java/lang/Throwable
    //   141	152	157	java/lang/Throwable
    //   152	155	157	java/lang/Throwable
    //   158	161	157	java/lang/Throwable
  }
  
  public final Context zzaog()
  {
    return zzgpu;
  }
  
  public final IBinder zzgv(String paramString)
    throws DynamiteModule.zzc
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a11 = a10\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  @DynamiteApi
  public class DynamiteLoaderClassLoader
  {
    public static ClassLoader sClassLoader;
    
    public DynamiteLoaderClassLoader() {}
  }
  
  public final class zza
  {
    public Cursor zzgpv;
    
    public zza() {}
  }
  
  public final class zzb
    implements Weather
  {
    public final int zzgpw;
    public final int zzgpx;
    
    public zzb(int paramInt)
    {
      zzgpw = this$1;
      zzgpx = 0;
    }
    
    public final int getLocation(Context paramContext, String paramString, boolean paramBoolean)
    {
      return 0;
    }
    
    public final int zzad(Context paramContext, String paramString)
    {
      return zzgpw;
    }
  }
  
  public final class zzc
    extends Exception
  {
    public zzc()
    {
      super();
    }
    
    public zzc(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  public abstract interface zzd
  {
    public abstract Msg getMessage(Context paramContext, String paramString, Weather paramWeather)
      throws DynamiteModule.zzc;
  }
}
