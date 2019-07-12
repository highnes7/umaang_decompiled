package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ig;
import f.g.c.package_10.Preconditions;
import java.util.HashMap;
import java.util.Map;

@b(serializable=true)
public class HashBasedTable<R, C, V>
  extends Ig<R, C, V>
{
  public static final long serialVersionUID = 0L;
  
  public HashBasedTable(Map paramMap, hb.a paramA)
  {
    super(paramMap, paramA);
  }
  
  public static HashBasedTable create()
  {
    return new HashBasedTable(new HashMap(), new hb.a(0));
  }
  
  public static HashBasedTable create(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    return new HashBasedTable(Maps.newHashMapWithExpectedSize(paramInt1), new hb.a(paramInt2));
  }
  
  public static HashBasedTable create(Table paramTable)
  {
    HashBasedTable localHashBasedTable = create();
    localHashBasedTable.putAll(paramTable);
    return localHashBasedTable;
  }
  
  public void clear()
  {
    backingMap.clear();
  }
  
  public Map column(Object paramObject)
  {
    return new Ig.c(this, paramObject);
  }
  
  public boolean contains(Object paramObject1, Object paramObject2)
  {
    return super.contains(paramObject1, paramObject2);
  }
  
  public boolean containsColumn(Object paramObject)
  {
    return super.containsColumn(paramObject);
  }
  
  public boolean containsRow(Object paramObject)
  {
    return super.containsRow(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return super.containsValue(paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public Object get(Object paramObject1, Object paramObject2)
  {
    return super.get(paramObject1, paramObject2);
  }
  
  public Object remove(Object paramObject1, Object paramObject2)
  {
    return super.remove(paramObject1, paramObject2);
  }
  
  public Map row(Object paramObject)
  {
    return new Ig.g(this, paramObject);
  }
}
