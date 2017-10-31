package cuong.tran;

import java.util.List;

public interface FileReader {

    List<String> readFromFile(String filePath) throws Exception;
}
