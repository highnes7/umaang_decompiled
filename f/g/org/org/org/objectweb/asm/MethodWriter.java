package f.g.org.org.org.objectweb.asm;

import f.g.b.a.c.F;
import f.g.b.a.d.d;
import f.g.b.a.g.h;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

@h
public class MethodWriter
{
  public static final String A = "https://developers.google.com/accounts/docs/application-default-credentials";
  public static final String T = "application_default_credentials.json";
  public static final String descriptor = "GOOGLE_APPLICATION_CREDENTIALS";
  public static final String e = "com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper";
  public static final String t = "gcloud";
  public boolean c = false;
  public f j = null;
  public boolean s = false;
  
  public MethodWriter() {}
  
  private final File a()
  {
    File localFile;
    if (getProperty("os.name", "").toLowerCase(Locale.US).indexOf("windows") >= 0) {
      localFile = new File(new File(replace("APPDATA")), "gcloud");
    } else {
      localFile = new File(new File(getProperty("user.home", ""), ".config"), "gcloud");
    }
    return new File(localFile, "application_default_credentials.json");
  }
  
  private final f b(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a9 = a8\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private final f c(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
  {
    if (s) {
      return null;
    }
    boolean bool = ClassWriter.execute(paramHttpTransport);
    s = true;
    if (bool) {
      return new a(paramHttpTransport, paramJsonFactory);
    }
    return null;
  }
  
  private final f execute(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
    throws IOException
  {
    if (c) {
      return null;
    }
    boolean bool = execute();
    c = true;
    if (!bool) {
      return null;
    }
    try
    {
      Object localObject = forName("com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper");
      localObject = ((Class)localObject).getConstructor(new Class[] { F.class, d.class });
      paramHttpTransport = ((Constructor)localObject).newInstance(new Object[] { paramHttpTransport, paramJsonFactory });
      return (f)paramHttpTransport;
    }
    catch (InvocationTargetException paramHttpTransport) {}catch (IllegalAccessException paramHttpTransport) {}catch (InstantiationException paramHttpTransport) {}catch (NoSuchMethodException paramHttpTransport) {}catch (ClassNotFoundException paramHttpTransport) {}
    paramJsonFactory = new IOException(String.format("Application Default Credentials failed to create the Google App Engine service account credentials class %s. Check that the component 'google-api-client-appengine' is deployed.", new Object[] { "com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper" }));
    ClassWriter.get(paramJsonFactory, (Throwable)paramHttpTransport);
    throw ((IOException)paramJsonFactory);
  }
  
  private boolean execute()
  {
    try
    {
      Object localObject1 = forName("com.google.appengine.api.utils.SystemProperty");
      try
      {
        localObject2 = ((Class)localObject1).getField("environment");
        localObject1 = ((Field)localObject2).get(null);
        localObject2 = ((Field)localObject2).getType();
        localObject2 = ((Class)localObject2).getMethod("value", new Class[0]);
        localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
        if (localObject1 == null) {
          break label112;
        }
        return true;
      }
      catch (InvocationTargetException localInvocationTargetException) {}catch (NoSuchMethodException localNoSuchMethodException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (IllegalArgumentException localIllegalArgumentException) {}catch (SecurityException localSecurityException) {}catch (NoSuchFieldException localNoSuchFieldException) {}
      Object localObject2 = new RuntimeException(String.format("Unexpcted error trying to determine if runnning on Google App Engine: %s", new Object[] { ((Exception)localNoSuchFieldException).getMessage() }));
      ClassWriter.get((Throwable)localObject2, localNoSuchFieldException);
      throw ((RuntimeException)localObject2);
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    label112:
    return false;
  }
  
  public final f a(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
    throws IOException
  {
    try
    {
      if (j == null) {
        j = b(paramHttpTransport, paramJsonFactory);
      }
      if (j != null)
      {
        paramHttpTransport = j;
        return paramHttpTransport;
      }
      throw new IOException(String.format("The Application Default Credentials are not available. They are available if running in Google Compute Engine. Otherwise, the environment variable %s must be defined pointing to a file defining the credentials. See %s for more information.", new Object[] { "GOOGLE_APPLICATION_CREDENTIALS", "https://developers.google.com/accounts/docs/application-default-credentials" }));
    }
    catch (Throwable paramHttpTransport)
    {
      throw paramHttpTransport;
    }
  }
  
  public boolean b(File paramFile)
  {
    return (paramFile.exists()) && (!paramFile.isDirectory());
  }
  
  public Class forName(String paramString)
    throws ClassNotFoundException
  {
    return Class.forName(paramString);
  }
  
  public String getProperty(String paramString1, String paramString2)
  {
    return System.getProperty(paramString1, paramString2);
  }
  
  public String replace(String paramString)
  {
    return System.getenv(paramString);
  }
}
