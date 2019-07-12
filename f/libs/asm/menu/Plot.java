package f.libs.asm.menu;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l.a.a.a.Log;
import l.a.a.a.f;

public class Plot
{
  public static final short[] a = { 10, 20, 30, 60, 120, 300 };
  public static final Map<String, String> next = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
  public final String c;
  public final j d;
  public final Object e = new Object();
  public final Qa.c f;
  public Thread g;
  public final Qa.b j;
  
  public Plot(String paramString, j paramJ, Qa.c paramC, Qa.b paramB)
  {
    if (paramJ != null)
    {
      d = paramJ;
      c = paramString;
      f = paramC;
      j = paramB;
      return;
    }
    throw new IllegalArgumentException("createReportCall must not be null.");
  }
  
  public void a(float paramFloat, Qa.d paramD)
  {
    try
    {
      if (g != null)
      {
        f.get().d("CrashlyticsCore", "Report upload has already been started.");
        return;
      }
      g = new Thread(new Qa.e(this, paramFloat, paramD), "Crashlytics Report Uploader");
      g.start();
      return;
    }
    catch (Throwable paramD)
    {
      throw paramD;
    }
  }
  
  /* Error */
  public boolean a(p paramP)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	f/libs/asm/menu/Plot:e	Ljava/lang/Object;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: iconst_0
    //   10: istore_3
    //   11: aload_0
    //   12: getfield 64	f/libs/asm/menu/Plot:c	Ljava/lang/String;
    //   15: astore 5
    //   17: new 117	f/libs/asm/menu/Handle
    //   20: dup
    //   21: aload 5
    //   23: aload_1
    //   24: invokespecial 120	f/libs/asm/menu/Handle:<init>	(Ljava/lang/String;Lf/libs/asm/menu/p;)V
    //   27: astore 5
    //   29: aload_0
    //   30: getfield 62	f/libs/asm/menu/Plot:d	Lf/libs/asm/menu/j;
    //   33: astore 7
    //   35: aload 7
    //   37: aload 5
    //   39: invokeinterface 125 2 0
    //   44: istore 4
    //   46: invokestatic 90	l/a/a/a/f:get	()Ll/a/a/a/Log;
    //   49: astore 7
    //   51: new 127	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   58: astore 8
    //   60: aload 8
    //   62: ldc -126
    //   64: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: iload 4
    //   70: ifeq +10 -> 80
    //   73: ldc -120
    //   75: astore 5
    //   77: goto +7 -> 84
    //   80: ldc -118
    //   82: astore 5
    //   84: aload 8
    //   86: aload 5
    //   88: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 8
    //   94: aload_1
    //   95: invokeinterface 143 1 0
    //   100: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 7
    //   106: ldc 92
    //   108: aload 8
    //   110: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokeinterface 149 3 0
    //   118: iload_3
    //   119: istore_2
    //   120: iload 4
    //   122: ifeq +67 -> 189
    //   125: aload_1
    //   126: invokeinterface 152 1 0
    //   131: iconst_1
    //   132: istore_2
    //   133: goto +56 -> 189
    //   136: astore_1
    //   137: goto +57 -> 194
    //   140: astore 5
    //   142: invokestatic 90	l/a/a/a/f:get	()Ll/a/a/a/Log;
    //   145: astore 7
    //   147: new 127	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   154: astore 8
    //   156: aload 8
    //   158: ldc -102
    //   160: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 8
    //   166: aload_1
    //   167: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 7
    //   173: ldc 92
    //   175: aload 8
    //   177: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: aload 5
    //   182: invokeinterface 160 4 0
    //   187: iload_3
    //   188: istore_2
    //   189: aload 6
    //   191: monitorexit
    //   192: iload_2
    //   193: ireturn
    //   194: aload 6
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	Plot
    //   0	199	1	paramP	p
    //   119	74	2	bool1	boolean
    //   10	178	3	bool2	boolean
    //   44	77	4	bool3	boolean
    //   15	72	5	localObject1	Object
    //   140	41	5	localException	Exception
    //   4	191	6	localObject2	Object
    //   33	139	7	localObject3	Object
    //   58	118	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	17	136	java/lang/Throwable
    //   17	29	136	java/lang/Throwable
    //   29	35	136	java/lang/Throwable
    //   35	51	136	java/lang/Throwable
    //   51	68	136	java/lang/Throwable
    //   84	118	136	java/lang/Throwable
    //   125	131	136	java/lang/Throwable
    //   142	187	136	java/lang/Throwable
    //   189	192	136	java/lang/Throwable
    //   194	197	136	java/lang/Throwable
    //   17	29	140	java/lang/Exception
    //   35	51	140	java/lang/Exception
    //   51	68	140	java/lang/Exception
    //   84	118	140	java/lang/Exception
    //   125	131	140	java/lang/Exception
  }
  
  public boolean b()
  {
    return g != null;
  }
  
  public List doInBackground()
  {
    f.get().d("CrashlyticsCore", "Checking for crash reports...");
    Object localObject1 = e;
    try
    {
      Object localObject3 = f.getFile();
      Object localObject2 = f.listFiles();
      File[] arrayOfFile = f.get();
      localObject1 = new LinkedList();
      int k = 0;
      int m;
      int i;
      Object localObject4;
      Object localObject5;
      StringBuilder localStringBuilder;
      if (localObject3 != null)
      {
        m = localObject3.length;
        i = 0;
        while (i < m)
        {
          localObject4 = localObject3[i];
          localObject5 = f.get();
          localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Found crash report ");
          localStringBuilder.append(((File)localObject4).getPath());
          ((Log)localObject5).d("CrashlyticsCore", localStringBuilder.toString());
          ((List)localObject1).add(new Segment((File)localObject4));
          i += 1;
        }
      }
      localObject3 = new HashMap();
      if (localObject2 != null)
      {
        m = localObject2.length;
        i = 0;
        while (i < m)
        {
          localObject4 = localObject2[i];
          localObject5 = ClassWriter.get((File)localObject4);
          if (!((Map)localObject3).containsKey(localObject5)) {
            ((Map)localObject3).put(localObject5, new LinkedList());
          }
          ((List)((Map)localObject3).get(localObject5)).add(localObject4);
          i += 1;
        }
      }
      localObject2 = ((Map)localObject3).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        localObject5 = f.get();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Found invalid session: ");
        localStringBuilder.append((String)localObject4);
        ((Log)localObject5).d("CrashlyticsCore", localStringBuilder.toString());
        localObject5 = (List)((Map)localObject3).get(localObject4);
        ((List)localObject1).add(new DynamicTableModel.a((String)localObject4, (File[])((List)localObject5).toArray(new File[((List)localObject5).size()])));
      }
      if (arrayOfFile != null)
      {
        m = arrayOfFile.length;
        i = k;
        while (i < m)
        {
          ((List)localObject1).add(new ActivatingIterator(arrayOfFile[i]));
          i += 1;
        }
      }
      if (((List)localObject1).isEmpty())
      {
        f.get().d("CrashlyticsCore", "No reports found.");
        return localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
    return localObject1;
  }
}
