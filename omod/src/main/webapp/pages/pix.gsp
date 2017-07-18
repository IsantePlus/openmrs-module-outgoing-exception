<%
ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
        var breadcrumbs = [
        { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
        { label: "${ ui.message("outgoingmessageexceptions.label") }",
            link: "${ ui.pageLink("outgoingmessageexceptions", "outgoingMessageExceptions") }"
        },
        { label: "${ ui.message('outgoingmessageexceptions.pix.label') }"}
];
</script>
<!-- example -->
<div id="apps">
        <a class="button app big" href="${ ui.pageLink("outgoingmessageexceptions", "details", [messageId: 7, backPage: "pix", backPageIndex: 1]) }"
                id="messageDetails">
            <i class="icon-calendar"></i>
            ${ ui.message("outgoingmessageexceptions.details.label") }
        </a>
</div>