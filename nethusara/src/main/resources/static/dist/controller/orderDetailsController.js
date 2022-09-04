function getAllOrderDetails() {

    $('#orderDetailsTableBody').empty();
    $.ajax({
        type: "GET",
        url: baseURL + 'api/order_detail',
        dataType: 'json',
        async: false
    }).done(function (data) {

        for (let i in data) {
            console.log(data);

            let orderDetail = data[i];
            let city = orderDetail['city'];
            let deliveryAddress = orderDetail['deliveryAddress'];
            let mobileNo = orderDetail['mobileNo'];
            let orderDetailID = orderDetail['orderDetailID'];
            let paymentMethod = orderDetail['paymentMethod'];
            let postalCode = orderDetail['postalCode'];
            let productID = orderDetail['productID'];
            let province = orderDetail['province'];
            let receiverFirstName = orderDetail['receiverFirstName'];
            let receiverLastName = orderDetail['receiverLastName'];

            //  "                                    <td>" + productID + "</td>\n" +
            let loadOrderDetailData = "<tr>\n" +
                "                                    <td>" + receiverFirstName + "</td>\n" +
                "                                    <td>" + receiverLastName + "</td>\n" +
                "                                    <td>" + deliveryAddress + "</td>\n" +
                "                                    <td>" + province + "</td>\n" +
                "                                    <td>" + city + "</td>\n" +
                "                                    <td>" + postalCode + "</td>\n" +
                "                                    <td>" + mobileNo + "</td>\n" +
                "                                    <td>" + paymentMethod + "</td>\n" +
                "                                    <td><button class=\"btn btn-dark btn-sm\" id=\"" + orderDetailID + "\" onclick=\"searchOrder(this.id)\"><i class=\"far fa-edit\"></i></button>" +
                "<button id=\"" + orderDetailID + "\" onclick=\"deleteOrderDetail(this.id)\" class=\"btn btn-danger btn-sm ml-1\"><i class=\"far fa-trash-alt\"></i></button></td>\n" +
                "                                </tr>";

            $('#orderDetailsTableBody').append(loadOrderDetailData);
            console.log("All orderDetail data set");

        }
    });
}


getAllOrderDetails();


function orderDetailAdd() {

    // let formData = $('#deliveryForm').serialize();
    let orderDetailsForm = $('#order_details_form')[0];
    let modalForm = $('#exampleModal');

    let firstname = $('#firstname').val();
    let lastname = $('#lastname').val();
    let province = $('#province').val();
    let city = $('#city').val();
    let address = $('#address').val();
    // let orderDetailID = $('#orderDetailID').val();
    let productID = $('#productID').val();
    let postalCode = $('#postalCode').val();
    let phoneNo = $('#phoneNo').val();
    let paymentMethod = $('#payment_status').val();

    if ((firstname.trim().length > 0) && (lastname.trim().length > 0) && (province.trim().length > 0)
        && (city.trim().length > 0) && (address.trim().length > 0)
        && (productID.trim().length > 0) && (postalCode.trim().length > 0) && (phoneNo.trim().length > 0)
        && (paymentMethod.trim().length > 0)) {

        let formDataJSON = JSON.stringify({
            orderDetailID: 0,
            receiverFirstName: firstname,
            receiverLastName: lastname,
            deliveryAddress: address,
            province: province,
            city: city,
            productID: productID,
            postalCode: postalCode,
            mobileNo: phoneNo,
            paymentMethod: paymentMethod,
        });

        $.ajax({
            type: "POST",
            url: baseURL + 'api/order_detail',
            data: formDataJSON,
            dataType: 'json',
            async: true,
            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                // alert("added");
                Swal.fire(
                    'Good job!',
                    'Order Job added success!',
                    'success'
                )
                orderDetailsForm.reset();
                modalForm.modal('toggle');
                getAllOrderDetails();

            },
            error: function (er) {
                // alert("added failed");
                Swal.fire(
                    'Ops!',
                    'Something went wrong!',
                    'error'
                )
            }
        });

    } else {
        // alert("All fields must be filled");
        Swal.fire(
            'Ops!',
            'All fields must be filled!',
            'error'
        )
    }
}



