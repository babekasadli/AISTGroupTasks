package AISTGroup.ders2.task1_v3;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Scrapper {
    //Scaperi başlatmadan önce TARGET_PAGE burada təyin edilməlidir.
    private static final int TARGET_PAGE = 5;
    private static final String PROPERTIES = "scraper.properties";

    public static void main(String[] args) {
        Properties properties = loadProperties();

        int lastPage = Integer.parseInt(properties.getProperty("lastPage", "0"));

        List<String[]> carDataList = new ArrayList<>();
        for (int pageNumber = lastPage + 1; pageNumber <= TARGET_PAGE; pageNumber++) {
            System.out.println("Processing page " + pageNumber + "...");
            String url = "https://turbo.az/autos/?page=" + pageNumber;
            try {
                Document doc = Jsoup.connect(url).get();
                Elements carLinks = doc.select("a.products-i__link[href]");

                for (Element link : carLinks) {
                    String carLink = link.attr("href");
                    Document carPage = Jsoup.connect("https://turbo.az/" + carLink).get();

                    List<String> carData = new ArrayList<>();
                    Elements elements = carPage.select("div.product-properties__column div.product-properties__i");

                    for (Element element : elements) {
                        String title = element.select("label.product-properties__i-name").text();
                        String value = element.select("span.product-properties__i-value").text();
                        carData.add(title + ": " + value);
                    }

                    Element priceElement = carPage.selectFirst(".product-price__i");
                    String price = priceElement.text();
                    carData.add("Qiymet: " + price);

                    carDataList.add(carData.toArray(new String[0]));
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        if (!carDataList.isEmpty()) {
            writeDataToExcel(carDataList);
            System.out.println("Data scrapped from page " + lastPage + " to " + TARGET_PAGE);
            properties.setProperty("lastPage", String.valueOf(TARGET_PAGE));
            saveProperties(properties);
        } else {
            System.out.println("TARGET_PAGE should be greater than " + lastPage);
        }

    }

    private static void writeDataToExcel(List<String[]> carDataList) {
        try {
            File file = new File("car_data.xlsx");
            Workbook workbook;

            if (!file.exists()) {
                workbook = new XSSFWorkbook();
            } else {
                FileInputStream inputStream = new FileInputStream(file);
                workbook = new XSSFWorkbook(inputStream);
            }

            Sheet sheet;
            if (workbook.getNumberOfSheets() == 0) {
                sheet = workbook.createSheet("Car Data");
            } else {
                sheet = workbook.getSheetAt(0);
            }

            if (!carDataList.isEmpty()) {
                for (String[] carData : carDataList) {
                    Row row = sheet.createRow(sheet.getLastRowNum() + 1);
                    int cellNum = 0;
                    for (String data : carData) {
                        Cell cell = row.createCell(cellNum++);
                        cell.setCellValue(data);
                    }
                }

                FileOutputStream outputStream = new FileOutputStream("car_data.xlsx");
                workbook.write(outputStream);
                outputStream.close();
                System.out.println("Success!");
            } else {
                System.out.println("No data to write!");
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(PROPERTIES)) {
            properties.load(inputStream);
        } catch (IOException e) {
            saveProperties(properties);
        }
        return properties;
    }

    private static void saveProperties(Properties properties) {
        try (OutputStream outputStream = new FileOutputStream(PROPERTIES)) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}