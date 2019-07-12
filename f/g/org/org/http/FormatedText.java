package f.g.org.org.http;

import java.io.IOException;

public class FormatedText
  extends IOException
{
  public static final long serialVersionUID = -1875819453475890043L;
  public final int bold;
  public final String content;
  public final String mFont;
  public final transient HttpHeaders mText;
  
  public FormatedText(HttpResponse paramHttpResponse)
  {
    this(new Item(paramHttpResponse));
  }
  
  public FormatedText(Item paramItem)
  {
    super(b);
    bold = a;
    mFont = g;
    mText = c;
    content = content;
  }
  
  public static StringBuilder computeMessageBuffer(HttpResponse paramHttpResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramHttpResponse.getStatusCode();
    if (i != 0) {
      localStringBuilder.append(i);
    }
    paramHttpResponse = paramHttpResponse.getStatusMessage();
    if (paramHttpResponse != null)
    {
      if (i != 0) {
        localStringBuilder.append(' ');
      }
      localStringBuilder.append(paramHttpResponse);
    }
    return localStringBuilder;
  }
  
  public final String getContent()
  {
    return content;
  }
  
  public HttpHeaders getText()
  {
    return mText;
  }
  
  public final String getTypeface()
  {
    return mFont;
  }
  
  public final int isBold()
  {
    return bold;
  }
  
  public final boolean isSuccess()
  {
    return HttpStatus.isSuccess(bold);
  }
}