function deleteOrderDetail(orderDetailID) {

    Swal.fire({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this data!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
        showCancelButton: true,
    })
        .then((willDelete) => {
            if (willDelete) {
                removeOrderById(orderDetailID);
                Swal.fire("Order Deleted ! ", {
                    icon: "success",
                });
                setTimeout(function () {
                    window.location.reload();
                }, 1500);
            } else {
                Swal.fire("Order Not Deleted!");
            }
        });


}

function removeOrderById(id) {
    $.ajax({
        type: "DELETE",
        url: baseURL + 'api/order_detail/' + id,
        dataType: 'json',
    }).done(function (data) {

        if (data['isDeleted']) {
            // alert("deleted");
            Swal.fire(
                'Order job Deleted.!',
                'Deliver Job delete success!',
                'success'
            )
        } else {
            // alert("not deleted");
            Swal.fire(
                'Order job not Deleted.!',
                'Deliver Job delete success!',
                'error'
            )
        }
    });



}

function updateOrderByID() {

    let edit_firstname = $('#edit_firstname').val();
    let edit_lastname = $('#edit_lastname').val();
    let edit_province = $('#edit_province').val();
    let edit_city = $('#edit_city').val();
    let edit_address = $('#edit_address').val();
    // let orderDetailID = $('#orderDetailID').val();
    let edit_productID = $('#edit_productID').val();
    let edit_postalCode = $('#edit_postalCode').val();
    let edit_phoneNo = $('#edit_phoneNo').val();
    let edit_paymentMethod = $('#edit_payment_status').val();
    let orderDetailID = $('#edit_orderID').val();
    let modalForm = $('#exampleEditModal');


    if ((edit_firstname.trim().length > 0) && (edit_lastname.trim().length > 0) && (edit_province.trim().length > 0)
        && (edit_city.trim().length > 0) && (edit_address.trim().length > 0)
        && (edit_productID.trim().length > 0) && (edit_postalCode.trim().length > 0) && (edit_phoneNo.trim().length > 0)
        && (edit_paymentMethod.trim().length > 0)) {

        let editedFormDataJSON = JSON.stringify({
            receiverFirstName: edit_firstname,
            receiverLastName: edit_lastname,
            deliveryAddress: edit_address,
            province: edit_province,
            city: edit_city,
            productID: edit_productID,
            postalCode: edit_postalCode,
            mobileNo: edit_phoneNo,
            paymentMethod: edit_paymentMethod,
        });

        $.ajax({
            type: "PUT",
            url: baseURL + 'api/order_detail/' + orderDetailID,
            async: true,
            dataType: 'json',
            data: editedFormDataJSON,
            contentType: 'application/json; charset=utf-8',
        }).done(function (data) {
           // alert("Order Updated..!");
            Swal.fire(
                'Order job Updated.!',
                'Deliver Job Updated success!',
                'success'
            )
            setTimeout(function () {
                modalForm.modal('toggle');
                getAllOrderDetails();
                 }, 1000);


        });
    }
}

    function searchOrder(orderID) {
        $.ajax({
            type: "GET",
            url: baseURL + 'api/order_detail/' + orderID,
            dataType: 'json',
        }).done(function (data) {
            console.log(data);

            let modalForm = $('#exampleEditModal');
            $('#edit_firstname').val(data['receiverFirstName']);
            $('#edit_lastname').val(data['receiverLastName']);
            $('#edit_province').val(data['province']);
            $('#edit_city').val(data['city']);
            $('#edit_address').val(data['deliveryAddress']);

            $('#edit_productID').val(data['productID']);
            $('#edit_postalCode').val(data['postalCode']);
            $('#edit_phoneNo').val(data['mobileNo']);
            $('#edit_payment_status').val(data['paymentMethod']);
            $('#edit_orderID').val(data['orderDetailID']);

            modalForm.modal();

        });
    }


