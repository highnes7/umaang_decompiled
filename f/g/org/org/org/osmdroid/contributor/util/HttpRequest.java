package f.g.org.org.org.osmdroid.contributor.util;

import f.g.org.org.apache.http.MockLowLevelHttpRequest;
import f.g.org.org.apache.http.MockLowLevelHttpResponse;
import f.g.org.org.http.LowLevelHttpResponse;
import f.g.org.org.org.osmdroid.Request;
import f.g.org.org.stream.digests.JsonWebSignature;
import f.g.org.org.stream.digests.JsonWebToken;
import f.g.org.org.stream.digests.JsonWebToken.Payload;
import f.g.org.org.util.GenericData;
import java.io.IOException;
import java.util.Map;

public class HttpRequest
  extends MockLowLevelHttpRequest
{
  public HttpRequest(ClassWriter paramClassWriter, String paramString)
  {
    super(paramString);
  }
  
  public LowLevelHttpResponse execute()
    throws IOException
  {
    Object localObject1 = Request.parseQuery(getContentAsString());
    String str = (String)((Map)localObject1).get("client_id");
    if (str != null)
    {
      if (b.b.containsKey(str))
      {
        localObject2 = (String)((Map)localObject1).get("client_secret");
        str = (String)b.b.get(str);
        if ((localObject2 != null) && (((String)localObject2).equals(str)))
        {
          localObject1 = (String)((Map)localObject1).get("refresh_token");
          if (b.c.containsKey(localObject1)) {
            localObject1 = (String)b.c.get(localObject1);
          } else {
            throw new IOException("Refresh Token not found.");
          }
        }
        else
        {
          throw new IOException("Client secret not found.");
        }
      }
      else
      {
        throw new IOException("Client ID not found.");
      }
    }
    else
    {
      if (!((Map)localObject1).containsKey("grant_type")) {
        break label370;
      }
      if (!"urn:ietf:params:oauth:grant-type:jwt-bearer".equals((String)((Map)localObject1).get("grant_type"))) {
        break label360;
      }
      localObject1 = (String)((Map)localObject1).get("assertion");
      localObject2 = JsonWebSignature.parse(ClassWriter.h, (String)localObject1);
      localObject1 = ((JsonWebToken)localObject2).get().getIssuer();
      if (!b.m.containsKey(localObject1)) {
        break label350;
      }
      localObject1 = (String)b.m.get(localObject1);
      localObject2 = (String)((JsonWebToken)localObject2).get().get("scope");
      if ((localObject2 == null) || (((String)localObject2).length() == 0)) {
        break label340;
      }
    }
    Object localObject2 = new f.g.org.org.stream.Object();
    ((f.g.org.org.stream.Object)localObject2).put(ClassWriter.h);
    ((GenericData)localObject2).put("access_token", localObject1);
    ((GenericData)localObject2).put("expires_in", Integer.valueOf(3600000));
    ((GenericData)localObject2).put("token_type", "Bearer");
    localObject1 = ((f.g.org.org.stream.Object)localObject2).toPrettyString();
    return new MockLowLevelHttpResponse().setContentType("application/json; charset=UTF-8").setContent((String)localObject1);
    label340:
    throw new IOException("Scopes not found.");
    label350:
    throw new IOException("Service Account Email not found as issuer.");
    label360:
    throw new IOException("Unexpected Grant Type.");
    label370:
    throw new IOException("Uknown token type.");
  }
}
