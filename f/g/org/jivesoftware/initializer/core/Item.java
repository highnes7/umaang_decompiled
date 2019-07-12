package f.g.org.jivesoftware.initializer.core;

import f.g.b.a.g.z;
import f.g.b.b.a.a.H;
import java.util.List;

public final class Item
  extends f.g.org.org.stream.Object
{
  @z
  public String description;
  @z
  public List<H> fields;
  @z
  public String mode;
  @z
  public String name;
  @z
  public String type;
  
  public Item() {}
  
  public Item a(String paramString)
  {
    type = paramString;
    return this;
  }
  
  public Item a(List paramList)
  {
    fields = paramList;
    return this;
  }
  
  public Item clone()
  {
    return (Item)super.clone();
  }
  
  public Item clone(String paramString, Object paramObject)
  {
    return (Item)super.clone(paramString, paramObject);
  }
  
  public List getData()
  {
    return fields;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getType()
  {
    return type;
  }
  
  public Item load(String paramString)
  {
    name = paramString;
    return this;
  }
  
  public Item setDescription(String paramString)
  {
    description = paramString;
    return this;
  }
  
  public Item setId(String paramString)
  {
    mode = paramString;
    return this;
  }
  
  public String toXML()
  {
    return mode;
  }
}
