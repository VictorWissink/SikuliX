
import org.junit.jupiter.api.*;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.DirtiesContext;

import java.awt.event.KeyEvent;
import java.io.IOException;


public class addUser {
    private static Pattern RUNAPP;
    private static Screen screen;
    private static String pathSearch, pathNewTab, pathUser, pathEnterName, pathUserSuccess, pathRemoveBtn, pathCrossBtn, pathEditBtn, pathResetBtn, pathUserError;

    @BeforeAll
    public static void setupTest()throws IOException {

        //clear DB




        //setup

        screen = new Screen();


        //load variables
//      pathSearch = new ClassPathResource("../src/test/resources/testimages/search.png").getPath();
//      pathNewTab = new ClassPathResource("../src/test/resources/testimages/nieuw_tabblad.png").getPath();
//      pathUser = new ClassPathResource("../src/test/resources/testimages/user.png").getPath();
//      pathEnterName = new ClassPathResource("../src/test/resources/testimages/entername.png").getPath();
//      pathUserSuccess = new ClassPathResource("../src/test/resources/testimages/usercreatedsuccess.png").getPath();
//      pathRemoveBtn = new ClassPathResource("../src/test/resources/testimages/removebtn.png").getPath();
//      pathCrossBtn = new ClassPathResource("../src/test/resources/testimages/crossbtn.png").getPath();
//      pathEditBtn = new ClassPathResource("../src/test/resources/testimages/editbtn.png").getPath();
//      pathResetBtn = new ClassPathResource("../src/test/resources/testimages/resetbtn.png").getPath();
//      pathUserError = new ClassPathResource("../src/test/resources/testimages/usererror.png").getPath();
//
//D:\Data\VWissink\Documents\Framework Tries\BaselineProjectSikuliX\BaselineProject\src\test\resources\testimages
       pathSearch = new ClassPathResource("src/test/resources/testimages/search.png").getPath();
       pathNewTab = new ClassPathResource("src/test/resources/testimages/nieuw_tabblad.png").getPath();
       pathUser = new ClassPathResource("src/test/resources/testimages/user.png").getPath();
       pathEnterName = new ClassPathResource("src/test/resources/testimages/entername.png").getPath();
       pathUserSuccess = new ClassPathResource("src/test/resources/testimages/usercreatedsuccess.png").getPath();
       pathRemoveBtn = new ClassPathResource("src/test/resources/testimages/removebtn.png").getPath();
       pathCrossBtn = new ClassPathResource("src/test/resources/testimages/crossbtn.png").getPath();
       pathEditBtn = new ClassPathResource("src/test/resources/testimages/editbtn.png").getPath();
       pathResetBtn = new ClassPathResource("src/test/resources/testimages/resetbtn.png").getPath();
       pathUserError = new ClassPathResource("src/test/resources/testimages/usererror.png").getPath();


        //only full path seems to work somehow?
    //    pathSearch = new ClassPathResource("D://Data/VWissink//Documents//Framework Tries//BaselineProjectSikuliX//BaselineProject//src//test//resources//search.png").getPath();
    //    pathNewTab = new ClassPathResource("D://Data/VWissink//Documents//Framework Tries//BaselineProjectSikuliX//BaselineProject//src//test//resources//nieuw_tabblad.png").getPath();
    //    pathUser = new ClassPathResource("D://Data/VWissink//Documents//Framework Tries//BaselineProjectSikuliX//BaselineProject//src//test//resources//user.png").getPath();
    //    pathEnterName = new ClassPathResource("D://Data/VWissink//Documents//Framework Tries//BaselineProjectSikuliX//BaselineProject//src//test//resources//entername.png").getPath();
    //    pathUserSuccess = new ClassPathResource("D://Data/VWissink//Documents//Framework Tries//BaselineProjectSikuliX//BaselineProject//src//test//resources//usercreatedsuccess.png").getPath();
    //    pathRemoveBtn = new ClassPathResource("D://Data/VWissink//Documents//Framework Tries//BaselineProjectSikuliX//BaselineProject//src//test//resources//removebtn.png").getPath();
    //    pathCrossBtn = new ClassPathResource("D://Data/VWissink//Documents//Framework Tries//BaselineProjectSikuliX//BaselineProject//src//test//resources//crossbtn.png").getPath();
    //    pathEditBtn = new ClassPathResource("D://Data/VWissink//Documents//Framework Tries//BaselineProjectSikuliX//BaselineProject//src//test//resources//editbtn.png").getPath();
    //    pathResetBtn = new ClassPathResource("D://Data/VWissink//Documents//Framework Tries//BaselineProjectSikuliX//BaselineProject//src//test//resources//resetbtn.png").getFilename();
    //    pathUserError = new ClassPathResource("D://Data/VWissink//Documents//Framework Tries//BaselineProjectSikuliX//BaselineProject//src//test//resources//usererror.png").getPath();

        openChromeAndGoToPage();
    }

    @AfterAll
    public static void teardownTestClass() throws FindFailed {
        RUNAPP = new Pattern(pathCrossBtn);
        screen.click(RUNAPP.similar((float) 0.80));

    }

    @AfterEach
    public void refresh() {

        //clear DB

        //refresh page
        screen.wait(1.0);
        screen.type(Key.F5);
        screen.wait(1.0);
    }

