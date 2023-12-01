

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
<section class="wrapper">
    <div class="form signup">
        <header>Signup</header>
        <!-- Display signup errors here -->
        <c:if test="${not empty requestScope.signupError}">
            <div class="error">${requestScope.signupError}</div>
        </c:if>
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
        <!-- Display login errors here -->
        <c:if test="${not empty requestScope.loginError}">
            <div class="error">${requestScope.loginError}</div>
            <script>
                // Display a pop-up with the login error message
                alert('${requestScope.loginError}');
            </script>
        </c:if>
        <form action="login" method="post">
            <input type="text" name="email" placeholder="Email address" required/>
            <input type="password" name="password" placeholder="Password" required/>
            <a href="#">Forgot password?</a>
            <input type="submit" value="Login"/>
        </form>
    </div>

    <script>
        const wrapper = document.querySelector(".wrapper"),
            signupHeader = document.querySelector(".signup header"),
            loginHeader = document.querySelector(".login header");

        // Function to show login form
        function showLoginForm() {
            wrapper.classList.add("active");
        }

        // Event listener for loginHeader click
        loginHeader.addEventListener("click", () => {
            wrapper.classList.add("active");
        });

        // Event listener for signupHeader click
        signupHeader.addEventListener("click", () => {
            wrapper.classList.remove("active");
        });

        // Check for the showLogin parameter in the URL
        const urlParams = new URLSearchParams(window.location.search);
        const showLogin = urlParams.get('showLogin');

        // If showLogin is true, call the showLoginForm function
        if (showLogin === 'true') {
            showLoginForm();
        }

        // Display a pop-up with the login error message (if exists)
        const loginError = '${requestScope.loginError}';
        if (loginError.trim() !== '') {
            alert(loginError);
        }
    </script>
</section>
</body>
</html>
