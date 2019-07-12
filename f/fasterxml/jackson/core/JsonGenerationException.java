package f.fasterxml.jackson.core;

public class JsonGenerationException
  extends JsonProcessingException
{
  public static final long serialVersionUID = 123L;
  
  public JsonGenerationException(String paramString)
  {
    super(paramString, null);
  }
  
  public JsonGenerationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, null, paramThrowable);
  }
  
  public JsonGenerationException(Throwable paramThrowable)
  {
    super(null, null, paramThrowable);
  }
}
