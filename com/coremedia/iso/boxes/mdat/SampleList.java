package com.coremedia.iso.boxes.mdat;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import f.h.a.b.d;
import f.h.a.b.d.a;
import f.slide.asm.Buffer;
import java.util.AbstractList;
import java.util.List;

public class SampleList
  extends AbstractList<d>
{
  public List<d> samples;
  
  public SampleList(TrackBox paramTrackBox, Buffer... paramVarArgs)
  {
    Container localContainer = ((Box)paramTrackBox.getParent()).getParent();
    if (paramTrackBox.getParent().getBoxes(MovieExtendsBox.class).isEmpty())
    {
      if (paramVarArgs.length <= 0)
      {
        samples = ((List)new a(paramTrackBox.getTrackHeaderBox().getTrackId(), localContainer));
        return;
      }
      throw new RuntimeException("The TrackBox comes from a standard MP4 file. Only use the additionalFragments param if you are dealing with ( fragmented MP4 files AND additional fragments in standalone files )");
    }
    samples = ((List)new f.h.a.b.d.b(paramTrackBox.getTrackHeaderBox().getTrackId(), localContainer, paramVarArgs));
  }
  
  public d get(int paramInt)
  {
    return (d)samples.get(paramInt);
  }
  
  public int size()
  {
    return samples.size();
  }
}
