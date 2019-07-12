package support.android.asm;

import android.support.transition.Transition;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Edit
{
  public final ArrayList<Transition> added = new ArrayList();
  public final Map<String, Object> values = new HashMap();
  public View view;
  
  public Edit() {}
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Edit))
    {
      View localView = view;
      paramObject = (Edit)paramObject;
      if ((localView == view) && (values.equals(values))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = view.hashCode();
    return values.hashCode() + i * 31;
  }
  
  public String toString()
  {
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("TransitionValues@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject).append(":\n");
    localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.toString(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(((StringBuilder)localObject).toString(), "    view = "), view, "\n"), "    values:");
    Iterator localIterator = values.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("    ");
      localStringBuilder.append(str);
      localStringBuilder.append(": ");
      localStringBuilder.append(values.get(str));
      localStringBuilder.append("\n");
      localObject = localStringBuilder.toString();
    }
    return localObject;
  }
}
