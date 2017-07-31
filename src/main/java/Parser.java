import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser {


    public HashMap<String, List<Call>> read(String fileName) throws IOException {

        String path = this.getClass().getClassLoader().getResource(fileName).getPath();
        String file = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        String[] lines = file.split("\\n");


        HashMap<String, List<Call>> mapCalls = new HashMap<>();

        for (int i = 0; i < lines.length; i++) {
            String currentLine[] = lines[i].split(";");

            //start
            String lStart[] = currentLine[0].split(":");
            LocalTime start = LocalTime.of(Integer.parseInt(lStart[0]), Integer.parseInt(lStart[1]), Integer.parseInt(lStart[2]));

            //end
            String lEnd[] = currentLine[1].split(":");
            LocalTime end = LocalTime.of(Integer.parseInt(lEnd[0]), Integer.parseInt(lEnd[1]), Integer.parseInt(lEnd[2]));


            Call call = new Call(currentLine[2], currentLine[3], start, end);

            if (!mapCalls.containsKey(call.getFrom()))
                mapCalls.put(call.getFrom(), new ArrayList<>());

            mapCalls.get(call.getFrom()).add(call);
        }

        System.out.println(mapCalls);

        return mapCalls;

    }

}
