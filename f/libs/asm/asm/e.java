package f.libs.asm.asm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import l.a.a.a.Log;
import l.a.a.a.a.b.ClassReader;
import l.a.a.a.a.b.Label;
import l.a.a.a.a.b.MethodVisitor;
import l.a.a.a.a.b.o;
import l.a.a.a.n;

public class e
  extends n<Boolean>
{
  public static final String e = "Answers";
  public static final String g = "com.crashlytics.ApiEndpoint";
  public f b;
  public boolean c = false;
  
  public e() {}
  
  public static e a()
  {
    return (e)l.a.a.a.f.add(f.c.a.a.b.class);
  }
  
  private void a(String paramString)
  {
    Log localLog = l.a.a.a.f.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Method ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is not supported when using Crashlytics through Firebase.");
    localLog.remove("Answers", localStringBuilder.toString());
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer != null)
    {
      if (c)
      {
        a("logPurchase");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramByteBuffer);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(Document paramDocument)
  {
    if (paramDocument != null)
    {
      if (c)
      {
        a("logInvite");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramDocument);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(ExtensionData paramExtensionData)
  {
    if (paramExtensionData != null)
    {
      if (c)
      {
        a("logLevelEnd");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramExtensionData);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(FieldWriter paramFieldWriter)
  {
    if (paramFieldWriter != null)
    {
      if (c)
      {
        a("logLevelStart");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramFieldWriter);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(File paramFile)
  {
    if (paramFile != null)
    {
      if (c)
      {
        a("logShare");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramFile);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(Handler paramHandler)
  {
    if (paramHandler != null)
    {
      if (c)
      {
        a("logSignUp");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramHandler);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(Item paramItem)
  {
    if (paramItem != null)
    {
      if (c)
      {
        a("logAddToCart");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramItem);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(SerializedGraph paramSerializedGraph)
  {
    if (paramSerializedGraph != null)
    {
      if (c)
      {
        a("logContentView");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramSerializedGraph);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(Subsequence paramSubsequence)
  {
    if (paramSubsequence != null)
    {
      if (c)
      {
        a("logRating");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramSubsequence);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(ac paramAc)
  {
    if (paramAc != null)
    {
      if (c)
      {
        a("logLogin");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramAc);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(g paramG)
  {
    if (paramG != null)
    {
      if (c)
      {
        a("logStartCheckout");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramG);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(q paramQ)
  {
    if (paramQ != null)
    {
      if (c)
      {
        a("logCustom");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramQ);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(t paramT)
  {
    if (paramT != null)
    {
      if (c)
      {
        a("logSearch");
        return;
      }
      f localF = b;
      if (localF != null) {
        localF.a(paramT);
      }
    }
    else
    {
      throw new NullPointerException("event must not be null");
    }
  }
  
  public void a(MethodVisitor paramMethodVisitor)
  {
    f localF = b;
    if (localF != null) {
      localF.b(paramMethodVisitor.a());
    }
  }
  
  public String b()
  {
    return l.a.a.a.a.b.ClassWriter.a(getContext(), "com.crashlytics.ApiEndpoint");
  }
  
  public void b(o paramO)
  {
    f localF = b;
    if (localF != null) {
      localF.a(paramO.a(), paramO.readUTF8());
    }
  }
  
  public String c()
  {
    return "1.4.7.32";
  }
  
  public String getId()
  {
    return "com.crashlytics.sdk.android:answers";
  }
  
  public boolean onCreate()
  {
    try
    {
      Context localContext = getContext();
      PackageInfo localPackageInfo = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0);
      int i = versionCode;
      String str2 = Integer.toString(i);
      String str1 = versionName;
      Object localObject = str1;
      if (str1 == null) {
        localObject = "0.0";
      }
      i = Build.VERSION.SDK_INT;
      long l = firstInstallTime;
      localObject = f.a(this, localContext, getName(), str2, (String)localObject, l);
      b = ((f)localObject);
      localObject = b;
      ((f)localObject).a();
      boolean bool = new l.a.a.a.a.b.h().a(localContext);
      c = bool;
      return true;
    }
    catch (Exception localException)
    {
      l.a.a.a.f.get().d("Answers", "Error retrieving app properties", localException);
    }
    return false;
  }
  
  public Boolean run()
  {
    boolean bool = Label.a(getContext()).a();
    Boolean localBoolean = Boolean.valueOf(false);
    if (!bool)
    {
      l.a.a.a.f.get().d("Fabric", "Analytics collection disabled, because data collection is disabled by Firebase.");
      b.c();
      return localBoolean;
    }
    try
    {
      Object localObject = l.a.a.a.a.g.h.c().b();
      if (localObject == null)
      {
        l.a.a.a.f.get().e("Answers", "Failed to retrieve settings");
        return localBoolean;
      }
      if (b.r)
      {
        l.a.a.a.f.get().d("Answers", "Analytics collection enabled");
        localF = b;
        localObject = c;
        localF.a((l.a.a.a.a.g.b)localObject, b());
        return Boolean.valueOf(true);
      }
      l.a.a.a.f.get().d("Answers", "Analytics collection disabled");
      f localF = b;
      localF.c();
      return localBoolean;
    }
    catch (Exception localException)
    {
      l.a.a.a.f.get().d("Answers", "Error dealing with settings", localException);
    }
    return localBoolean;
  }
}
