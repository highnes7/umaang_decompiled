package k.a.a.c;

public class Log
{
  public String DEBUG;
  public String Desc;
  public String SERVER;
  public String TAG;
  public boolean _debug;
  public String _value;
  public String b;
  public String d;
  public String f;
  public String i;
  public String id;
  public boolean level;
  public String log_tag;
  public String logs;
  public String mName;
  public String mNumber;
  public String mTag;
  public String m_sort;
  public String message;
  public String out;
  public String recordId;
  public String s;
  public boolean sEnabled;
  public String string;
  public String t;
  public String tag;
  public String text;
  public String timestamp;
  public String type;
  public String value;
  
  public Log() {}
  
  public void add(String paramString)
  {
    id = paramString;
  }
  
  public void add(boolean paramBoolean)
  {
    level = paramBoolean;
  }
  
  public void append(String paramString)
  {
    i = paramString;
  }
  
  public void close(String paramString)
  {
    tag = paramString;
  }
  
  public String d()
  {
    return f;
  }
  
  public void d(String paramString)
  {
    t = paramString;
  }
  
  public String e()
  {
    return mTag;
  }
  
  public void e(String paramString)
  {
    s = paramString;
  }
  
  public void equals(String paramString)
  {
    logs = paramString;
  }
  
  public void execute(String paramString)
  {
    recordId = paramString;
  }
  
  public void format(String paramString)
  {
    mNumber = paramString;
  }
  
  public String get()
  {
    return t;
  }
  
  public void get(String paramString)
  {
    value = paramString;
  }
  
  public String getClassName()
  {
    return type;
  }
  
  public String getColor()
  {
    return value;
  }
  
  public String getDesc()
  {
    return Desc;
  }
  
  public String getID()
  {
    return recordId;
  }
  
  public String getLog()
  {
    return logs;
  }
  
  public boolean getLogLevel()
  {
    return level;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public void getName(String paramString)
  {
    mName = paramString;
  }
  
  public String getNumber()
  {
    return mNumber;
  }
  
  public String getSort()
  {
    return m_sort;
  }
  
  public String getString()
  {
    return string;
  }
  
  public String getTAG()
  {
    return TAG;
  }
  
  public String getTag()
  {
    return tag;
  }
  
  public String getText()
  {
    return text;
  }
  
  public String getTimestamp()
  {
    return timestamp;
  }
  
  public String getValue()
  {
    return b;
  }
  
  public String i()
  {
    return i;
  }
  
  public boolean isDebugEnabled()
  {
    return _debug;
  }
  
  public boolean isEnabled()
  {
    return sEnabled;
  }
  
  public void log(String paramString)
  {
    m_sort = paramString;
  }
  
  public void name(String paramString)
  {
    log_tag = paramString;
  }
  
  public void next(String paramString)
  {
    mTag = paramString;
  }
  
  public String print()
  {
    return log_tag;
  }
  
  public void print(String paramString)
  {
    TAG = paramString;
  }
  
  public void put(String paramString)
  {
    timestamp = paramString;
  }
  
  public String read()
  {
    return s;
  }
  
  public void read(String paramString)
  {
    b = paramString;
  }
  
  public String readClass()
  {
    return DEBUG;
  }
  
  public String save()
  {
    return id;
  }
  
  public void set(String paramString)
  {
    type = paramString;
  }
  
  public void set(boolean paramBoolean)
  {
    _debug = paramBoolean;
  }
  
  public void setMessage(String paramString)
  {
    message = paramString;
  }
  
  public void size(String paramString)
  {
    Desc = paramString;
  }
  
  public void split(String paramString)
  {
    _value = paramString;
  }
  
  public void start(String paramString)
  {
    d = paramString;
  }
  
  public String t()
  {
    return d;
  }
  
  public void toString(String paramString)
  {
    string = paramString;
  }
  
  public String trace()
  {
    return out;
  }
  
  public void trim(String paramString)
  {
    text = paramString;
  }
  
  public void update(String paramString)
  {
    out = paramString;
  }
  
  public void v(String paramString)
  {
    DEBUG = paramString;
  }
  
  public String value()
  {
    return _value;
  }
  
  public void valueOf(boolean paramBoolean)
  {
    sEnabled = paramBoolean;
  }
  
  public void w(String paramString)
  {
    SERVER = paramString;
  }
  
  public String write()
  {
    return SERVER;
  }
  
  public void write(String paramString)
  {
    f = paramString;
  }
}
