package f.g.org.org.org;

public final class CSVParserBuilder
{
  public boolean strictQuotes;
  
  public CSVParserBuilder() {}
  
  public Request build()
  {
    return new Request(strictQuotes);
  }
  
  public boolean isStrictQuotes()
  {
    return strictQuotes;
  }
  
  public CSVParserBuilder withStrictQuotes(boolean paramBoolean)
  {
    strictQuotes = paramBoolean;
    return this;
  }
}
