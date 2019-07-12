package f.libs.asm.menu;

import android.app.ActivityManager.RunningAppProcessInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import l.a.a.a.Log;
import l.a.a.a.a.b.y.a;
import l.a.a.a.f;

public class Handler
{
  public static final Label a = Label.a("0");
  public static final Label b = Label.a("Unity");
  public static final String d = "0";
  
  public Handler() {}
  
  public static int a()
  {
    int i = ByteVector.write(1, a);
    int j = ByteVector.write(2, a);
    return ByteVector.add(3, 0L) + (j + (i + 0));
  }
  
  public static int a(Label paramLabel)
  {
    return ByteVector.write(1, paramLabel);
  }
  
  public static int a(Label paramLabel1, Label paramLabel2)
  {
    int i = ByteVector.add(1, 0L);
    int j = ByteVector.add(2, 0L);
    j = ByteVector.write(3, paramLabel1) + (j + (i + 0));
    i = j;
    if (paramLabel2 != null) {
      i = j + ByteVector.write(4, paramLabel2);
    }
    return i;
  }
  
  public static int a(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, Label paramLabel5, int paramInt, Label paramLabel6)
  {
    int i = ByteVector.write(1, paramLabel1);
    int j = ByteVector.write(2, paramLabel3);
    int k = ByteVector.write(3, paramLabel4);
    int m = add(paramLabel2);
    int n = ByteVector.get(5);
    int i1 = ByteVector.a(m);
    j = ByteVector.write(6, paramLabel5) + (i1 + n + m + (k + (j + (i + 0))));
    i = j;
    if (paramLabel6 != null)
    {
      i = ByteVector.write(8, b);
      i = ByteVector.write(9, paramLabel6) + (i + j);
    }
    return ByteVector.a(10, paramInt) + i;
  }
  
  public static int a(Label paramLabel1, Label paramLabel2, boolean paramBoolean)
  {
    int i = ByteVector.a(1, 3);
    int j = ByteVector.write(2, paramLabel1);
    int k = ByteVector.write(3, paramLabel2);
    return ByteVector.add(4, paramBoolean) + (k + (j + (i + 0)));
  }
  
  public static int a(o paramO, int paramInt1, int paramInt2)
  {
    int i = ByteVector.write(1, Label.a(a));
    int k = 0;
    int j = i + 0;
    Object localObject = d;
    i = j;
    if (localObject != null) {
      i = j + ByteVector.write(3, Label.a((String)localObject));
    }
    localObject = c;
    int m = localObject.length;
    j = 0;
    while (j < m)
    {
      int n = a(localObject[j], true);
      int i1 = ByteVector.get(4);
      i += ByteVector.a(n) + i1 + n;
      j += 1;
    }
    localObject = b;
    if (localObject != null)
    {
      j = k;
      paramO = (o)localObject;
      if (paramInt1 < paramInt2)
      {
        paramInt1 = a((o)localObject, paramInt1 + 1, paramInt2);
        paramInt2 = ByteVector.get(6);
        return i + (ByteVector.a(paramInt1) + paramInt2 + paramInt1);
      }
      while (paramO != null)
      {
        paramO = b;
        j += 1;
      }
      return i + ByteVector.write(7, j);
    }
    return i;
  }
  
  public static int a(o paramO, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List paramList, int paramInt, Label paramLabel1, Label paramLabel2)
  {
    int i = a(paramThread, paramArrayOfStackTraceElement, 4, true);
    int j = ByteVector.get(1);
    int m = ByteVector.a(i);
    int k = paramArrayOfThread.length;
    i = m + j + i + 0;
    j = 0;
    while (j < k)
    {
      m = a(paramArrayOfThread[j], (StackTraceElement[])paramList.get(j), 0, false);
      n = ByteVector.get(1);
      i += ByteVector.a(m) + n + m;
      j += 1;
    }
    paramInt = a(paramO, 1, paramInt);
    j = ByteVector.get(2);
    k = ByteVector.a(paramInt);
    m = a();
    int n = ByteVector.get(3);
    int i1 = ByteVector.a(m);
    int i2 = a(paramLabel1, paramLabel2);
    int i3 = ByteVector.get(3);
    return ByteVector.a(i2) + i3 + i2 + (i1 + n + m + (k + j + paramInt + i));
  }
  
