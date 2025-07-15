// script.js

// Function to validate the form
function validate() {
    // Get form elements
    var titleInput = document.getElementById("title");
    var descriptionInput = document.getElementById("description");
    var genreInput = document.getElementById("pass");
    var subjectInput = document.getElementById("subject");
    var starInput = document.getElementById("Star");
    var yearInput = document.getElementById("year");
    var ProductionInput = document.getElementById("Production");
  
    // Get input values
    var title = titleInput.value;
    var description = descriptionInput.value;
    var pass = genreInput.value;
    var subject = subjectInput.value;
  
    var titleInputErrorMsg = "× Title should be non-empty with the format xyx@xyz.xyz"
    var descriptionInputErrorMsg = "× Description should be non-empty, and within than 20 characters"
    var genreInputErrorMsg = "× Password should be at least 6 characters: one uppercase, one lowercase"
    var genreInputErrorMsg2 = "× Password should have at least one uppercase and one lowercase letter"
    var subjectInputErrorMsg = "× Please retype password"
    var yearInputErrorMsg = "× Please accept the year and conditions"
  
    // Reset previous error messages and styling
    const errorMessages = document.querySelectorAll(".error-message");
    for (var i = 0; i < errorMessages.length; i++) {
      errorMessages[i].remove();
    }
    var valid = true;
    // Validate title format
    var titlePattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (!title.match(titlePattern)) {
      titleInput.classList.add("error");
      displayErrorMessage(titleInput, titleInputErrorMsg);
      valid = false;
    }
    else {
      titleInput.classList.remove("error");
    }
  
    // Validate description name length
    if (description.length === 0 || description.length > 20) {
      descriptionInput.classList.add("error");
      displayErrorMessage(descriptionInput, descriptionInputErrorMsg);
      valid = false;
    }
    else {
      descriptionInput.classList.remove("error");
    }
  
    // Convert description name to lowercase
    description = description.replace(/[^a-z]/g, '');
    descriptionInput.value = description.toLowerCase();
  
    // Validate password length
    if (pass.length < 6) {
      genreInput.classList.add("error");
      displayErrorMessage(genreInput, genreInputErrorMsg);
      valid = false;
    }
    else {
      genreInput.classList.remove("error");
    }
  
    // Validate password pattern (at least one uppercase and lowercase letter)
    var passPattern = /^(?=.*[a-z])(?=.*[A-Z]).*$/;
    if (!pass.match(passPattern) && pass.length > 1) {
      genreInput.classList.add("error");
      displayErrorMessage(genreInput, genreInputErrorMsg2);
      valid = false;
    }
    else {
      subjectInput.classList.remove("error");
    }
  
    // Validate password match
    if (pass !== subject || pass === "" || subject === "") {
      genreInput.classList.add("error");
      subjectInput.classList.add("error");
      displayErrorMessage(subjectInput, subjectInputErrorMsg);
      valid = false;
    }
    else {
      genreInput.classList.remove("error");
      subjectInput.classList.remove("error");
    }
  
    // Validate year and conditions acceptance
    if (!yearInput.checked) {
      displayErrorMessage(yearInput, yearInputErrorMsg);
      valid = false;
    }
  
    // if (titleInput.value == "" &&
    // descriptionInput.value == "" &&
    // genreInput.value == "" &&
    // subjectInput.value == "") {
    //   displayErrorMessage(titleInput, yearInputErrorMsg);
    //   displayErrorMessage(descriptionInput, yearInputErrorMsg);
    //   displayErrorMessage(genreInput, yearInputErrorMsg);
    //   displayErrorMessage(subjectInput, yearInputErrorMsg);
    //   // displayErrorMessage(yearInput, yearInputErrorMsg);
    //   valid = false;
    // }
  
    // Successful form submission
    if (title.match(titlePattern) &&
    (description.length !== 0 || description.length < 20) &&
    pass.length > 6 &&
    pass.match(passPattern) &&
    (pass === subject || pass !== "" || subject !== "") &&
    yearInput.checked) {
      alert("Form submitted successfully!");
      return valid;
    }
    // Clear form fields
    if (titleInput.value != "" &&
    descriptionInput.value != "" &&
    genreInput.value != "" &&
    subjectInput.value != "" &&
    yearInput.checked) {
    titleInput.value = "";
    descriptionInput.value = "";
    genreInput.value = "";
    subjectInput.value = "";
    !yearInput.checked;
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
  // Function to display a popup after clicking on the receive weekly Stars checkbox
  function onStarClick() {
    var starInput = document.getElementById("Star");
    if (starInput.checked) {
      alert("Be aware that you may receive spam by subscribing to the Star.");
    }
  }
  
  function removeErrors() {
      titleInput.classList.remove("error");
      descriptionInput.classList.remove("error");
      genreInput.classList.remove("error");
      subjectInput.classList.remove("error");
      yearInput.classList.remove("error");
  }