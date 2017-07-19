jQuery(document).ready(function() {
    $("#jsGrid").jsGrid({
        height: "auto",
        width: "100%",

        sorting: true,
        paging: true,
        pageLoading: true,
        autoload: true,
        pageSize: 10,
        pageButtonCount: 5,

        controller: {
            loadData: function (filter) {
                var d = $.Deferred();

                jQuery.ajax({
                    url: "/openmrs/ws/rest/isanteplus/messages?type=" +
                    window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1, window.location.pathname.lastIndexOf(".")),
                    type: "GET",
                    dataType: "json",
                    data: filter
                }).done(function (response) {
                    d.resolve(response);
                });

                return d.promise();
            }
        },
        fields: [
            {title: titles[0], name: "timestamp", type: "text", sorting: true, filtering: true},
            {title: titles[1], name: "destination" , type: "text", sorting: true, filtering: true},
            {title: titles[2], name: "user.name" , type: "text", textField: "uuid", filtering: true},
            {
                title: titles[3], name: "failure" , type: "text", sorting: true, filtering: true, align: "center",
                itemTemplate: function(value) {
                    var result;
                    if (value === true) {
                        result = $("<div>").prepend('<img id="successImage" src="/openmrs/ms/uiframework/resource/outgoing-message-exceptions/images/icons8-Ok-48.png" />');
                    } else {
                        result = $("<div>").prepend('<img id="failureImage" src="/openmrs/ms/uiframework/resource/outgoing-message-exceptions/images/icons8-Cancel-48.png" />');
                    }
                    return result;
                }
            }
        ]
    });
});