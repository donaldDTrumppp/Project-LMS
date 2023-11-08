/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nguyen Quoc Trumg
 */
public class ValidAccount {

    public boolean isValidPassword(String password) {
        if (password.length() < 6 || password.length() > 30) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasNumber = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }

            if (hasNumber && hasUppercase) {
                return true; // Đủ điều kiện
            }
        }

        return false; // Không đủ điều kiện
    }

    public boolean isPhoneNumberValid(String phoneNumber) {
        // Loại bỏ các khoảng trắng ở đầu và cuối chuỗi (nếu có)
        phoneNumber = phoneNumber.trim();

        // Kiểm tra xem số điện thoại có đúng 10 ký tự số và chỉ chứa số
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            return true;
        }

        return false;
    }

    public boolean isEmailAllowed(String email) {
        String allowedEmailPattern = "^[a-zA-Z]{3,10}he17\\d{4}@fpt.edu.vn$";

        // Tạo một Pattern từ mẫu regex
        Pattern pattern = Pattern.compile(allowedEmailPattern);

        // Tạo một Matcher để so khớp với mẫu
        Matcher matcher = pattern.matcher(email);

        // Kiểm tra xem email khớp với mẫu không
        return matcher.matches();
    }

}