  public static int a(o paramO, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List paramList, int paramInt1, Label paramLabel1, Label paramLabel2, Map paramMap, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt2)
  {
    paramInt1 = a(paramO, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramLabel1, paramLabel2);
    int i = ByteVector.get(1);
    int j = ByteVector.a(paramInt1);
    boolean bool = false;
    paramInt1 = j + i + paramInt1 + 0;
    i = paramInt1;
    if (paramMap != null)
    {
      paramO = paramMap.entrySet().iterator();
      for (;;)
      {
        i = paramInt1;
        if (!paramO.hasNext()) {
          break;
        }
        paramThread = (Map.Entry)paramO.next();
        i = a((String)paramThread.getKey(), (String)paramThread.getValue());
        j = ByteVector.get(2);
        paramInt1 += ByteVector.a(i) + j + i;
      }
    }
    paramInt1 = i;
    if (paramRunningAppProcessInfo != null)
    {
      if (importance != 100) {
        bool = true;
      }
      paramInt1 = i + ByteVector.add(3, bool);
    }
    return ByteVector.write(4, paramInt2) + paramInt1;
  }
  
  public static int a(Float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
  {
    int i = 0;
    if (paramFloat != null) {
      i = 0 + ByteVector.a(1, paramFloat.floatValue());
    }
    paramInt1 = ByteVector.read(2, paramInt1);
    int j = ByteVector.add(3, paramBoolean);
    paramInt2 = ByteVector.write(4, paramInt2);
    int k = ByteVector.add(5, paramLong1);
    return ByteVector.add(6, paramLong2) + (k + (paramInt2 + (j + (paramInt1 + i))));
  }
  
  public static int a(StackTraceElement paramStackTraceElement, boolean paramBoolean)
  {
    boolean bool = paramStackTraceElement.isNativeMethod();
    int k = 0;
    if (bool) {
      i = ByteVector.add(1, Math.max(paramStackTraceElement.getLineNumber(), 0));
    } else {
      i = ByteVector.add(1, 0L);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStackTraceElement.getClassName());
    localStringBuilder.append(".");
    localStringBuilder.append(paramStackTraceElement.getMethodName());
    int j = ByteVector.write(2, Label.a(localStringBuilder.toString())) + (i + 0);
    int i = j;
    if (paramStackTraceElement.getFileName() != null) {
      i = j + ByteVector.write(3, Label.a(paramStackTraceElement.getFileName()));
    }
    j = i;
    if (!paramStackTraceElement.isNativeMethod())
    {
      j = i;
      if (paramStackTraceElement.getLineNumber() > 0) {
        j = i + ByteVector.add(4, paramStackTraceElement.getLineNumber());
      }
    }
    i = k;
    if (paramBoolean) {
      i = 2;
    }
    return ByteVector.write(5, i) + j;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i = ByteVector.write(1, Label.a(paramString1));
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    return ByteVector.write(2, Label.a(paramString1)) + i;
  }
  
  public static int a(Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
  {
    int i = ByteVector.write(1, Label.a(paramThread.getName()));
    i = ByteVector.write(2, paramInt) + i;
    int j = paramArrayOfStackTraceElement.length;
    paramInt = 0;
    while (paramInt < j)
    {
      int k = a(paramArrayOfStackTraceElement[paramInt], paramBoolean);
      int m = ByteVector.get(3);
      i += ByteVector.a(k) + m + k;
      paramInt += 1;
    }
    return i;
  }
  
  public static int a(y.a paramA, String paramString)
  {
    int i = ByteVector.a(1, paramA.i);
    return ByteVector.write(2, Label.a(paramString)) + i;
  }
  
  public static Label a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Label.a(paramString);
  }
  
  public static void a(ByteVector paramByteVector, int paramInt, StackTraceElement paramStackTraceElement, boolean paramBoolean)
    throws Exception
  {
    paramByteVector.add(paramInt, 2);
    paramByteVector.add(a(paramStackTraceElement, paramBoolean));
    if (paramStackTraceElement.isNativeMethod()) {
      paramByteVector.write(1, Math.max(paramStackTraceElement.getLineNumber(), 0));
    } else {
      paramByteVector.write(1, 0L);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStackTraceElement.getClassName());
    localStringBuilder.append(".");
    localStringBuilder.append(paramStackTraceElement.getMethodName());
    paramByteVector.add(2, Label.a(localStringBuilder.toString()));
    if (paramStackTraceElement.getFileName() != null) {
      paramByteVector.add(3, Label.a(paramStackTraceElement.getFileName()));
    }
    boolean bool = paramStackTraceElement.isNativeMethod();
    paramInt = 4;
    if ((!bool) && (paramStackTraceElement.getLineNumber() > 0)) {
      paramByteVector.write(4, paramStackTraceElement.getLineNumber());
    }
    if (!paramBoolean) {
      paramInt = 0;
    }
    paramByteVector.put(5, paramInt);
  }
  
  public static void a(ByteVector paramByteVector, int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, Map paramMap, int paramInt3, String paramString2, String paramString3)
    throws Exception
  {
    Label localLabel = a(paramString1);
    paramString1 = a(paramString3);
    paramString2 = a(paramString2);
    paramByteVector.add(9, 2);
    paramByteVector.add(write(paramInt1, localLabel, paramInt2, paramLong1, paramLong2, paramBoolean, paramMap, paramInt3, paramString2, paramString1));
    paramByteVector.get(3, paramInt1);
    paramByteVector.add(4, localLabel);
    paramByteVector.put(5, paramInt2);
    paramByteVector.write(6, paramLong1);
    paramByteVector.write(7, paramLong2);
    paramByteVector.put(10, paramBoolean);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      paramString3 = (Map.Entry)paramMap.next();
      paramByteVector.add(11, 2);
      paramByteVector.add(a((y.a)paramString3.getKey(), (String)paramString3.getValue()));
      paramByteVector.get(1, getKeyi);
      paramByteVector.add(2, Label.a((String)paramString3.getValue()));
    }
    paramByteVector.put(12, paramInt3);
    if (paramString2 != null) {
      paramByteVector.add(13, paramString2);
    }
    if (paramString1 != null) {
      paramByteVector.add(14, paramString1);
    }
  }
  
