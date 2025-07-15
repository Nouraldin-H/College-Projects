<!-- TODO: Something about bootstrap, validation like in lab 5, etc. -->

<!-- write your PHP script to define two string array -->
<!--write your php function  here -->
<?php
// Define two string arrays
$genres = array("Action", "Adventure", "Comedy", "Drama");
$subjects = array("Animation", "Children and Youth", "People");

// Function to generate <select> options based on the given string array
function generateOptions($array) {
    $options = "";
    foreach ($array as $element) {
        $options .= "<option>$element</option>";
    }
    return $options;
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Chapter 12</title>    
    
    <link rel="stylesheet" href="css/styles1.css" />

</head>
<body>
<!-- include the header file here -->
<?php include 'headerM.php'; ?>
    
<main>
<form class="form" method="post" action="process.php" id="mainForm" onsubmit="return validate(event);">
    <fieldset class="form__panel">
        <legend class="form__heading">Edit Movie Details</legend>
        <p class="form__row">
            <label for="title">Title</label><br/>
            <input type="text" name="title" id="title" class="form__input form__input--large"/>
        </p>
        <p class="form__row">
            <label for="description">Description</label><br/>
            <input type="text" name="description" id="description" class="form__input form__input--large">
        </p>            
        <p class="form__row"> 
            <label for="genre">Genre</label><br/>
            <select name="genre" id="genre" class="form__input form__select">
                <option>Choose genre</option> 
                <?php echo generateOptions($genres); ?>
            </select>
        </p>
        <p class="form__row"> 
            <label for="subject">Subject</label><br/>
            <select name="subject" id="subject" class="form__input form__select">
                <option>Choose subject</option> 
                <?php echo generateOptions($subjects); ?>
            </select>
        </p>
        <p class="form__row">	
            <label for="Star">Star</label><br/>               
            <input type="text" name="Star" id="Star"class="form__input form__input--medium" />
        </p>
        <p class="form__row">	
            <label for="year">Year</label><br/>               
            <input type="text" name="year" id="year" class="form__input form__input--small" />
        </p>  
        <p class="form__row">	
            <label for="Production">Production</label><br/>               
            <input type="text" name="Production" id="Production" class="form__input form__input--medium"/>
        </p>                             

        <div class="form__box"> 
            <input type="submit" class="form__btn"> <input type="reset" value="Clear Form" class="form__btn">      
        </div>
    </fieldset>
    </form>
</main> 
<script src="js/script.js"></script>
<!-- include the footer file here -->    
<?php include 'footerM.php'; ?> 
</body>
</html>
