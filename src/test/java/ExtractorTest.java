import com.pathfinderGenerator.app.utility.Extractor;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class ExtractorTest {


    Extractor extractor = new Extractor();
    @Test
    public void extractorTest() throws FileNotFoundException {
        extractor.sqlExtractor();
    }
}
