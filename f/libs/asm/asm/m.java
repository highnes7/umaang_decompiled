package f.libs.asm.asm;

public final class m
{
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final Boolean e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  public final String k;
  public String s;
  
  public m(String paramString1, String paramString2, String paramString3, Boolean paramBoolean, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    c = paramString1;
    b = paramString2;
    d = paramString3;
    e = paramBoolean;
    a = paramString4;
    f = paramString5;
    g = paramString6;
    h = paramString7;
    k = paramString8;
    i = paramString9;
  }
  
  public String toString()
  {
    if (s == null)
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("appBundleId=");
      localStringBuilder.append(c);
      localStringBuilder.append(", executionId=");
      localStringBuilder.append(b);
      localStringBuilder.append(", installationId=");
      localStringBuilder.append(d);
      localStringBuilder.append(", limitAdTrackingEnabled=");
      localStringBuilder.append(e);
      localStringBuilder.append(", betaDeviceToken=");
      localStringBuilder.append(a);
      localStringBuilder.append(", buildId=");
      localStringBuilder.append(f);
      localStringBuilder.append(", osVersion=");
      localStringBuilder.append(g);
      localStringBuilder.append(", deviceModel=");
      localStringBuilder.append(h);
      localStringBuilder.append(", appVersionCode=");
      localStringBuilder.append(k);
      localStringBuilder.append(", appVersionName=");
      localStringBuilder.append(i);
      s = localStringBuilder.toString();
    }
    return s;
  }
}