    public static void openChromeAndGoToPage() throws IOException {
        //press windows button
        screen.keyDown(KeyEvent.VK_WINDOWS);
        screen.keyUp(KeyEvent.VK_WINDOWS);

        //wait till the windows start menu is visible
        RUNAPP = new Pattern(pathSearch);
        try {
            screen.wait(RUNAPP.similar((float) 0.80), 2);
            //type chrome and press enter to start chrome
            screen.type("chrome" );
            screen.type(Key.ENTER);


            //wait till chrome is open
            RUNAPP = new Pattern(pathNewTab);
            screen.wait(RUNAPP.similar((float) 0.80), 10);

        } catch (FindFailed findFailed) {

            findFailed.printStackTrace();
            throw new IOException("failed to open chrome");
        }
       //make browser fullscreen
       screen.keyDown(KeyEvent.VK_WINDOWS);
       screen.keyDown(KeyEvent.VK_UP);
       screen.keyUp(KeyEvent.VK_UP);
       screen.keyUp(KeyEvent.VK_WINDOWS);

       //enter page url and press enter
       screen.type("localhost:8080/SpringBootCRUDApp/");
       screen.type(Key.ENTER);
       RUNAPP = new Pattern(pathUser);
        try {
            screen.wait(RUNAPP.similar((float) 0.80), 10);
        } catch (FindFailed findFailed) {

            findFailed.printStackTrace();
            throw new IOException("failed to load the application");
        }
    }

    @Test
    public void addUserAndRemoveIt() throws FindFailed {





        RUNAPP = new Pattern(pathEnterName);
        screen.click(RUNAPP.similar((float) 0.80));

        screen.type("Thomas" + Key.TAB + "32" + Key.TAB + "2323" + Key.ENTER);

        RUNAPP = new Pattern(pathUserSuccess);
        screen.wait(RUNAPP.similar((float) 0.80), 10);


        RUNAPP = new Pattern(pathRemoveBtn);
        screen.click(RUNAPP.similar((float) 0.80));

    }


    @Test
    public void addValuesAndResetForm() throws FindFailed {


        RUNAPP = new Pattern(pathUser);
        screen.wait(RUNAPP.similar((float) 0.80), 10);


        RUNAPP = new Pattern(pathEnterName);
        screen.click(RUNAPP.similar((float) 0.80));

        screen.type("Thomas" + Key.TAB + "32" + Key.TAB + "2323");

        RUNAPP = new Pattern(pathResetBtn);
        screen.click(RUNAPP.similar((float) 0.80), 10);


        RUNAPP = new Pattern(pathEnterName);
        screen.wait(RUNAPP.similar((float) 0.80), 3);
    }

    @Test
    public void addValuesAndResetFormWithLongName() throws FindFailed {


        RUNAPP = new Pattern(pathUser);
        screen.wait(RUNAPP.similar((float) 0.80), 10);


        RUNAPP = new Pattern(pathEnterName);
        screen.click(RUNAPP.similar((float) 0.80));

        screen.type("Prince-Fritz-Cruene-August-Willem-Jan-Hendrik-Dick" + Key.TAB + "32" + Key.TAB + "2323");

        RUNAPP = new Pattern(pathResetBtn);
        screen.click(RUNAPP.similar((float) 0.80), 10);


        RUNAPP = new Pattern(pathEnterName);
        screen.wait(RUNAPP.similar((float) 0.80), 3);

    }

    @Test
    public void addValuesAndResetFormWithShortName() throws FindFailed {


        RUNAPP = new Pattern(pathUser);
        screen.wait(RUNAPP.similar((float) 0.80), 10);


        RUNAPP = new Pattern(pathEnterName);
        screen.click(RUNAPP.similar((float) 0.80));

        screen.type("An" + Key.TAB + "32" + Key.TAB + "2323");

        RUNAPP = new Pattern(pathResetBtn);
        screen.click(RUNAPP.similar((float) 0.80), 10);


        RUNAPP = new Pattern(pathEnterName);
        screen.wait(RUNAPP.similar((float) 0.80), 3);

    }

    @Test
    public void addUserAndAddDuplicate() throws FindFailed {
        RUNAPP = new Pattern(pathEnterName);
        screen.click(RUNAPP.similar((float) 0.80));

        screen.type("Thomas" + Key.TAB + "32" + Key.TAB + "2323" + Key.ENTER);

        RUNAPP = new Pattern(pathUserSuccess);
        screen.wait(RUNAPP.similar((float) 0.80), 10);

        RUNAPP = new Pattern(pathEnterName);
        screen.click(RUNAPP.similar((float) 0.80));

        screen.type("Thomas" + Key.TAB + "32" + Key.TAB + "2323" + Key.ENTER);

        //check if error is shown
        RUNAPP = new Pattern(pathUserError);
        screen.wait(RUNAPP.similar((float) 0.80), 10);

        RUNAPP = new Pattern(pathRemoveBtn);
        screen.click(RUNAPP.similar((float) 0.80));

    }


    @Test
    public void addUserInvalidFind() throws FindFailed {
        RUNAPP = new Pattern(pathUserError);
        screen.click(RUNAPP.similar((float) 0.80));
    }


    //won't compile because of invalid variable reference
   // @Test
   // public void addUserInvalidVariable() throws FindFailed {
   //     RUNAPP = new Pattern(errorerror);
   //     screen.click(RUNAPP.similar((float) 1));
   // }


}

