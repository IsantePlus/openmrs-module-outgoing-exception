<%
ui.decorateWith("appui", "standardEmrPage")
if (context.hasPrivilege("View Outgoing Messages")) {
%>
<% ui.includeJavascript("outgoing-message-exceptions", "outgoing.message.controller.js") %>
<% ui.includeJavascript("outgoing-message-exceptions", "jsGrid.min.js") %>

<script type="text/javascript">
    var breadcrumbs = [
        { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
        {
            label: "${ ui.message("outgoing-message-exceptions.label") }",
            link: "${ ui.pageLink("outgoing-message-exceptions", "outgoingMessageExceptions") }"
        },
        { label: "${ ui.message('outgoing-message-exceptions.xdsb.label') }"}
    ];
    var titles = [
        "${ ui.message('outgoing-message-exceptions.message.header.timestamp') }",
        "${ ui.message('outgoing-message-exceptions.message.header.destination') }",
        "${ ui.message('outgoing-message-exceptions.message.header.user') }",
        "${ ui.message('outgoing-message-exceptions.message.header.failure') }"
    ];
</script>

<div id="jsGrid" class="jsgrid" style="position: relative; height: auto; width: 100%;"></div>

<% } %>