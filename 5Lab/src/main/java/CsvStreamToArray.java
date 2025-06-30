import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;

public class CsvStreamToArray
{
    public static Vector<String[]> readerToData(BufferedReader reader) throws IOException
    {
        List<String[]> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) { lines.add(line.split(",")); }

        {
            int control_count = lines.get(1).length;
            for (int ii = 2; ii < lines.size(); ++ii)
            {
                if (control_count != lines.get(ii).length) { throw new IOException("Файл с данными не корректен (разное кол-во данных в строках)"); }
            }
        }

        Vector<String[]> data = new Vector<String[]>();
        short i = 0;
        for (int g = 0; g < lines.size(); ++g) 
        {
            if (i == 0)
            {
                for (int u = 0; u < lines.get(1).length; ++u)
                {
                    data.add(new String[lines.get(0).length]);
                }
            }

            for (int j = 0; j < lines.get(1).length; ++j)
            {
                for (int jj = 0; jj < (lines.size() - 1); ++jj)
                {
                    data.get(j)[jj] = lines.get(jj + 1)[j];
                }
            }
            ++i;
        }
        return data;
    }
}