  public static void a(ByteVector paramByteVector, long paramLong1, String paramString1, o paramO, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List paramList, Map paramMap, b paramB, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt1, String paramString2, String paramString3, Float paramFloat, int paramInt2, boolean paramBoolean, long paramLong2, long paramLong3)
    throws Exception
  {
    Label localLabel = Label.a(paramString2);
    if (paramString3 == null) {
      paramString2 = null;
    } else {
      paramString2 = Label.a(paramString3.replace("-", ""));
    }
    paramString3 = paramB.a();
    if (paramString3 == null) {
      f.get().d("CrashlyticsCore", "No log data to include with this event.");
    }
    paramB.d();
    paramByteVector.add(10, 2);
    paramByteVector.add(add(paramLong1, paramString1, paramO, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, 8, paramMap, paramRunningAppProcessInfo, paramInt1, localLabel, paramString2, paramFloat, paramInt2, paramBoolean, paramLong2, paramLong3, paramString3));
    paramByteVector.write(1, paramLong1);
    paramByteVector.add(2, Label.a(paramString1));
    a(paramByteVector, paramO, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, 8, localLabel, paramString2, paramMap, paramRunningAppProcessInfo, paramInt1);
    a(paramByteVector, paramFloat, paramInt2, paramBoolean, paramInt1, paramLong2, paramLong3);
    a(paramByteVector, paramString3);
  }
  
  public static void a(ByteVector paramByteVector, Label paramLabel)
    throws Exception
  {
    if (paramLabel != null)
    {
      paramByteVector.add(6, 2);
      paramByteVector.add(a(paramLabel));
      paramByteVector.add(1, paramLabel);
    }
  }
  
  public static void a(ByteVector paramByteVector, o paramO, int paramInt1, int paramInt2, int paramInt3)
    throws Exception
  {
    paramByteVector.add(paramInt3, 2);
    paramByteVector.add(a(paramO, 1, paramInt2));
    paramByteVector.add(1, Label.a(a));
    Object localObject = d;
    if (localObject != null) {
      paramByteVector.add(3, Label.a((String)localObject));
    }
    localObject = c;
    int j = localObject.length;
    int i = 0;
    paramInt3 = 0;
    while (paramInt3 < j)
    {
      a(paramByteVector, 4, localObject[paramInt3], true);
      paramInt3 += 1;
    }
    localObject = b;
    if (localObject != null)
    {
      paramInt3 = i;
      paramO = (o)localObject;
      if (paramInt1 < paramInt2)
      {
        a(paramByteVector, (o)localObject, paramInt1 + 1, paramInt2, 6);
        return;
      }
      while (paramO != null)
      {
        paramO = b;
        paramInt3 += 1;
      }
      paramByteVector.put(7, paramInt3);
    }
  }
  
