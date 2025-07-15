<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $firstName = $_POST['First Name'];
    $lastName = $_POST['Last Name'];
    $email = $_POST['Email'];

    // Process the data (can add other logic here)
    // For example, save the data to a database or send it through email

    // Display a success message
    echo "Form submitted successfully!";
    exit;
}
?>
