package com.booking.util;

import com.booking.entities.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class UserServiceUtils {

    public static ByteArrayInputStream usersToExcel(List<User> users) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet("Users");

            // Create header row
            Row headerRow = sheet.createRow(0);
            Cell cell = headerRow.createCell(0);
            cell.setCellValue("ID");
            cell = headerRow.createCell(1);
            cell.setCellValue("First Name");
            cell = headerRow.createCell(2);
            cell.setCellValue("Last Name");
            cell = headerRow.createCell(3);
            cell.setCellValue("Email");
            cell = headerRow.createCell(4);
            cell.setCellValue("Phone Number");
            cell = headerRow.createCell(5);
            cell.setCellValue("Created At");
            cell = headerRow.createCell(6);
            cell.setCellValue("Updated At");

            // Populate data rows
            int rowCount = 1;
            for (User user : users) {
                Row row = sheet.createRow(rowCount++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getFirstName());
                row.createCell(2).setCellValue(user.getLastName());
                row.createCell(3).setCellValue(user.getEmail());
                row.createCell(4).setCellValue(user.getPhoneNumber());
                row.createCell(5).setCellValue(user.getCreatedAt().toString());
                row.createCell(6).setCellValue(user.getUpdatedAt().toString());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Failed to create Excel file", e);
        }
    }
    public static String usersToCsv(List<User> users) {
        StringBuilder csvBuilder = new StringBuilder();

        // Add header row
        csvBuilder.append("ID,First Name,Last Name,Email,Phone Number,Created At,Updated At\n");

        // Add data rows
        for (User user : users) {
            csvBuilder.append(user.getId()).append(",");
            csvBuilder.append(user.getFirstName()).append(",");
            csvBuilder.append(user.getLastName()).append(",");
            csvBuilder.append(user.getEmail()).append(",");
            csvBuilder.append(user.getPhoneNumber()).append(",");
            csvBuilder.append(user.getCreatedAt()).append(",");
            csvBuilder.append(user.getUpdatedAt()).append("\n");
        }

        return csvBuilder.toString();
    }

}
