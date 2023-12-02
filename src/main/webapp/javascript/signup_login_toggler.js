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