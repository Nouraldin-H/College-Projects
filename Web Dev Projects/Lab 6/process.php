<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <title>Form Data</title>
    <link rel="stylesheet" href="css/styles1.css" />
</head>
<body>
    <?php include 'headerM.php'; ?>
    <main>
        <h2>Form Data</h2>
        <p><strong>Title:</strong> <?php echo isset($_POST['title']) ? $_POST['title'] : ''; ?></p>
        <p><strong>Description:</strong> <?php echo isset($_POST['description']) ? $_POST['description'] : ''; ?></p>
        <p><strong>Genre:</strong> <?php echo isset($_POST['genre']) ? $_POST['genre'] : ''; ?></p>
        <p><strong>Subject:</strong> <?php echo isset($_POST['subject']) ? $_POST['subject'] : ''; ?></p>
        <p><strong>Star:</strong> <?php echo isset($_POST['Star']) ? $_POST['Star'] : ''; ?></p>
        <p><strong>Year:</strong> <?php echo isset($_POST['year']) ? $_POST['year'] : ''; ?></p>
        <p><strong>Production:</strong> <?php echo isset($_POST['Production']) ? $_POST['Production'] : ''; ?></p>
    </main>
    <?php include 'footerM.php'; ?>
</body>
</html>
