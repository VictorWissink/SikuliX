

import org.junit.jupiter.api.*;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.DirtiesContext;

import java.awt.event.KeyEvent;
import java.io.IOException;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class editUser {




        private static Pattern RUNAPP;
        private static Screen screen;
        private static String pathSearch, pathNewTab, pathUser, pathEnterName, pathUserSuccess, pathRemoveBtn, pathCrossBtn, pathEditBtn, pathUpdateBtn, pathTxtfieldThomas, pathUpdateSuccess;

        @BeforeAll
        public static void setupTest()throws IOException {

            //clear DB




            //setup

            screen = new Screen();


            //load variables
            //                                  D:/Data/VWissink/Documents/Framework Tries/BaselineProjectSikuliX/BaselineProject/src/test/resources/testimages/
            pathSearch = new ClassPathResource("D:/Data/VWissink/Documents/Framework Tries/BaselineProjectSikuliX/BaselineProject/src/test/resources/testimages/search.png").getPath();
            pathNewTab = new ClassPathResource("D:/Data/VWissink/Documents/Framework Tries/BaselineProjectSikuliX/BaselineProject/src/test/resources/testimages/nieuw_tabblad.png").getPath();
            pathUser = new ClassPathResource("D:/Data/VWissink/Documents/Framework Tries/BaselineProjectSikuliX/BaselineProject/src/test/resources/testimages/user.png").getPath();
            pathEnterName = new ClassPathResource("D:/Data/VWissink/Documents/Framework Tries/BaselineProjectSikuliX/BaselineProject/src/test/resources/testimages/entername.png").getPath();
            pathUserSuccess = new ClassPathResource("D:/Data/VWissink/Documents/Framework Tries/BaselineProjectSikuliX/BaselineProject/src/test/resources/testimages/usercreatedsuccess.png").getPath();
            pathRemoveBtn = new ClassPathResource("D:/Data/VWissink/Documents/Framework Tries/BaselineProjectSikuliX/BaselineProject/src/test/resources/testimages/removebtn.png").getPath();
            pathCrossBtn = new ClassPathResource("D:/Data/VWissink/Documents/Framework Tries/BaselineProjectSikuliX/BaselineProject/src/test/resources/testimages/crossbtn.png").getPath();
            pathEditBtn = new ClassPathResource("D:/Data/VWissink/Documents/Framework Tries/BaselineProjectSikuliX/BaselineProject/src/test/resources/testimages/editbtn.png").getPath();
            pathUpdateBtn = new ClassPathResource("D:/Data/VWissink/Documents/Framework Tries/BaselineProjectSikuliX/BaselineProject/src/test/resources/testimages/updatebtn.png").getPath();
            pathTxtfieldThomas = new ClassPathResource("D:/Data/VWissink/Documents/Framework Tries/BaselineProjectSikuliX/BaselineProject/src/test/resources/testimages/textfieldthomas.png").getPath();
            pathUpdateSuccess = new ClassPathResource("D:/Data/VWissink/Documents/Framework Tries/BaselineProjectSikuliX/BaselineProject/src/test/resources/testimages/userupdatedsuccess.png").getPath();

            openChromeAndGoToPage();


        }

        @AfterAll
        public static void teardownTestClass() throws FindFailed {
            RUNAPP = new Pattern(pathCrossBtn);
            screen.click(RUNAPP.similar((float) 0.90));

        }


        public static void openChromeAndGoToPage() throws IOException {
            //press windows button
            screen.keyDown(KeyEvent.VK_WINDOWS);
            screen.keyUp(KeyEvent.VK_WINDOWS);

            //wait till the windows start menu is visible
            RUNAPP = new Pattern(pathSearch);
            try {
                screen.wait(RUNAPP.similar((float) 0.90), 2);
                //type chrome and press enter to start chrome
                screen.type("chrome" );
                screen.type(Key.ENTER);


                //wait till chrome is open
                RUNAPP = new Pattern(pathNewTab);
                screen.wait(RUNAPP.similar((float) 0.90), 10);

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
                screen.wait(RUNAPP.similar((float) 0.90), 10);
            } catch (FindFailed findFailed) {

                findFailed.printStackTrace();
                throw new IOException("failed to load the application");
            }
        }

        @AfterEach
        public void refresh() {

            //clear DB

            //refresh page
            // screen.type(Key.F5);


        }



        @Test
        public void addUserAndEditIt() throws FindFailed {





            RUNAPP = new Pattern(pathEnterName);
            screen.click(RUNAPP.similar((float) 0.90));

            screen.type("Thomas" + Key.TAB + "32" + Key.TAB + "2323" + Key.ENTER);

            RUNAPP = new Pattern(pathUserSuccess);
            screen.wait(RUNAPP.similar((float) 0.90), 10);

            //click edit button
            RUNAPP = new Pattern(pathEditBtn);
            screen.doubleClick(RUNAPP.similar((float) 0.90));

            //enter new values
            RUNAPP = new Pattern(pathTxtfieldThomas);
            screen.doubleClick(RUNAPP.similar((float) 0.90));

            screen.type("Theodor" + Key.TAB + "31" + Key.TAB + "99999");
            //click update button
            RUNAPP = new Pattern(pathUpdateBtn);
            screen.click(RUNAPP.similar((float) 0.90));


            RUNAPP = new Pattern(pathUpdateSuccess);
            screen.wait(RUNAPP.similar((float) 0.90), 4);


            RUNAPP = new Pattern(pathRemoveBtn);
            screen.click(RUNAPP.similar((float) 0.90));

        }








}
