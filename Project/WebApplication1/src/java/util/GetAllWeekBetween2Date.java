/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import model.Week;

/**
 *
 * @author acer
 */
public class GetAllWeekBetween2Date {

     private int getWeekOfYear(LocalDate endDate) {
        int weekOfYear = endDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        return weekOfYear;
    }

    public List<Week> getAllWeeksBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        // Lấy số tuần giữa hai ngày
        long weeksBetween = (endDate.getYear() - startDate.getYear()) * 52 + (getWeekOfYear(endDate) - getWeekOfYear(startDate));

        // Tạo danh sách các tuần
        List<Week> weeks = new ArrayList<>();

        // Lặp qua tất cả các tuần
        for (long i = 0; i <= weeksBetween; i++) {
            // Lấy ngày bắt đầu của tuần
            LocalDate startDateOfWeek = startDate.plusWeeks(i - 1);
            // Lấy ngày kết thúc của tuần
            LocalDate endDateOfWeek = startDateOfWeek.plusDays(6);
            FormatDate fd = new FormatDate();
            Date s = Date.valueOf(startDateOfWeek.minusDays(1));
            Date e = Date.valueOf(endDateOfWeek.minusDays(1));
            // Thêm tuần vào danh sách
            weeks.add(new Week(s, e, fd.formatDateSQL(s), fd.formatDateSQL(e)));
        }

        return weeks;
    }


}
