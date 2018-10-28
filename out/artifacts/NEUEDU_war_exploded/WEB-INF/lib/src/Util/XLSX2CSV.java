package Util;/*
package Util;


import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XLSX2CSV {
*
     * Uses the XSSF Event SAX helpers to do most of the work
     *  of parsing the Sheet XML, and outputs the contents
     *  as a (basic) CSV.


    private class SheetToCSV implements SheetContentsHandler {
        private int currentRow = -1;
        private int currentCol = -1;
        private List<List<String>> sheetList;
        private List<String> tmp;
        public SheetToCSV(List<List<String>> sheetList) {
            this.sheetList = sheetList;
        }

        private void outputMissingRows(int number) {
            for (int i=0; i<number; i++) {
                sheetList.add(noneList);
            }
        }

        @Override
        public void startRow(int rowNum) {
            // If there were gaps, output the missing rows
            outputMissingRows(rowNum-currentRow-1);
            // Prepare for this row
            tmp = new ArrayList<>();
            sheetList.add(tmp);
            currentRow = rowNum;
            currentCol = -1;
        }

        @Override
        public void endRow(int rowNum) {
            // Ensure the minimum number of columns
        }

        @Override
        public void cell(String cellReference, String formattedValue,
                         XSSFComment comment) {

            // gracefully handle missing CellRef here in a similar way as XSSFCell does
            if(cellReference == null) {
                cellReference = new CellAddress(currentRow, currentCol).formatAsString();
            }

            // Did we miss any cells?
            int thisCol = (new CellReference(cellReference)).getCol();
            int missedCols = thisCol - currentCol - 1;
            for (int i=0; i<missedCols; i++) {
                tmp.add(noneString);
            }
            currentCol = thisCol;
            tmp.add(formattedValue);
        }

        @Override
        public void headerFooter(String s, boolean b, String s1) {

        }
    }


    ///////////////////////////////////////

    private final OPCPackage xlsxPackage;
*
     * Destination for data


    private final List<List<List<String>>> list;



    private static final String noneString = "";
    private static final List<String> noneList = new ArrayList<>();

    public List<List<List<String>>> getList() {
        return list;
    }

*
     * Creates a new XLSX -> CSV converter
     *
     * @param pkg        The XLSX package to process


    public XLSX2CSV(OPCPackage pkg) {
        this.xlsxPackage = pkg;
        this.list = new ArrayList<>();
    }

*
     * Parses and shows the content of one sheet
     * using the specified styles and shared-strings tables.
     *
     * @param styles The table of styles that may be referenced by cells in the sheet
     * @param strings The table of strings that may be referenced by cells in the sheet
     * @param sheetInputStream The stream to read the sheet-data from.

     * @exception IOException An IO exception from the parser,
     *            possibly from a byte stream or character stream
     *            supplied by the application.
     * @throws SAXException if parsing the XML data fails.


    public void processSheet(
            StylesTable styles,
            ReadOnlySharedStringsTable strings,
            SheetContentsHandler sheetHandler,
            InputStream sheetInputStream) throws IOException, SAXException {
        DataFormatter formatter = new DataFormatter();
        InputSource sheetSource = new InputSource(sheetInputStream);
        try {
            XMLReader sheetParser = SAXHelper.newXMLReader();
            ContentHandler handler = new XSSFSheetXMLHandler(
                    styles, null, strings, sheetHandler, formatter, false);
            sheetParser.setContentHandler(handler);
            sheetParser.parse(sheetSource);
        } catch(ParserConfigurationException e) {
            throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
        }
    }

*
     * Initiates the processing of the XLS workbook file to CSV.
     *
     * @throws IOException If reading the data from the package fails.
     * @throws SAXException if parsing the XML data fails.


    public void process() throws IOException, OpenXML4JException, SAXException {
        ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(this.xlsxPackage);
        XSSFReader xssfReader = new XSSFReader(this.xlsxPackage);
        StylesTable styles = xssfReader.getStylesTable();
        XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
        int index = 0;
        while (iter.hasNext()) {
            InputStream stream = iter.next();
            String sheetName = iter.getSheetName();
            this.list.add(new ArrayList<>());
            processSheet(styles, strings, new SheetToCSV(list.get(index)), stream);
            stream.close();
            ++index;
        }
    }

    public static List<List<List<String>>> open(InputStream in) throws Exception {

        // The package open is instantaneous, as it should be.
        OPCPackage p = OPCPackage.open(in);
        XLSX2CSV xlsx2csv = new XLSX2CSV(p);
        xlsx2csv.process();
        p.close();
        return xlsx2csv.list;
    }
}
*/
