$(document).ready(function() {
    $(".linkMinus").on("click", function(evt) {
        evt.preventDefault();
        productId = $(this).attr("pid");  //获取产品的id
        quantityInput = $("#quantity" + productId); //获取产品的数量
        newQuantity = parseInt(quantityInput.val()) - 1;

        if (newQuantity > 0) {
            quantityInput.val(newQuantity);
        } else {
            showWarningModal('Minimum quantity is 1');
        }
    });

    $(".linkPlus").on("click", function(evt) {
        evt.preventDefault();
        productId = $(this).attr("pid");
        quantityInput = $("#quantity" + productId);
        newQuantity = parseInt(quantityInput.val()) + 1;

        if (newQuantity <= 5) {
            quantityInput.val(newQuantity);
        } else {
            showWarningModal('Maximum quantity is 5');
        }
    });
});