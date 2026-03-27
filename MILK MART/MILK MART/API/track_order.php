<?php
include 'db_connect.php';

$order_id = $_POST['order_id'];

$sql = "SELECT status, order_date FROM orders WHERE id = '$order_id'";
$result = $conn->query($sql);

if($result->num_rows > 0){
    $row = $result->fetch_assoc();
    echo json_encode(["status" => "success", "order_status" => $row['status'], "date" => $row['order_date']]);
} else {
    echo json_encode(["status" => "error", "message" => "Invalid Order ID"]);
}
?>
