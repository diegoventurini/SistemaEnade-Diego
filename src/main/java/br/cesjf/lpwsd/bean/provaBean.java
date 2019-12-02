/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.bean;

import br.cesjf.lpwsd.dao.ProvaDAO;
import br.cesjf.lpwsd.model.Prova;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author diego
 */
@ManagedBean
@ViewScoped
public class provaBean {

    Prova prova = new Prova();

    List provas = new ArrayList();

    //construtor
    public provaBean() {
        provas = new ProvaDAO().buscarTodas();
        prova = new Prova();
    }
    
    //Métodos dos botões 
    public void record(ActionEvent actionEvent) {
        new ProvaDAO().persistir(prova);
        provas = new ProvaDAO().buscarTodas();
        prova = new Prova();
    }

    public void exclude(ActionEvent actionEvent) {
        new ProvaDAO().remover(prova);
        provas = new ProvaDAO().buscarTodas();
        prova = new Prova();
    }

    //getters and setters
    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public List getProvas() {
        return provas;
    }

    public void setProvas(List provas) {
        this.provas = provas;
    }

    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);

        HSSFCellStyle cellStyle = wb.createCellStyle();
        //cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
            HSSFCell cell = header.getCell(i);

            cell.setCellStyle(cellStyle);
        }
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

    }
    


}
