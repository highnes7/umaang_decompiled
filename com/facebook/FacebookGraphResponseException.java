package com.facebook;

public class FacebookGraphResponseException
  extends FacebookException
{
  public final GraphResponse graphResponse;
  
  public FacebookGraphResponseException(GraphResponse paramGraphResponse, String paramString)
  {
    super(paramString);
    graphResponse = paramGraphResponse;
  }
  
  public final GraphResponse getGraphResponse()
  {
    return graphResponse;
  }
  
  public final String toString()
  {
    Object localObject = graphResponse;
    if (localObject != null) {
      localObject = ((GraphResponse)localObject).getError();
    } else {
      localObject = null;
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("{FacebookGraphResponseException: ");
    String str = getMessage();
    if (str != null)
    {
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
    }
    if (localObject != null)
    {
      localStringBuilder.append("httpResponseCode: ");
      localStringBuilder.append(((FacebookRequestError)localObject).getRequestStatusCode());
      localStringBuilder.append(", facebookErrorCode: ");
      localStringBuilder.append(((FacebookRequestError)localObject).getErrorCode());
      localStringBuilder.append(", facebookErrorType: ");
      localStringBuilder.append(((FacebookRequestError)localObject).getErrorType());
      localStringBuilder.append(", message: ");
      localStringBuilder.append(((FacebookRequestError)localObject).getErrorMessage());
      localStringBuilder.append("}");
    }
    return localStringBuilder.toString();
  }
}
