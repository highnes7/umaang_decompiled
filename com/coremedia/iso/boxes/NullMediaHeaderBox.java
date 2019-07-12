package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import java.nio.ByteBuffer;

public class NullMediaHeaderBox
  extends AbstractMediaHeaderBox
{
  public static String TYPE;
  
  public NullMediaHeaderBox()
  {
    super(TYPE);
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
  }
  
  public long getContentSize()
  {
    return 4L;
  }
}
