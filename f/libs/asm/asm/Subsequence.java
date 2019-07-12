package f.libs.asm.asm;

import f.c.a.a.I;
import f.c.a.a.M;

public class Subsequence
  extends I<M>
{
  public static final String KEY_RATING = "rating";
  public static final String RATING = "rating";
  public static final String base = "contentId";
  public static final String begin = "contentType";
  public static final String size = "contentName";
  
  public Subsequence() {}
  
  public Subsequence a(int paramInt)
  {
    c.add("rating", Integer.valueOf(paramInt));
    return this;
  }
  
  public Subsequence a(String paramString)
  {
    c.add("contentId", paramString);
    return this;
  }
  
  public String getId()
  {
    return "rating";
  }
  
  public Subsequence onCreateView(String paramString)
  {
    c.add("contentType", paramString);
    return this;
  }
  
  public Subsequence write(String paramString)
  {
    c.add("contentName", paramString);
    return this;
  }
}
