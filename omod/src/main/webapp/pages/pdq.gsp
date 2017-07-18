<%
ui.decorateWith("appui", "standardEmrPage")
%>


<script type="text/javascript">
        var breadcrumbs = [
        { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
        { label: "${ ui.message("outgoingmessageexceptions.label")}",
            link: "${ ui.pageLink("outgoingmessageexceptions", "outgoingMessageExceptions") }"
        },
        { label: "${ ui.message('outgoingmessageexceptions.pdq.label') }"}
];
</script>