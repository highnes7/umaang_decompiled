package support.android.v4.util;

import b.b.a.G;

public class Type<F, S>
{
  @G
  public final S b;
  @G
  public final F c;
  
  public Type(Object paramObject1, Object paramObject2)
  {
    c = paramObject1;
    b = paramObject2;
  }
  
  public static Type create(Object paramObject1, Object paramObject2)
  {
    return new Type(paramObject1, paramObject2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Type)) {
      return false;
    }
    paramObject = (Type)paramObject;
    return (LatLong.equals(c, c)) && (LatLong.equals(b, b));
  }
  
  public int hashCode()
  {
    Object localObject = c;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i ^ j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Pair{");
    localStringBuilder.append(String.valueOf(c));
    localStringBuilder.append(" ");
    localStringBuilder.append(String.valueOf(b));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
