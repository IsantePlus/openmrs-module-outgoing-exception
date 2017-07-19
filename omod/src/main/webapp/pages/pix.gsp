<%
ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
        var breadcrumbs = [
        { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
        { label: "${ ui.message("outgoing-message-exceptions.label") }",
            link: "${ ui.pageLink("outgoing-message-exceptions", "outgoingMessageExceptions") }"
        },
        { label: "${ ui.message('outgoing-message-exceptions.pix.label') }" }
];
</script>
<!-- example -->
<div id="apps">
        <a class="button app big" href="${ ui.pageLink("outgoing-message-exceptions", "details", [messageId: 7, backPage: "pix", backPageIndex: 1]) }"
                id="messageDetails">
            <i class="icon-calendar"></i>
            ${ ui.message("outgoing-message-exceptions.details.label") }
        </a>
</div>