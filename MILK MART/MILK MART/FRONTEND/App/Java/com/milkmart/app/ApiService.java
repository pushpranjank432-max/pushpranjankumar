 @FormUrlEncoded
@POST("add_product.php")
Call<String> addProduct(
    @Field("name") String name,
    @Field("price") String price,
    @Field("image") String image
);
