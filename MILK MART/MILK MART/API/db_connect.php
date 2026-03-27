<?php
$host = "localhost";
$user = "root"; 
$pass = ""; 
$dbname = "milk_mart_db"; // Jo naam aap database ka rakhenge

$conn = new mysqli($host, $user, $pass, $dbname);

if($conn->connect_error){
    die("Connection failed: " . $conn->connect_error);
}
?>