  public static void a(ByteVector paramByteVector, o paramO, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List paramList, int paramInt, Label paramLabel1, Label paramLabel2)
    throws Exception
  {
    paramByteVector.add(1, 2);
    paramByteVector.add(a(paramO, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt, paramLabel1, paramLabel2));
    a(paramByteVector, paramThread, paramArrayOfStackTraceElement, 4, true);
    int j = paramArrayOfThread.length;
    int i = 0;
    while (i < j)
    {
      a(paramByteVector, paramArrayOfThread[i], (StackTraceElement[])paramList.get(i), 0, false);
      i += 1;
    }
    a(paramByteVector, paramO, 1, paramInt, 2);
    paramByteVector.add(3, 2);
    paramByteVector.add(a());
    paramByteVector.add(1, a);
    paramByteVector.add(2, a);
    paramByteVector.write(3, 0L);
    paramByteVector.add(4, 2);
    paramByteVector.add(a(paramLabel1, paramLabel2));
    paramByteVector.write(1, 0L);
    paramByteVector.write(2, 0L);
    paramByteVector.add(3, paramLabel1);
    if (paramLabel2 != null) {
      paramByteVector.add(4, paramLabel2);
    }
  }
  
  public static void a(ByteVector paramByteVector, o paramO, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List paramList, int paramInt1, Label paramLabel1, Label paramLabel2, Map paramMap, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt2)
    throws Exception
  {
    paramByteVector.add(3, 2);
    paramByteVector.add(a(paramO, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramLabel1, paramLabel2, paramMap, paramRunningAppProcessInfo, paramInt2));
    a(paramByteVector, paramO, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramLabel1, paramLabel2);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      a(paramByteVector, paramMap);
    }
    if (paramRunningAppProcessInfo != null)
    {
      boolean bool;
      if (importance != 100) {
        bool = true;
      } else {
        bool = false;
      }
      paramByteVector.put(3, bool);
    }
    paramByteVector.put(4, paramInt2);
  }
  
  public static void a(ByteVector paramByteVector, Float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
    throws Exception
  {
    paramByteVector.add(5, 2);
    paramByteVector.add(a(paramFloat, paramInt1, paramBoolean, paramInt2, paramLong1, paramLong2));
    if (paramFloat != null) {
      paramByteVector.add(1, paramFloat.floatValue());
    }
    paramByteVector.putInt(2, paramInt1);
    paramByteVector.put(3, paramBoolean);
    paramByteVector.put(4, paramInt2);
    paramByteVector.write(5, paramLong1);
    paramByteVector.write(6, paramLong2);
  }
  
  public static void a(ByteVector paramByteVector, String paramString1, String paramString2, long paramLong)
    throws Exception
  {
    paramByteVector.add(1, Label.a(paramString2));
    paramByteVector.add(2, Label.a(paramString1));
    paramByteVector.write(3, paramLong);
  }
  
  public static void a(ByteVector paramByteVector, String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    paramString1 = Label.a((String)localObject);
    localObject = a(paramString2);
    Label localLabel = a(paramString3);
    int j = ByteVector.write(1, paramString1) + 0;
    int i = j;
    if (paramString2 != null) {
      i = j + ByteVector.write(2, (Label)localObject);
    }
    j = i;
    if (paramString3 != null) {
      j = i + ByteVector.write(3, localLabel);
    }
    paramByteVector.add(6, 2);
    paramByteVector.add(j);
    paramByteVector.add(1, paramString1);
    if (paramString2 != null) {
      paramByteVector.add(2, (Label)localObject);
    }
    if (paramString3 != null) {
      paramByteVector.add(3, localLabel);
    }
  }
  
  public static void a(ByteVector paramByteVector, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
    throws Exception
  {
    Label localLabel = Label.a(paramString1);
    paramString2 = Label.a(paramString2);
    paramString3 = Label.a(paramString3);
    paramString4 = Label.a(paramString4);
    paramString5 = Label.a(paramString5);
    if (paramString6 != null) {
      paramString1 = Label.a(paramString6);
    } else {
      paramString1 = null;
    }
    paramByteVector.add(7, 2);
    paramByteVector.add(a(localLabel, paramString2, paramString3, paramString4, paramString5, paramInt, paramString1));
    paramByteVector.add(1, localLabel);
    paramByteVector.add(2, paramString3);
    paramByteVector.add(3, paramString4);
    paramByteVector.add(5, 2);
    paramByteVector.add(add(paramString2));
    paramByteVector.add(1, paramString2);
    paramByteVector.add(6, paramString5);
    if (paramString1 != null)
    {
      paramByteVector.add(8, b);
      paramByteVector.add(9, paramString1);
    }
    paramByteVector.get(10, paramInt);
  }
  
  public static void a(ByteVector paramByteVector, String paramString1, String paramString2, boolean paramBoolean)
    throws Exception
  {
    paramString1 = Label.a(paramString1);
    paramString2 = Label.a(paramString2);
    paramByteVector.add(8, 2);
    paramByteVector.add(a(paramString1, paramString2, paramBoolean));
    paramByteVector.get(1, 3);
    paramByteVector.add(2, paramString1);
    paramByteVector.add(3, paramString2);
    paramByteVector.put(4, paramBoolean);
  }
  
  public static void a(ByteVector paramByteVector, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
    throws Exception
  {
    paramByteVector.add(1, 2);
    paramByteVector.add(a(paramThread, paramArrayOfStackTraceElement, paramInt, paramBoolean));
    paramByteVector.add(1, Label.a(paramThread.getName()));
    paramByteVector.put(2, paramInt);
    int i = paramArrayOfStackTraceElement.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramByteVector, 3, paramArrayOfStackTraceElement[paramInt], paramBoolean);
      paramInt += 1;
    }
  }
  
  public static void a(ByteVector paramByteVector, Map paramMap)
    throws Exception
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      paramByteVector.add(2, 2);
      paramByteVector.add(a((String)paramMap.getKey(), (String)paramMap.getValue()));
      paramByteVector.add(1, Label.a((String)paramMap.getKey()));
      String str = (String)paramMap.getValue();
      paramMap = str;
      if (str == null) {
        paramMap = "";
      }
      paramByteVector.add(2, Label.a(paramMap));
    }
  }
  
  public static int add(long paramLong1, String paramString, o paramO, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, Thread[] paramArrayOfThread, List paramList, int paramInt1, Map paramMap, ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, int paramInt2, Label paramLabel1, Label paramLabel2, Float paramFloat, int paramInt3, boolean paramBoolean, long paramLong2, long paramLong3, Label paramLabel3)
  {
    int i = ByteVector.add(1, paramLong1);
    int j = ByteVector.write(2, Label.a(paramString));
    paramInt1 = a(paramO, paramThread, paramArrayOfStackTraceElement, paramArrayOfThread, paramList, paramInt1, paramLabel1, paramLabel2, paramMap, paramRunningAppProcessInfo, paramInt2);
    int k = ByteVector.get(3);
    int m = ByteVector.a(paramInt1);
    paramInt2 = a(paramFloat, paramInt3, paramBoolean, paramInt2, paramLong2, paramLong3);
    paramInt3 = ByteVector.get(5);
    paramInt2 = ByteVector.a(paramInt2) + paramInt3 + paramInt2 + (m + k + paramInt1 + (j + (i + 0)));
    paramInt1 = paramInt2;
    if (paramLabel3 != null)
    {
      paramInt1 = a(paramLabel3);
      paramInt3 = ByteVector.get(6);
      paramInt1 = paramInt2 + (ByteVector.a(paramInt1) + paramInt3 + paramInt1);
    }
    return paramInt1;
  }
  
  public static int add(Label paramLabel)
  {
    return ByteVector.write(1, paramLabel) + 0;
  }
  
  public static int write(int paramInt1, Label paramLabel1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, Map paramMap, int paramInt3, Label paramLabel2, Label paramLabel3)
  {
    int j = ByteVector.a(3, paramInt1);
    int i = 0;
    if (paramLabel1 == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = ByteVector.write(4, paramLabel1);
    }
    paramInt2 = ByteVector.write(5, paramInt2);
    int k = ByteVector.add(6, paramLong1);
    int m = ByteVector.add(7, paramLong2);
    paramInt1 = ByteVector.add(10, paramBoolean) + (m + (k + (paramInt2 + (j + 0 + paramInt1))));
    paramInt2 = paramInt1;
    if (paramMap != null)
    {
      paramLabel1 = paramMap.entrySet().iterator();
      for (;;)
      {
        paramInt2 = paramInt1;
        if (!paramLabel1.hasNext()) {
          break;
        }
        paramMap = (Map.Entry)paramLabel1.next();
        paramInt2 = a((y.a)paramMap.getKey(), (String)paramMap.getValue());
        j = ByteVector.get(11);
        paramInt1 += ByteVector.a(paramInt2) + j + paramInt2;
      }
    }
    j = ByteVector.write(12, paramInt3);
    if (paramLabel2 == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = ByteVector.write(13, paramLabel2);
    }
    if (paramLabel3 == null) {
      paramInt3 = i;
    } else {
      paramInt3 = ByteVector.write(14, paramLabel3);
    }
    return j + paramInt2 + paramInt1 + paramInt3;
  }
}
