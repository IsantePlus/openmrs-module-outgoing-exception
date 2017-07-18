<%
    ui.decorateWith("appui", "standardEmrPage")
    def artifactId = "outgoingmessageexceptions"
%>

<script type="text/javascript">
    var breadcrumbs = [
        { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
        { label: "${ ui.message(artifactId + '.' + param.backPage[0] + '.label') }",
            link: "${ ui.pageLink(artifactId, param.backPage[0]) }"
        },
        { label: "${ ui.message(artifactId + '.details.label') }"}
    ];
</script>

<div id="apps">
    ${ ui.includeFragment(artifactId, "exceptionDetails", [messageId: param.messageId, pageIndex: param.backPageIndex]) }
</div>