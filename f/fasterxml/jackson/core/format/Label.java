package f.fasterxml.jackson.core.format;

import f.fasterxml.jackson.core.JsonFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class Label
{
  public static final int REACHABLE = 64;
  public final MatchStrength c;
  public final MatchStrength g;
  public final int h;
  public final JsonFactory[] j;
  
  public Label(Collection paramCollection)
  {
    this((JsonFactory[])paramCollection.toArray(new JsonFactory[paramCollection.size()]));
  }
  
  public Label(JsonFactory... paramVarArgs)
  {
    j = paramVarArgs;
    c = localMatchStrength1;
    g = localMatchStrength2;
    h = 64;
  }
  
  public Label(JsonFactory[] paramArrayOfJsonFactory, MatchStrength paramMatchStrength1, MatchStrength paramMatchStrength2, int paramInt)
  {
    j = paramArrayOfJsonFactory;
    c = paramMatchStrength1;
    g = paramMatchStrength2;
    h = paramInt;
  }
  
  private DataFormatMatcher a(InputAccessor.Std paramStd)
    throws IOException
  {
    JsonFactory[] arrayOfJsonFactory = j;
    int k = arrayOfJsonFactory.length;
    Object localObject2 = null;
    int i = 0;
    Object localObject3;
    Object localObject4;
    for (Object localObject1 = null;; localObject1 = localObject4)
    {
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (i >= k) {
        break;
      }
      JsonFactory localJsonFactory = arrayOfJsonFactory[i];
      paramStd.reset();
      localObject3 = localJsonFactory.hasFormat(paramStd);
      Object localObject5 = localObject2;
      localObject4 = localObject1;
      if (localObject3 != null) {
        if (((Enum)localObject3).ordinal() < g.ordinal())
        {
          localObject5 = localObject2;
          localObject4 = localObject1;
        }
        else if ((localObject2 != null) && (localObject1.ordinal() >= ((Enum)localObject3).ordinal()))
        {
          localObject5 = localObject2;
          localObject4 = localObject1;
        }
        else
        {
          if (((Enum)localObject3).ordinal() >= c.ordinal())
          {
            localObject4 = localObject3;
            localObject3 = localJsonFactory;
            break;
          }
          localObject4 = localObject3;
          localObject5 = localJsonFactory;
        }
      }
      i += 1;
      localObject2 = localObject5;
    }
    return paramStd.createMatcher((JsonFactory)localObject3, localObject4);
  }
  
  public DataFormatMatcher a(InputStream paramInputStream)
    throws IOException
  {
    return a(new InputAccessor.Std(paramInputStream, new byte[h]));
  }
  
  public Label a(int paramInt)
  {
    if (paramInt == h) {
      return this;
    }
    return new Label(j, c, g, paramInt);
  }
  
  public Label a(MatchStrength paramMatchStrength)
  {
    if (paramMatchStrength == g) {
      return this;
    }
    return new Label(j, c, paramMatchStrength, h);
  }
  
  public DataFormatMatcher b(byte[] paramArrayOfByte)
    throws IOException
  {
    return a(new InputAccessor.Std(paramArrayOfByte));
  }
  
  public DataFormatMatcher b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return a(new InputAccessor.Std(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public Label b(MatchStrength paramMatchStrength)
  {
    if (paramMatchStrength == c) {
      return this;
    }
    return new Label(j, paramMatchStrength, g, h);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    JsonFactory[] arrayOfJsonFactory = j;
    int k = arrayOfJsonFactory.length;
    if (k > 0)
    {
      localStringBuilder.append(arrayOfJsonFactory[0].getFormatName());
      int i = 1;
      while (i < k)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(j[i].getFormatName());
        i += 1;
      }
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}
