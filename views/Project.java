package views;

import android.net.Uri;
import d.d.a;
import java.util.Collections;
import java.util.List;

public class Project
{
  public Uri sourceUrl;
  public List<d.a> targets;
  public Uri webUrl;
  
  public Project(Uri paramUri1, List paramList, Uri paramUri2)
  {
    sourceUrl = paramUri1;
    paramUri1 = paramList;
    if (paramList == null) {
      paramUri1 = Collections.emptyList();
    }
    targets = paramUri1;
    webUrl = paramUri2;
  }
  
  public Uri getSourceUrl()
  {
    return sourceUrl;
  }
  
  public List getTargets()
  {
    return Collections.unmodifiableList(targets);
  }
  
  public Uri getWebUrl()
  {
    return webUrl;
  }
}
