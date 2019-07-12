package f.g.org.org.http;

public class HttpStatus
{
  public static final int FORBIDDEN_403 = 403;
  public static final int SC_BAD_GATEWAY = 502;
  public static final int SC_INTERNAL_SERVER_ERROR = 500;
  public static final int SC_MOVED_PERMANENTLY = 301;
  public static final int SC_MOVED_TEMPORARILY = 302;
  public static final int SC_MULTIPLE_CHOICES = 300;
  public static final int SC_NOT_FOUND = 404;
  public static final int SC_NOT_MODIFIED = 304;
  public static final int SC_NO_CONTENT = 204;
  public static final int SC_OK = 200;
  public static final int SC_SEE_OTHER = 303;
  public static final int SC_SERVICE_UNAVAILABLE = 503;
  public static final int SC_TEMPORARY_REDIRECT = 307;
  public static final int SC_UNAUTHORIZED = 401;
  
  public HttpStatus() {}
  
  public static boolean isRedirect(int paramInt)
  {
    if (paramInt != 307) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    return true;
  }
  
  public static boolean isSuccess(int paramInt)
  {
    return (paramInt >= 200) && (paramInt < 300);
  }
}
