package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.b.b.a.a.E.a;
import f.g.org.org.util.Data;
import java.util.List;

public final class Token
  extends f.g.org.org.stream.Object
{
  @z
  public Boolean ignoreUnknownValues;
  @z
  public String kind;
  @z
  public List<E.a> rows;
  @z
  public Boolean skipInvalidRows;
  
  static
  {
    Data.nullOf(E.a.class);
  }
  
  public Token() {}
  
  public Token clone()
  {
    return (Token)super.clone();
  }
  
  public Token clone(String paramString, Object paramObject)
  {
    return (Token)super.clone(paramString, paramObject);
  }
  
  public String getIssuer()
  {
    return kind;
  }
  
  public Boolean getSecretKeySpec()
  {
    return ignoreUnknownValues;
  }
  
  public List getValue()
  {
    return rows;
  }
  
  public Boolean isEOF()
  {
    return skipInvalidRows;
  }
  
  public Token setPos(Boolean paramBoolean)
  {
    skipInvalidRows = paramBoolean;
    return this;
  }
  
  public Token setValue(Boolean paramBoolean)
  {
    ignoreUnknownValues = paramBoolean;
    return this;
  }
  
  public Token setValue(String paramString)
  {
    kind = paramString;
    return this;
  }
  
  public Token setValue(List paramList)
  {
    rows = paramList;
    return this;
  }
}
