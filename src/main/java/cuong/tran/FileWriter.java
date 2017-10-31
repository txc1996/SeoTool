package cuong.tran;

import java.io.File;
import java.util.List;

public interface FileWriter {

    void writeToFile(List<Card> datas, String filePath) throws Exception;
}
