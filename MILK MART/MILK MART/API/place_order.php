<?php
include 'db_connect.php';

$user_id = $_POST['user_id'];
$total = $_POST['total_amount'];
$lat = $_POST['lat']; // Google Map se aayega
$lng = $_POST['lng']; // Google Map se aayega

$sql = "INSERT INTO orders (user_id, total_amount, lat, lng, status) 
        VALUES ('$user_id', '$total', '$lat', '$lng', 'Pending')";

if($conn->query($sql)){
    echo json_encode(["status" => "success", "message" => "Order Placed Successfully"]);
} else {
    echo json_encode(["status" => "error", "message" => "Order Failed"]);
}
?>
