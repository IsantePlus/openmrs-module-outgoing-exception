<%
ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
        var breadcrumbs = [
        { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
        { label: "${ ui.message("outgoing-message-exceptions.label")}",
            link: "${ui.pageLink("outgoing-message-exceptions", "outgoingMessageExceptions")}"
        },
        { label: "${ ui.message('outgoing-message-exceptions.pix.label') }"}
];
</script>