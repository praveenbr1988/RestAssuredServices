package api.payloads.UsingJSONFiles;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Pattern;

public class UsingJSONFile {

    public static JSONObject getReqFromJsonFile(String filePath) throws FileNotFoundException {

        File f = new File(filePath);
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject req = new JSONObject(jt);

        String modifiedReq = req.toString();
        modifiedReq = modifiedReq.replaceAll(Pattern.quote("{{" + "empName" + "}}"),"Netflix");

        return new JSONObject(modifiedReq);
    }




}
