package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;

public final class CSVParserBuilder
  extends f.g.org.org.stream.Object
{
  @z
  public Map copy;
  @z
  public Boolean dryRun;
  @z
  public SocketAddress extract;
  @z
  public LinkedList link;
  @z
  public Attribute load;
  @z
  public Query query;
  
  public CSVParserBuilder() {}
  
  public LinkedList build()
  {
    return link;
  }
  
  public CSVParserBuilder clone()
  {
    return (CSVParserBuilder)super.clone();
  }
  
  public CSVParserBuilder clone(String paramString, Object paramObject)
  {
    return (CSVParserBuilder)super.clone(paramString, paramObject);
  }
  
  public SocketAddress getEscapeChar()
  {
    return extract;
  }
  
  public Query getQuery()
  {
    return query;
  }
  
  public Map getWriter()
  {
    return copy;
  }
  
  public Boolean isDryRunEnabled()
  {
    return dryRun;
  }
  
  public Attribute load()
  {
    return load;
  }
  
  public CSVParserBuilder withIgnoreLeadingWhiteSpace(Attribute paramAttribute)
  {
    load = paramAttribute;
    return this;
  }
  
  public CSVParserBuilder withIgnoreLeadingWhiteSpace(Query paramQuery)
  {
    query = paramQuery;
    return this;
  }
  
  public CSVParserBuilder withIgnoreLeadingWhiteSpace(Boolean paramBoolean)
  {
    dryRun = paramBoolean;
    return this;
  }
  
  public CSVParserBuilder withStrictQuotes(LinkedList paramLinkedList)
  {
    link = paramLinkedList;
    return this;
  }
  
  public CSVParserBuilder withStrictQuotes(Map paramMap)
  {
    copy = paramMap;
    return this;
  }
  
  public CSVParserBuilder withStrictQuotes(SocketAddress paramSocketAddress)
  {
    extract = paramSocketAddress;
    return this;
  }
}
