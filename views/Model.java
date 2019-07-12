package views;

import android.net.Uri;

public class Model
{
  public final String className;
  public final String link;
  public final String packageName;
  public final Uri url;
  
  public Model(String paramString1, String paramString2, Uri paramUri, String paramString3)
  {
    packageName = paramString1;
    className = paramString2;
    url = paramUri;
    link = paramString3;
  }
  
  public String getClassName()
  {
    return className;
  }
  
  public String getLink()
  {
    return link;
  }
  
  public String getPackageName()
  {
    return packageName;
  }
  
  public Uri getUrl()
  {
    return url;
  }
}
