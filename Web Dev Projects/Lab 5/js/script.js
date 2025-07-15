// script.js

// Function to validate the form
function validate() {
  // Get form elements
  var emailInput = document.getElementById("email");
  var loginInput = document.getElementById("login");
  var passInput = document.getElementById("pass");
  var pass2Input = document.getElementById("pass2");
  var newsletterInput = document.getElementById("newsletter");
  var termsInput = document.getElementById("terms");

  // Get input values
  var email = emailInput.value;
  var login = loginInput.value;
  var pass = passInput.value;
  var pass2 = pass2Input.value;

  var emailInputErrorMsg = "× Email address should be non-empty with the format xyx@xyz.xyz"
  var loginInputErrorMsg = "× User name should be non-empty, and within than 20 characters"
  var passInputErrorMsg = "× Password should be at least 6 characters: one uppercase, one lowercase"
  var passInputErrorMsg2 = "× Password should have at least one uppercase and one lowercase letter"
  var pass2InputErrorMsg = "× Please retype password"
  var termsInputErrorMsg = "× Please accept the terms and conditions"

  // Reset previous error messages and styling
  const errorMessages = document.querySelectorAll(".error-message");
  for (var i = 0; i < errorMessages.length; i++) {
    errorMessages[i].remove();
  }
  var valid = true;
  // Validate email format
  var emailPattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  if (!email.match(emailPattern)) {
    emailInput.classList.add("error");
    displayErrorMessage(emailInput, emailInputErrorMsg);
    valid = false;
  }
  else {
    emailInput.classList.remove("error");
  }

  // Validate login name length
  if (login.length === 0 || login.length > 20) {
    loginInput.classList.add("error");
    displayErrorMessage(loginInput, loginInputErrorMsg);
    valid = false;
  }
  else {
    loginInput.classList.remove("error");
  }

  // Convert login name to lowercase
  login = login.replace(/[^a-z]/g, '');
  loginInput.value = login.toLowerCase();

  // Validate password length
  if (pass.length < 6) {
    passInput.classList.add("error");
    displayErrorMessage(passInput, passInputErrorMsg);
    valid = false;
  }
  else {
    passInput.classList.remove("error");
  }

  // Validate password pattern (at least one uppercase and lowercase letter)
  var passPattern = /^(?=.*[a-z])(?=.*[A-Z]).*$/;
  if (!pass.match(passPattern) && pass.length > 1) {
    passInput.classList.add("error");
    displayErrorMessage(passInput, passInputErrorMsg2);
    valid = false;
  }
  else {
    pass2Input.classList.remove("error");
  }

  // Validate password match
  if (pass !== pass2 || pass === "" || pass2 === "") {
    passInput.classList.add("error");
    pass2Input.classList.add("error");
    displayErrorMessage(pass2Input, pass2InputErrorMsg);
    valid = false;
  }
  else {
    passInput.classList.remove("error");
    pass2Input.classList.remove("error");
  }

  // Validate terms and conditions acceptance
  if (!termsInput.checked) {
    displayErrorMessage(termsInput, termsInputErrorMsg);
    valid = false;
  }

  // if (emailInput.value == "" &&
  // loginInput.value == "" &&
  // passInput.value == "" &&
  // pass2Input.value == "") {
  //   displayErrorMessage(emailInput, termsInputErrorMsg);
  //   displayErrorMessage(loginInput, termsInputErrorMsg);
  //   displayErrorMessage(passInput, termsInputErrorMsg);
  //   displayErrorMessage(pass2Input, termsInputErrorMsg);
  //   // displayErrorMessage(termsInput, termsInputErrorMsg);
  //   valid = false;
  // }

  // Successful form submission
  if (email.match(emailPattern) &&
  (login.length !== 0 || login.length < 20) &&
  pass.length > 6 &&
  pass.match(passPattern) &&
  (pass === pass2 || pass !== "" || pass2 !== "") &&
  termsInput.checked) {
    alert("Form submitted successfully!");
    return valid;
  }
  // Clear form fields
  if (emailInput.value != "" &&
  loginInput.value != "" &&
  passInput.value != "" &&
  pass2Input.value != "" &&
  termsInput.checked) {
  emailInput.value = "";
  loginInput.value = "";
  passInput.value = "";
  pass2Input.value = "";
  !termsInput.checked;
  }
  return false;
}

// Function to display an error message below the specified input field
function displayErrorMessage(inputField, message) {
  var errorMessage = document.createElement("div");
  errorMessage.className = "error-message";
  errorMessage.innerText = message;
  inputField.parentNode.appendChild(errorMessage);
}
// Function to display a popup after clicking on the receive weekly newsletters checkbox
function onNewsletterClick() {
  var newsletterInput = document.getElementById("newsletter");
  if (newsletterInput.checked) {
    alert("Be aware that you may receive spam by subscribing to the newsletter.");
  }
}

function removeErrors() {
    emailInput.classList.remove("error");
    loginInput.classList.remove("error");
    passInput.classList.remove("error");
    pass2Input.classList.remove("error");
    termsInput.classList.remove("error");
}