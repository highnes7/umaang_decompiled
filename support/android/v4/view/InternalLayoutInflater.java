package support.android.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class InternalLayoutInflater
  extends LayoutInflater
{
  public static final String[] sClassPrefixList = { "android.widget.", "android.webkit.", "android.app." };
  
  public InternalLayoutInflater(Context paramContext)
  {
    super(paramContext);
  }
  
  public LayoutInflater cloneInContext(Context paramContext)
  {
    return new InternalLayoutInflater(paramContext);
  }
  
  public View onCreateView(String paramString, AttributeSet paramAttributeSet)
    throws ClassNotFoundException
  {
    String[] arrayOfString = sClassPrefixList;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      try
      {
        localObject = createView(paramString, (String)localObject, paramAttributeSet);
        if (localObject != null) {
          return localObject;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return super.onCreateView(paramString, paramAttributeSet);
  }
}
