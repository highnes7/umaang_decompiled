package views;

import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Logger
  implements o<Void, List<TResult>>
{
  public Logger(Collection paramCollection) {}
  
  public List then(Task paramTask)
    throws Exception
  {
    if (crls.size() == 0) {
      return Collections.emptyList();
    }
    paramTask = new ArrayList();
    Iterator localIterator = crls.iterator();
    while (localIterator.hasNext()) {
      paramTask.add(((Task)localIterator.next()).getResult());
    }
    return paramTask;
  }
}
