package f.g.org.org.apache.commons;

import f.g.b.a.g.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

@h
public class LogRecordingHandler
  extends Handler
{
  public final List<LogRecord> records = new ArrayList();
  
  public LogRecordingHandler() {}
  
  public void close()
    throws SecurityException
  {}
  
  public void flush() {}
  
  public List messages()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = records.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((LogRecord)localIterator.next()).getMessage());
    }
    return localArrayList;
  }
  
  public void publish(LogRecord paramLogRecord)
  {
    records.add(paramLogRecord);
  }
}
