<?php
include 'db_connect.php';

$name = $_POST['name'];
$mobile = $_POST['mobile'];
$password = password_hash($_POST['password'], PASSWORD_DEFAULT); // Password safe rakhne ke liye
$address = $_POST['address'];

$sql = "INSERT INTO users (name, mobile, password, address) VALUES ('$name', '$mobile', '$password', '$address')";

if($conn->query($sql)){
    echo json_encode(["status" => "success", "message" => "User Registered"]);
} else {
    echo json_encode(["status" => "error", "message" => "Mobile number already exists"]);
}
?>
