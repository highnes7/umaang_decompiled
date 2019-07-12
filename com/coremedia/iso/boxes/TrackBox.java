package com.coremedia.iso.boxes;

import f.h.a.b;
import f.h.a.e;
import java.util.Iterator;
import java.util.List;

public class TrackBox
  extends b
{
  public static final String TYPE = "trak";
  public SampleTableBox sampleTableBox;
  
  public TrackBox()
  {
    super("trak");
  }
  
  public MediaBox getMediaBox()
  {
    Iterator localIterator = ((e)this).getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof MediaBox));
    return (MediaBox)localBox;
  }
  
  public SampleTableBox getSampleTableBox()
  {
    Object localObject = sampleTableBox;
    if (localObject != null) {
      return localObject;
    }
    localObject = getMediaBox();
    if (localObject != null)
    {
      localObject = ((MediaBox)localObject).getMediaInformationBox();
      if (localObject != null)
      {
        sampleTableBox = ((MediaInformationBox)localObject).getSampleTableBox();
        return sampleTableBox;
      }
    }
    return null;
  }
  
  public TrackHeaderBox getTrackHeaderBox()
  {
    Iterator localIterator = ((e)this).getBoxes().iterator();
    Box localBox;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localBox = (Box)localIterator.next();
    } while (!(localBox instanceof TrackHeaderBox));
    return (TrackHeaderBox)localBox;
  }
  
  public void setBoxes(List paramList)
  {
    ((e)this).setBoxes(paramList);
    sampleTableBox = null;
  }
}
