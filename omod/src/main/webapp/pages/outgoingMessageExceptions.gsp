<%
    ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
    var breadcrumbs = [
        { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
        { label: "${ ui.message("Outgoing Message Exceptions")}"}
    ];
</script>

<div id="apps">
    
    <a class="button app big" href="${ ui.pageLink("outgoingmessageexceptions", "pix") }"
            id="outgoingmessageexceptions.pix">
        <i class="icon-calendar"></i>
        ${ ui.message("outgoingmessageexceptions.pix.label") }
    </a>
    
    <a class="button app big" href="${ ui.pageLink("outgoingmessageexceptions", "pdq") }"
            id="outgoingmessageexceptions.pdq">
        <i class="icon-calendar"></i>
        ${ ui.message("outgoingmessageexceptions.pdq.label") }
    </a>
    
    <a class="button app big" href="${ ui.pageLink("outgoingmessageexceptions", "xdsb") }"
            id="outgoingmessageexceptions.xdsb">
        <i class="icon-calendar"></i>
        ${ ui.message("outgoingmessageexceptions.xdsb.label") }
    </a>
    
    <a class="button app big" href="${ ui.pageLink("outgoingmessageexceptions", "ccd") }"
            id="outgoingmessageexceptions.ccd">
        <i class="icon-calendar"></i>
        ${ ui.message("outgoingmessageexceptions.ccd.label") }
    </a>

</div>