<?php
include 'db_config.php';

$name = $_POST['name'];
$price = $_POST['price'];
$image = $_POST['image']; // Abhi ke liye hum sirf image ka naam/URL bhejenge

$sql = "INSERT INTO products (name, price, image) VALUES ('$name', '$price', '$image')";

if (mysqli_query($conn, $sql)) {
    echo "Success";
} else {
    echo "Error";
}
?>
