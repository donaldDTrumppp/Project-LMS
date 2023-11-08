<%-- 
    Document   : veifyPhone
    Created on : Oct 16, 2023, 12:11:54 AM
    Author     : Nguyen Quoc Trumg
--%>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Verify</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                text-align: center;
            }
            .container {
                background-color: #ffffff;
                border: 1px solid #e0e0e0;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
                margin: 50px auto;
                max-width: 400px;
            }
            h2 {
                color: #333;
            }
            input[type="text"] {
                width: 95%;
                padding: 10px;
                margin: 10px 0;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
            input[type="button"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            input[type="button"]:hover {
                background-color: #45a049;
            }
            .hidden {
                display: none;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Xác minh OTP</h2>
            <div id="sender">
                <input type="text" id="number" value="${requestScope.mobile}"  required/>
                <div id="recaptcha-container"></div>
                <input type="button" id="send" value="Send OTP" onclick="phoneAuth()"/>
            </div>
            <div class="hidden" id="verifier">
                <input type="text" id="verificationcode" placeholder="Nhập mã OTP" required>
                <input type="button" id="verify" value="Verify" onclick="codeverify()"/>
                <div>
                    <p class="n-conf hidden" style="color: red">Mã OTP không hợp lệ. Vui lòng thử lại.</p>
                    <p class="p-conf hidden">Xác minh thành công!</p>
                    <!--<input type="button" class="p-conf hidden" id="redirect-btn" onclick="redirectToLogin()"/>Về trang đăng nhập-->
                </div>
            </div>
        </div>
        <script src="https://www.gstatic.com/firebasejs/9.12.1/firebase-app-compat.js"></script>
        <script src="https://www.gstatic.com/firebasejs/9.12.1/firebase-auth-compat.js"></script>
        <script>
                    // For Firebase JS SDK v7.20.0 and later, measurementId is optional
                    const firebaseConfig = {
                        apiKey: "AIzaSyAUM-Z4f_1T_OQXQZx-P2RYZIIx9FlA7dA",
                        authDomain: "swp-prj.firebaseapp.com",
                        projectId: "swp-prj",
                        storageBucket: "swp-prj.appspot.com",
                        messagingSenderId: "397064042550",
                        appId: "1:397064042550:web:d3d1390655e11784374097",
                        measurementId: "G-ZB6S2CB46D"
                    };
                    firebase.initializeApp(firebaseConfig);
                    render();
                    function render() {
                        window.recaptchaVerifier = new firebase.auth.RecaptchaVerifier('recaptcha-container');
                        recaptchaVerifier.verify();
                    }
                    // function for send message
                    function phoneAuth() {
                        var number = document.getElementById('number').value;
                        console.log(number);
                        if (number.charAt(0) === '0') {
                            number = '+84' + number.substr(1);
                        }
                        firebase.auth().signInWithPhoneNumber(number, window.recaptchaVerifier).then(function (confirmationResult) {
                            window.confirmationResult = confirmationResult;
                            coderesult = confirmationResult;
                            document.getElementById('sender').style.display = 'none';
                            document.getElementById('verifier').style.display = 'block';
                        }).catch(function (error) {
                            alert(error.message);
                        });
                    }
                    // function for code verify
                    function codeverify() {
                        var code = document.getElementById('verificationcode').value;
//                        var hidden = document.getElementById('isHidden').value;
                        coderesult.confirm(code).then(function () {
                            document.getElementsByClassName('p-conf')[0].style.display = 'block';
                            document.getElementsByClassName('n-conf')[0].style.display = 'none';
                            window.location = "http://localhost:9999/prj/updstt";

                        }).catch(function () {
                            document.getElementsByClassName('p-conf')[0].style.display = 'none';
                            document.getElementsByClassName('n-conf')[0].style.display = 'block';
                        });
                    }


//                        function handleSuccess() {
//                            // Lấy số điện thoại
//                            const mobile = document.getElementById('number').value;
//
//                            // Gọi ajax để cập nhật status
//                            $.ajax({
//                                url: '/updstt',
//                                type: 'POST',
//                                data: {mobile},
//                                success: function () {
//                                    // Không cần hiển thị nút trở về trang đăng nhập tại đây
//                                }
//                            });
//                        }
//                        function redirectToLogin() {
//                            window.location.href = '/prj/login'; // Điều hướng đến trang đăng nhập của bạn
//                        }
        </script>

    </body>
</html>