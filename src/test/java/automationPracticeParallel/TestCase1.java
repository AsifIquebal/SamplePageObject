package automationPracticeParallel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.automationPracticePageObjects.HomePage;
import pageObjects.base.ThreadLocalBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestCase1 extends ThreadLocalBase {
    HomePage homePage;

    @Test(dataProvider = "dp")
    public void simpleSearch(String string) {
        homePage = LaunchApplication();
        homePage
                .enterSearchQuery(string)
                .clickOnSearchInButton();
    }

    @DataProvider(name = "dp", parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"Sari"},
                {"CHIFFON"}
        };
    }

    @DataProvider(name = "TestDataProvider")
    public Object[][] getDataFromExcel() {
        String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\testNG\\dataProvider\\TestData.xlsx";
        Object[][] arrayObject = getExcelData(excelFilePath, "TestData");
        return arrayObject;
    }

    // @param File Name * @param Sheet Name * @return
    public String[][] getExcelData(String fileName, String sheetName) {
        String[][] arrayExcelData = null;
        try {
            FileInputStream fs = new FileInputStream(fileName);
            XSSFWorkbook wb = new XSSFWorkbook(fs);
            //Workbook workbook = WorkbookFactory.create(fs);
            XSSFSheet sh = wb.getSheet(sheetName);
            int totalNoOfRows = sh.getLastRowNum() + 1;
            int column = sh.getRow(0).getLastCellNum();
            arrayExcelData = new String[totalNoOfRows][column];
            for (int i = 0; i < totalNoOfRows; i++) {
                for (int j = 0; j < column; j++) {
                    /*DataFormatter formatter = new DataFormatter();
                    String cellData = formatter.formatCellValue(sh.getRow(i).getCell(j));
                    arrayExcelData[i][j] = cellData;*/
                    arrayExcelData[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
                }
            }
            wb.close();
            fs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayExcelData;
    }
    /*@Test(dataProvider = "dp1")
    public void simpleSearch1(String string) {
        System.out.println("" + Thread.currentThread().getName());
        homePage = LaunchApplication();
        homePage
                .enterSearchQuery(string)
                .clickOnSearchInButton();
    }

    @DataProvider(name = "dp1")
    public Object[][] getData1(){
        return new Object[][]{
                {"Sari"},
                {"CHIFFON"}
        };
    }*/
}