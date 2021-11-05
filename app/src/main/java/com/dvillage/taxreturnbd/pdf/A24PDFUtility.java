package com.dvillage.taxreturnbd.pdf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.dvillage.taxreturnbd.R;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class A24PDFUtility {

    private static final String TAG = A24PDFUtility.class.getSimpleName();
    private static Font FONT_TITLE = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font FONT_SUBTITLE = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
    private static Font FONT_CELL = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    private static Font FONT_COLUMN = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL);

    public interface OnDocumentClose {
        void onPDFDocumentClose(File file);
    }
    public static void createPdf(@NonNull Context context, OnDocumentClose callback, List<String[]> items, @NonNull String filePath, boolean isPortrait) throws Exception {
        if(filePath.equals("")) {
            throw new NullPointerException("PDF File Name can't be null or blank.PDF File can't be created");
        }
        File file = new File (filePath);
        if (file.exists()) {
            file.delete();
            Thread.sleep(50);
        }

        Document document = new Document();
        document.setMargins(24f, 24f, 32f, 32f);
        document.setPageSize(isPortrait? PageSize.A4:PageSize.A4.rotate());

        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(filePath));
        pdfWriter.setFullCompression();
        //  pdfWriter.setPageEvent(new PageNumeration());

        document.open();

        setMetaData(document);
        addHeader(context, document);
        document.add(createDataTable(items));
        document.add(createSignBox());
        document.close();

        try {
            pdfWriter.close();
        } catch (Exception ex) {
            Log.e(TAG, "Error While Closing PDF Writter: "+ ex.toString());
        }

        if (callback!=null) {
            callback.onPDFDocumentClose(file);
        }
    }

    private static  void setMetaData(Document document) {
        document.addCreationDate();
        document.addAuthor("Santosh Barai");
        document.addCreator("Santosh Barai");
        document.addHeader("DEVELOPER", "SANTOSH BARAI");
    }

    private static void addHeader(Context context, Document document) throws Exception {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{ 2,7,2});
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell cell;
        {
            Drawable d = ContextCompat.getDrawable(context, R.mipmap.splash_logo);
            Bitmap bmp = ((BitmapDrawable) d).getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);

            Image logo = Image.getInstance(stream.toByteArray());
            logo.setWidthPercentage(80);
            logo.scaleToFit(105, 55);

            cell = new PdfPCell(logo);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setUseAscender(true);
            cell.setBorder(PdfPCell.NO_BORDER);
            cell.setPadding(2f);
            table.addCell(cell);
        }

        {
            /*MIDDLE TEXT*/
            cell = new PdfPCell();
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorder(PdfPCell.NO_BORDER);
            cell.setPadding(8f);
            cell.setUseAscender(true);

            Paragraph temp = new Paragraph("I AM TITLE" ,FONT_TITLE);
            temp.setAlignment(Element.ALIGN_CENTER);
            cell.addElement(temp);

            temp = new Paragraph("I am Subtitle" ,FONT_SUBTITLE);
            temp.setAlignment(Element.ALIGN_CENTER);
            cell.addElement(temp);

            table.addCell(cell);
        }
        /* RIGHT TOP LOGO*/
        {
            PdfPTable logoTable=new PdfPTable(1);
            logoTable.setWidthPercentage(100);
            logoTable.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            logoTable.setHorizontalAlignment(Element.ALIGN_CENTER);
            logoTable.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);

            Drawable drawable=ContextCompat.getDrawable(context, R.mipmap.splash_logo);
            Bitmap bmp =((BitmapDrawable)drawable).getBitmap();

            ByteArrayOutputStream stream=new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG,100,stream);
            Image logo=Image.getInstance(stream.toByteArray());
            logo.setWidthPercentage(80);
            logo.scaleToFit(38,38);

            PdfPCell logoCell = new PdfPCell(logo);
            logoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            logoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            logoCell.setBorder(PdfPCell.NO_BORDER);

            logoTable.addCell(logoCell);

            logoCell = new PdfPCell(new Phrase("Logo Text",FONT_CELL));
            logoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            logoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            logoCell.setBorder(PdfPCell.NO_BORDER);
            logoCell.setPadding(4f);
            logoTable.addCell(logoCell);

            cell = new PdfPCell(logoTable);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setUseAscender(true);
            cell.setBorder(PdfPCell.NO_BORDER);
            cell.setPadding(2f);
            table.addCell(cell);
        }

        document.add(table);
    }


    private static PdfPTable createDataTable(List<String[]> dataTable) throws DocumentException {
        PdfPTable table1 = new PdfPTable(5);
        table1.setWidthPercentage(100);
        table1.setWidths(new float[] {1f, 2f, 2f, 2f, 2f});
        table1.setHeaderRows(1);
        table1.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);
        table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell cell;
        {
            cell = new PdfPCell(new Phrase("Col-1", FONT_COLUMN));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(4f);
            table1.addCell(cell);

            cell = new PdfPCell(new Phrase("Col-2", FONT_COLUMN));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(4f);
            table1.addCell(cell);

            cell = new PdfPCell(new Phrase("Col-3", FONT_COLUMN));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(4f);
            table1.addCell(cell);

            cell = new PdfPCell(new Phrase("Col-3", FONT_COLUMN));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(4f);
            table1.addCell(cell);

            cell = new PdfPCell(new Phrase("Col-3", FONT_COLUMN));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(4f);
            table1.addCell(cell);
        }

        float top_bottom_Padding = 8f;
        float left_right_Padding = 4f;
        boolean alternate = false;

        BaseColor lt_gray = new BaseColor(221, 221, 221);
        BaseColor cell_color;

        int size = dataTable.size();

        for (int i =0; i<size; i++) {
            cell_color = alternate? lt_gray:BaseColor.WHITE;
            String[] temp = dataTable.get(i);

            cell = new PdfPCell(new Phrase(temp[0], FONT_CELL));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingLeft(left_right_Padding);
            cell.setPaddingRight(left_right_Padding);
            cell.setPaddingTop(top_bottom_Padding);
            cell.setPaddingBottom(top_bottom_Padding);
            cell.setBackgroundColor(cell_color);
            table1.addCell(cell);

            cell = new PdfPCell(new Phrase(temp[1], FONT_CELL));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingLeft(left_right_Padding);
            cell.setPaddingRight(left_right_Padding);
            cell.setPaddingTop(top_bottom_Padding);
            cell.setPaddingBottom(top_bottom_Padding);
            cell.setBackgroundColor(cell_color);
            table1.addCell(cell);

            cell = new PdfPCell(new Phrase(temp[2], FONT_CELL));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingLeft(left_right_Padding);
            cell.setPaddingRight(left_right_Padding);
            cell.setPaddingTop(top_bottom_Padding);
            cell.setPaddingBottom(top_bottom_Padding);
            cell.setBackgroundColor(cell_color);
            table1.addCell(cell);

            cell = new PdfPCell(new Phrase(temp[3], FONT_CELL));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingLeft(left_right_Padding);
            cell.setPaddingRight(left_right_Padding);
            cell.setPaddingTop(top_bottom_Padding);
            cell.setPaddingBottom(top_bottom_Padding);
            cell.setBackgroundColor(cell_color);
            table1.addCell(cell);

            cell = new PdfPCell(new Phrase(temp[4], FONT_CELL));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingLeft(left_right_Padding);
            cell.setPaddingRight(left_right_Padding);
            cell.setPaddingTop(top_bottom_Padding);
            cell.setPaddingBottom(top_bottom_Padding);
            cell.setBackgroundColor(cell_color);
            table1.addCell(cell);

            alternate = !alternate;
        }
        return table1;
    }

    private static PdfPTable createSignBox() throws DocumentException {
        PdfPTable outerTable = new PdfPTable(1);
        outerTable.setWidthPercentage(100);
        outerTable.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        PdfPTable innerTable = new PdfPTable(2);
        {
            innerTable.setWidthPercentage(100);
            innerTable.setWidths(new float[] {1,1});
            innerTable.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

            //ROW-1: EMPTY SPACE
            PdfPCell cell = new PdfPCell();
            cell.setBorder(PdfPCell.NO_BORDER);
            cell.setFixedHeight(60);
            innerTable.addCell(cell);//ROW-1: EMPTY SPACE

            //ROW-2: EMPTY SPACE
            cell = new PdfPCell();
            cell.setBorder(PdfPCell.NO_BORDER);
            cell.setFixedHeight(60);
            innerTable.addCell(cell);

            //ROW-2: EMPTY SPACE
            cell = new PdfPCell();
            Paragraph temp = new Paragraph(new Phrase("Signature of Supervisor", FONT_SUBTITLE));
            cell.addElement(temp);

            temp = new Paragraph(new Phrase("(Barai Santosh)", FONT_SUBTITLE));
            temp.setPaddingTop(4f);
            temp.setAlignment(Element.ALIGN_LEFT);
            cell.addElement(temp);

            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorder(PdfPCell.NO_BORDER);
            cell.setPadding(4f);
            innerTable.addCell(cell);

            //ROW-4 : Content Right Aligned
            cell = new PdfPCell(new Phrase("Signature of Staff", FONT_SUBTITLE));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorder(PdfPCell.NO_BORDER);
            cell.setPadding(4f);
            innerTable.addCell(cell);
        }

        PdfPCell signRow = new PdfPCell(innerTable);
        signRow.setHorizontalAlignment(Element.ALIGN_LEFT);
        signRow.setBorder(PdfPCell.NO_BORDER);
        signRow.setPadding(4f);
        outerTable.addCell(signRow);

        return outerTable;
    }
}
