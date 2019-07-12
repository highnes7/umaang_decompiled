package f.slide.asm;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import f.h.a.g;
import f.h.a.g.m;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Regex
{
  public Regex() {}
  
  public static void replace(Map paramMap, File paramFile)
    throws IOException
  {
    Object localObject1 = new Buffer(new g(new RandomAccessFile(paramFile, "r").getChannel()));
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext())
      {
        ((Buffer)localObject1).close();
        paramMap = new RandomAccessFile(paramFile, "rw").getChannel();
        paramFile = localHashMap1.keySet().iterator();
        for (;;)
        {
          if (!paramFile.hasNext())
          {
            paramMap.close();
            return;
          }
          localObject1 = (String)paramFile.next();
          localObject2 = (Box)localHashMap1.get(localObject1);
          paramMap.position(((Long)localHashMap2.get(localObject1)).longValue());
          ((Box)localObject2).getBox(paramMap);
        }
      }
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject3 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = m.a((Container)localObject1, (String)localObject3);
      localHashMap1.put(m.a((Box)localObject3), (Box)((Map.Entry)localObject2).getValue());
      localHashMap2.put(m.a((Box)localObject3), Long.valueOf(((Box)localObject3).getOffset()));
    }
  }
}
