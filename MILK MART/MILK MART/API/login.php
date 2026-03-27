<?php
include 'db_connect.php';

$mobile = $_POST['mobile'];
$password = $_POST['password'];

$sql = "SELECT * FROM users WHERE mobile = '$mobile'";
$result = $conn->query($sql);

if($result->num_rows > 0){
    $user = $result->fetch_assoc();
    // Password check kar rahe hain
    if(password_verify($password, $user['password'])){
        echo json_encode(["status" => "success", "user" => $user]);
    } else {
        echo json_encode(["status" => "error", "message" => "Wrong Password"]);
    }
} else {
    echo json_encode(["status" => "error", "message" => "User not found"]);
}
?>
