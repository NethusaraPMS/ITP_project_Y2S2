
function deliveryAdd() {

    // let formData = $('#deliveryForm').serialize();
    let deliveryCreateForm = $('#deliveryForm')[0];

    let deliveryID = $('#deliveryID').val();
    let destination = $('#destination').val();
    let driverName = $('#driverName').val();
    let driverDate = $('#driverDate').val();
    let deliveryStatus = $('#deliveryStatus').val();


        if ((deliveryID.trim().length > 0) && (destination.trim().length > 0) && (driverName.trim().length > 0)
            && (driverDate.trim().length > 0) && (deliveryStatus.trim().length > 0)) {

            let formDataJSON = JSON.stringify({
                deliveryID: deliveryID,
                destination: destination,
                driverName: driverName,
                driverDate: driverDate,
                deliveryStatus: deliveryStatus
            });

            $.ajax({
                type: "POST",
                url: baseURL + 'api/delivery',
                data: formDataJSON,
                dataType: 'json',
                async: true,
                contentType: 'application/json; charset=utf-8',
                success: function (response) {
                    // alert("added");
                    Swal.fire(
                        'Good job!',
                        'Deliver Job added success!',
                        'success'
                    )
                    deliveryCreateForm.reset();
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

        }else {
            alert("All fields must be filled");
            Swal.fire(
                'Ops!',
                'All fields must be filled!',
                'error'
            )
        }
}


