<?php
include '../API/db_connect.php';

$sql = "SELECT orders.*, users.name FROM orders JOIN users ON orders.user_id = users.id";
$result = $conn->query($sql);

echo "<h2>All Orders</h2>";
while($row = $result->fetch_assoc()){
    echo "ID: ".$row['id']." | Name: ".$row['name']." | Status: <b>".$row['status']."</b><br>";
    echo "Location: <a href='https://www.google.com/maps?q=".$row['lat'].",".$row['lng']."'>View on Map</a><br><hr>";
}
?>
