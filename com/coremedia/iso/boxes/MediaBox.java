package com.coremedia.iso.boxes;

import f.h.a.b;
import f.h.a.e;
import java.util.Iterator;
import java.util.List;

public class MediaBox
  extends b
{
  public static final String TYPE = "mdia";
  
  public MediaBox()
  {
    super("mdia");
  }
  
  public HandlerBox getHandlerBox()
  {
    Iterator localIterator = ((e)this).getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof HandlerBox));
    return (HandlerBox)localBox;
  }
  
  public MediaHeaderBox getMediaHeaderBox()
  {
    Iterator localIterator = ((e)this).getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof MediaHeaderBox));
    return (MediaHeaderBox)localBox;
  }
  
  public MediaInformationBox getMediaInformationBox()
  {
    Iterator localIterator = ((e)this).getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof MediaInformationBox));
    return (MediaInformationBox)localBox;
  }
}
