<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Login & Signup Form</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
<%--<%@include file="../includes/headers.jsp" %>--%>
<section class="wrapper">
    <div class="form signup">
        <header>Signup</header>
        <form action="signup" method="post">
            <input name="name" type="text" placeholder="Full name" required/>
            <input type="email" name="email" placeholder="Email address" required/>
            <input type="password" name="password" placeholder="Password" required/>
            <div class="checkbox">
                <input type="checkbox" id="signupCheck"/>
                <label for="signupCheck">I accept all terms & conditions</label>
            </div>
            <input type="submit" value="Signup"/>
        </form>
    </div>

    <div class="form login">
        <header>Login</header>
        <form action="login" method="post">
            <input type="text" name="email" placeholder="Email address" required/>
            <input type="password" name="password" placeholder="Password" required/>
            <a href="#">Forgot password?</a>
            <input type="submit" value="Login"/>
        </form>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const wrapper = document.querySelector(".wrapper"),
                signupHeader = document.querySelector(".signup header"),
                loginHeader = document.querySelector(".login header");

            // Function to show login form
            function showLoginForm() {
                wrapper.classList.add("active");
                document.getElementById('loginEmail').focus(); // Set focus on the login form's email input
            }

            // Event listener for loginHeader click
            loginHeader.addEventListener("click", () => {
                wrapper.classList.add("active");
                document.getElementById('loginEmail').focus(); // Set focus on the login form's email input
            });

            // Event listener for signupHeader click
            signupHeader.addEventListener("click", () => {
                wrapper.classList.remove("active");
            });
            const urlParams = new URLSearchParams(window.location.search);
            const showLogin = urlParams.get('showLogin');
            // Display a pop-up with the login error message (if exists)
             const loginError = '<%= request.getAttribute("loginError") %>';
            const signupError = '<%= request.getAttribute("signupError") %>';
            if (loginError.trim() !== '' && loginError.trim() !== 'null')  {
                alert(loginError);
                showLoginForm();
            }
            // Display the login form if the showLogin parameter is true
            if (showLogin === 'true') {
                showLoginForm();
            }
            if (signupError.trim() !== '' && signupError.trim() !== 'null')  {
                alert(signupError);
                showLoginForm();
            }
        });
    </script>
</section>
</body>
</html>
