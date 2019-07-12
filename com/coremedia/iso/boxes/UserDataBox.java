package com.coremedia.iso.boxes;

import f.h.a.b;
import f.h.a.e;
import f.h.a.f;
import f.slide.asm.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class UserDataBox
  extends b
{
  public static final String TYPE = "udta";
  
  public UserDataBox()
  {
    super("udta");
  }
  
  public void getBox(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    paramWritableByteChannel.write(getHeader());
    ((e)this).writeContainer(paramWritableByteChannel);
  }
  
  public void parse(f paramF, ByteBuffer paramByteBuffer, long paramLong, a paramA)
    throws IOException
  {
    super.parse(paramF, paramByteBuffer, paramLong, paramA);
  }
}
