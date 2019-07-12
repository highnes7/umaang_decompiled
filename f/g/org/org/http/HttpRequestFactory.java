package f.g.org.org.http;

import java.io.IOException;

public final class HttpRequestFactory
{
  public final AnnotationVisitor initializer;
  public final HttpTransport transport;
  
  public HttpRequestFactory(HttpTransport paramHttpTransport, AnnotationVisitor paramAnnotationVisitor)
  {
    transport = paramHttpTransport;
    initializer = paramAnnotationVisitor;
  }
  
  public HttpRequest buildDeleteRequest(GenericUrl paramGenericUrl)
    throws IOException
  {
    return buildRequest("DELETE", paramGenericUrl, null);
  }
  
  public HttpRequest buildHeadRequest(GenericUrl paramGenericUrl)
    throws IOException
  {
    return buildRequest("HEAD", paramGenericUrl, null);
  }
  
  public HttpRequest buildPatchRequest(GenericUrl paramGenericUrl, HttpContent paramHttpContent)
    throws IOException
  {
    return buildRequest("PATCH", paramGenericUrl, paramHttpContent);
  }
  
  public HttpRequest buildPostRequest(GenericUrl paramGenericUrl, HttpContent paramHttpContent)
    throws IOException
  {
    return buildRequest("POST", paramGenericUrl, paramHttpContent);
  }
  
  public HttpRequest buildRequest(GenericUrl paramGenericUrl)
    throws IOException
  {
    return buildRequest("GET", paramGenericUrl, null);
  }
  
  public HttpRequest buildRequest(GenericUrl paramGenericUrl, HttpContent paramHttpContent)
    throws IOException
  {
    return buildRequest("PUT", paramGenericUrl, paramHttpContent);
  }
  
  public HttpRequest buildRequest(String paramString, GenericUrl paramGenericUrl, HttpContent paramHttpContent)
    throws IOException
  {
    HttpRequest localHttpRequest = transport.buildRequest();
    AnnotationVisitor localAnnotationVisitor = initializer;
    if (localAnnotationVisitor != null) {
      localAnnotationVisitor.visit(localHttpRequest);
    }
    localHttpRequest.setRequestMethod(paramString);
    if (paramGenericUrl != null) {
      localHttpRequest.setUrl(paramGenericUrl);
    }
    if (paramHttpContent != null) {
      localHttpRequest.setContent(paramHttpContent);
    }
    return localHttpRequest;
  }
  
  public AnnotationVisitor getInitializer()
  {
    return initializer;
  }
  
  public HttpTransport getTransport()
  {
    return transport;
  }
}
