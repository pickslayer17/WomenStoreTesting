import org.junit.jupiter.api.Test;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class ScrTest1 extends AbstractBaseTest{

    @Test
    public void takeScreenshot() throws IOException {
        App().Flow().navigateToUrl("https://www.google.com/");
        System.out.println("Screenshot Test");
        System.out.println();
        System.out.println("--------------");

    }
}
