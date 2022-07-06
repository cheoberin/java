package main.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UserUpdate {

	public static void main(String[] args) throws IOException {

		ArrayList<String> dasID = new ArrayList<String>();
		ArrayList<String> idCostCenter = new ArrayList<String>(); // fazer o update logo abaixo? sei não eim...
		ArrayList<String> uniqueIdCostCenter = new ArrayList<String>();
		ArrayList<String> costCenterName = new ArrayList<String>(); // o nome já tá aqui...
		ArrayList<String> uniqueCostCenterName = new ArrayList<String>();

		ArrayList<Integer> idOrgUnit = new ArrayList<Integer>(); // mesma coisa dos de cima
		ArrayList<Integer> uniqueIdOrgUnit = new ArrayList<Integer>();
		ArrayList<String> orgUnitName = new ArrayList<String>(); // e dale nome...
		ArrayList<String> uniqueOrgUnitName = new ArrayList<String>();
		ArrayList<String> gcm = new ArrayList<String>(); // aqui vai ter que ser direto do excel, vai ter jeito não,
															// procura, pega o ID e da insert
		ArrayList<String> dasIdGestor = new ArrayList<String>();
		ArrayList<String> location = new ArrayList<String>(); // isso vai dar uma merda colossal que eu nem sei como
																// resolver
		ArrayList<Integer> nessieId = new ArrayList<Integer>();
		ArrayList<Integer> payrollSystemNumber = new ArrayList<Integer>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Integer> status = new ArrayList<Integer>(); // 1 - ativo | 2 - inativo
		ArrayList<String> email = new ArrayList<String>();
		ArrayList<String> practice = new ArrayList<String>(); // validar isso com a aline
		ArrayList<String> subpractice = new ArrayList<String>(); // isso também
		ArrayList<String> market = new ArrayList<String>(); // e isso também

		File excelFile = new File("src/main/resources/userupdate.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIt = sheet.iterator();

		while (rowIt.hasNext()) {
			Row row = rowIt.next();
			Iterator<Cell> cellIt = row.cellIterator();
			if (row.getRowNum() >= 1) {
				while (cellIt.hasNext()) {
					Cell cell = cellIt.next();

					if (cell.getColumnIndex() == 0) {
						nessieId.add(Integer.parseInt(cell.getStringCellValue()));
					} else if (cell.getColumnIndex() == 1) {
						dasID.add(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 2) {
						if (cell.getStringCellValue() != "") {
							payrollSystemNumber.add(Integer.parseInt(cell.getStringCellValue()));
						} else {
							payrollSystemNumber.add(0);
						}
					} else if (cell.getColumnIndex() == 3) {
						name.add(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 4) {
						if (cell.getStringCellValue() == "Active") {
							status.add(1);
						} else {
							status.add(2);
						}
					} else if (cell.getColumnIndex() == 6) {
						dasIdGestor.add(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 8) {
						// FAZER LÓGICA DO INSERT E GET ID AQUI
						gcm.add(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 11) {
						// vai fazer aqui também?
						practice.add(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 12) {
						// e aqui?
						subpractice.add(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 13) {
						// e aqui?
						market.add(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 17) {
						idCostCenter.add(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 18) {
						costCenterName.add(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 19) {
						idOrgUnit.add(Integer.parseInt(cell.getStringCellValue()));
					} else if (cell.getColumnIndex() == 20) {
						orgUnitName.add(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 26) {
						// to fodido nisso aqui
						location.add(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 27) {
						email.add(cell.getStringCellValue());
					}
				}
			}
		}
		workbook.close();
		fis.close();

		for (int i = 0; i < idCostCenter.size(); i++) {
			if (!uniqueIdCostCenter.contains(idCostCenter.get(i))) {
				uniqueIdCostCenter.add(idCostCenter.get(i));
				uniqueCostCenterName.add(costCenterName.get(i));
			}
		}

		for (int i = 0; i < idOrgUnit.size(); i++) {
			if (!uniqueIdOrgUnit.contains(idOrgUnit.get(i))) {
				uniqueIdOrgUnit.add(idOrgUnit.get(i));
				uniqueOrgUnitName.add(orgUnitName.get(i));
			}
		}

		idOrgUnit.forEach(orgUnit -> {
			if (!uniqueIdOrgUnit.contains(orgUnit)) {
				uniqueIdOrgUnit.add(orgUnit);
			}
		});

		for (String aux : uniqueOrgUnitName) {
			System.out.println(aux);
		}

		uniqueCostCenterName.forEach(costCenter -> System.out.println(costCenter));
	}
}
