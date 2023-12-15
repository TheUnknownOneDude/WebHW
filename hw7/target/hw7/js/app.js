window.notify = function (message) {
    $.notify(message, {
        position: "right bottom",
        className: "success"
    });
}

window.ajax = function (obj, data, $error, type = "POST", url = "", dataType = "json") {

    const givenOrDefaultValue = function (defaultValue) {
        return x => (x !== undefined && x !== null && x) ? x : defaultValue;
    }

    type = givenOrDefaultValue("POST")(type);
    url = givenOrDefaultValue("")(url);
    dataType = givenOrDefaultValue("json")(dataType);


    let ajaxObject;
    ajaxObject = {
        type: type,
        url: url,
        dataType: dataType,
        data: data,
        success: function (response) {
            if (response["error"]) {
                $error.text(response["error"])
            } else {
                location.href = response["redirect"];
            }
        }
    }

    $.ajax(
        ajaxObject
    );
}
