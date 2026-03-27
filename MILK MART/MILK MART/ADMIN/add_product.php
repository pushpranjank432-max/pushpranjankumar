<?php
include '../API/db_connect.php'; // API folder se connection le raha hai

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    $name = $_POST['p_name'];
    $price = $_POST['p_price'];
    $desc = $_POST['p_desc'];
    
    // Abhi simple text save kar rahe hain, image upload baad mein sikhenge
    $sql = "INSERT INTO products (p_name, p_price, p_desc) VALUES ('$name', '$price', '$desc')";
    
    if($conn->query($sql)){
        echo "Product Added Successfully!";
    } else {
        echo "Error: " . $conn->error;
    }
}
?>

<form method="POST">
    <input type="text" name="p_name" placeholder="Product Name" required><br>
    <input type="number" name="p_price" placeholder="Price" required><br>
    <textarea name="p_desc" placeholder="Description"></textarea><br>
    <button type="submit">Add Product</button>
</form>
