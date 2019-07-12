package f.libs.asm.menu;

import android.content.Context;
import l.a.a.a.a.b.ClassWriter;
import l.a.a.a.a.g.f;

public class MethodWriter
{
  public static final String A = "com.crashlytics.CrashSubmissionAlwaysSendTitle";
  public static final String T = "com.crashlytics.CrashSubmissionPromptMessage";
  public static final String descriptor = "com.crashlytics.CrashSubmissionPromptTitle";
  public static final String e = "com.crashlytics.CrashSubmissionCancelTitle";
  public static final String t = "com.crashlytics.CrashSubmissionSendTitle";
  public final f b;
  public final Context c;
  
  public MethodWriter(Context paramContext, f paramF)
  {
    c = paramContext;
    b = paramF;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (put(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  private String c(String paramString1, String paramString2)
  {
    return a(ClassWriter.a(c, paramString1), paramString2);
  }
  
  private boolean put(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public String a()
  {
    String str = b.c;
    return a(ClassWriter.a(c, "com.crashlytics.CrashSubmissionPromptTitle"), str);
  }
  
  public String b()
  {
    String str = b.h;
    return a(ClassWriter.a(c, "com.crashlytics.CrashSubmissionSendTitle"), str);
  }
  
  public String c()
  {
    String str = b.g;
    return a(ClassWriter.a(c, "com.crashlytics.CrashSubmissionAlwaysSendTitle"), str);
  }
  
  public String d()
  {
    String str = b.s;
    return a(ClassWriter.a(c, "com.crashlytics.CrashSubmissionPromptMessage"), str);
  }
  
  public String f()
  {
    String str = b.b;
    return a(ClassWriter.a(c, "com.crashlytics.CrashSubmissionCancelTitle"), str);
  }
}
