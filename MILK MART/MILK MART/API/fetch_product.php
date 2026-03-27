<?php
include 'db_connect.php';

$sql = "SELECT * FROM products";
$result = $conn->query($sql);

$products = array();
while($row = $result->fetch_assoc()){
    $products[] = $row;
}

echo json_encode($products);
?>
